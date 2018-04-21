package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyTypeBean;
import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.PropertyTypeDAO;
import digimation.vacationrental.dao.QuestionDAO;
import digimation.vacationrental.util.ValidationUtils;


public class PropertyTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ptype = request.getParameter("txtPType");
		
		boolean isError=false;
		PropertyTypeBean propertyTypeBean = new PropertyTypeBean();
		
		if(ValidationUtils.isEmpty(ptype)){
			
			request.setAttribute("ptype", "<font color=red>* property type name is required</font>");
			isError=true;
		}else{
			propertyTypeBean.setType_name(ptype);
		}
		
		if(isError){
			request.getRequestDispatcher("PropertyType.jsp").forward(request, response);
		}
		else{
		
			System.out.println("Data ready for insertion...");
			
			if(new PropertyTypeDAO().insert(propertyTypeBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("propertyTypeList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
