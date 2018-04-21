package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.util.ValidationUtils;


public class AmenitiesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String amenitiesId = request.getParameter("txtamenitiesId");
			String amenitiesName = request.getParameter("txtamenitiesName");
			
			boolean isError = false;
			
			AmenitiesBean amenitiesBean = new AmenitiesBean();
			
			if(ValidationUtils.isEmpty(amenitiesName)){
				request.setAttribute("amenitiesName","<font color=red>*Amenities name is Required</font>");
				isError =true;
			}
			else{
				amenitiesBean.setAmenitiesName(amenitiesName);
			}
			
			if(isError){
				request.getRequestDispatcher("Amenities.jsp").forward(request, response);
			}else{
	    		System.out.println("Data is ready for insertation.....");
	    	}
			
			if(new AmenitiesDAO().insert(amenitiesBean)){
				System.out.println("Data Inserted...");
				request.getRequestDispatcher("amenitiesList").forward(request, response);
			}else{
				System.out.println("oopsss!!! some problem...");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
