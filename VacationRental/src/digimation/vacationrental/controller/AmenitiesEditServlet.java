package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.dao.AmenitiesDAO;


public class AmenitiesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String amenitiesId = request.getParameter("amenitiesId");
			System.out.println("aid:"+amenitiesId);
			AmenitiesBean amenitiesBean =new AmenitiesDAO().getDataByPK(amenitiesId);
			
			if(amenitiesBean!= null){
				request.setAttribute("amenitiesBean", amenitiesBean);
				request.getRequestDispatcher("AmenitiesEdit.jsp").forward(request, response);
			}
	}

	
	

}
