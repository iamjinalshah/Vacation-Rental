package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;

public class RestaurantDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ResataurantDetailsBean> listOfRestaurant = new RestaurantDetailsDAO().list();
		
		if(listOfRestaurant!=null){
			request.setAttribute("listOfRestaurant", listOfRestaurant);
			request.getRequestDispatcher("RestaurantDetailsList.jsp").forward(request, response);
		}
	
	}

}
