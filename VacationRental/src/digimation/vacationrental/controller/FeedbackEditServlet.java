package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.FeedbackBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.FeedbackDAO;

public class FeedbackEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String feedbackId = request.getParameter("feedbackId");
		System.out.println("feedback-id:"+feedbackId);
		
		FeedbackBean feedbackBean =new FeedbackDAO().getDatabyPK(feedbackId);
		
		if(feedbackBean!= null){
			request.setAttribute("feedbackBean", feedbackBean);
			request.getRequestDispatcher("FeedbackEdit.jsp").forward(request, response);
		}
	}

}
