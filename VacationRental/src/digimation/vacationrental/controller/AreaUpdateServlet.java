package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.AreaBean;
import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.dao.AreaDAO;
import digimation.vacationrental.dao.CityDAO;
import digimation.vacationrental.util.ValidationUtils;

public class AreaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String area = request.getParameter("txtArea");
		String pincode = request.getParameter("txtPincode");
		String drpCity = request.getParameter("drpdnCity");
		String areaId = request.getParameter("areaId");
		System.out.println("id:"+drpCity);
		
		boolean isError=false;
		AreaBean areaBean = new AreaBean();
		
		if(ValidationUtils.isEmpty(area)){
			
			request.setAttribute("area", "<font color=red>* Area name is required</font>");
			isError=true;
		}else{
			areaBean.setArea_name(area);
		}
		
		if(ValidationUtils.isEmpty(pincode)){
			
			request.setAttribute("pincode", "<font color=red>* Pincode is required</font>");
			isError=true;
		}else{
			areaBean.setPincode(pincode);
		}
		
		if(isError){
			request.getRequestDispatcher("AreaEdit.jsp").forward(request, response);
		}
		else{
			
			int drpdnCity = Integer.parseInt(drpCity);
			areaBean.setCity_id(drpdnCity);
			int id = Integer.parseInt(areaId);
			areaBean.setArea_id(id);
		
			System.out.println("Data ready for insertion...");
			
			if(new AreaDAO().update(areaBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("areaList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}

	}

}
