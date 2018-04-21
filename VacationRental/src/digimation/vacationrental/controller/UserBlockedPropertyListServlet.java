package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class UserBlockedPropertyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id = request.getParameter("userId");
		System.out.println("id:"+Id);
		
		List<PropertyDetailsBean> listOfUserProperty = new PropertyDetailsDAO().userBlockedPropertylist(Id);
		
		if(listOfUserProperty!=null){
			request.setAttribute("listOfUserProperty", listOfUserProperty);
			request.getRequestDispatcher("UserBlockedPropertyList.jsp").forward(request, response);
		}
	
	
	}

}
