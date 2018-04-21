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

import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.dao.RestaurantPhotoDAO;


public class RestaurantPhotoUpdateServlet extends HttpServlet {
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

		RestaurantPhotoBean restaurantPhotoBean = new RestaurantPhotoBean();

		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("drpdnRestaurant")) {
						String value = fieldValue;
						int intvalue = Integer.parseInt(value);
						restaurantPhotoBean.setRestaurant_id(intvalue);
						System.out.println("Restaurant : " + intvalue);
					}
					if (fieldName.equalsIgnoreCase("photoId")) {
						String value = fieldValue;
						int intvalue = Integer.parseInt(value);
						restaurantPhotoBean.setRestaurantphoto_id(intvalue);
						System.out.println("Id : " + intvalue);
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
					
					
					String path = "G:\\Java_Project\\workspace\\VacationRental\\WebContent\\upload\\hotel";
					
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
								restaurantPhotoBean.setPhoto_name(file.getName());
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								
								if(new RestaurantPhotoDAO().update(restaurantPhotoBean)){
									System.out.println("data inserted");
									request.getRequestDispatcher("restaurantPhotoList").forward(request, response);
								}else{
									System.out.println("oops some problem...");
								}
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("RestaurantPhotoEdit.jsp").forward(request, response);
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
