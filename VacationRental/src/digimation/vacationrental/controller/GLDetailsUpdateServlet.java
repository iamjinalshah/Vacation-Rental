package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.dao.GLDetailsDAO;

public class GLDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String drpdnGuides = request.getParameter("drpdnGuides");
		String drpdnLanguages = request.getParameter("drpdnLanguages");
		String languageId = request.getParameter("languageId");
		
		boolean isError=false;
		GLDetailsBean glDetailsBean = new GLDetailsBean();
		
		
		if(isError){
			request.getRequestDispatcher("GLDetailsEdit.jsp").forward(request, response);
		}
		else{
			
			int drpdGuides = Integer.parseInt(drpdnGuides);
			glDetailsBean.setTourguide_id(drpdGuides);
			
			int drpLanguages = Integer.parseInt(drpdnLanguages);
			glDetailsBean.setGL_id(drpLanguages);
			
			int lid = Integer.parseInt(languageId);
			glDetailsBean.setLanguage_id(lid);
		
			System.out.println("Data ready for updation...");
			
			if(new GLDetailsDAO().update(glDetailsBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("glDetailsList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
