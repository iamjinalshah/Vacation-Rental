package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;

public class PropertyFullInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String propertyId = request.getParameter("propertyId");
		System.out.println("propertyId:"+propertyId);
		
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsDAO().propertyFullInfo(propertyId);
		List<PropertyPhotoBean> listOfPropertyPhotos = new PropertyPhotoDAO().propertyPhotolist(propertyId);
		List<AmenitiesBean> listOfAmenities = new AmenitiesDAO().Amenitieslist(propertyId);
		
		if(propertyDetailsBean!=null && listOfPropertyPhotos!=null && listOfAmenities!=null){
			System.out.println("succesfully fetch all data");
			request.setAttribute("propertyDetailsBean", propertyDetailsBean);
			request.setAttribute("listOfPropertyPhotos", listOfPropertyPhotos);
			request.setAttribute("listOfAmenities", listOfAmenities);
			request.getRequestDispatcher("propertySingle.jsp").forward(request, response);
		}
	
	}

}
