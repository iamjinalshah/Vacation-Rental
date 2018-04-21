package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelTypeDAO;
import digimation.vacationrental.dao.RoomTypeDAO;

public class RoomTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rtypeId = request.getParameter("rtypeId");
		System.out.println("hid:"+rtypeId);
		if(new RoomTypeDAO().delete(rtypeId)){
			response.sendRedirect("roomTypeList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("roomTypeList");
		}
	}

}
