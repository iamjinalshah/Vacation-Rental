package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.FeedbackBean;
import digimation.vacationrental.dao.FeedbackDAO;
import digimation.vacationrental.util.ValidationUtils;

public class FeedbackInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String txtFeedback = request.getParameter("txtFeedback");
	String txtDate = request.getParameter("txtDate");
	String drpdnHotel = request.getParameter("drpdnHotel");
	String drpdnProperty = request.getParameter("drpdnProperty");
	String drpdnRestaurant = request.getParameter("drpdnRestaurant");
	String drpdnCar = request.getParameter("drpdnCar");
	String drpdnTourGuide = request.getParameter("drpdnTourGuide");
	
	boolean isError = false;
	FeedbackBean feedbackBean = new FeedbackBean();
	
	if(ValidationUtils.isEmpty(txtFeedback)){
		request.setAttribute("feedback", "<font color=red>* required</font>");
		isError=true;
	}else{
		feedbackBean.setFeedback_details(txtFeedback);
	}
	
	if(ValidationUtils.isEmpty(txtDate)){
		request.setAttribute("date", "<font color=red>* required</font>");
		isError=true;
	}else{
		feedbackBean.setDate(txtDate);
	}
	
	if(isError){
		request.getRequestDispatcher("Feedback.jsp").forward(request, response);
	}else{
		
		int drpHotel = Integer.parseInt(drpdnHotel);
		feedbackBean.setHotel_id(drpHotel);
		
		int drpProperty = Integer.parseInt(drpdnProperty);
		feedbackBean.setProperty_id(drpProperty);
		
		int drpRestaurant = Integer.parseInt(drpdnRestaurant);
		feedbackBean.setRestaurant_id(drpRestaurant);
		
		int drpCar = Integer.parseInt(drpdnCar);
		feedbackBean.setCar_id(drpCar);
		
		int drpTourGuide = Integer.parseInt(drpdnTourGuide);
		feedbackBean.setTourguide_id(drpTourGuide);
		
		System.out.println("data ready for insertion...");
		
		if(new FeedbackDAO().insert(feedbackBean)){
			System.out.println("data are inserted...");
			request.getRequestDispatcher("feedbackList").forward(request, response);
		}else{
			System.out.println("oopss some error...");
		}
	}
	
	}

}
