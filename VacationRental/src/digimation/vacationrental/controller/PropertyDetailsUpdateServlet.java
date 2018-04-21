package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.util.ValidationUtils;

public class PropertyDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String propertyId = request.getParameter("propertyId");
		String txtTitle = request.getParameter("txtTitle");
		String txtAddress = request.getParameter("txtAddress");
		String txtOwnerName = request.getParameter("txtOwnerName");
		String txtEmail = request.getParameter("txtEmail");
		String txtMobile = request.getParameter("txtMobile");
		String txtLandline = request.getParameter("txtLandline");
		String txtRate  = request.getParameter("txtRate");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String state = request.getParameter("state");
		String drpdnproperty = request.getParameter("drpdnproperty");
		
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsBean();
		boolean isError = false;
		
		if(ValidationUtils.isEmpty(txtTitle)){
			request.setAttribute("title", "<font color=red>* Required</font>");
			isError=true;
		}else{
			propertyDetailsBean.setProperty_title(txtTitle);
		}
		
		if(ValidationUtils.isEmpty(txtOwnerName)){
			request.setAttribute("owner", "<font color=red>* Required</font>");
			isError=true;
		}else{
			propertyDetailsBean.setOwner_name(txtOwnerName);
		}

		if(ValidationUtils.isEmpty(txtAddress)){
			request.setAttribute("address", "<font color=red>* Required</font>");
			isError=true;
		}else{
			propertyDetailsBean.setAddress(txtAddress);
		}
		
		if(ValidationUtils.isEmpty(txtEmail)){
			request.setAttribute("email", "<font color=red>* Required</font>");
			isError=true;
		}else{
			propertyDetailsBean.setEmail_id(txtEmail);
		}
		
		if(ValidationUtils.isEmpty(txtMobile)){
			request.setAttribute("mobile", "<font color=red>* Required</font>");
			isError=true;
		}else{
			int mobile = Integer.parseInt(txtMobile);
			propertyDetailsBean.setMobile(mobile);
		}
		
		if(ValidationUtils.isEmpty(txtRate)){
			request.setAttribute("rate", "<font color=red>* Required</font>");
			isError=true;
		}else{
			int rate = Integer.parseInt(txtRate);
			propertyDetailsBean.setRate(rate);
		}
		
		if(isError){
			request.getRequestDispatcher("PropertyDetails.jsp").forward(request, response);
		}else{
			
			int landline = Integer.parseInt(txtLandline);
			propertyDetailsBean.setLandline(landline);
			
			int City = Integer.parseInt(city);
			propertyDetailsBean.setCity_id(City);
			
			int Area = Integer.parseInt(area);
			propertyDetailsBean.setArea_id(Area);
			
			int State = Integer.parseInt(state);
			propertyDetailsBean.setState_id(State);
			
			int type = Integer.parseInt(drpdnproperty);
			propertyDetailsBean.setPtype_id(type);
			
			int id = Integer.parseInt(propertyId);
			propertyDetailsBean.setProperty_id(id);
			
			System.out.println("data ready for updation...");
			
			if(new PropertyDetailsDAO().update(propertyDetailsBean)){
				System.out.println("Data Updated..");
				request.getRequestDispatcher("propertyDetailsList").forward(request, response);
			}else{
				System.out.println("oopssss some error...");
			}
		}
	
	
	}

}
