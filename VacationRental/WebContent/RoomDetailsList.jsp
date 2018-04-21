<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.RoomDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>Room Details</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Room Details</li>
          </ol>
          </br>
<form action="">
	<center>
	<table border="1">
		<% List<RoomDetailsBean> listOfRooms = (ArrayList)request.getAttribute("listOfRooms");
		if(listOfRooms!=null){
		%>
		<tr bgcolor="orange">
		<td>ROOM ID</td>
		<td>IS AVAILABLE</td>
		<td>ROOM TYPE</td>
		<td>HOTEL ID</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfRooms.size();i++){
			RoomDetailsBean roomDetailsBean = listOfRooms.get(i);
			%>
		<tr>
			<td><%=roomDetailsBean.getRoom_id()%></td>
			<td><%=roomDetailsBean.getisIsavailable()%></td>
			<td><%=roomDetailsBean.getType_name()%></td>
			<td><%=roomDetailsBean.getHotel_id()%></td>
			<td><a href="roomDetailsEdit?roomId=<%=roomDetailsBean.getRoom_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="roomDetailsDelete?roomId=<%=roomDetailsBean.getRoom_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="RoomDetails.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>