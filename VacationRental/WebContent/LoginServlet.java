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
import digimation.vacationrental.util.ValidationUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("txtEmail");
		System.out.println("email:"+email);
		String password = request.getParameter("txtPassword");
		System.out.println("password:"+password);
		
		boolean isError=false;
		AdminBean adminBean = new AdminBean();
		UserBean userBean = new UserBean();
		
		if(ValidationUtils.isEmpty(email)){
			request.setAttribute("email", "<font color=red>* Required</font>");
			isError=true;
		}else{
			
			adminBean.setEmail_id(email);
			userBean.setEmail_id(email);
		}
		
		if(ValidationUtils.isEmpty(password)){
			request.setAttribute("password", "<font color=red>* Required</font>");
			isError=true;
		}else{
			
			adminBean.setPassword(password);
			userBean.setPassword(password);
		}
		
		if(isError){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			System.out.println("data ready for login...");
			
			AdminBean bean = new AdminDAO().login(adminBean);
			UserBean bean2 = new UserDAO().login(userBean);
			
			if(bean!=null && bean.getAdmin_id()!=0){
				
				HttpSession session = request.getSession();
				session.setAttribute("bean", bean);
				System.out.println("Admin Panel");
				System.out.println("successfull login...");
				request.getRequestDispatcher("AdminPanel.jsp").forward(request, response);
			}else if(bean!=null && bean2.getUser_id()!=0){
				HttpSession session = request.getSession();
				session.setAttribute("bean2", bean2);
				System.out.println("User Panel");
				System.out.println("successfull login...");
				request.getRequestDispatcher("UserPanel.jsp").forward(request, response);
				
			}else{
				request.setAttribute("invalidLogin", "<font color=red>Invalid Login and password...</font>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}
	
	}

}
