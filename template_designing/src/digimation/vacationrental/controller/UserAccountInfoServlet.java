package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;
import digimation.vacationrental.util.ValidationUtils;


public class UserAccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		
		String userId = request.getParameter("userId");
		System.out.println("userId:"+userId);
		
		String bankName = request.getParameter("txtBankName");
		System.out.println("Bank Name:"+bankName);
		
		String accno = request.getParameter("txtAccountNo");
		System.out.println("accono:"+accno);
		
		String ifscCode = request.getParameter("txtIFSCCode");
		System.out.println("ifsc:"+ifscCode);
		
		String pda_id = request.getParameter("pda_id");
		System.out.println("pda_id:"+pda_id);
		
		
		boolean isError=false;
		UserBean userBean = new UserBean();
		
		if(ValidationUtils.isEmpty(bankName)){
			request.setAttribute("bankName", "<font color=red>* Required</font>");
			isError=true;
		}else{
			userBean.setBank_name(bankName);
		}
		
		if(ValidationUtils.isEmpty(accno)){
			request.setAttribute("accno", "<font color=red>* Required</font>");
			isError=true;
		}else{
			userBean.setAccount_no(accno);
		}
		
		if(ValidationUtils.isEmpty(ifscCode)){
			request.setAttribute("ifscCode", "<font color=red>* Required</font>");
			isError=true;
		}else{
			userBean.setIfsc_code(ifscCode);
		}
		
		if(isError){
			request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
		}else{
			
			int id = Integer.parseInt(userId);
			userBean.setUser_id(id);
			System.out.println("data ready for insertion...");
			
			int pdaId = Integer.parseInt(pda_id);
			
			if(new UserDAO().accountInfoInsert(userBean)){
				System.out.println("data inserted...");
				request.setAttribute("pdaId", pdaId);
				request.getRequestDispatcher("propertyFinalInfo").forward(request, response);
			}else{
				System.out.println("ooopsss... some error...");
				
			}
		}
	
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
