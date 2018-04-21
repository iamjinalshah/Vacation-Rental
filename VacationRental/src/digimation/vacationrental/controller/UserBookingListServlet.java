package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.BookingDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class UserBookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id = request.getParameter("userId");
		System.out.println("Booking id:"+Id);
		
		List<BookingBean> listOfUserBooking = new BookingDAO().userBookinglist(Id);
		
		if(listOfUserBooking!=null){
			request.setAttribute("listOfUserBooking", listOfUserBooking);
			request.getRequestDispatcher("UserBookingList.jsp").forward(request, response);
		}
	
	}

}
