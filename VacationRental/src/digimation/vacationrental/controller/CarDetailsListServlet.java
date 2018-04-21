package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarDetailsBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.dao.CarDetailsDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;

public class CarDetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 List<CarDetailsBean> listOfCar = new CarDetailsDAO().list();
			
			if(listOfCar!=null){
				request.setAttribute("listOfCar", listOfCar);
				request.getRequestDispatcher("CarDetailsList.jsp").forward(request, response);
			}
	
	}

}
