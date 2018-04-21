package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.RoomTypeBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.RoomTypeDAO;


public class RoomTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id=request.getParameter("rtypeId");
		System.out.println("c-id :"+Id);
		
		RoomTypeBean room = new RoomTypeDAO().getDatabyPK(Id);
		
		if(room!=null){
			
			request.setAttribute("room", room);
			request.getRequestDispatcher("RoomTypeEdit.jsp").forward(request, response);
			
		}
	}

}
