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

import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.dao.PropertyDetailsDAO;
import digimation.vacationrental.dao.PropertyPhotoDAO;
import digimation.vacationrental.util.ValidationUtils;


public class AddPropertyPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean userSession = (UserBean)session.getAttribute("bean2");
		if(userSession!=null){

		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String[] fieldValues=null;
		String fileName = null;
		File file = null;

		PropertyPhotoBean propertyPhotoBean = new PropertyPhotoBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("propertyId")) {
						String value = fieldValue;
						propertyPhotoBean.setProperty_id(value);
						System.out.println("propId : " + value);
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
					
					
					String path = "G:\\Java_Project\\workspace\\template_designing\\WebContent\\upload\\Property";
					
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
								propertyPhotoBean.setPhoto_name(file.getName());
								
								System.out.println("photo uploaded");
								System.out.println("data ready for insertion...");
								
								if(new PropertyPhotoDAO().insert(propertyPhotoBean)){
									System.out.println("data inserted");
									String prop_id = propertyPhotoBean.getProperty_id();
									System.out.println("prop_id:"+prop_id);
									request.setAttribute("property_id", prop_id);
									request.getRequestDispatcher("propertyAfterAddPhotoList").forward(request, response);
								}else{
									System.out.println("oops some problem...");
								}
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("PropertyPhotoList.jsp").forward(request, response);
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
	
		}else{
			response.sendRedirect("login.jsp");
		}
	
	}

}
