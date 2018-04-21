package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingBean;
import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.dao.BookingDAO;
import digimation.vacationrental.dao.BookingStatusDAO;

public class BookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BookingBean> listOfBooking = new BookingDAO().list();
		
		if(listOfBooking!=null){
			request.setAttribute("listOfBooking", listOfBooking);
			request.getRequestDispatcher("BookingList.jsp").forward(request, response);
		}
	
	}

}
