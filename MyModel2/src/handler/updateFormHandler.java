package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDaoMysql;
import model.BoardDataBean;

public class updateFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		BoardDaoMysql dbPro = BoardDaoMysql.getInstance();

		BoardDataBean  article = dbPro.getUpdateArticle(num); 


		request.setAttribute("article", article);

	
		 
		return "/view/board/updateForm.jsp";
	}

}
