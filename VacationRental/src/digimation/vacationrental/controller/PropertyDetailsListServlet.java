package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;

public class PropertyDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<PropertyDetailsBean> listOfProperty = new PropertyDetailsDAO().list();
		
		if(listOfProperty!=null){
			request.setAttribute("listOfProperty", listOfProperty);
			request.getRequestDispatcher("PropertyDetailsList.jsp").forward(request, response);
		}
	
	}

}
