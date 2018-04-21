package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.dao.GLDetailsDAO;

public class GLDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String languageId = request.getParameter("languageId");
		
		GLDetailsBean glDetailsBean = new GLDetailsDAO().getDataByPK(languageId);
		
		if(glDetailsBean!=null){
			request.setAttribute("glDetailsBean", glDetailsBean);
			request.getRequestDispatcher("GLDetailsEdit.jsp").forward(request, response);
		}
	}

}
