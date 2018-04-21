<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsAmenitiesBean"%>
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
<form action="">
	<center>
	<table border="1">
		<% List<PropertyDetailsAmenitiesBean> listOfPDA = (ArrayList)request.getAttribute("listOfPDA");
		if(listOfPDA!=null){
		%>
		<tr bgcolor="orange">
		<td>PDA-ID</td>
		<td>PROPERTY ID</td>
		<td>AMENITIES NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfPDA.size();i++){
			PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = listOfPDA.get(i);
			%>
		<tr>
			<td><%=propertyDetailsAmenitiesBean.getPDA_id()%></td>
			<td><%=propertyDetailsAmenitiesBean.getProperty_id()%></td>
			<td><%=propertyDetailsAmenitiesBean.getAmenities_name()%></td>
			<td><a href="propertyDetailsAmenitiesEdit?pdaId=<%=propertyDetailsAmenitiesBean.getPDA_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="propertyDetailsAmenitiesDelete?pdaId=<%=propertyDetailsAmenitiesBean.getPDA_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="PropertyDetailsAmenities.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</body>
</html>