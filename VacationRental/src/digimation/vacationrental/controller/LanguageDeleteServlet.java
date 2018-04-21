package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.LanguageDAO;

public class LanguageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String languageId = request.getParameter("languageId");
			System.out.println("id:"+languageId);
			
			if(new LanguageDAO().delete(languageId)){
				System.out.println("data deleted..");
				request.getRequestDispatcher("languageList").forward(request, response);
			}
			else{
				System.out.println("data not deleted...");
			}
			
	
	}

}
