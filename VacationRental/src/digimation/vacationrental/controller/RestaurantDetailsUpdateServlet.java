package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.dao.RestaurantDetailsDAO;
import digimation.vacationrental.util.ValidationUtils;

public class RestaurantDetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restaurantId = request.getParameter("restaurantId");
		String txtRestaurant = request.getParameter("txtRestaurant");
		String txtAddress = request.getParameter("txtAddress");
		String txtDescription = request.getParameter("txtDescription");
		String txtManagerName = request.getParameter("txtManagerName");
		String txtEmail = request.getParameter("txtEmail");
		String txtMobile = request.getParameter("txtMobile");
		String txtLandline = request.getParameter("txtLandline");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String drpdncategory = request.getParameter("drpdncategory");
		
		ResataurantDetailsBean resataurantDetailsBean = new ResataurantDetailsBean();
		boolean isError = false;
		
		if(ValidationUtils.isEmpty(txtRestaurant)){
			request.setAttribute("restaurant", "<font color=red>* Required</font>");
			isError=true;
		}else{
			resataurantDetailsBean.setRestaurant_name(txtRestaurant);
		}
		
		if(ValidationUtils.isEmpty(txtDescription)){
			request.setAttribute("description", "<font color=red>* Required</font>");
			isError=true;
		}else{
			resataurantDetailsBean.setDescription(txtDescription);
		}
		
		if(ValidationUtils.isEmpty(txtManagerName)){
			request.setAttribute("manager", "<font color=red>* Required</font>");
			isError=true;
		}else{
			resataurantDetailsBean.setManager_name(txtManagerName);
		}

		if(ValidationUtils.isEmpty(txtAddress)){
			request.setAttribute("address", "<font color=red>* Required</font>");
			isError=true;
		}else{
			resataurantDetailsBean.setAddress(txtAddress);
		}
		
		if(ValidationUtils.isEmpty(txtEmail)){
			request.setAttribute("email", "<font color=red>* Required</font>");
			isError=true;
		}else{
			resataurantDetailsBean.setEmail_id(txtEmail);
		}
		
		if(ValidationUtils.isEmpty(txtMobile)){
			request.setAttribute("mobile", "<font color=red>* Required</font>");
			isError=true;
		}else{
			int mobile = Integer.parseInt(txtMobile);
			resataurantDetailsBean.setMobile(mobile);
		}
		
		
		if(isError){
			request.getRequestDispatcher("RestaurantDetails.jsp").forward(request, response);
		}else{
			int id = Integer.parseInt(restaurantId);
			resataurantDetailsBean.setRestaurant_id(id);
			
			int landline = Integer.parseInt(txtLandline);
			resataurantDetailsBean.setLandline(landline);
			
			int City = Integer.parseInt(city);
			resataurantDetailsBean.setCity_id(City);
			
			int Area = Integer.parseInt(area);
			resataurantDetailsBean.setArea_id(Area);
			
			int type = Integer.parseInt(drpdncategory);
			resataurantDetailsBean.setHrcategory_id(type);
			
			System.out.println("data ready for updation...");
			
			if(new RestaurantDetailsDAO().update(resataurantDetailsBean)){
				System.out.println("Data updated..");
				request.getRequestDispatcher("restaurantDetailsList").forward(request, response);
			}else{
				System.out.println("oopssss some error...");
			}
		}
	
	
	
	}

}
