package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import digimation.vacationrental.bean.RDCBean;
import digimation.vacationrental.dao.RDCDAO;

public class RDCUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String drpdnRestaurant = request.getParameter("drpdnRestaurant");
		String drpdnType = request.getParameter("drpdnType");
		String drpdnCousins = request.getParameter("drpdnCousins");
		String rdcId = request.getParameter("rdcId");
		System.out.println("id:"+rdcId);
		
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
			
			int id = Integer.parseInt(rdcId);
			rdcBean.setRDC_id(id);
		
			System.out.println("Data ready for updation...");
			
			if(new RDCDAO().update(rdcBean)){
				System.out.println("data udated into database...");
				request.getRequestDispatcher("rdcList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
