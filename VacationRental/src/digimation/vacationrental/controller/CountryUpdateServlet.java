package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.util.ValidationUtils;


public class CountryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String country = request.getParameter("txtcountry");
		String cid = request.getParameter("countryId");
		
		boolean isError=false;
		CountryBean countryBean = new CountryBean();
		
		if(ValidationUtils.isEmpty(country)){
			
			request.setAttribute("country", "<font color=red>* country name is required</font>");
			isError=true;
		}else{
				countryBean.setCountry_name(country);
		}	
		
		if(isError){
			request.getRequestDispatcher("CountryEdit.jsp").forward(request, response);
		}
		else{
		
			int countryId = Integer.parseInt(cid);
			countryBean.setCountry_id(countryId);
			System.out.println("Data ready for updation...");
			
			if(new CountryDAO().update(countryBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("countryList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}
	

}
