<%@page import="digimation.vacationrental.bean.HotelPhotoBean"%>
<%@page import="digimation.vacationrental.dao.HotelDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="hotelPhotoUpdate" method="post" enctype="multipart/form-data">
<table>
<% HotelPhotoBean hotelPhotoBean = (HotelPhotoBean)request.getAttribute("hotelPhotoBean");
	if(hotelPhotoBean!=null){
%>

<input type="hidden" name="photoId" value="<%=hotelPhotoBean.getHotelphoto_id()%>">
		
<input type="hidden" name="drpdnHotel" value="<%=hotelPhotoBean.getHotel_id()%>">
	<tr>
		<th>Hotel photo</th>
		<td>:</td>
		<td><input type="file" name="fileHotel" id="fileHotel">${photo}</td>
	</tr>
	
	<tr>
		<td><input type="submit" name="submit" value="SUBMIT"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	</tr>
	<%} %>
</table>
</form>
</body>
</html>