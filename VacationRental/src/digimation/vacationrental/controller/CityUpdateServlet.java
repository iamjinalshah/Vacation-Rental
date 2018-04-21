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

public class CityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String city = request.getParameter("txtCity");
		String cityid = request.getParameter("cityId");
		System.out.println("iD:"+cityid);
		String drpdnState = request.getParameter("drpdnState");
		
		boolean isError=false;
		CityBean  cityBean = new CityBean();
		
		if(ValidationUtils.isEmpty(city)){
			
			request.setAttribute("city", "<font color=red>*City name is required</font>");
			isError=true;
		}else{
				cityBean.setCity_name(city);
		}	
		
		if(isError){
			request.getRequestDispatcher("CityEdit.jsp").forward(request, response);
		}
		else{
		
			int cityId = Integer.parseInt(cityid);
			cityBean.setCity_id(cityId);
			int drpState = Integer.parseInt(drpdnState);
			cityBean.setState_id(drpState);
					
			System.out.println("Data ready for updation...");
			
			if(new CityDAO().update(cityBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("cityList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
