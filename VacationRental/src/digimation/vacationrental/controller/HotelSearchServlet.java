package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;

public class HotelSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("txtSearch");
		System.out.println("hid:"+search);
		
		List<HotelDetailsBean> listOfHotel = new HotelDetailsDAO().Searchlist(search);
		
		if(listOfHotel!= null){
			request.setAttribute("listOfHotel", listOfHotel);
			request.getRequestDispatcher("HotelDetailsList.jsp").forward(request, response);
		}
		}
	
	
	

}
