package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarBrandBean;
import digimation.vacationrental.dao.CarBrandDAO;

public class CarBrandEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carBrandId = request.getParameter("carBrandId");
		System.out.println("id:"+carBrandId);
		
		CarBrandBean carBrandBean  = new CarBrandDAO().getDataByPK(carBrandId);
		
		if(carBrandBean!=null){
			request.setAttribute("carBrandBean", carBrandBean);
			request.getRequestDispatcher("CarBrandEdit.jsp").forward(request, response);
		}
	}

}
