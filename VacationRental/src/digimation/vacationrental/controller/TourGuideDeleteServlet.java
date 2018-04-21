package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.TourGuideDAO;

public class TourGuideDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tourguideId = request.getParameter("tourguideId");
		System.out.println("guide-id:"+tourguideId);
		if(new TourGuideDAO().delete(tourguideId)){
			response.sendRedirect("tourGuideList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("tourGuideList");
		}
	}

}
