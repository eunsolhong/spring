package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDaoMysql;

public class deleteProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");

		BoardDaoMysql dbPro = BoardDaoMysql.getInstance();
		int check = dbPro.deleteArticle(num, passwd); 
		
		request.setAttribute("check", check);
		return "/view/board/updatePro.jsp";
	}

}
