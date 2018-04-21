<%@page import="digimation.vacationrental.dao.RestaurantDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.ResataurantDetailsBean"%>
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
<form action="restaurantPhotoInsert" method="post" enctype="multipart/form-data">
<table>
<% String restaurantId = request.getParameter("restaurantId"); %>
		<tr>
		<td><input type="hidden" name="drpdnRestaurant" id="drpdnRestaurant" value="<%=restaurantId%>"></td>
		</tr>
		
	<tr>
		<th>Restaurant photo</th>
		<td>:</td>
		<td><input type="file" name="fileRestaurat" id="fileRestaurat">${photo}</td>
	</tr>
	
	<tr>
		<td><input type="submit" name="submit" value="SUBMIT"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	</tr>
</table>
</form>
</body>
</html>