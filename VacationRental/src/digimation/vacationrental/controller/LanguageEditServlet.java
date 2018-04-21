package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.dao.LanguageDAO;


public class LanguageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String languageId = request.getParameter("languageId");
		System.out.println("id:"+languageId);
		
		LanguageBean languageBean  = new LanguageDAO().getDataByPK(languageId);
		
		if(languageId!=null){
			request.setAttribute("languageBean", languageBean);
			request.getRequestDispatcher("LanguageEdit.jsp").forward(request, response);
		}
	}

}
