package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.dao.QuestionDAO;
import digimation.vacationrental.util.ValidationUtils;

public class QuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String question = request.getParameter("txtQue");
		
		boolean isError=false;
		QuestionBean questionBean = new QuestionBean();
		
		if(ValidationUtils.isEmpty(question)){
			
			request.setAttribute("question", "<font color=red>* Question is required</font>");
			isError=true;
		}else{
			questionBean.setQuestion(question);
		}
		
		if(isError){
			request.getRequestDispatcher("Question.jsp").forward(request, response);
		}
		else{
		
			System.out.println("Data ready for insertion...");
			
			if(new QuestionDAO().insert(questionBean)){
				System.out.println("data inserted into database...");
				request.getRequestDispatcher("questionList").forward(request, response);
				
			}
			else{
				System.out.println("ooops some problem occur..");
			}
			
		}
	}

}
