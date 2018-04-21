package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.RDCBean;
import digimation.vacationrental.dao.RDCDAO;

public class RDCEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rdcId = request.getParameter("rdcId");
		
		RDCBean rdcBean = new RDCDAO().getDataByPK(rdcId);
		
		if(rdcBean!=null){
			request.setAttribute("rdcBean", rdcBean);
			request.getRequestDispatcher("RDCEdit.jsp").forward(request, response);
		}
	}

}
