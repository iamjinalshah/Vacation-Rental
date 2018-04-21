package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.dao.AmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;

public class PropertyDetailsAmenitiesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pdaId = request.getParameter("pdaId");
		
		PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean =new PropertyDetailsAmenitiesDAO().getDataByPK(pdaId);
		
		if(propertyDetailsAmenitiesBean!= null){
			request.setAttribute("propertyDetailsAmenitiesBean", propertyDetailsAmenitiesBean);
			request.getRequestDispatcher("propertyDetailsAmenitieEdit.jsp").forward(request, response);
		}
	}

}
