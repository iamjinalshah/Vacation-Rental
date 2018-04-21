package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.dao.LanguageDAO;
import digimation.vacationrental.util.ValidationUtils;

public class LanguageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String languageName = request.getParameter("txtLanguageName");
		boolean isError = false;
		LanguageBean languageBean = new LanguageBean();
		
		if(ValidationUtils.isEmpty(languageName)){
			request.setAttribute("languageName", "* languageName is required");
			isError=true;
		}else{
			languageBean.setLanguage_Name(languageName);
		}
		
		if(isError){
			request.getRequestDispatcher("Language.jsp").forward(request, response);
		}else{
			
			System.out.println("data ready for insertion...");
			
			if(new LanguageDAO().insert(languageBean)){
				System.out.println("data are inserted...");
				request.getRequestDispatcher("languageList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
}
} 