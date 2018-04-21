package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CategoryBean;
import digimation.vacationrental.dao.CategoryDAO;


public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<CategoryBean> listOfCategory = new CategoryDAO().list();
	
	if(listOfCategory!=null){
		request.setAttribute("listOfCategory", listOfCategory);
		request.getRequestDispatcher("HRCategoryList.jsp").forward(request, response);
	}
	}

}
