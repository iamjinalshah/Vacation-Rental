package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AttractionBean;
import digimation.vacationrental.bean.AttractionPhotoBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.dao.AttractionDAO;
import digimation.vacationrental.dao.HotelDetailsDAO;
import digimation.vacationrental.dao.HotelPhotoDAO;

public class AttractionFullInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String attractionId = request.getParameter("attractionId");
		System.out.println("attractionId:" +attractionId);
		
		AttractionBean attractionBean = new AttractionDAO().attractionFullInfo(attractionId);
		List<AttractionPhotoBean> listOfAttractionPhotos = new AttractionDAO().attractionphotolist(attractionId);
		
		if(attractionBean!=null && listOfAttractionPhotos!=null){
			System.out.println("succesfully fetch all data");
			request.setAttribute("attractionBean", attractionBean);
			request.setAttribute("listOfAttractionPhotos", listOfAttractionPhotos);
			request.getRequestDispatcher("attractionSingle.jsp").forward(request, response);
		}
		
		}
	
	

}
