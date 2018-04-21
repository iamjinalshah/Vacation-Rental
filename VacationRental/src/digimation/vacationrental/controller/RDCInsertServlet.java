package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.bean.RDCBean;
import digimation.vacationrental.dao.GLDetailsDAO;
import digimation.vacationrental.dao.RDCDAO;

public class RDCInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drpdnRestaurant = request.getParameter("drpdnRestaurant");
		String drpdnType = request.getParameter("drpdnType");
		String drpdnCousins = request.getParameter("drpdnCousins");
		
		boolean isError=false;
		RDCBean rdcBean = new RDCBean();
		
		
		if(isError){
			request.getRequestDispatcher("RDC.jsp").forward(request, response);
		}
		else{
			
			int drpRestaurant = Integer.parseInt(drpdnRestaurant);
			rdcBean.setRes_id(drpRestaurant);
			
			rdcBean.setCousins_type(drpdnType);
			
			int drpCousins = Integer.parseInt(drpdnCousins);
			rdcBean.setCousin_id(drpCousins);
		
			System.out.println("Data ready for insertion...");
			
			if(new RDCDAO().insert(rdcBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("rdcList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	
	}

}
