package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CategoryDAO;


public class CategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String categoryId = request.getParameter("categoryId");
			System.out.println("id:"+categoryId);
			
			if(new CategoryDAO().delete(categoryId)){
				System.out.println("data deleted..");
				request.getRequestDispatcher("categoryList").forward(request, response);
			}
			else{
				System.out.println("data not deleted...");
			}
			
	
	}

}
