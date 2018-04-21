package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.PropertyPhotoDAO;
import digimation.vacationrental.dao.QuestionDAO;

public class PropertyPhotoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id=request.getParameter("photoId");
		System.out.println("photo-id :"+Id);
		
		PropertyPhotoBean propertyPhotoBean = new PropertyPhotoDAO().getDatabyPK(Id);
		if(propertyPhotoBean!=null){
			
			request.setAttribute("propertyPhotoBean", propertyPhotoBean);
			request.getRequestDispatcher("PropertyPhotoEdit.jsp").forward(request, response);
			
		}
	
	}

}
