package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CarModelsDAO;

public class CarModelDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String carModelId = request.getParameter("carModelId");
			System.out.println("id:"+carModelId);
			
			if(new CarModelsDAO().delete(carModelId)){
				System.out.println("data deleted..");
				request.getRequestDispatcher("carModelList").forward(request, response);
			}
			else{
				System.out.println("data not deleted...");
			}
			
	
	}

}
