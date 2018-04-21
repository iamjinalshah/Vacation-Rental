<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.AttractionBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="AdminHeader.jsp" %>
<body>
<form action="" name="">
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>Attraction</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Attraction</li>
          </ol>
          </br>
<%List<AttractionBean> listOfAttraction = (ArrayList)request.getAttribute("listOfAttraction"); 
if(listOfAttraction!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Area</th>
			<th>City</th>
			<th>State</th>
			<th colspan="3">Action</th>
		</tr>
		<%for(int i=0;i<listOfAttraction.size();i++){
			AttractionBean attractionBean = listOfAttraction.get(i); %>
		<tr>
			<td><%=attractionBean.getAttraction_id()%></td>
			<td><%=attractionBean.getAttraction_name()%></td>
			<td><%=attractionBean.getDescription()%></td>
			<td><%=attractionBean.getArea_name()%></td>
			<td><%=attractionBean.getCity_name()%></td>
			<td><%=attractionBean.getState_name()%></td>
			<td><a href="#?bookingId=<%=attractionBean.getAttraction_id()%>">Update</a></td>
			<td><a href="#?bookingId=<%=attractionBean.getAttraction_id()%>">Delete</a></td>
			<td><a href="AttractionPhoto.jsp?attractionId=<%=attractionBean.getAttraction_id()%>">Add photos</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
	</section>
	</div>
</body>
</html>