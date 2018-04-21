package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.util.ValidationUtils;


public class AmenitiesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String amenitiesId = request.getParameter("amenitiesId");
			String amenitiesName = request.getParameter("txtamenitiesName");
			
			boolean isError = false;
			
			AmenitiesBean amenitiesBean = new AmenitiesBean();
			
			if(ValidationUtils.isEmpty(amenitiesName)){
				request.setAttribute("amenitiesName","<font color=red>*Required</font>");
				isError =true;
			}
			else{
				amenitiesBean.setAmenitiesName(amenitiesName);
			}
			
			if(isError){
				request.getRequestDispatcher("Amenities.jsp").forward(request, response);
			}else{
				int amenitiesid=Integer.parseInt(amenitiesId);
				amenitiesBean.setAmenitiesId(amenitiesid);
	    		System.out.println("Data is ready for updation.....");
	    	}
			
			if(new AmenitiesDAO().update(amenitiesBean)){
				System.out.println("Data Updated...");
				request.getRequestDispatcher("amenitiesList").forward(request, response);
			}else{
				System.out.println("oopsss!!! some problem...");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
