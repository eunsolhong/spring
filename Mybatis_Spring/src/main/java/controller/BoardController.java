package controller;

import java.io.FileOutputStream;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import model.BoardDataBean;
import mybatis.MybatisBoardDaoMysql;

@Controller
@RequestMapping("/board/") // 해당되는 컨트롤러는 board 안으로 들어오는걸 실행해라
public class BoardController {

	String boardid;
	String ip;
	String pageNum;

	@Autowired
	MybatisBoardDaoMysql dbPro;

	@ModelAttribute
	public void initProcess(HttpServletRequest request) {

		HttpSession session = request.getSession();
		ip = request.getRemoteAddr();

		if (request.getParameter("boardid") != null) {
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", 1);
			boardid = (String) session.getAttribute("boardid");
		}

		if (boardid == null) {
			boardid = "1";
			session.setAttribute("boardid", "1");
		}
	}

	// board/list -> board_list
	@RequestMapping(value = "list")
	public String board_list(HttpServletRequest request) {

		HttpSession session = request.getSession();

		int pageSize = 3;
		int num = 9;
		int currentPage = 1;

		if (session.getAttribute("pageNum") == null) {
			session.setAttribute("pageNum", 1);
			System.out.println("2 " + currentPage);
		}

		try {
			currentPage = Integer.parseInt(request.getParameter("pageNum"));
			session.setAttribute("pageNum", currentPage);

			System.out.println("1 " + currentPage);

		} catch (Exception e) {

		}

		currentPage = (int) session.getAttribute("pageNum");

		String boardid = (String) session.getAttribute("boardid");

		int count = dbPro.getArticleCount(boardid);

		System.out.println(count);

		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		if (currentPage > pageCount) {
			currentPage = pageCount;
			session.setAttribute("pageNum", currentPage);
		}

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		// int endRow = currentPage * pageSize;

		System.out.println(startRow + ":" + endRow + ":" + boardid);

		List li = dbPro.getArticles(startRow, endRow, boardid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int number = count - (currentPage - 1) * pageSize;

		int bottomLine = 3;

		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount)
			endPage = pageCount;

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

		return "board/list";
	}

	// board/write
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String board_writeForm(@ModelAttribute("article") BoardDataBean article) {
		//오브젝트를 읽어서 리퀘스트 필드명으로 읽어줘서 보내줌...? @RequestsetAttribute를 @Modelattribute가 해줌
		
		//오브젝트 하나를 만들어서 보내는거 
		
		
		return "board/writeUploadForm";
	}

//	@RequestMapping(value = "write", method = RequestMethod.POST)
//	public String board_writePro(BoardDataBean article) throws Exception {
//
//		article.setIp(ip);
//		article.setBoardid(boardid);
//		System.out.println(article);
//		dbPro.insertArticle(article);
//		return "redirect:/board/list";
//	}

//	@RequestMapping(value="write" , method=RequestMethod.POST)	
//	public String board_writePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
//		String realFolder = "";
//		String saveFolder = "uploadFile";
//		String encType = "UTF-8";
//		System.out.println("******************8888"+request.getParameter("writer"));
//		int maxSize = 10 * 1024 * 1024;//10M
//		ServletContext context = request.getServletContext();
//		realFolder = context.getRealPath(saveFolder);
//		try {
//			MultipartRequest multi = 
//					new MultipartRequest(request, realFolder, maxSize, encType,
//					new DefaultFileRenamePolicy());
//			BoardDataBean article = new BoardDataBean();
//			Enumeration files = multi.getFileNames();
//
//			if (files.hasMoreElements()) {
//				String name = (String) files.nextElement();
//				File file = multi.getFile(name);
//				if (file != null) {
//					article.setFilename(file.getName());
//					article.setFilesize((int) file.length());
//				} else {
//					article.setFilename("");
//					article.setFilesize(0);
//				}
//			}
//
//			article.setNum(Integer.parseInt(multi.getParameter("num")));
//			article.setRef(Integer.parseInt(multi.getParameter("ref")));
//			article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
//			article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
//			article.setWriter(multi.getParameter("writer"));
//			article.setContent(multi.getParameter("content"));
//			article.setPasswd(multi.getParameter("passwd"));
//			article.setSubject(multi.getParameter("subject"));
//			article.setEmail(multi.getParameter("email"));
//			article.setBoardid((String) request.getSession().getAttribute("boardid"));
//			article.setIp(request.getRemoteAddr());
//			service.insertArticle(article);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//		
//		return "redirect:/board/list";
//	}

	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeUploadPro(MultipartHttpServletRequest multipart, BoardDataBean article) throws Exception{
		MultipartFile multi = multipart.getFile("uploadfile");
		
		String filename = multi.getOriginalFilename();
		if(filename != null && !filename.equals("")) {
			String uploadPath = multipart.getRealPath("/") + "/uploadFile";
			System.out.println(uploadPath);
			
			FileCopyUtils.copy(multi.getInputStream(), 
					new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));
			
			article.setFilename(filename);
			article.setFilesize((int) multi.getSize());
		} else {
			article.setFilename("");
			article.setFilesize(0);
		}
		article.setIp(ip);
		article.setBoardid(boardid);
		dbPro.insertArticle(article);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "content")
	public String board_content(int num, Model m) {

		BoardDataBean article = dbPro.getArticle(num);
		m.addAttribute("article", article);
		return "board/content";
	}

	@RequestMapping(value = "deleteForm")
	public String board_deleteForm(int num, Model m) {

		m.addAttribute("num", num);
		return "board/deleteForm";
	}

	@RequestMapping(value = "deletePro", method = RequestMethod.POST)
	public String board_deletePro(int num, String passwd, Model m) throws Exception {

		int check = dbPro.deleteArticle(num, passwd);
		m.addAttribute("check", check);
		return "board/updatePro";
	}

	@RequestMapping(value = "updateForm")
	public String board_updateForm(int num, Model m) {

		BoardDataBean article = dbPro.getUpdateArticle(num);
		m.addAttribute("article", article);

		return "board/updateForm";
	}

	@RequestMapping(value = "updatePro", method = RequestMethod.POST)
	public String board_updatePro(BoardDataBean article, Model m) throws Exception {

		System.out.println(article);
		int check = dbPro.updateArticle(article);
		System.out.println(check);
		m.addAttribute("check", check);

		return "board/updatePro";
	}

}