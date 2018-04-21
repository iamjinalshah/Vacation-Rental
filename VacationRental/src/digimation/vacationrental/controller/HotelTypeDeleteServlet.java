package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.HotelTypeDAO;

public class HotelTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String htypeId = request.getParameter("htypeId");
		System.out.println("hid:"+htypeId);
		
		if(new HotelTypeDAO().fkchecking(htypeId)){
			request.setAttribute("fkchecking", "<font color=red>This Hotel Type is not deleted...because It refer some other table...</font>");
			request.getRequestDispatcher("hotelTypeList").forward(request, response);
		}else{
		if(new HotelTypeDAO().delete(htypeId)){
			response.sendRedirect("hotelTypeList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("hotelTypeList");
		}
		}
	}

}
