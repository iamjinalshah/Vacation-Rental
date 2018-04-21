package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.dao.BookingStatusDAO;


public class BookingStatusEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookingStatusId = request.getParameter("bookingStatusId");
		System.out.println("id:"+bookingStatusId);
		
		BookingStatusBean bookingStatusBean  = new BookingStatusDAO().getDataByPK(bookingStatusId);
		
		if(bookingStatusBean!=null){
			request.setAttribute("bookingStatusBean", bookingStatusBean);
			request.getRequestDispatcher("BookingStatusEdit.jsp").forward(request, response);
		}
	}

}
