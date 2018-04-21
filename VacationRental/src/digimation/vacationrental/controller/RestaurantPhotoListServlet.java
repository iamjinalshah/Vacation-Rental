package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.RestaurantPhotoDAO;

public class RestaurantPhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<RestaurantPhotoBean> listOfPhoto = new RestaurantPhotoDAO().list();
		
		if(listOfPhoto!=null){
			request.setAttribute("listOfPhoto", listOfPhoto);
			request.getRequestDispatcher("RestaurantPhotoList.jsp").forward(request, response);
		}
	
	}

}
