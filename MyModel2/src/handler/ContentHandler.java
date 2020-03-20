package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDaoMysql;
import model.BoardDataBean;

public class ContentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		if (pageNum==null||pageNum.equals("")) { pageNum = "1";}

		 BoardDaoMysql  dbPro = BoardDaoMysql.getInstance();
		 BoardDataBean article = dbPro.getArticle(num);
		 
		 request.setAttribute("article", article);
		 
		return "/view/board/content.jsp";
	}

}
