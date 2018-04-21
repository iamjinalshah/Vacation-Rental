<%@page import="digimation.vacationrental.bean.HotelPhotoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyPhotoBean"%>
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
<form action="" name="">

<%List<HotelPhotoBean> listOfPhoto = (ArrayList)request.getAttribute("listOfPhoto"); 
if(listOfPhoto!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>PHOTO-Name</th>
			<th>IS VISISBLE</th>
			<th>IS COVER PHOTO</th>
			<th>HOTEL-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfPhoto.size();i++){
			HotelPhotoBean hotelPhotoBean =listOfPhoto.get(i); %>
		<tr>
			<td><%=hotelPhotoBean.getHotelphoto_id()%></td>
			<td><%=hotelPhotoBean.getPhoto_name()%></td>
			<td><%=hotelPhotoBean.getisIsvisible()%></td>
			<td><%=hotelPhotoBean.getisIscoverpage()%></td>
			<td><%=hotelPhotoBean.getHotel_name()%></td>
			<td><a href="hotelPhotoEdit?photoId=<%=hotelPhotoBean.getHotelphoto_id()%>">Update</a></td>
			<td><a href="hotelPhotoDelete?photoId=<%=hotelPhotoBean.getHotelphoto_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>
</body>
</html>