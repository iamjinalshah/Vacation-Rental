package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.StateDAO;

public class CityDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cityId = request.getParameter("cityId");
		System.out.println("cid:"+cityId);
		
		if(new CityDAO().fkchecking(cityId)){
			System.out.println("This city refer one city soo this country noty deleted...");
			request.setAttribute("fkchecking", "<font color=red>This city is not deleted...because It refer some other table...</font>");
			request.getRequestDispatcher("cityList").forward(request, response);
		}else{
		if(new CityDAO().delete(cityId)){
			response.sendRedirect("cityList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("cityList");
		}
	}
	}

}
