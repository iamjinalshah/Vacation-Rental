package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.dao.GLDetailsDAO;


public class GLDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<GLDetailsBean> listOfLanguages = new GLDetailsDAO().list();
	
	if(listOfLanguages!=null){
		
		request.setAttribute("listOfLanguages", listOfLanguages);
		request.getRequestDispatcher("GLDetailsList.jsp").forward(request, response);
	}
	}

}
