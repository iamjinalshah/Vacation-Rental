package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.dao.CousinDAO;


public class CousinDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String cousinId = request.getParameter("cousinId");
			System.out.println("cousin-id:"+cousinId);
			
			if(new CousinDAO().delete(cousinId)){
				System.out.println("data deleted..");
				request.getRequestDispatcher("cousinList").forward(request, response);
			}
			else{
				System.out.println("data not deleted...");
			}
			
	
	}

}
