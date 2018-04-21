package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AreaDAO;
import digimation.vacationrental.dao.CityDAO;

public class AreaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String areaId = request.getParameter("areaId");
		System.out.println("Aid:"+areaId);
		
		
		if(new AreaDAO().delete(areaId)){
			response.sendRedirect("areaList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("areaList");
		}

	
	}

}
