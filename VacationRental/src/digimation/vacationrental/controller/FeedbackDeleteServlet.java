package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.FeedbackDAO;

public class FeedbackDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String feedbackId = request.getParameter("feedbackId");
		System.out.println("feedback-id:"+feedbackId);
		if(new FeedbackDAO().delete(feedbackId)){
			response.sendRedirect("feedbackList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("feedbackList");
		}
	
	}

}
