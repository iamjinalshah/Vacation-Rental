<%@page import="digimation.vacationrental.bean.RoomTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% RoomTypeBean room = (RoomTypeBean)request.getAttribute("room"); 
if(room!=null) {%>

<form action="roomTypeUpdate">

<center>

<table>


	<input type="hidden" name="rtypeId" value="<%=room.getRtype_id()%>">
	<tr>
		<th>Question</th>
		<td>:</td>
		<td><input type="text" name="txtRType" id="txtRType" value="<%=room.getType_name()%>">${rtype}</td>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="UPDATE">
	<a href="hotelTypeList"><input type="button" value="Skip Updation"></a></td>
	</tr>
	
</table>

</center>
	
</form>
<%}else{ %>
	<h1>data never updated..</h1>
	<%} %>
</body>
</html>