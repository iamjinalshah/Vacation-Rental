package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;

public class PropertyPhotoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String photoId = request.getParameter("photoId");
		System.out.println("photo-id:"+photoId);
		
		String propertyId = request.getParameter("propertyId");
		System.out.println("propertyId:"+propertyId);
		
		if(new PropertyPhotoDAO().delete(photoId)){
			request.setAttribute("property_id", propertyId);
			request.getRequestDispatcher("propertyAfterAddPhotoList").forward(request, response);
		}
		else{
			System.out.println("data not deleted..");
			request.setAttribute("property_id", propertyId);
			request.getRequestDispatcher("propertyAfterAddPhotoList").forward(request, response);
		}
		
		}else{
			response.sendRedirect("login.jsp");
		}
	}

}
