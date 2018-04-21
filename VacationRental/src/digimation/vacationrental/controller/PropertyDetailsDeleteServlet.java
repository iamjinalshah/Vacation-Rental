package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class PropertyDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String propertyId = request.getParameter("propertyId");
		
		if(new PropertyDetailsDAO().delete(propertyId)){
			response.sendRedirect("propertyDetailsList");
		}else{
			response.sendRedirect("propertyDetailsList");
		}
	}

}
