package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDaoMysql;
import model.BoardDataBean;

public class updateProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		   request.setCharacterEncoding("utf-8");
		   BoardDataBean article = new BoardDataBean();
		    article.setNum(Integer.parseInt(request.getParameter("num")));
		    article.setWriter(request.getParameter("writer"));
			article.setContent(request.getParameter("content"));
			article.setPasswd(request.getParameter("passwd"));
			article.setSubject(request.getParameter("subject"));
			article.setEmail(request.getParameter("email"));
		    System.out.println(article);
			BoardDaoMysql dbPro = BoardDaoMysql.getInstance();
		    int check = dbPro.updateArticle(article); 
		    System.out.println(check);
		    request.setAttribute("check", check);
		 
		return "/view/board/updatePro.jsp";
	}

}
