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
import digimation.vacationrental.util.ValidationUtils;

public class ReminderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String txtDetails = request.getParameter("txtDetails");
		String txtDate = request.getParameter("txtDate");
		String userId = request.getParameter("userId");
		
		boolean isError=false;
		ReminderBean reminderBean = new ReminderBean();
		
		if(ValidationUtils.isEmpty(txtDetails)){
			
			request.setAttribute("txtDetails", "<font color=red>* Details is required</font>");
			isError=true;
		}else{
			reminderBean.setDetails(txtDetails);
		}
		
		if(ValidationUtils.isEmpty(txtDate)){
			
			request.setAttribute("txtDetails", "<font color=red>* Date is required</font>");
			isError=true;
		}else{
			reminderBean.setDate(txtDate);
		}
		
		if(isError){
			request.getRequestDispatcher("Reminder.jsp").forward(request, response);
		}
		else{
		
			int userid = Integer.parseInt(userId);
			reminderBean.setUser_id(userid);
			
			System.out.println("Data ready for insertion...");
			
			if(new ReminderDAO().insert(reminderBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("reminderList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
