package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarModelBean;
import digimation.vacationrental.dao.CarModelsDAO;

public class CarModelListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<CarModelBean> listOfCarModels = new CarModelsDAO().list();
	
	if(listOfCarModels!=null){
		request.setAttribute("listOfCarModels", listOfCarModels);
		request.getRequestDispatcher("CarModelsList.jsp").forward(request, response);
	}
	}

}
