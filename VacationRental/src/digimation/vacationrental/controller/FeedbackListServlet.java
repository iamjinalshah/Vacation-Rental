package digimation.vacationrental.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.CarModelBean;
import digimation.vacationrental.bean.FeedbackBean;
import digimation.vacationrental.dao.CarModelsDAO;
import digimation.vacationrental.dao.FeedbackDAO;

public class FeedbackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FeedbackBean> listOfFeedback = new FeedbackDAO().list();
		
		if(listOfFeedback!=null){
			request.setAttribute("listOfFeedback", listOfFeedback);
			request.getRequestDispatcher("FeedbackList.jsp").forward(request, response);
		}
	}

}
