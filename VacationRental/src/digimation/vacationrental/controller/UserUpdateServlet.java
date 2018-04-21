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

import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.UserDAO;
import digimation.vacationrental.util.ValidationUtils;

public class UserUpdateServlet extends HttpServlet {
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
					if (fieldName.equalsIgnoreCase("userId")) {
						String value = fieldValue;
						int id = Integer.parseInt(value);
						userBean.setUser_id(id);
						System.out.println("ID : " + value);
					}
					
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
						userBean.setPassword(value);
						System.out.println("password : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMobile")) {
						String value = fieldValue;
						int mobile = Integer.parseInt(value);
						userBean.setMobile(mobile);
						System.out.println("MiddleName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtLandline")) {
						String value = fieldValue;
						int landline = Integer.parseInt(value);
						userBean.setLandline(landline);
						System.out.println("Landline : " + value);
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
					String appPath = context.getRealPath("\\")+("upload\\Property");
					System.out.println("Path : "+appPath);
					
					
					String path = "G:\\Java_Project\\workspace\\VacationRental\\WebContent\\upload\\ProfilePhoto";
					
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
								
								if(new UserDAO().update(userBean)){
									System.out.println("data inserted");
									request.getRequestDispatcher("userList").forward(request, response);
								}else{
									System.out.println("oops some problem...");
								}
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("PropertyPhoto.jsp").forward(request, response);
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
