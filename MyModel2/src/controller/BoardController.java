package controller;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDaoMysql;
import dao.MybatisBoardDaoMysql;
import model.BoardDataBean;

import mskim.annotation.ActionAnnotation;
import mskim.annotation.RequestMapping;
import mskim.annotation.RequestMapping.RequestMethod;




public class BoardController extends ActionAnnotation {

	public void initProcess(HttpServletRequest request, HttpServletResponse arg1)  {
		// TODO Auto-generated method stub
		System.out.println("=================initProcess");
		
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(request.getParameter("boardid")!=null) {
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", 1);
		}


		String boardid = (String) session.getAttribute("boardid");
		
		if (boardid==null) {
			boardid = "1";
			session.setAttribute("boardid", "1");
			
		}
		
	}
	
	//board/list   -> board_list
	@RequestMapping(value="list")
	public String board_list(HttpServletRequest request, HttpServletResponse res) {
		
		
		System.out.println("=================board_list");
		HttpSession  session = request.getSession();
		int pageSize=3;
		int num=9;
		int currentPage=1;
		if (session.getAttribute("pageNum")==null) {
			session.setAttribute("pageNum", 1);
			System.out.println("2 "+currentPage);
		}
			try {
				currentPage=Integer.parseInt(request.getParameter("pageNum"));
				session.setAttribute("pageNum", currentPage);
				System.out.println("1 "+currentPage);
			}  catch (Exception e) {
				
			
			}

		currentPage = (int)session.getAttribute("pageNum"); 
		
		String boardid = (String) session.getAttribute("boardid"); 
		
		
		
		MybatisBoardDaoMysql service = MybatisBoardDaoMysql.getInstance();
		int count = service.getArticleCount(boardid); 
		System.out.println(count);
		int pageCount = count/pageSize + (count % pageSize == 0 ? 0 :1 );

		if (currentPage>pageCount) { 
			currentPage=pageCount;
			session.setAttribute("pageNum", currentPage);
		}

		int startRow = (currentPage-1)*pageSize +1;
		int endRow = startRow + pageSize - 1;
		// int endRow = currentPage * pageSize;


		System.out.println(startRow+":"+endRow+":"+boardid);
		List li = service.getArticles(startRow, endRow, boardid);  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int number=count-(currentPage-1)*pageSize;

		
		   int bottomLine = 3;
		  
		   int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		   int endPage = startPage + bottomLine - 1;
		   if (endPage > pageCount) endPage = pageCount;
		
		
		
		
		
		
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("bottomLine", bottomLine);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		
		request.setAttribute("li", li);
		

		
		
		
		return "/view/board/list.jsp";
	}
	//board/write
	@RequestMapping(value="write", method=RequestMethod.GET)
public String board_writeForm(HttpServletRequest request, HttpServletResponse res) {
		
		int num=0, ref=1, re_step=0, re_level=0;
		if (request.getParameter("num")!=null) {
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}

		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);

		
		return "/view/board/writeUploadForm.jsp";
	}

	@RequestMapping(value="write" , method=RequestMethod.POST)	
	public String board_writePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
		String realFolder = "";
		String saveFolder = "uploadFile";
		String encType = "UTF-8";
		System.out.println("******************8888"+request.getParameter("writer"));
		int maxSize = 10 * 1024 * 1024;//10M
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
			BoardDataBean article = new BoardDataBean();
			Enumeration files = multi.getFileNames();

			if (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				File file = multi.getFile(name);
				if (file != null) {
					article.setFilename(file.getName());
					article.setFilesize((int) file.length());
				} else {
					article.setFilename("");
					article.setFilesize(0);
				}
			}

			article.setNum(Integer.parseInt(multi.getParameter("num")));
			article.setRef(Integer.parseInt(multi.getParameter("ref")));
			article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
			article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
			article.setWriter(multi.getParameter("writer"));
			article.setContent(multi.getParameter("content"));
			article.setPasswd(multi.getParameter("passwd"));
			article.setSubject(multi.getParameter("subject"));
			article.setEmail(multi.getParameter("email"));
			article.setBoardid((String) request.getSession().getAttribute("boardid"));
			article.setIp(request.getRemoteAddr());
			MybatisBoardDaoMysql service = MybatisBoardDaoMysql.getInstance();
			service.insertArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value="content")	
public String board_content(HttpServletRequest request, HttpServletResponse res) {
	// TODO Auto-generated method stub
	

			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			if (pageNum==null||pageNum.equals("")) { pageNum = "1";}

			MybatisBoardDaoMysql  dbPro = MybatisBoardDaoMysql.getInstance();
			 BoardDataBean article = dbPro.getArticle(num);
			 
			 request.setAttribute("article", article);
			 
			return "/view/board/content.jsp";
}

	@RequestMapping(value="deleteForm")
public String board_deleteForm(HttpServletRequest request, HttpServletResponse res) {
	// TODO Auto-generated method stub
	
			request.setAttribute("num", request.getParameter("num"));
			 
			return "/view/board/deleteForm.jsp";
}

	@RequestMapping(value="deletePro", method=RequestMethod.POST)
public String board_deletePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");

	MybatisBoardDaoMysql dbPro = MybatisBoardDaoMysql.getInstance();
	int check = dbPro.deleteArticle(num, passwd); 
	
	request.setAttribute("check", check);
	return "/view/board/updatePro.jsp";
}


	@RequestMapping(value="updateForm")
public String board_updateForm(HttpServletRequest request, HttpServletResponse res) {
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	MybatisBoardDaoMysql dbPro = MybatisBoardDaoMysql.getInstance();

	BoardDataBean  article = dbPro.getUpdateArticle(num); 


	request.setAttribute("article", article);


	 
	return "/view/board/updateForm.jsp";
}

	@RequestMapping(value="updatePro", method=RequestMethod.POST)
public String board_updatePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
		
	    BoardDataBean article = new BoardDataBean();
	    article.setNum(Integer.parseInt(request.getParameter("num")));
	    article.setWriter(request.getParameter("writer"));
		article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));
		article.setSubject(request.getParameter("subject"));
		article.setEmail(request.getParameter("email"));
	    System.out.println(article);
	    MybatisBoardDaoMysql dbPro = MybatisBoardDaoMysql.getInstance();
	    int check = dbPro.updateArticle(article); 
	    System.out.println(check);
	    request.setAttribute("check", check);
	 
	return "/view/board/updatePro.jsp";
}

}