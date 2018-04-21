package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.TourGuideDAO;

public class TourGuideListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<TourGuideBean> listOfTourGuide = new TourGuideDAO().list();
		
		if(listOfTourGuide!=null){
			request.setAttribute("listOfTourGuide", listOfTourGuide);
			request.getRequestDispatcher("TourGuideList.jsp").forward(request, response);
		}
	}

}
