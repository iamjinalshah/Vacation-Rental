package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyTypeBean;
import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.PropertyTypeDAO;
import digimation.vacationrental.dao.QuestionDAO;

public class PropertyTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<PropertyTypeBean> property = new PropertyTypeDAO().list();
		
		if(property!=null){
			request.setAttribute("property", property);
			request.getRequestDispatcher("PropertyTypeList.jsp").forward(request, response);
		}
	}

}
