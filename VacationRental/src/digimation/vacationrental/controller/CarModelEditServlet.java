package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarModelBean;
import digimation.vacationrental.dao.CarModelsDAO;

public class CarModelEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carModelId = request.getParameter("carModelId");
		System.out.println("id:"+carModelId);
		
		CarModelBean carModelBean  = new CarModelsDAO().getDataByPK(carModelId);
		
		if(carModelBean!=null){
			request.setAttribute("carModelBean", carModelBean);
			request.getRequestDispatcher("CarModelsEdit.jsp").forward(request, response);
		}
	}

}
