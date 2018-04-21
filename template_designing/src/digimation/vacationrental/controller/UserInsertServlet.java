package digimation.vacationrental.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.dao.UserDAO;
import digimation.vacationrental.util.ValidationUtils;

public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;

		UserBean userBean = new UserBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("txtFirstName")) {
						String value = fieldValue;
						userBean.setFirst_name(value);
						System.out.println("FirstName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMiddleName")) {
						String value = fieldValue;
						userBean.setMiddle_name(value);
						System.out.println("MiddleName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtLastName")) {
						String value = fieldValue;
						userBean.setLast_name(value);
						System.out.println("LastName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtEmail")) {
						String value = fieldValue;
						userBean.setEmail_id(value);
						System.out.println("Email : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtPassword")) {
						String value = fieldValue;
						if(ValidationUtils.password(value)){
							request.setAttribute("password", "<font color=red>Minimum length is 8</font>");
							request.getRequestDispatcher("register.jsp").forward(request, response);
						}else{
						userBean.setPassword(value);
						System.out.println("password : " + value);
						
					}
					}
					
					if (fieldName.equalsIgnoreCase("txtMobileNo1")) {
						String value = fieldValue;
						if(ValidationUtils.isNum(value)){
							request.setAttribute("mobile1", "<font color=red>enter only 10 numbers</font>");
							request.getRequestDispatcher("register.jsp").forward(request, response);
						}else{
						userBean.setMobile(value);
						System.out.println("MobileNo1 : " + value);
						}
					}
					
					
					if (fieldName.equalsIgnoreCase("txtMobileNo2")) {
						String value = fieldValue;
						if(ValidationUtils.isNum(value)){
							request.setAttribute("mobile2", "<font color=red>enter only 10 numbers</font>");
							request.getRequestDispatcher("register.jsp");
							return;
						}else{
						userBean.setLandline(value);
						System.out.println("MobileNo2 : " + value);
						}
					}
					
					if (fieldName.equalsIgnoreCase("rdbGender")) {
						String value = fieldValue;
						userBean.setGender(value);
						System.out.println("Gender : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtAddress")) {
						String value = fieldValue;
						userBean.setAddress(value);
						System.out.println("Address : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("dateDOB")) {
						String value = fieldValue;
						userBean.setDob(value);
						System.out.println("Date of birth : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("drpdnQuestion")) {
						String value = fieldValue;
						int Id = Integer.parseInt(value);
						userBean.setQue_id(Id);
						System.out.println("Id : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtAnswer")) {
						String value = fieldValue;
						userBean.setAnswer(value);
						System.out.println("Answer : " + value);
					}
					
					
				}else {
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					
					fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1,
							fileName.length());
					System.out.println("File Name 1 : "+fileName);
					
					ServletContext context = getServletContext();
					String appPath = context.getRealPath("\\")+("upload\\PofilePhoto");
					System.out.println("Path : "+appPath);
					
					
					String path = "C:\\Users\\Akash\\workspace\\template_designing\\WebContent\\upload\\ProfilePhoto";
					
					file = new File(path + File.separator
							+ fileName);

					try {

						if (fileName.isEmpty()) {

							// Validations....
						} else {
							System.out.println("MIME : "+context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals(
									"image/gif")
									|| context.getMimeType(fileName)
											.equals("image/jpeg")
									|| context.getMimeType(fileName)
											.equals("image/png")) {
								item.write(file);
								System.out.println("===> "+file.getName());
								userBean.setPhoto(file.getName());
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								
								if(new UserDAO().insert(userBean)){
									System.out.println("data inserted");
									request.setAttribute("success", "<font color=red>you are successfully registered</font>");
									request.getRequestDispatcher("login.jsp").forward(request, response);
								}else{
									System.out.println("oops some problem...");
								}
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("User.jsp").forward(request, response);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		 
	}

}
