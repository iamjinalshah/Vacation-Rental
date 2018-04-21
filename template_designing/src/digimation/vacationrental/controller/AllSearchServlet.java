package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AttractionBean;
import digimation.vacationrental.bean.CarDetailsBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.AttractionDAO;
import digimation.vacationrental.dao.CarDetailsDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.dao.RestaurantDetailsDAO;
import digimation.vacationrental.dao.TourGuideDAO;


public class AllSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("action is:"+action);
		
		if(action.equalsIgnoreCase("hotelSearch")){
			List<HotelDetailsBean> listOfHotel = new HotelDetailsDAO().AllSearchlist();
			
			if(listOfHotel!= null){
				System.out.println("Hotel Search");
				request.setAttribute("listOfHotel", listOfHotel);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("hotelSearch.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("restaurantSearch")){
			List<ResataurantDetailsBean> listOfRestaurant = new RestaurantDetailsDAO().AllSearchlist();
			
			if(listOfRestaurant!= null){
				System.out.println("Restaurant Search");
				request.setAttribute("listOfRestaurant", listOfRestaurant);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("restaurantSearch.jsp").forward(request, response);
			}	
		
		}else if(action.equalsIgnoreCase("homeRentalSearch")){
			List<PropertyDetailsBean> listOfProperties = new PropertyDetailsDAO().AllSearchlist();
			
			if(listOfProperties!= null){
				request.setAttribute("listOfProperties", listOfProperties);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("propertySearch.jsp").forward(request, response);
			}
			
		}else if(action.equalsIgnoreCase("carRentalSearch")){
			List<CarDetailsBean> listOfCar = new CarDetailsDAO().AllSearchlist();
			
			if(listOfCar!= null){
				request.setAttribute("listOfCar", listOfCar);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("carRentalSearch.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("attractionSearch")){
			List<AttractionBean> listOfAttraction = new AttractionDAO().AllSearchlist();
			
			if(listOfAttraction!= null){
				request.setAttribute("listOfAttraction", listOfAttraction);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("attractionSearch.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("tourGuideSearch")){
			List<TourGuideBean> listOfGuide = new TourGuideDAO().AllSearchlist();
			
			if(listOfGuide!= null){
				request.setAttribute("listOfGuide", listOfGuide);
				request.setAttribute("search", "India");
				request.getRequestDispatcher("tourGuideSearch.jsp").forward(request, response);
			}
		}
	
	
	}

}
