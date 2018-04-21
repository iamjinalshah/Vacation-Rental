package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.ReminderBean;
import digimation.vacationrental.dao.ReminderDAO;
import digimation.vacationrental.util.ValidationUtils;

public class ReminderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String txtDetails = request.getParameter("txtDetails");
		String txtDate = request.getParameter("txtDate");
		String reminderId = request.getParameter("reminderId");
		
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
			request.getRequestDispatcher("ReminderEdit.jsp").forward(request, response);
		}
		else{
		
			int reminderid = Integer.parseInt(reminderId);
			reminderBean.setReminder_id(reminderid);
			
			System.out.println("Data ready for updation...");
			
			if(new ReminderDAO().update(reminderBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("reminderList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	
	}

}
