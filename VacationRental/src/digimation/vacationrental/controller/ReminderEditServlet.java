package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.ReminderBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.ReminderDAO;

public class ReminderEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reminderId=request.getParameter("reminderId");
		System.out.println("reminder-id :"+reminderId);
		
		ReminderBean reminderBean = new ReminderDAO().getDatabyPK(reminderId);
		
		if(reminderBean!=null){
			
			request.setAttribute("reminderBean", reminderBean);
			request.getRequestDispatcher("ReminderEdit.jsp").forward(request, response);
			
		}
	}

}
