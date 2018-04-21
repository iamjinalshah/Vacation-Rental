package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsAmenitiesDAO;


public class PropertyInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		
		if(userSession!=null){
		
	int pda_id = Integer.parseInt(request.getParameter("pda_id"));
	int amenities_id = Integer.parseInt(request.getParameter("amenities_id"));
	int property_id = Integer.parseInt(request.getParameter("property_id"));
	int account_id = Integer.parseInt(request.getParameter("account_id"));
	
	System.out.println("pda_id:"+pda_id);
	System.out.println("pda_id:"+amenities_id);
	System.out.println("pda_id:"+property_id);
	System.out.println("pda_id:"+account_id);
	
	
	new PropertyDetailsAmenitiesDAO().allPropertyInfodelete(pda_id, amenities_id, property_id, account_id);
		System.out.println("data successfully deleted..");
		request.getRequestDispatcher("listYourProperty.jsp").forward(request, response);
		
		}else{
			response.sendRedirect("login.jsp");
		}
	}
	
	

}
