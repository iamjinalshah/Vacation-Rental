package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CategoryBean;
import digimation.vacationrental.dao.CategoryDAO;


public class CategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryId = request.getParameter("categoryId");
		System.out.println("id:"+categoryId);
		
		CategoryBean categoryBean  = new CategoryDAO().getDataByPK(categoryId);
		
		if(categoryBean!=null){
			request.setAttribute("categoryBean", categoryBean);
			request.getRequestDispatcher("HRCategoryEdit.jsp").forward(request, response);
		}
	}

}
