package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CarDetailsDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;

public class CarDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carId = request.getParameter("carId");
		System.out.println("car-id:"+carId);
		
		
		if(new CarDetailsDAO().delete(carId)){
			response.sendRedirect("carDetailsList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("carDetailsList");
		}
	
	}

}
