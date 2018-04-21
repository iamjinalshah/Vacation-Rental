<%@page import="digimation.vacationrental.dao.AmenitiesDAO"%>
<%@page import="digimation.vacationrental.bean.AmenitiesBean"%>
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
<form action="propertyDetailsAmenitiesInsert">
	<table>
	<% String propertyId = request.getParameter("propertyId"); %>
		<tr>
		<td><input type="hidden" name="drpdnPropertyDetails" id="drpdnPropertyDetails" value="<%=propertyId%>"></td>
		</tr>
		
		<tr>
			<th>Select Amenities:</th>
			<td><select name="drpdnAmenities">
				<option value="0">-select -</option>
				<% List<AmenitiesBean> amenities = new AmenitiesDAO().list();
					for(int i=0;i<amenities.size();i++){
						AmenitiesBean amenitiesBean = amenities.get(i);
				%>
				<option value="<%=amenitiesBean.getAmenitiesId()%>"><%=amenitiesBean.getAmenitiesName() %></option>
				<%} %>		
				</select>
		</tr>
		<tr>
		<th></th>
		<td></td>
		<td><input type="submit" name="submit" value="SUBMIT">
			<input type="reset" name="reset" value="RESET">
			<a href="propertyDetailsAmenitiesList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>

</form>
</body>
</html>