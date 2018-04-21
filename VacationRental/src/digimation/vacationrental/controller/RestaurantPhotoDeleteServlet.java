package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.RestaurantPhotoDAO;

public class RestaurantPhotoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String photoId = request.getParameter("photoId");
		System.out.println("photo-id:"+photoId);
		if(new RestaurantPhotoDAO().delete(photoId)){
			response.sendRedirect("restaurantPhotoList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("restaurantPhotoList");
		}
	
	}

}
