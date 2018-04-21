<%@page import="digimation.vacationrental.dao.CarDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.CarDetailsBean"%>
<%@page import="digimation.vacationrental.dao.RestaurantDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.ResataurantDetailsBean"%>
<%@page import="digimation.vacationrental.dao.PropertyDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@page import="digimation.vacationrental.dao.HotelDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
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
<form action="feedbackInsert">
	<table>
		<tr>
			<th>Feedback</th>
			<td>:</td>
			<td><input type="text" name="txtFeedback" id="txtFeedback">${feedback}
		</tr>
		
		<tr>
			<th>Date</th>
			<td>:</td>
			<td><input type="text" name="txtDate" id="txtdate"  placeholder="yyyy/mm/dd">${date}
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
			<option value="<%=hotelDetailsBean.getHotel_id()%>"><%=hotelDetailsBean.getHotel_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
		<th>Property</th>
		<td>:</td>
		<td><select name="drpdnProperty">
			<option value="0">-Select Property-</option>
			<% List<PropertyDetailsBean> Property = new PropertyDetailsDAO().list();
				for(int i=0;i<Property.size();i++){
					PropertyDetailsBean propertyDetailsBean = Property.get(i);
			%>
			<option value="<%=propertyDetailsBean.getProperty_id()%>"><%=propertyDetailsBean.getProperty_title()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
		<th>Restaurant</th>
		<td>:</td>
		<td><select name="drpdnRestaurant">
			<option value="0">-Select Restaurant-</option>
			<% List<ResataurantDetailsBean> Restaurant = new RestaurantDetailsDAO().list();
				for(int i=0;i<Restaurant.size();i++){
					ResataurantDetailsBean resataurantDetailsBean = Restaurant.get(i);
			%>
			<option value="<%=resataurantDetailsBean.getRestaurant_id()%>"><%=resataurantDetailsBean.getRestaurant_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
		<th>Car</th>
		<td>:</td>
		<td><select name="drpdnCar">
			<option value="0">-Select Car-</option>
			<% List<CarDetailsBean> car = new CarDetailsDAO().list();
				for(int i=0;i<car.size();i++){
					CarDetailsBean carDetailsBean = car.get(i);
			%>
			<option value="<%=carDetailsBean.getCar_id()%>"><%=carDetailsBean.getCarbrand_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
		<th>Tour guide</th>
		<td>:</td>
		<td><select name="drpdnTourGuide">
			<option value="0">-Select TourGuide-</option>
			<option value="1">Mr.Patel</option>
			<option value="2">Mr.Shah</option>
			<option value="3">Mr.Maheta</option>
			</select>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="feedbackList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
	
	
		
	</table>
</form>
</body>
</html>