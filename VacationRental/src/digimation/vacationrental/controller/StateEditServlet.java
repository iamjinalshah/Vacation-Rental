package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.StateDAO;

public class StateEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stateId=request.getParameter("stateId");
		System.out.println("s-id :"+stateId);
		
		StateBean stateBean = new StateDAO().getDaatabyPK(stateId);
		
		if(stateBean!=null){
			
			request.setAttribute("stateBean", stateBean);
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
			
		}
	}

}
