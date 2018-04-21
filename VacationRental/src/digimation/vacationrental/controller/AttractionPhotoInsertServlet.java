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

import digimation.vacationrental.bean.AttractionBean;
import digimation.vacationrental.bean.AttractionPhotoBean;
import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.AttractionDAO;
import digimation.vacationrental.dao.TourGuideDAO;

public class AttractionPhotoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		
		AttractionPhotoBean attractionPhotoBean = new AttractionPhotoBean();
		
		try {
			items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("attarctionId")) {
						String value = fieldValue;
						attractionPhotoBean.setAttraction_id(value);
						System.out.println("Id : " + value);
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
					String appPath = context.getRealPath("\\")+("upload\\attraction ");
					System.out.println("Path : "+appPath);
					
					
					String path = "G:\\Java_Project\\workspace\\VacationRental\\WebContent\\upload\\attraction";
					
					file = new File(path + File.separator + fileName);
					
					
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
								attractionPhotoBean.setPhoto_name(file.getName());
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								
								if(new AttractionDAO().photoinsert(attractionPhotoBean)){
									System.out.println("data inserted");
									request.getRequestDispatcher("attractionList").forward(request, response);
								}else{
									System.out.println("oops some problem...");
								}
								
							
							} else {

								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							request.getRequestDispatcher("TourGuide.jsp").forward(request, response);
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
