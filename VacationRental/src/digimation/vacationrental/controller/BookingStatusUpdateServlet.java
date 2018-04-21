package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.dao.BookingStatusDAO;
import digimation.vacationrental.util.ValidationUtils;

public class BookingStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("bookingStatusId");
		System.out.println("bookingStatusId:"+Id);
		
		String bookingStatus = request.getParameter("txtBookingStatus");
		
		boolean isError = false;
		BookingStatusBean bookingStatusBean = new BookingStatusBean();
		
		if(ValidationUtils.isEmpty(bookingStatus)){
			request.setAttribute("bookingStatus", "* bookingStatus is required");
			isError=true;
		}else{
			bookingStatusBean.setBookingstatus(bookingStatus);
		}
		
		if(isError){
			request.getRequestDispatcher("BookingEdit.jsp").forward(request, response);
		}else{
			 
			int bookingStatusId = Integer.parseInt(Id);
			bookingStatusBean.setBookingstatusid(bookingStatusId);
			System.out.println("data ready for updation...");
			
			if(new BookingStatusDAO().update(bookingStatusBean)){
				System.out.println("data are updated...");
				request.getRequestDispatcher("bookingStatusList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
	
	}

}
