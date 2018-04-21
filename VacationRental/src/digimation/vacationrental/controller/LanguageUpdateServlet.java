package digimation.vacationrental.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.dao.LanguageDAO;
import digimation.vacationrental.util.ValidationUtils;

public class LanguageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("languageId");
		System.out.println("language-id:"+Id);
		
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
			request.getRequestDispatcher("LanguageEdit.jsp").forward(request, response);
		}else{
			 
			int languageId = Integer.parseInt(Id);
			languageBean.setLanguage_Id(languageId);
			System.out.println("data ready for updation...");
			
			if(new LanguageDAO().update(languageBean)){
				System.out.println("data are updated...");
				request.getRequestDispatcher("languageList").forward(request, response);
			}else{
				System.out.println("oopss some error...");
			}
		}
	
	}

}
