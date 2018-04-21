package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;

public class PropertyDetailsAmenitiesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<PropertyDetailsAmenitiesBean> listOfPDA = new PropertyDetailsAmenitiesDAO().list();
		
		if(listOfPDA!=null){
			request.setAttribute("listOfPDA", listOfPDA);
			request.getRequestDispatcher("PropertyDetailsAmenitiesList.jsp").forward(request, response);
		}
	}

}
