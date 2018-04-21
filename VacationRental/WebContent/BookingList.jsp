<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.BookingBean"%>
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
<form action="" name="">
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>BOOKING</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Booking</li>
          </ol>
          </br>
<%List<BookingBean> listOfBooking = (ArrayList)request.getAttribute("listOfBooking"); 
if(listOfBooking!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>BOOKING DATE</th>
			<th>BookingStatus</th>
			<th>HOTEL NAME</th>
			<th>PROPERTY NAME</th>
			<th>USER NAME</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfBooking.size();i++){
			BookingBean bookingBean = listOfBooking.get(i); %>
		<tr>
			<td><%=bookingBean.getBooking_id()%></td>
			<td><%=bookingBean.getBooking_date()%></td>
			<td><%=bookingBean.getBookingstatus()%></td>
			<td><%=bookingBean.getHotel_name()%></td>
			<td><%=bookingBean.getProperty_name()%></td>
			<td><%=bookingBean.getFirst_name()+" "+bookingBean.getLast_name()%></td>
			<td><a href="bookingEdit?bookingId=<%=bookingBean.getBooking_id()%>">Update</a></td>
			<td><a href="bookingDelete?bookingId=<%=bookingBean.getBooking_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
	</section>
	</div>
</form>
</body>
</html>