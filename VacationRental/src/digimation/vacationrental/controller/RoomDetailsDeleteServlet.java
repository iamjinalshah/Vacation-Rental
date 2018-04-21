package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;
import digimation.vacationrental.dao.RoomDetailsDAO;


public class RoomDetailsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		
		if(new RoomDetailsDAO().delete(roomId)){
			response.sendRedirect("roomDetailsList");
		}else{
			response.sendRedirect("roomDetailsList");
		}
	}

}
