package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.BookingDAO;
import digimation.vacationrental.dao.BookingStatusDAO;

public class BookingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookingId = request.getParameter("bookingId");
		System.out.println("id:"+bookingId);
		
		if(new BookingDAO().delete(bookingId)){
			System.out.println("data deleted..");
			request.getRequestDispatcher("bookingList").forward(request, response);
		}
		else{
			System.out.println("data not deleted...");
			request.getRequestDispatcher("bookingList").forward(request, response);
		}
	
	}

}
