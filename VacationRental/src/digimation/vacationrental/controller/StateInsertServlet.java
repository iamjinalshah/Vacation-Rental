package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.StateDAO;
import digimation.vacationrental.util.ValidationUtils;

public class StateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String state = request.getParameter("txtState");
		String drpCountry = request.getParameter("drpdnCountry");
		System.out.println("id:"+drpCountry);
		
		boolean isError=false;
		StateBean stateBean = new StateBean();
		
		if(ValidationUtils.isEmpty(state)){
			
			request.setAttribute("state", "<font color=red>* State name is required</font>");
			isError=true;
		}else{
			stateBean.setState_name(state);
		}
		
		if(isError){
			request.getRequestDispatcher("Country.jsp").forward(request, response);
		}
		else{
			
			int drpdnCountry = Integer.parseInt(drpCountry);
			stateBean.setState_id(drpdnCountry);
		
			System.out.println("Data ready for insertion...");
			
			if(new StateDAO().insert(stateBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("stateList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
