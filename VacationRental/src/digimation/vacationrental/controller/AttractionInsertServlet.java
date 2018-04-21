package digimation.vacationrental.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import digimation.vacationrental.bean.AttractionBean;
import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.AttractionDAO;
import digimation.vacationrental.dao.TourGuideDAO;


public class AttractionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String txtAttractionName = request.getParameter("txtAttractionName");
		String txtDescription = request.getParameter("txtDescription");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		
		AttractionBean attractionBean = new AttractionBean();
		
		attractionBean.setAttraction_name(txtAttractionName);
		attractionBean.setDescription(txtDescription);
		
		int State = Integer.parseInt(state);
		attractionBean.setState_id(State);
		
		int City = Integer.parseInt(city);
		attractionBean.setCity_id(City);
		
		int Area = Integer.parseInt(area);
		attractionBean.setArea_id(Area);
		
		if(new AttractionDAO().insert(attractionBean)){
			System.out.println("data inserted");
			response.sendRedirect("attractionList");
		}else{
			System.out.println("oops some problem...");
		}
	}
}
