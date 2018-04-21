package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.StateDAO;
import digimation.vacationrental.util.ValidationUtils;


public class StateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state = request.getParameter("txtState");
		String stateid = request.getParameter("stateId");
		System.out.println("iD:"+stateid);
		String drpdnCountry = request.getParameter("drpdnCountry");
		
		boolean isError=false;
		StateBean stateBean = new StateBean();
		
		if(ValidationUtils.isEmpty(stateid)){
			
			request.setAttribute("stateid", "<font color=red>* stateid is required</font>");
			isError=true;
		}else{
				stateBean.setState_name(state);
		}	
		
		if(isError){
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
		}
		else{
		
			int stateId = Integer.parseInt(stateid);
			stateBean.setState_id(stateId);
			int drpCountry = Integer.parseInt(drpdnCountry);
			stateBean.setCountry_id(drpCountry);
					
			System.out.println("Data ready for updation...");
			
			if(new StateDAO().update(stateBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("stateList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}
	

}
