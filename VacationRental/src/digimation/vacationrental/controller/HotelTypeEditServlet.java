package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.dao.HotelTypeDAO;

public class HotelTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("htypeId");
		System.out.println("htype-id :"+Id);
		
		HotelTypeBean hotel = new HotelTypeDAO().getDatabyPK(Id);
		if(hotel!=null){
			
			request.setAttribute("hotel", hotel);
			request.getRequestDispatcher("HotelTypeEdit.jsp").forward(request, response);
			
		}
	}

}
