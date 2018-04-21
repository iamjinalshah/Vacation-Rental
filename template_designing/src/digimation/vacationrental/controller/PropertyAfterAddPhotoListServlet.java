package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyPhotoDAO;


public class PropertyAfterAddPhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
		String propertyId =(String)request.getAttribute("property_id");
		System.out.println("id:"+propertyId);
		
		List<PropertyPhotoBean> listOfPhoto = new PropertyPhotoDAO().photolist(propertyId);
		
		if(listOfPhoto!=null){
			request.setAttribute("listOfPhoto", listOfPhoto);
			request.setAttribute("propertyId", propertyId);
			request.getRequestDispatcher("PropertyPhotoList.jsp").forward(request, response);
		}
		
	}else{
		response.sendRedirect("login.jsp");
	}
	
	}

}
