<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.RestaurantPhotoBean"%>
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

<%List<RestaurantPhotoBean> listOfPhoto = (ArrayList)request.getAttribute("listOfPhoto"); 
if(listOfPhoto!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>PHOTO-Name</th>
			<th>IS VISISBLE</th>
			<th>IS COVER PHOTO</th>
			<th>RESTAURANT-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfPhoto.size();i++){
			RestaurantPhotoBean restaurantPhotoBean =listOfPhoto.get(i); %>
		<tr>
			<td><%=restaurantPhotoBean.getRestaurantphoto_id()%></td>
			<td><%=restaurantPhotoBean.getPhoto_name()%></td>
			<td><%=restaurantPhotoBean.getisIsvisible()%></td>
			<td><%=restaurantPhotoBean.getisIscoverpage()%></td>
			<td><%=restaurantPhotoBean.getRestaurant_name()%></td>
			<td><a href="restaurantPhotoEdit?photoId=<%=restaurantPhotoBean.getRestaurantphoto_id()%>">Update</a></td>
			<td><a href="restaurantPhotoDelete?photoId=<%=restaurantPhotoBean.getRestaurantphoto_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>
</body>
</html>