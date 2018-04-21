package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AreaBean;
import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.dao.AreaDAO;
import digimation.vacationrental.dao.CityDAO;

public class AreaEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String areaId = request.getParameter("areaId");
		System.out.println("A-id :"+areaId);
		
		AreaBean areaBean = new AreaDAO().getDaatabyPK(areaId);
		
		if(areaBean!=null){
			
			request.setAttribute("areaBean", areaBean);
			request.getRequestDispatcher("AreaEdit.jsp").forward(request, response);
			
		}
	
	}

}
