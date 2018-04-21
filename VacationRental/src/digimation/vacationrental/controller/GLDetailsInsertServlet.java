package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.dao.GLDetailsDAO;


public class GLDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String drpdnGuides = request.getParameter("drpdnGuides");
		String drpdnLanguages = request.getParameter("drpdnLanguages");
		
		boolean isError=false;
		GLDetailsBean glDetailsBean = new GLDetailsBean();
		
		
		if(isError){
			request.getRequestDispatcher("GLDetails.jsp").forward(request, response);
		}
		else{
			
			int drpdGuides = Integer.parseInt(drpdnGuides);
			glDetailsBean.setTourguide_id(drpdGuides);
			
			int drpLanguages = Integer.parseInt(drpdnLanguages);
			glDetailsBean.setGL_id(drpLanguages);
		
			System.out.println("Data ready for insertion...");
			
			if(new GLDetailsDAO().insert(glDetailsBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("glDetailsList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
