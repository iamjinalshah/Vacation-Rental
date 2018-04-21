package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CategoryBean;
import digimation.vacationrental.dao.CategoryDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CategoryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryName = request.getParameter("txtCategoryName");
		boolean isError = false;
		CategoryBean categoryBean = new CategoryBean();
		
		if(ValidationUtils.isEmpty(categoryName)){
			request.setAttribute("categoryName", "* categoryName is required");
			isError=true;
		}else{
			categoryBean.setCategory_Name(categoryName);
		}
		
		if(isError){
			request.getRequestDispatcher("HRCategory.jsp").forward(request, response);
		}else{
			
			System.out.println("data ready for insertion...");
			
			if(new CategoryDAO().insert(categoryBean)){
				System.out.println("data are inserted...");
				request.getRequestDispatcher("categoryList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
}
} 