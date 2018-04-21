<%@page import="digimation.vacationrental.dao.PropertyDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyPhotoBean"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
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
<form action="propertyPhotoUpdate" method="post" enctype="multipart/form-data">
<table>
<% PropertyPhotoBean propertyPhotoBean = (PropertyPhotoBean)request.getAttribute("propertyPhotoBean");
	if(propertyPhotoBean!=null){
%>

	<input type="hidden" name="photoId" value="<%=propertyPhotoBean.getPropertyphoto_id()%>">
		
	<input type="hidden" name="drpdnProperty" value="<%=propertyPhotoBean.getProperty_id()%>">
	<tr>
		<th>Propety photo</th>
		<td>:</td>
		<td><input type="file" name="fileProperty" id="fileProperty" value="<%=propertyPhotoBean.getPhoto_name()%>">${photo}</td>
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