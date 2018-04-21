package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.dao.HotelPhotoDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;

public class HotelPhotoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("photoId");
		System.out.println("photo-id :"+Id);
		
		HotelPhotoBean hotelPhotoBean = new HotelPhotoDAO().getDatabyPK(Id);
		if(hotelPhotoBean!=null){
			
			request.setAttribute("hotelPhotoBean", hotelPhotoBean);
			request.getRequestDispatcher("HotelPhotoEdit.jsp").forward(request, response);
			
		}
	
	}

}
