package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyTypeBean;
import digimation.vacationrental.dao.PropertyTypeDAO;

public class PropertyTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("ptypeId");
		System.out.println("ptype-id :"+Id);
		
		PropertyTypeBean property = new PropertyTypeDAO().getDatabyPK(Id);
		if(property!=null){
			
			request.setAttribute("property", property);
			request.getRequestDispatcher("PropertyTypeEdit.jsp").forward(request, response);
			
		}
	}

}
