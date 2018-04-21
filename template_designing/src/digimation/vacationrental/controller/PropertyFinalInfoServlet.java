package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;


public class PropertyFinalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		int pdaId = (Integer) request.getAttribute("pdaId");
		System.out.println("PDA_id:"+pdaId);
		
	PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesDAO().PropertyAllInfo(pdaId);
	
	if(propertyDetailsAmenitiesBean!=null){
		request.setAttribute("propertyDetailsAmenitiesBean", propertyDetailsAmenitiesBean);
		request.getRequestDispatcher("PropertyFinalInfo.jsp").forward(request, response);
	}
	
	}else{
		response.sendRedirect("login.jsp");
	}
		
	}
}
