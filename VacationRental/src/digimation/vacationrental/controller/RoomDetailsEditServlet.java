package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.RoomDetailsBean;
import digimation.vacationrental.dao.RoomDetailsDAO;


public class RoomDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		
		RoomDetailsBean roomDetailsBean = new RoomDetailsDAO().getDataByPK(roomId);
		
		if(roomDetailsBean!=null){
			request.setAttribute("roomDetailsBean", roomDetailsBean);
			request.getRequestDispatcher("RoomDetailsEdit.jsp").forward(request, response);
		}
	}

}
