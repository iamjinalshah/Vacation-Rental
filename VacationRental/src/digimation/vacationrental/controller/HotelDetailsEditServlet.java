package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class HotelDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String hotelId = request.getParameter("hotelId");
		System.out.println("hid:"+hotelId);
		
		HotelDetailsBean hotelDetailsBean =new HotelDetailsDAO().getDatabyPK(hotelId);
		
		if(hotelDetailsBean!= null){
			request.setAttribute("hotelDetailsBean", hotelDetailsBean);
			request.getRequestDispatcher("HotelDetailsEdit.jsp").forward(request, response);
		}
	}

}
