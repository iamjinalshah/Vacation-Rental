package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.UserDAO;

public class UserIsActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		System.out.println("id:"+userId);
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("false")){
			if(new UserDAO().isActiveTrue(userId)){
			System.out.println("User is now activated");
			request.getRequestDispatcher("userList").forward(request, response);
			}else{
				System.out.println("error...");
			}
		}else if(action.equalsIgnoreCase("true")){
			if(new UserDAO().isActiveFalse(userId)){
			System.out.println("User is now Blocked");
			request.getRequestDispatcher("userList").forward(request, response);
			
				}else{
					System.out.println("error..");
				}
			}
	}

}
