package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsDAO;


public class UserPropertyEditListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String Id = (String) request.getAttribute("userId");
		System.out.println("id:"+Id);
		
		
		
		List<PropertyDetailsBean> listOfUserProperty = new PropertyDetailsDAO().userPropertylist(Id);
		
		if(listOfUserProperty!=null){
			request.setAttribute("listOfUserProperty", listOfUserProperty);
			request.getRequestDispatcher("userPropertyList.jsp").forward(request, response);
		}
		
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
