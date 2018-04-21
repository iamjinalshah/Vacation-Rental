package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;
import digimation.vacationrental.dao.RestaurantPhotoDAO;

public class RestaurantFullInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurantId = request.getParameter("restaurantId");
		System.out.println("restaurantId:"+restaurantId);
		
		ResataurantDetailsBean resataurantDetailsBean = new RestaurantDetailsDAO().restaurantFullInfo(restaurantId);
		List<RestaurantPhotoBean> listOfRestaurantPhotos = new RestaurantPhotoDAO().restaurantPhotolist(restaurantId);
		/*List<AmenitiesBean> listOfAmenities = new AmenitiesDAO().Amenitieslist(propertyId);*/
		
		if(resataurantDetailsBean!=null && listOfRestaurantPhotos!=null){
			System.out.println("succesfully fetch all data");
			request.setAttribute("resataurantDetailsBean", resataurantDetailsBean);
			request.setAttribute("listOfRestaurantPhotos", listOfRestaurantPhotos);
			/*request.setAttribute("listOfAmenities", listOfAmenities);*/
			request.getRequestDispatcher("restaurantSingle.jsp").forward(request, response);
		}
	
	}

	
	

}
