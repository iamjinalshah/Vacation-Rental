package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.dao.RestaurantDetailsDAO;

public class RestaurantSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("txtSearch");
		System.out.println("rid:"+search);
		
		List<ResataurantDetailsBean> listOfRestaurant = new RestaurantDetailsDAO().Searchlist(search);
		
		if(listOfRestaurant!= null){
			request.setAttribute("listOfRestaurant", listOfRestaurant);
			request.getRequestDispatcher("RestaurantDetailsList.jsp").forward(request, response);
		}
	}

}
