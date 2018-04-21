package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.RoomTypeDAO;

public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId = request.getParameter("adminId");
		System.out.println("admin-id:"+adminId);
		if(new AdminDAO().delete(adminId)){
			response.sendRedirect("adminList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("adminList");
		}
	
	
	}

}
