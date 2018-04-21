<%@page import="digimation.vacationrental.bean.BookingStatusBean"%>
<%@page import="java.util.ArrayList"%>
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
            <b>BOOKING STATUS</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Booking status</li>
          </ol>
          </br>
<form action="" name="">
<%List<BookingStatusBean> listOfBookings = (ArrayList)request.getAttribute("listOfBookings"); 
if(listOfBookings!=null) {%>
	<table border="1">
		<tr>
			<th>BookingStatusId</th>
			<th>BookingStatus</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfBookings.size();i++){
			BookingStatusBean bookingStatusBean = listOfBookings.get(i); %>
		<tr>
			<td><%=bookingStatusBean.getBookingstatusid()%></td>
			<td><%=bookingStatusBean.getBookingstatus()%></td>
			<td><a href="bookingStatusEdit?bookingStatusId=<%=bookingStatusBean.getBookingstatusid()%>">Update</a></td>
			<td><a href="bookingStatusDelete?bookingStatusId=<%=bookingStatusBean.getBookingstatusid()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>
</section>
</div>
</body>
</html>