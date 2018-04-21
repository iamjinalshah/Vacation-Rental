package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AreaBean;
import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.dao.AreaDAO;
import digimation.vacationrental.dao.CityDAO;

public class AreaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<AreaBean> listOfArea = new AreaDAO().list();
		
		if(listOfArea!=null){
			request.setAttribute("listOfArea", listOfArea);
			request.getRequestDispatcher("AreaList.jsp").forward(request, response);
		}
	
	}

}
