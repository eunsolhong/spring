package handler;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDaoMysql;



public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
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
		
		
		
		BoardDaoMysql service = BoardDaoMysql.getInstance();
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

}
