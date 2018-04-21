<%@page import="digimation.vacationrental.dao.PropertyDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@page import="digimation.vacationrental.dao.PropertyTypeDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyTypeBean"%>
<%@page import="digimation.vacationrental.dao.HotelDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@page import="digimation.vacationrental.dao.BookingStatusDAO"%>
<%@page import="digimation.vacationrental.bean.BookingStatusBean"%>
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
<form action="bookingInsert" name="" method="get">

<table>
	<tr>
		<th>Booking-Date</th>
		<td>:</td>
		<td><input type="text" name="txtDate" id="txtDate" placeholder="e.g yyyy/mm/dd">${date}</td>
	</tr>
	
	<tr>
		<th>Booking Status</th>
		<td>:</td>
		<td><select name="drpdnStatus">
			<option value="0">-Select Booking Status-</option>
			<% List<BookingStatusBean> status = new BookingStatusDAO().list();
				for(int i=0;i<status.size();i++){
					BookingStatusBean bookingStatusBean = status.get(i);
			%>
			<option value="<%=bookingStatusBean.getBookingstatusid()%>"><%=bookingStatusBean.getBookingstatus()%></option>${status}
			<%} %>
			</select>
	</tr>
	
	<tr>
		<th>Hotel</th>
		<td>:</td>
		<td><select name="drpdnHotel">
			<option value="0">-Select Hotel-</option>
			<% List<HotelDetailsBean> hotel = new HotelDetailsDAO().list();
				for(int i=0;i<hotel.size();i++){
					HotelDetailsBean hotelDetailsBean = hotel.get(i);
			%>
			<option value="<%=hotelDetailsBean.getHotel_id()%>"><%=hotelDetailsBean.getHotel_name()%></option>${hotel }
			<%} %>
			</select>
	</tr>
	
	 
 		 <tr>
		<th>Property</th>
		<td>:</td>
		<td><select name="drpdnproperty">
			<option value="0">-Select Property-</option>
			<% List<PropertyDetailsBean> property = new PropertyDetailsDAO().list();
				for(int i=0;i<property.size();i++){
					PropertyDetailsBean propertyDetailsBean = property.get(i);
			%>
			<option value="<%=propertyDetailsBean.getProperty_id()%>"><%=propertyDetailsBean.getProperty_title()%></option>
			<%} %>
			</select>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="SUBMIT"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	<tr>
</table>
</form>
</body>
</html>