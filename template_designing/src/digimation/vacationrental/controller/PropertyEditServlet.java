package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;


public class PropertyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String propertyId = request.getParameter("propertyId");
		System.out.println("P_id:"+propertyId);
		
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsDAO().getDatabyPK(propertyId);	
		
	if(propertyDetailsBean!=null){
		request.setAttribute("propertyDetailsBean", propertyDetailsBean);
		request.getRequestDispatcher("PropertyEdit.jsp").forward(request, response);
	}
	
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
