package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;

public class PropertyPhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<PropertyPhotoBean> listOfPhoto = new PropertyPhotoDAO().list();
		
		if(listOfPhoto!=null){
			request.setAttribute("listOfPhoto", listOfPhoto);
			request.getRequestDispatcher("PropertyPhotoList.jsp").forward(request, response);
		}
	}

}
