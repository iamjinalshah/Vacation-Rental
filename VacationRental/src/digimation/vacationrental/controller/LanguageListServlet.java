package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.dao.LanguageDAO;


public class LanguageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<LanguageBean> listOfLanguages = new LanguageDAO().list();
	
	if(listOfLanguages!=null){
		request.setAttribute("listOfLanguages", listOfLanguages);
		request.getRequestDispatcher("LanguageList.jsp").forward(request, response);
	}
	}

}
