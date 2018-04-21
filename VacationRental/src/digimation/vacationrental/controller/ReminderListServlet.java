package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.ReminderBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.ReminderDAO;

public class ReminderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ReminderBean> listOfReminder = new ReminderDAO().list();
		
		if(listOfReminder!=null){
			request.setAttribute("listOfReminder", listOfReminder);
			request.getRequestDispatcher("ReminderList.jsp").forward(request, response);
		}
	}

}
