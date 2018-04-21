package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.StateDAO;

public class CityEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cityId=request.getParameter("cityId");
		System.out.println("c-id :"+cityId);
		
		CityBean cityBean = new CityDAO().getDaatabyPK(cityId);
		
		if(cityBean!=null){
			
			request.setAttribute("cityBean", cityBean);
			request.getRequestDispatcher("CityEdit.jsp").forward(request, response);
			
		}
	}

}
