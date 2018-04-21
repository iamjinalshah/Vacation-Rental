package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.LanguageDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;
import digimation.vacationrental.dao.RestaurantPhotoDAO;
import digimation.vacationrental.dao.TourGuideDAO;

public class TourguideFullInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tourguideId = request.getParameter("tourguideId");
		System.out.println("tourguideId:"+tourguideId);
		
		TourGuideBean tourGuideBean = new TourGuideDAO().tourguideFullInfo(tourguideId);
		List<LanguageBean> listOfLanguages = new LanguageDAO().languageList(tourguideId);
		
		if(tourGuideBean!=null && listOfLanguages!=null){
			System.out.println("succesfully fetch all data");
			request.setAttribute("tourGuideBean", tourGuideBean);
			request.setAttribute("listOfLanguages", listOfLanguages);
			request.getRequestDispatcher("tourguideSingle.jsp").forward(request, response);
		}
	
	}

}
