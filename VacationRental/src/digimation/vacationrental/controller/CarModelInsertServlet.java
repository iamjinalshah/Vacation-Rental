package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarModelBean;
import digimation.vacationrental.dao.CarModelsDAO;
import digimation.vacationrental.util.ValidationUtils;

public class CarModelInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carModel = request.getParameter("txtCarModel");
		String drpdnCarBrand = request.getParameter("drpdnCarBrand");
		
		boolean isError = false;
		CarModelBean carModelBean = new CarModelBean();
		
		if(ValidationUtils.isEmpty(carModel)){
			request.setAttribute("carModel", "* carModel is required");
			isError=true;
		}else{
			carModelBean.setCarmodel_name(carModel);
		}
		
		if(isError){
			request.getRequestDispatcher("CarModels.jsp").forward(request, response);
		}else{
			
			int drpcarbrand = Integer.parseInt(drpdnCarBrand);			
			carModelBean.setCarbarnd_id(drpcarbrand);
			
			System.out.println("data ready for insertion...");
			
			if(new CarModelsDAO().insert(carModelBean)){
				System.out.println("data are inserted...");
				request.getRequestDispatcher("carModelList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
}
} 