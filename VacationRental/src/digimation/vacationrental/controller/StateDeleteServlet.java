package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.StateDAO;

public class StateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stateId = request.getParameter("stateId");
		System.out.println("sid:"+stateId);
		
		if(new StateDAO().fkchecking(stateId)){
			System.out.println("This State refer one city soo this country noty deleted...");
			request.setAttribute("fkchecking", "<font color=red>This state is not deleted...because It refer some other table...</font>");
			request.getRequestDispatcher("stateList").forward(request, response);
		}else{
		if(new StateDAO().delete(stateId)){
			response.sendRedirect("stateList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("stateList");
		}
	}
	}
}
