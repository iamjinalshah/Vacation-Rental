package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CountryDAO;


public class CountryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String countryId = request.getParameter("countryId");
		System.out.println("cid:"+countryId);
		
		if(new CountryDAO().fkchecking(countryId)){
			System.out.println("This country refer one city soo this country noty deleted...");
			request.setAttribute("fkchecking", "<font color=red>This state is not deleted...because It refer some other table...</font>");
			request.getRequestDispatcher("countryList").forward(request, response);
		}else{
		
		if(new CountryDAO().delete(countryId)){
			response.sendRedirect("countryList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("countryList");
		}

		}
	}

}
