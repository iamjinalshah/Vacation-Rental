package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyTypeDAO;

public class HotelDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String hotelId = request.getParameter("hotelId");
		System.out.println("hotelp-id:"+hotelId);
		
		
		if(new HotelDetailsDAO().delete(hotelId)){
			response.sendRedirect("hotelDetailsList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("hotelDetailsList");
		}
		
	}

}
