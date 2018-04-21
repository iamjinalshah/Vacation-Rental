<%@page import="digimation.vacationrental.bean.PropertyTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% PropertyTypeBean property = (PropertyTypeBean)request.getAttribute("property"); 
if(property!=null) {%>

<form action="propertyTypeUpdate">

<center>

<table>


	<input type="hidden" name="ptypeId" value="<%=property.getPtype_id()%>">
	<tr>
		<th>Question</th>
		<td>:</td>
		<td><input type="text" name="txtPType" id="txtPType" value="<%=property.getType_name()%>">${ptype}</td>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="UPDATE">
	<a href="propertyTypeList"><input type="button" value="Skip Updation"></a></td>
	</tr>
	
</table>

</center>
	
</form>
<%}else{ %>
	<h1>data never updated..</h1>
	<%} %>
</body>
</html>