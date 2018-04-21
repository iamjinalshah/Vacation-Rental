package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.RDCBean;
import digimation.vacationrental.dao.RDCDAO;

public class RDCListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<RDCBean> listOfRDC = new RDCDAO().list();
		
		if(listOfRDC!=null){
			
			request.setAttribute("listOfRDC", listOfRDC);
			request.getRequestDispatcher("RDCList.jsp").forward(request, response);
		}
		}
	

}
