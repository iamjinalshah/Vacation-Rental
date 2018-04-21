package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;


public class PropertyAmenitiesAfterAddServlet extends HttpServlet {
	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String propertyId = (String) request.getAttribute("propertyId");
		System.out.println("propertyid:"+propertyId);
		
		List<AmenitiesBean> amenitiesBeans = new AmenitiesDAO().Amenitieslist(propertyId);
		
		if(amenitiesBeans!= null){
			request.setAttribute("amenitiesBeans", amenitiesBeans);
			request.setAttribute("propertyId", propertyId);
			request.getRequestDispatcher("AmenitiesList.jsp").forward(request, response);
		}
		
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
