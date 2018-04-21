package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.TourGuideDAO;

public class TourGuideSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("txtSearch");
		System.out.println("pid:"+search);
		
		List<TourGuideBean> listOfGuide = new TourGuideDAO().Searchlist(search);
		
		if(listOfGuide!= null){
			request.setAttribute("listOfGuide", listOfGuide);
			request.getRequestDispatcher("TourGuideList.jsp").forward(request, response);
		}
	}

}
