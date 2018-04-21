package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;

public class UserPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String txtPassword = request.getParameter("txtPassword");
		System.out.println("pass:"+txtPassword);
		String txtConfirmPassword = request.getParameter("txtConfirmPassword");
		System.out.println("repass:"+txtConfirmPassword);
		System.out.println("userId:"+userId);
		UserBean userBean = new UserBean();
		boolean isError = false;
		HttpSession session = request.getSession();
		if(txtPassword.equals(txtConfirmPassword)){
	
		userBean.setPassword(txtPassword);
		int id = Integer.parseInt(userId);
		System.out.println("userId:"+id);
		userBean.setUser_id(id);
		System.out.println("data ready for insertion...");
		
		if(new UserDAO().Passwordupdate(userBean)){
			System.out.println("pssword updated...");
			request.setAttribute("reset", "<font color=red>Password successfully updated</font>");
			request.getRequestDispatcher("login.jsp");
		}else{
			System.out.println("some erroe...");
		}
		}else{
			request.setAttribute("same", "<font color=red>password and confirm password not same</font>");
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
		
		}
	
	
	}


