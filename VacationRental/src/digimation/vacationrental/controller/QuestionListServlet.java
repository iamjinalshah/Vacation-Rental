package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.QuestionDAO;


public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	List<QuestionBean> question = new QuestionDAO().list();
	
	if(question!=null){
		request.setAttribute("question", question);
		request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
	}
}
}
