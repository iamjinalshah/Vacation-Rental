package digimation.vacationrental.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;


public class PropertyDetailsAmenitiesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pdaId = request.getParameter("pdaId");
		
		if(new PropertyDetailsAmenitiesDAO().delete(pdaId)){
			response.sendRedirect("propertyDetailsAmenitiesList");
		}else{
			response.sendRedirect("propertyDetailsAmenitiesList");
		}
	}
}
