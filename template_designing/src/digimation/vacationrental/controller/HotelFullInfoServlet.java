package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.HotelPhotoDAO;

public class HotelFullInfoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hotelId = request.getParameter("hotelId");
		System.out.println("hotelId:");

		HotelDetailsBean hotelDetailsBean = new HotelDetailsDAO().hotelFullInfo(hotelId);
		List<HotelPhotoBean> listOfHotelPhotos = new HotelPhotoDAO().Hotelphotolist(hotelId);

		if (hotelDetailsBean != null && listOfHotelPhotos != null) {
			
			System.out.println("succesfully fetch all data");
			
			request.setAttribute("hotelDetailsBean", hotelDetailsBean);
			request.setAttribute("listOfHotelPhotos", listOfHotelPhotos);
			request.getRequestDispatcher("hotelSingle.jsp").forward(request, response);
		}

	}

}
