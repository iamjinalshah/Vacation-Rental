package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarBrandBean;
import digimation.vacationrental.dao.CarBrandDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CarBrandInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carBrand = request.getParameter("txtCarBrand");
		boolean isError = false;
		CarBrandBean carBrandBean = new CarBrandBean();
		
		if(ValidationUtils.isEmpty(carBrand)){
			request.setAttribute("carBrand", "* car brand name is required");
			isError=true;
		}else{
			carBrandBean.setCarBrand_Name(carBrand);
		}
		
		if(isError){
			request.getRequestDispatcher("CarBrand.jsp").forward(request, response);
		}else{
			
			System.out.println("data ready for insertion...");
			
			if(new CarBrandDAO().insert(carBrandBean)){
				System.out.println("data are inserted...");
				request.getRequestDispatcher("carBrandList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
}
} 