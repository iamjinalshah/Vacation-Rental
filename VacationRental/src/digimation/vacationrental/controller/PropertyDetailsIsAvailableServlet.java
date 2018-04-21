package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class PropertyDetailsIsAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String propertyId = request.getParameter("propertyId");
		System.out.println("id:"+propertyId);
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("false")){
			if(new PropertyDetailsDAO().isAvailableTrue(propertyId)){
			System.out.println("Property is now available for everyone");
			request.getRequestDispatcher("propertyDetailsList").forward(request, response);
			}else{
				System.out.println("error...");
			}
		}else if(action.equalsIgnoreCase("true")){
			if(new PropertyDetailsDAO().isAvailableFalse(propertyId)){
			System.out.println("Property is now unavailable of everyone..");
			request.getRequestDispatcher("propertyDetailsList").forward(request, response);
			
				}else{
					System.out.println("error..");
				}
			}
	
	}

}
