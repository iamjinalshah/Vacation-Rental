package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.dao.AdminDAO;

public class AdminPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId = request.getParameter("adminId");
		String txtPassword = request.getParameter("txtPassword");
		System.out.println("pass:"+txtPassword);
		String txtConfirmPassword = request.getParameter("txtConfirmPassword");
		System.out.println("repass:"+txtConfirmPassword);
		
		AdminBean adminBean = new AdminBean();
		boolean isError = false;
		
		if(txtPassword.equals(txtConfirmPassword)){
	
		adminBean.setPassword(txtPassword);
		int id = Integer.parseInt(adminId);
		adminBean.setAdmin_id(id);
		System.out.println("data ready for insertion...");
		
		if(new AdminDAO().Passwordupdate(adminBean)){
			System.out.println("pssword updated...");
			request.setAttribute("reset", "<font color=red>Password successfully updated</font>");
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}else{
			System.out.println("some erroe...");
		}
		}else{
			request.setAttribute("same", "<font color=red>password and confirm password not same</font>");
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
		}
		
		}
	
	
	}


