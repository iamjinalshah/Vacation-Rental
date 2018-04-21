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

public class CarDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carId = request.getParameter("carId");
		System.out.println("car-sid:"+carId);
		
		CarDetailsBean carDetailsBean =new CarDetailsDAO().getDatabyPK(carId);
		
		if(carDetailsBean!= null){
			request.setAttribute("carDetailsBean", carDetailsBean);
			request.getRequestDispatcher("CarDetailsEdit.jsp").forward(request, response);
		}
	
	}

}
