package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class PropertyDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String propertyId = request.getParameter("propertyId");
		System.out.println("pid:"+propertyId);
		
		PropertyDetailsBean propertyDetailsBean =new PropertyDetailsDAO().getDatabyPK(propertyId);
		
		if(propertyDetailsBean!= null){
			request.setAttribute("propertyDetailsBean", propertyDetailsBean);
			request.getRequestDispatcher("PropertyDetailsEdit.jsp").forward(request, response);
		}
		
	}

}
