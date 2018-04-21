package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;

public class PropertyDetailsAmenitiesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String drpdnPropertyDetails = request.getParameter("drpdnPropertyDetails");
	String drpdnAmenities = request.getParameter("drpdnAmenities");
	
	 PropertyDetailsAmenitiesBean   propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesBean();
	 
	 int propertyId = Integer.parseInt(drpdnPropertyDetails);
	 propertyDetailsAmenitiesBean.setProperty_id(propertyId);
	 
	 int amenitiesId = Integer.parseInt(drpdnAmenities);
	 propertyDetailsAmenitiesBean.setAmenities_id(amenitiesId);
	 
	 System.out.println("data ready for insertion...");
	 
	 if(new PropertyDetailsAmenitiesDAO().insert(propertyDetailsAmenitiesBean)){
		 System.out.println("Data are inserted...");
		 request.getRequestDispatcher("propertyDetailsAmenitiesList").forward(request, response);
	 }else{
		 System.out.println("oopss some error...");
	 }
	 
	
	}

}
