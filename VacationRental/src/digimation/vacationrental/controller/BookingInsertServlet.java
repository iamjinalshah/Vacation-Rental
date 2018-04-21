package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingBean;
import digimation.vacationrental.dao.BookingDAO;
import digimation.vacationrental.util.ValidationUtils;

public class BookingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String txtDate = request.getParameter("txtDate");
	String drpdnStatus = request.getParameter("drpdnStatus");
	String drpdnHotel = request.getParameter("drpdnHotel");
	String drpdnproperty = request.getParameter("drpdnproperty");
	
	BookingBean bookingBean = new BookingBean();
	boolean isError = false;
	
	if(ValidationUtils.isEmpty(txtDate)){
		request.setAttribute("date", "<font color=red>*Required</font>");
		isError=true;
	}else{
		bookingBean.setBooking_date(txtDate);
	}
	
	if(ValidationUtils.isEmpty(drpdnStatus)){
		request.setAttribute("status", "<font color=red>*Required</font>");
		isError=true;
	}else{
		int status = Integer.parseInt(drpdnStatus);
		bookingBean.setBookingstatusid(status);
	}
	
	if(isError){
		request.getRequestDispatcher("Booking.jsp").forward(request, response);
	}else{
		
		int hotel = Integer.parseInt(drpdnHotel);
		bookingBean.setHotel_id(hotel);
		
		int property = Integer.parseInt(drpdnproperty);
		bookingBean.setProperty_id(property);
	}
		System.out.println("data ready for insertion...");
		if(new BookingDAO().insert(bookingBean)){
			System.out.println("dtat inserted...");
			request.getRequestDispatcher("bookingList").forward(request, response);
		}else{
			System.out.println("ooopsss some error...");
		}
	}
		
	}
	


