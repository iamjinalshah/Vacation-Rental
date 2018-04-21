package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import digimation.vacationrental.dao.QuestionDAO;


public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String questionId = request.getParameter("questionId");
		System.out.println("qid:"+questionId);
		if(new QuestionDAO().delete(questionId)){
			response.sendRedirect("questionList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("questionList");
		}
	}
	

}
