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

import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.dao.TourGuideDAO;

public class TourGuideUpdateServlet extends HttpServlet {
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
		
		TourGuideBean tourGuideBean = new TourGuideBean();
		
		try {
			items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					if (fieldName.equalsIgnoreCase("tourguideId")) {
						String value = fieldValue;
						int guideId = Integer.parseInt(value);
						tourGuideBean.setTourguide_id(guideId);
						System.out.println("GuideId : " + guideId);
					}
					
					if (fieldName.equalsIgnoreCase("txtFirstName")) {
						String value = fieldValue;
						tourGuideBean.setFirst_name(value);
						System.out.println("FirstName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMiddleName")) {
						String value = fieldValue;
						tourGuideBean.setMiddle_name(value);
						System.out.println("MiddleName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtLastName")) {
						String value = fieldValue;
						tourGuideBean.setLast_name(value);
						System.out.println("LastName : " + value);
					}
					
					if (fieldName.equalsIgnoreCase("txtMobile")) {
						String value = fieldValue;
						int mobile = Integer.parseInt(value);
						tourGuideBean.setMobile(mobile);
						System.out.println("Mobile : " + mobile);
					}
					
					if (fieldName.equalsIgnoreCase("txtLandline")) {
						String value = fieldValue;
						int landline = Integer.parseInt(value);
						tourGuideBean.setLandline(landline);
						System.out.println("Landline : " + landline);
					}
					
					if (fieldName.equalsIgnoreCase("txtRate")) {
						String value = fieldValue;
						int rate = Integer.parseInt(value);
						tourGuideBean.setRate(rate);
						System.out.println("Rate : " + rate);
					}
					
					if (fieldName.equalsIgnoreCase("city")) {
						String value = fieldValue;
						int cityId = Integer.parseInt(value);
						tourGuideBean.setCity_id(cityId);
						System.out.println("CityId : " + cityId);
					}
					
					if (fieldName.equalsIgnoreCase("area")) {
						String value = fieldValue;
						int areaId = Integer.parseInt(value);
						tourGuideBean.setArea_id(areaId);
						System.out.println("AreaId : " + areaId);
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
					String appPath = context.getRealPath("\\")+("upload\\tourguide");
					System.out.println("Path : "+appPath);
					
					
					String path = "G:\\Java_Project\\workspace\\VacationRental\\WebContent\\upload\\tourguide";
					
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
								tourGuideBean.setPhoto(file.getName());
								
								System.out.println("photo uploaded");
								request.setAttribute("fileName", file.getName());
								
								if(new TourGuideDAO().update(tourGuideBean)){
									System.out.println("data updated");
									request.getRequestDispatcher("tourGuideList").forward(request, response);
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
