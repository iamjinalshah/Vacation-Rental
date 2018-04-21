package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.StateDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String city = request.getParameter("txtCity");
		String drpState = request.getParameter("drpdnState");
		System.out.println("id:"+drpState);
		
		boolean isError=false;
		CityBean cityBean = new CityBean();
		
		if(ValidationUtils.isEmpty(city)){
			
			request.setAttribute("city", "<font color=red>* City name is required</font>");
			isError=true;
		}else{
			cityBean.setCity_name(city);
		}
		
		if(isError){
			request.getRequestDispatcher("City.jsp").forward(request, response);
		}
		else{
			
			int drpdnState = Integer.parseInt(drpState);
			cityBean.setState_id(drpdnState);
		
			System.out.println("Data ready for insertion...");
			
			if(new CityDAO().insert(cityBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("cityList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}

	}

}
