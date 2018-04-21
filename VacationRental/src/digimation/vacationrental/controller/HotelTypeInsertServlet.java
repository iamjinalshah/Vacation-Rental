package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.dao.HotelTypeDAO;
import digimation.vacationrental.util.ValidationUtils;


public class HotelTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String htype = request.getParameter("txtHType");
		
		boolean isError=false;
		HotelTypeBean hotelTypeBean = new HotelTypeBean();
		
		if(ValidationUtils.isEmpty(htype)){
			
			request.setAttribute("htype", "<font color=red>* Hotel type name is required</font>");
			isError=true;
		}else{
			hotelTypeBean.setType_name(htype);
		}
		
		if(isError){
			request.getRequestDispatcher("HotelType.jsp").forward(request, response);
		}
		else{
		
			System.out.println("Data ready for insertion...");
			
			if(new HotelTypeDAO().insert(hotelTypeBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("hotelTypeList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	
	}

}
