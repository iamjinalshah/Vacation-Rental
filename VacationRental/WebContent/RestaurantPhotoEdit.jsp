<%@page import="digimation.vacationrental.bean.RestaurantPhotoBean"%>
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
<form action="restaurantPhotoUpdate" method="post" enctype="multipart/form-data">
<table>
<% RestaurantPhotoBean restaurantPhotoBean = (RestaurantPhotoBean)request.getAttribute("restaurantPhotoBean");
	if(restaurantPhotoBean!=null){
%>

<input type="hidden" name="photoId" value="<%=restaurantPhotoBean.getRestaurantphoto_id()%>">
<input type="hidden" name="drpdnRestaurant" id="drpdnRestaurant" value="<%=restaurantPhotoBean.getRestaurant_id()%>">

		<tr>
		<th>Hotel</th>
		<td>:</td>
		<td><select name="drpdnRestaurant">
			<option value="0">-Select Restaurant-</option>
			<% List<ResataurantDetailsBean> resataurant = new RestaurantDetailsDAO().list();
				for(int i=0;i<resataurant.size();i++){
					ResataurantDetailsBean resataurantDetailsBean = resataurant.get(i);
					if(resataurantDetailsBean.getRestaurant_id()==restaurantPhotoBean.getRestaurant_id()){
			%>
			<option value="<%=resataurantDetailsBean.getRestaurant_id()%>" selected="selected"><%=resataurantDetailsBean.getRestaurant_name()%></option>
			<%} else{%>
			<option value="<%=resataurantDetailsBean.getRestaurant_id()%>"><%=resataurantDetailsBean.getRestaurant_name()%></option>
			<%} %>
			<%} %>
			</select>
		</tr>
	
	<tr>
		<th>Restaurant photo</th>
		<td>:</td>
		<td><input type="file" name="fileRestaurat" id="fileRestaurat">${photo}</td>
	</tr>
	
	<tr>
		<td><input type="submit" name="submit" value="UPDATE"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	</tr>
	<%}%>
</table>
</form>
</body>
</html>