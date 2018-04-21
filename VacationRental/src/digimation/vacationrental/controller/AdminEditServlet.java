package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.CountryDAO;

public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId=request.getParameter("adminId");
		System.out.println("admin-id :"+adminId);
		
		AdminBean admin = new AdminDAO().getDatabyPK(adminId);
		
		if(admin!=null){
			
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
			
		}
	}

}
