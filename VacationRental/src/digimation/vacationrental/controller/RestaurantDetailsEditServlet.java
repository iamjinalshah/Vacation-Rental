package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;

public class RestaurantDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurantId = request.getParameter("restaurantId");
		System.out.println("Rid:"+restaurantId);
		
		ResataurantDetailsBean resataurantDetailsBean = new RestaurantDetailsDAO().getDatabyPK(restaurantId);
		
		if(resataurantDetailsBean!= null){
			request.setAttribute("resataurantDetailsBean", resataurantDetailsBean);
			request.getRequestDispatcher("RestaurantDetailsEdit.jsp").forward(request, response);
		}
	}

}
