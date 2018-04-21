package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;

public class RestaurantDetailsIsAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurantId = request.getParameter("restaurantId");
		System.out.println("id:"+restaurantId);
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("false")){
			if(new RestaurantDetailsDAO().isAvailableTrue(restaurantId)){
			System.out.println("Restaurant is now available for everyone");
			request.getRequestDispatcher("restaurantDetailsList").forward(request, response);
			}else{
				System.out.println("error...");
			}
		}else if(action.equalsIgnoreCase("true")){
			if(new RestaurantDetailsDAO().isAvailableFalse(restaurantId)){
			System.out.println("Restaurant is now unavailable of everyone..");
			request.getRequestDispatcher("restaurantDetailsList").forward(request, response);
			
				}else{
					System.out.println("error..");
				}
			}
	
	}

}
