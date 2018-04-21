package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.util.ValidationUtils;

public class HotelDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String txtHotel = request.getParameter("txtHotel");
		String txtAddress = request.getParameter("txtAddress");
		String txtDescription = request.getParameter("txtDescription");
		String txtManagerName = request.getParameter("txtManagerName");
		String txtEmail = request.getParameter("txtEmail");
		String txtMobile = request.getParameter("txtMobile");
		String txtLandline = request.getParameter("txtLandline");
		String txtWebsite  = request.getParameter("txtWebsite");
		String txtCharge  = request.getParameter("txtCharge");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String state = request.getParameter("state");
		String drpdncategory = request.getParameter("drpdncategory");
		String drpdnHotelType = request.getParameter("drpdnHotelType");
		
		HotelDetailsBean hotelDetailsBean = new HotelDetailsBean();
		boolean isError = false;
		
		if(ValidationUtils.isEmpty(txtHotel)){
			request.setAttribute("hotel", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setHotel_name(txtHotel);
		}
		
		if(ValidationUtils.isEmpty(txtDescription)){
			request.setAttribute("description", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setDescription(txtDescription);
		}
		
		if(ValidationUtils.isEmpty(txtManagerName)){
			request.setAttribute("manager", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setManager_name(txtManagerName);
		}

		if(ValidationUtils.isEmpty(txtAddress)){
			request.setAttribute("address", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setAddress(txtAddress);
		}
		
		if(ValidationUtils.isEmpty(txtEmail)){
			request.setAttribute("email", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setEmail_id(txtEmail);
		}
		
		if(ValidationUtils.isEmpty(txtWebsite)){
			request.setAttribute("rate", "<font color=red>* Required</font>");
			isError=true;
		}else{
			hotelDetailsBean.setWebsite(txtWebsite);
		}
		
		if(isError){
			request.getRequestDispatcher("HotelDetails.jsp").forward(request, response);
		}else{
			
			int landline = Integer.parseInt(txtLandline);
			hotelDetailsBean.setLandline(landline);
			
			int City = Integer.parseInt(city);
			hotelDetailsBean.setCity_id(City);
			
			int Area = Integer.parseInt(area);
			hotelDetailsBean.setArea_id(Area);
			
			int State = Integer.parseInt(state);
			hotelDetailsBean.setState_id(State);
			
			int type = Integer.parseInt(drpdncategory);
			hotelDetailsBean.setHrcategory_id(type);
			
			hotelDetailsBean.setCharge(txtCharge);
			
			int hotelType = Integer.parseInt(drpdnHotelType);
			hotelDetailsBean.setHtype_id(hotelType);
			
			System.out.println("data ready for insertion...");
			
			if(new HotelDetailsDAO().insert(hotelDetailsBean)){
				System.out.println("Data inserted..");
				request.getRequestDispatcher("hotelDetailsList").forward(request, response);
			}else{
				System.out.println("oopssss some error...");
			}
		}
	
	
	}

}
