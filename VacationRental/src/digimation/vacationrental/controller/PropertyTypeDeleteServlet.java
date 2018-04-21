package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.dao.PropertyTypeDAO;

public class PropertyTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ptypeId = request.getParameter("ptypeId");
		System.out.println("qid:"+ptypeId);
		
		if(new PropertyTypeDAO().fkchecking(ptypeId)){
			System.out.println("This Property type refer one city soo this country noty deleted...");
			request.setAttribute("fkchecking", "<font color=red>This Property type is not deleted...because It refer some other table...</font>");
			request.getRequestDispatcher("propertyTypeList").forward(request, response);
		}else{
		if(new PropertyTypeDAO().delete(ptypeId)){
			response.sendRedirect("propertyTypeList");
		}
		else{
			System.out.println("data not deleted..");
			response.sendRedirect("propertyTypeList");
		}
		}
	}

}
