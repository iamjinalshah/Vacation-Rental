package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.UserDAO;


public class UserAccountUpdateServlte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String userId = request.getParameter("userId");
		System.out.println("userId:"+userId);
		String txtBankName = request.getParameter("txtBankName");
		System.out.println("name:"+txtBankName);
		String txtAccNo = request.getParameter("txtAccNo");
		System.out.println("acc no:"+txtAccNo);
		String txtIfscCode = request.getParameter("txtIfscCode");
		System.out.println("ifsc Code:"+txtIfscCode);
		
		UserBean userBean = new UserBean();
		
		int id = Integer.parseInt(userId);
		userBean.setUser_id(id);
		userBean.setBank_name(txtBankName);
		userBean.setAccount_no(txtAccNo);
		userBean.setIfsc_code(txtIfscCode);
		
		if(new UserDAO().Accountupdate(userBean)){
			System.out.println("data updated...");
			request.setAttribute("userId", userId);
			request.getRequestDispatcher("userAccountInfoAfterUpdate").forward(request, response);
		}else{
			System.out.println("oopssss..some error");
		}
		}else{
			response.sendRedirect("login.jsp");
		}
		}
		
}
