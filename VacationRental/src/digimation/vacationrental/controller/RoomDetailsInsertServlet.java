package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.RoomDetailsBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;
import digimation.vacationrental.dao.RoomDetailsDAO;


public class RoomDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String drpdnRoomType = request.getParameter("drpdnRoomType");
		String drpdnHotel = request.getParameter("drpdnHotel");
		
		 RoomDetailsBean   roomDetailsBean = new RoomDetailsBean();
		 
		 int drproomtype = Integer.parseInt(drpdnRoomType);
		 roomDetailsBean.setRtype_id(drproomtype);
		 
		 int drphotel = Integer.parseInt(drpdnHotel);
		 roomDetailsBean.setHotel_id(drphotel);
		 
		 System.out.println("data ready for insertion...");
		 
		 if(new RoomDetailsDAO().insert(roomDetailsBean)){
			 System.out.println("Data are inserted...");
			 request.getRequestDispatcher("roomDetailsList").forward(request, response);
		 }else{
			 System.out.println("oopss some error...");
		 }
		 
	
	}

}
