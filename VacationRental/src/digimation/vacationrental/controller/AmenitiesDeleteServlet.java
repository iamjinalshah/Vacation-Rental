package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.CityDAO;


public class AmenitiesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String amenitiesId = request.getParameter("amenitiesId");
			
			if(new AmenitiesDAO().fkchecking(amenitiesId)){
				request.setAttribute("fkchecking", "<font color=red>This Amenities is not deleted...because It refer some other table...</font>");
				request.getRequestDispatcher("amenitiesList").forward(request, response);
			}else{
			if(new AmenitiesDAO().delete(amenitiesId)){
				response.sendRedirect("amenitiesList");
			}else{
				response.sendRedirect("amenitiesList");
			}
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
