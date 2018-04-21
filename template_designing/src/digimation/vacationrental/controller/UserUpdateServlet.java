package digimation.vacationrental.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.UserDAO;
import digimation.vacationrental.util.ValidationUtils;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String txtFirstName = request.getParameter("txtFirstName");
		String txtMiddleName = request.getParameter("txtMiddleName");
		String txtLastName = request.getParameter("txtLastName");
		String txtEmail = request.getParameter("txtEmail");
		String txtPassword = request.getParameter("txtPassword");
		String txtMobileNo = request.getParameter("txtMobileNo");
		String txtLandline = request.getParameter("txtLandline");
		String txtAddress = request.getParameter("txtAddress");
		String dateDOB = request.getParameter("dateDOB");
		int drpdnQuestion = Integer.parseInt(request.getParameter("drpdnQuestion"));
		String txtAnswer = request.getParameter("txtAnswer");

		UserBean userBean = new UserBean();
		
		userBean.setFirst_name(txtFirstName);
		userBean.setMiddle_name(txtMiddleName);
		userBean.setLast_name(txtLastName);
		userBean.setEmail_id(txtEmail);
		userBean.setMobile(txtMobileNo);
		userBean.setLandline(txtLandline);
		userBean.setDob(dateDOB);
		userBean.setAddress(txtAddress);
		userBean.setQue_id(drpdnQuestion);
		userBean.setAnswer(txtAnswer);
		userBean.setUser_id(userId);
		userBean.setPassword(txtPassword);
		
		if(new UserDAO().update(userBean)){
			System.out.println("data updated...");
			request.setAttribute("updateProfile", "<font color=red>Your data updated but for seeing this upadate please login again...</font>");
			request.getRequestDispatcher("userPanel.jsp").forward(request, response);
		}else{
			System.out.println("oopssss..some error");
		}
		
		}else{
			response.sendRedirect("login.jsp");
		}
	
		
	}


}
