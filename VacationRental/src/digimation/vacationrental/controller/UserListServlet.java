package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;

public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UserBean> listOfUser = new UserDAO().list();
		
		if(listOfUser!=null){
			request.setAttribute("listOfUser", listOfUser);
			request.getRequestDispatcher("UserList.jsp").forward(request, response);
			System.out.println("size:"+listOfUser.size());
		}
	}

}
