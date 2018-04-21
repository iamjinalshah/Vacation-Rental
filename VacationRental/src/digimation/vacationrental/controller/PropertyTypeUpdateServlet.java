package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.PropertyTypeBean;
import digimation.vacationrental.dao.CountryDAO;
import digimation.vacationrental.dao.PropertyTypeDAO;
import digimation.vacationrental.util.ValidationUtils;

public class PropertyTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ptype = request.getParameter("txtPType");
		String ptid = request.getParameter("ptypeId");
		
		boolean isError=false;
		PropertyTypeBean propertyTypeBean = new PropertyTypeBean();
		
		if(ValidationUtils.isEmpty(ptype)){
			
			request.setAttribute("property", "<font color=red>* property type  name is required</font>");
			isError=true;
		}else{
			propertyTypeBean.setType_name(ptype);
		}	
		
		if(isError){
			request.getRequestDispatcher("PropertyTypeEdit.jsp").forward(request, response);
		}
		else{
		
			int PtypeId = Integer.parseInt(ptid);
			propertyTypeBean.setPtype_id(PtypeId);
			System.out.println("Data ready for updation...");
			
			if(new PropertyTypeDAO().update(propertyTypeBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("propertyTypeList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	
	}

}
