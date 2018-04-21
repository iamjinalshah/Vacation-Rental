package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CousinBean;
import digimation.vacationrental.dao.CousinDAO;


public class CousinEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cousinId = request.getParameter("cousinId");
		System.out.println("id:"+cousinId);
		
		CousinBean cousinBean  = new CousinDAO().getDataByPK(cousinId);
		
		if(cousinBean!=null){
			request.setAttribute("cousinBean", cousinBean);
			request.getRequestDispatcher("CousinEdit.jsp").forward(request, response);
		}
	}

}
