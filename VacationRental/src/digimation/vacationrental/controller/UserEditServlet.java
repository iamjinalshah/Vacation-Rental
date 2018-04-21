package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;

public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId=request.getParameter("userId");
		System.out.println("user-id :"+userId);
		
		UserBean userBean = new UserDAO().getDatabyPK(userId);
		
		if(userBean!=null){
			
			request.setAttribute("userBean", userBean);
			request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
			
		}
	
	}

}
