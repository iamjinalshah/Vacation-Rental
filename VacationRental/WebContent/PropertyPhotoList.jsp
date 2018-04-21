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

<%List<PropertyPhotoBean> listOfPhoto = (ArrayList)request.getAttribute("listOfPhoto"); 
if(listOfPhoto!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>PHOTO-Name</th>
			<th>IS VISISBLE</th>
			<th>IS COVER PHOTO</th>
			<th>PROPERTY-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfPhoto.size();i++){
			PropertyPhotoBean propertyPhotoBean =listOfPhoto.get(i); %>
		<tr>
			<td><%=propertyPhotoBean.getPropertyphoto_id()%></td>
			<td><%=propertyPhotoBean.getPhoto_name()%></td>
			<td><%=propertyPhotoBean.getisIsvisible()%></td>
			<td><%=propertyPhotoBean.getisIscoverpage()%></td>
			<td><%=propertyPhotoBean.getProperty_name()%></td>
			<td><a href="propertyPhotoEdit?photoId=<%=propertyPhotoBean.getPropertyphoto_id()%>">Update</a></td>
			<td><a href="propertyPhotoDelete?photoId=<%=propertyPhotoBean.getPropertyphoto_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>

</body>
</html>