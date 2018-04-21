package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;

public class HotelPhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<HotelPhotoBean> listOfPhoto = new HotelPhotoDAO().list();
		
		if(listOfPhoto!=null){
			request.setAttribute("listOfPhoto", listOfPhoto);
			request.getRequestDispatcher("HotelPhotoList.jsp").forward(request, response);
		}
	
	}

}
