package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingBean;
import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.dao.BookingDAO;
import digimation.vacationrental.dao.BookingStatusDAO;

public class BookingEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookingId = request.getParameter("bookingId");
		System.out.println("id:"+bookingId);
		
		BookingBean bookingBean  = new BookingDAO().getDataByPK(bookingId);
		
		if(bookingBean!=null){
			request.setAttribute("bookingBean", bookingBean);
			request.getRequestDispatcher("BookingEdit.jsp").forward(request, response);
		}
	}

}
