package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.QuestionDAO;



public class QuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("questionId");
		System.out.println("Q-id :"+Id);
		
		QuestionBean question = new QuestionDAO().getDatabyPK(Id);
		if(question!=null){
			
			request.setAttribute("question", question);
			request.getRequestDispatcher("QuestionEdit.jsp").forward(request, response);
			
		}
	}
}

	

