package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;

public class HotelDetailsIsAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String hotelId = request.getParameter("hotelId");
	System.out.println("id:"+hotelId);
	String action=request.getParameter("action");
	
	if(action.equalsIgnoreCase("false")){
		if(new HotelDetailsDAO().isAvailableTrue(hotelId)){
		System.out.println("hotel is now available for everyone");
		request.getRequestDispatcher("hotelDetailsList").forward(request, response);
		}else{
			System.out.println("error...");
		}
	}else if(action.equalsIgnoreCase("true")){
		if(new HotelDetailsDAO().isAvailableFalse(hotelId)){
		System.out.println("hotel is now unavailable of everyone..");
		request.getRequestDispatcher("hotelDetailsList").forward(request, response);
		
			}else{
				System.out.println("error..");
			}
		}
	}
}


