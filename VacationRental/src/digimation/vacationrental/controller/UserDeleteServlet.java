package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;

public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("admin-id:"+userId);
		
		if(new UserDAO().delete(userId)){
			response.sendRedirect("userList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("userList");
		}
	}

}
