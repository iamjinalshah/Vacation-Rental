package digimation.vacationrental.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.dao.UserDAO;
import digimation.vacationrental.util.ValidationUtils;


public class PropertyDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
			
			String allvalues = "";
			String userId = request.getParameter("userId");
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
			String[] amenitiesName = request.getParameterValues("chkAmenities");
			
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
				request.setAttribute("email", "<font color=red>*Email Required</font>");
				isError=true;
			}else{
				propertyDetailsBean.setEmail_id(txtEmail);
			}
			
			if(ValidationUtils.isEmpty(txtMobile)){
				request.setAttribute("mobile", "<font color=red>* Required</font>");
				isError=true;
			}else{
				propertyDetailsBean.setMobile(txtMobile);
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
				
				
				for (String amenitiesNames : amenitiesName) {
					allvalues += amenitiesNames.concat(",");
					String values = allvalues;
					 propertyDetailsBean.setAmenities(values);
				}
				
				propertyDetailsBean.setLandline(txtLandline);
				
				int UserId = Integer.parseInt(userId);
				propertyDetailsBean.setUser_id(UserId);
				
				int City = Integer.parseInt(city);
				propertyDetailsBean.setCity_id(City);
				
				int Area = Integer.parseInt(area);
				propertyDetailsBean.setArea_id(Area);
				
				int State = Integer.parseInt(state);
				propertyDetailsBean.setState_id(State);
				
				int type = Integer.parseInt(drpdnproperty);
				propertyDetailsBean.setPtype_id(type);
				
				System.out.println("data ready for insertion...");
				
				if(new PropertyDetailsDAO().Propertyinsert(propertyDetailsBean)){
					System.out.println("data inserted into property,amenities and photos...");
					int pda_id = propertyDetailsBean.getProperty_id();
					System.out.println("pda_id:"+pda_id);
					request.setAttribute("pda_id", pda_id);
					request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
				}else{
					System.out.println("oops some problem...");
				}
			}
		
	}else{
		response.sendRedirect("login.jsp");
	}

	
	}

}
