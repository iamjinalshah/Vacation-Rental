package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.dao.HotelTypeDAO;

public class HotelTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<HotelTypeBean> hotel = new HotelTypeDAO().list();
		
		if(hotel!=null){
			request.setAttribute("hotel", hotel);
			request.getRequestDispatcher("HotelTypeList.jsp").forward(request, response);
		}
	}

}
