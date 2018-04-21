package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.dao.CountryDAO;


public class CountryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("countryId");
		System.out.println("c-id :"+Id);
		
		CountryBean country = new CountryDAO().getDatabyPK(Id);
		
		if(country!=null){
			
			request.setAttribute("country", country);
			request.getRequestDispatcher("CountryEdit.jsp").forward(request, response);
			
		}
	}
	

}
