package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarBrandBean;
import digimation.vacationrental.dao.CarBrandDAO;

public class CarBrandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<CarBrandBean> listOfCarBrands = new CarBrandDAO().list();
	
	if(listOfCarBrands!=null){
		request.setAttribute("listOfCarBrands", listOfCarBrands);
		request.getRequestDispatcher("CarBrandList.jsp").forward(request, response);
	}
	}

}
