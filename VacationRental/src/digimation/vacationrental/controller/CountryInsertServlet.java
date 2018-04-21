
package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CountryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String country = request.getParameter("txtCountry");

		boolean isError=false;
		CountryBean countryBean = new CountryBean();
		
		if(ValidationUtils.isEmpty(country)){
			
			request.setAttribute("country", "<font color=red>* Country name is required</font>");
			isError=true;
		}else{
			countryBean.setCountry_name(country);
		}
		
		if(ValidationUtils.isChar(country)){
			
			request.setAttribute("pattern", "<font color:red>* Numbers not allowed...</font>");
			isError = true;
		}
		
		if(isError){
			request.getRequestDispatcher("Country.jsp").forward(request, response);
		}
		else{
		
			System.out.println("Data ready for insertion...");
			
			if(new CountryDAO().duplicate(countryBean)){
				System.out.println("data already exist");
				request.setAttribute("duplicate", "<font color=red>"+country+"</font> is already exist in database...");
				request.getRequestDispatcher("Country.jsp").forward(request, response);
			}else{
				
				if(new CountryDAO().insert(countryBean)){
					System.out.println("data inserted into database...");
					request.getRequestDispatcher("countryList").forward(request, response);
					
				}
				else{
					System.out.println("ooops some problem occur..");
				}
			}
		}
	}
	
	
}
