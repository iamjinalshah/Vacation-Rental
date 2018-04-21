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

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.dao.AdminDAO;
import digimation.vacationrental.util.ValidationUtils;

public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;

		AdminBean adminBean = new AdminBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("txtAdminId")) {
						String value = fieldValue;
						int id = Integer.parseInt(value);
						adminBean.setAdmin_id(id);
						System.out.println("FirstName : " + id);
					}
					
					if (fieldName.equalsIgnoreCase("txtFirstName")) {
						String value = fieldValue;
						adminBean.setFirst_name(value);
						System.out.println("FirstName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMiddleName")) {
						String value = fieldValue;
						adminBean.setMiddle_name(value);
						System.out.println("MiddleName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtLastName")) {
						String value = fieldValue;
						adminBean.setLast_name(value);
						System.out.println("LastName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtEmail")) {
						String value = fieldValue;
						adminBean.setEmail_id(value);
						System.out.println("Email : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtPassword")) {
						String value = fieldValue;
						adminBean.setPassword(value);
						System.out.println("password : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMobile")) {
						String value = fieldValue;
						int mobile = Integer.parseInt(value);
						adminBean.setMobile(mobile);
						System.out.println("MiddleName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtLandline")) {
						String value = fieldValue;
						int landline = Integer.parseInt(value);
						adminBean.setLandline(landline);
						System.out.println("Landline : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("rdbGender")) {
						String value = fieldValue;
						adminBean.setGender(value);
						System.out.println("Gender : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtAddress")) {
						String value = fieldValue;
						adminBean.setAddress(value);
						System.out.println("Address : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("dateDOB")) {
						String value = fieldValue;
						adminBean.setDob(value);
						System.out.println("Date of birth : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("drpdnQuestion")) {
						String value = fieldValue;
						int Id = Integer.parseInt(value);
						adminBean.setQue_id(Id);
						System.out.println("Id : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtAnswer")) {
						String value = fieldValue;
						adminBean.setAnswer(value);
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
					
					
					String path = "G:\\Java_Project\\workspace\\VacationRental\\WebContent\\upload\\Idproof";
					
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
								adminBean.setPhoto(file.getName());
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								
								if(new AdminDAO().update(adminBean)){
									System.out.println("data inserted");
									request.getRequestDispatcher("adminList").forward(request, response);
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
