package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarDetailsBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.dao.CarDetailsDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CarDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String txtCapacity = request.getParameter("txtCapacity");
		String txtManagerName = request.getParameter("txtManagerName");
		String txtEmail = request.getParameter("txtEmail");
		String txtMobile = request.getParameter("txtMobile");
		String txtLandline = request.getParameter("txtLandline");
		String txtWebsite  = request.getParameter("txtWebsite");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String state = request.getParameter("state");
		String drpdnBrand = request.getParameter("drpdnBrand");
		String drpdnModel = request.getParameter("drpdnModel");
		
		CarDetailsBean carDetailsBean = new CarDetailsBean();
		boolean isError = false;
		
		
		
		if(ValidationUtils.isNum(txtCapacity)){
			request.setAttribute("capacity", "<font color=red>* Character not allowed</font>");
			isError=true;
		}else{
			int capacity = Integer.parseInt(txtCapacity);
			carDetailsBean.setCapacity(capacity);
		}
		
		if(ValidationUtils.isEmpty(txtManagerName)){
			request.setAttribute("manager", "<font color=red>* Required</font>");
			isError=true;
		}else{
			carDetailsBean.setManager_name(txtManagerName);
		}
		
		if(ValidationUtils.isEmpty(txtEmail)){
			request.setAttribute("email", "<font color=red>* Required</font>");
			isError=true;
		}else{
			carDetailsBean.setEmail_id(txtEmail);
		}
		
		if(ValidationUtils.isEmpty(txtMobile)){
			request.setAttribute("mobile", "<font color=red>* Required</font>");
			isError=true;
		}else{
			int mobile = Integer.parseInt(txtMobile);
			carDetailsBean.setMobile(mobile);
		}
		
		if(isError){
			request.getRequestDispatcher("CarDetails.jsp").forward(request, response);
		}else{
			
			int landline = Integer.parseInt(txtLandline);
			carDetailsBean.setLandline(landline);
			
			int City = Integer.parseInt(city);
			carDetailsBean.setCity_id(City);
			
			int Area = Integer.parseInt(area);
			carDetailsBean.setArea_id(Area);
			
			int State = Integer.parseInt(state);
			carDetailsBean.setState_id(State);
			
			int brand = Integer.parseInt(drpdnBrand);
			carDetailsBean.setCarbrand_id(brand);
			
			int model = Integer.parseInt(drpdnModel);
			carDetailsBean.setCarmodel_id(model);
			
			
			System.out.println("data ready for insertion...");
			
			if(new CarDetailsDAO().insert(carDetailsBean)){
				System.out.println("Data inserted..");
				request.getRequestDispatcher("carDetailsList").forward(request, response);
			}else{
				System.out.println("oopssss some error...");
			}
		}
	
	}

}
