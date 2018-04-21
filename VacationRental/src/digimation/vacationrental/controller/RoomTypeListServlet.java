package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.bean.RoomTypeBean;
import digimation.vacationrental.dao.HotelTypeDAO;
import digimation.vacationrental.dao.RoomTypeDAO;

public class RoomTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<RoomTypeBean> room = new RoomTypeDAO().list();
		
		if(room!=null){
			request.setAttribute("room", room);
			request.getRequestDispatcher("RoomTypeList.jsp").forward(request, response);
		}
	}

}
