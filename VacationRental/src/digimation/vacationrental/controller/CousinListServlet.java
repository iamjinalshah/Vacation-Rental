package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CousinBean;
import digimation.vacationrental.dao.CousinDAO;



public class CousinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<CousinBean> listOfCousins = new CousinDAO().list();
	
	if(listOfCousins!=null){
		request.setAttribute("listOfCousins", listOfCousins);
		request.getRequestDispatcher("CousinList.jsp").forward(request, response);
	}
	}

}
