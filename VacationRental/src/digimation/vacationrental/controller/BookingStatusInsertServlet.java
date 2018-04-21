package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.dao.BookingStatusDAO;
import digimation.vacationrental.util.ValidationUtils;

public class BookingStatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookingStatus = request.getParameter("txtBookingStatus");
		boolean isError = false;
		BookingStatusBean bookingStatusBean = new BookingStatusBean();

		if (ValidationUtils.isEmpty(bookingStatus)) {
			request.setAttribute("bookingStatus", "* bookingStatus is required");
			isError = true;
		} else {
			bookingStatusBean.setBookingstatus(bookingStatus);
		}

		if (isError) {
			request.getRequestDispatcher("BookingStatus.jsp").forward(request, response);
		} else {

			System.out.println("data ready for insertion...");

			if (new BookingStatusDAO().insert(bookingStatusBean)) {
				System.out.println("data are inserted...");
				request.getRequestDispatcher("bookingStatusList").forward(request, response);
			} else {
				System.out.println("oopss some error...");
			}
		}
	}
}