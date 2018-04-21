package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.util.ValidationUtils;


public class AmenitiesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
			String propertyId = request.getParameter("propertyId");
			String[] amenitiesName = request.getParameterValues("chkAmenities");
			String allvalues = "";
			
			
			AmenitiesBean amenitiesBean = new AmenitiesBean();
			for (String amenitiesNames : amenitiesName) {
				allvalues += amenitiesNames.concat(",");
				String values = allvalues;
				 amenitiesBean.setAmenitiesName(values);
			}
			

			boolean isError = false;
			/*if(ValidationUtils.isEmpty(amenitiesName)){
				request.setAttribute("amenitiesName","<font color=red>*Amenities name is Required</font>");
				isError =true;
			}
			else{
				amenitiesBean.setAmenitiesName(amenitiesName);
			}*/
			
			if(isError){
				request.getRequestDispatcher("AmenitiesList.jsp").forward(request, response);
			}else{
				int id = Integer.parseInt(propertyId);
				amenitiesBean.setProperty_id(id);
				
	    		System.out.println("Data is ready for insertation.....");
			
	    		
			if(new AmenitiesDAO().insert(amenitiesBean)){
				System.out.println("Data Inserted...");
				request.setAttribute("propertyId", propertyId);
				request.getRequestDispatcher("propertyAmnitiesAfterAdd").forward(request, response);
			}else{
				System.out.println("oopsss!!! some problem...");
			}
			
			}
			
		}else{
			response.sendRedirect("login.jsp");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
