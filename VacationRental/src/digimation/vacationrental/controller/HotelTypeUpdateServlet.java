package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.dao.HotelTypeDAO;
import digimation.vacationrental.util.ValidationUtils;

public class HotelTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String htype = request.getParameter("txtHType");
		String htid = request.getParameter("htypeId");
		
		boolean isError=false;
		HotelTypeBean hotelTypeBean = new HotelTypeBean();
		
		if(ValidationUtils.isEmpty(htype)){
			
			request.setAttribute("hotel", "<font color=red>* property type  name is required</font>");
			isError=true;
		}else{
			hotelTypeBean.setType_name(htype);
		}	
		
		if(isError){
			request.getRequestDispatcher("HotelTypeEdit.jsp").forward(request, response);
		}
		else{
		
			int HtypeId = Integer.parseInt(htid);
			hotelTypeBean.setHtype_id(HtypeId);
			System.out.println("Data ready for updation...");
			
			if(new HotelTypeDAO().update(hotelTypeBean)){
				System.out.println("data updated into database...");
				request.getRequestDispatcher("hotelTypeList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
