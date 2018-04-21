package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;

public class RestaurantDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurantId = request.getParameter("restaurantId");
		System.out.println("restaurant-id:"+restaurantId);
		
		
		if(new RestaurantDetailsDAO().delete(restaurantId)){
			response.sendRedirect("restaurantDetailsList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("restaurantDetailsList");
		}
	}

}
