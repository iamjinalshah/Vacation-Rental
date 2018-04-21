package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class HotelDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 List<HotelDetailsBean> listOfHotel = new HotelDetailsDAO().list();
		
		if(listOfHotel!=null){
			request.setAttribute("listOfHotel", listOfHotel);
			request.getRequestDispatcher("HotelDetailsList.jsp").forward(request, response);
		}
	
	}

}
