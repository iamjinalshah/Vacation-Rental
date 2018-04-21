package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.RoomDetailsBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;
import digimation.vacationrental.dao.RoomDetailsDAO;


public class RoomDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<RoomDetailsBean> listOfRooms = new RoomDetailsDAO().list();
		
		if(listOfRooms!=null){
			request.setAttribute("listOfRooms", listOfRooms);
			request.getRequestDispatcher("RoomDetailsList.jsp").forward(request, response);
		}
	
	}

}
