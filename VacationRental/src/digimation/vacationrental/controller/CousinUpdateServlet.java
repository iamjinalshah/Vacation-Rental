package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CousinBean;
import digimation.vacationrental.dao.CousinDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CousinUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("cousinId");
		System.out.println("cousin-id:"+Id);
		
		String cousinName = request.getParameter("txtCousinName");
		
		boolean isError = false;
		CousinBean cousinBean = new CousinBean();
		
		if(ValidationUtils.isEmpty(cousinName)){
			request.setAttribute("cousinName", "* cousinName is required");
			isError=true;
		}else{
			cousinBean.setCousin_name(cousinName);
		}
		
		if(isError){
			request.getRequestDispatcher("CousinEdit.jsp").forward(request, response);
		}else{
			 
			int cousinId = Integer.parseInt(Id);
			cousinBean.setCousin_id(cousinId);
			System.out.println("data ready for updation...");
			
			if(new CousinDAO().update(cousinBean)){
				System.out.println("data are updated...");
				request.getRequestDispatcher("cousinList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
	
	}

}
