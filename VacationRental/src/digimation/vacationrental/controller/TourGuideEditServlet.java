package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.TourGuideDAO;

public class TourGuideEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tourguideId=request.getParameter("tourguideId");
		System.out.println("guide-id :"+tourguideId);
		
		TourGuideBean tourGuideBean = new TourGuideDAO().getDatabyPK(tourguideId);
		
		if(tourGuideBean!=null){
			
			request.setAttribute("tourGuideBean", tourGuideBean);
			request.getRequestDispatcher("TourGuideEdit.jsp").forward(request, response);
			
		}
	}

}
