package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.GLDetailsDAO;
import digimation.vacationrental.dao.RDCDAO;

public class RDCDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rdcId = request.getParameter("rdcId");
		 
		 if(new RDCDAO().delete(rdcId)){
			 System.out.println("Data Deleted");
			 response.sendRedirect("rdcList");
		 }
	}

}
