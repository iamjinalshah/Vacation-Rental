package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.dao.CountryDAO;


public class CountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CountryBean> country = new CountryDAO().list();
		
		if(country!=null){
			request.setAttribute("country", country);
			request.getRequestDispatcher("CountryList.jsp").forward(request, response);
		}
	}
	

}
