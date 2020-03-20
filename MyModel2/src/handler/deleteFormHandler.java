package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDaoMysql;
import model.BoardDataBean;

public class deleteFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		request.setAttribute("num", request.getParameter("num"));
		 
		return "/view/board/deleteForm.jsp";
	}

}
