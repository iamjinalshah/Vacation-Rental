package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.StateDAO;

public class StateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<StateBean> listOfState = new StateDAO().list();
		
		if(listOfState!=null){
			request.setAttribute("listOfState", listOfState);
			request.getRequestDispatcher("StateList.jsp").forward(request, response);
		}
	}

}
