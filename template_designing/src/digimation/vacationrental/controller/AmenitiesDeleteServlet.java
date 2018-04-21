package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.CityDAO;


public class AmenitiesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
			String amenitiesId = request.getParameter("amenitiesId");
			System.out.println("amenId:"+amenitiesId);
			String propertyId = request.getParameter("propertyId");
			System.out.println("propId:"+propertyId);
			
			
			if(new AmenitiesDAO().delete(amenitiesId)){
				System.out.println("data deleted");
				request.setAttribute("propertyId", propertyId);
				request.getRequestDispatcher("propertyAmnitiesAfterAdd").forward(request, response);
			}else{
				System.out.println("data not deleted");
				response.sendRedirect("propertyAmnitiesAfterAdd");
			}
			
		}else{
			response.sendRedirect("login.jsp");
		}
			
	}

}
