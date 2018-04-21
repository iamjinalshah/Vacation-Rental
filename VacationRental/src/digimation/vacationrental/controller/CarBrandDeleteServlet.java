package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CarBrandDAO;

public class CarBrandDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String carBrandId = request.getParameter("carBrandId");
			System.out.println("id:"+carBrandId);
			
			if(new CarBrandDAO().delete(carBrandId)){
				System.out.println("data deleted..");
				request.getRequestDispatcher("carBrandList").forward(request, response);
			}
			else{
				System.out.println("data not deleted...");
			}
			
	
	}

}
