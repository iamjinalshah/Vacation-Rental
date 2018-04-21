package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.RestaurantPhotoDAO;

public class RestaurantPhotoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("photoId");
		System.out.println("photo-id :"+Id);
		
		RestaurantPhotoBean restaurantPhotoBean = new RestaurantPhotoDAO().getDatabyPK(Id);
		if(restaurantPhotoBean!=null){
			
			request.setAttribute("restaurantPhotoBean", restaurantPhotoBean);
			request.getRequestDispatcher("RestaurantPhotoEdit.jsp").forward(request, response);
			
		}
	
	}

}
