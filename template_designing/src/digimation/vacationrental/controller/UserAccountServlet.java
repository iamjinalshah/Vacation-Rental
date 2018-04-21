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
import digimation.vacationrental.dao.UserDAO;


public class UserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String userId = request.getParameter("userId");
		System.out.println("id:"+userId);
		
		UserBean accountInfo = new UserDAO().Account_info(userId);
		
		if(accountInfo!=null){
			request.setAttribute("accountInfo", accountInfo);
			request.getRequestDispatcher("userAccount.jsp").forward(request, response);
		}
		
	}else{
		response.sendRedirect("login.jsp");
	}
	}

}
