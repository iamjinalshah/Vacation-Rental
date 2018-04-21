package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.StateDAO;

public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CityBean> listOfCity = new CityDAO().list();
		
		if(listOfCity!=null){
			request.setAttribute("listOfCity", listOfCity);
			request.getRequestDispatcher("CityList.jsp").forward(request, response);
		}
	}

}
