<%@page import="digimation.vacationrental.bean.PropertyDetailsAmenitiesBean"%>
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
<form action="propertyDetailsAmenitiesUpdate">
<%PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = (PropertyDetailsAmenitiesBean)request.getAttribute("propertyDetailsAmenitiesBean");
if(propertyDetailsAmenitiesBean!=null){
%>
	<table>
	<input type="hidden" name="pdaID" value="<%=propertyDetailsAmenitiesBean.getPDA_id()%>">
	
	<td><input type="hidden" name="drpdnPropertyDetails" id="drpdnPropertyDetails" value="<%=propertyDetailsAmenitiesBean.getProperty_id()%>"></td>
		<tr>
			<th>Select property:</th>
			<td><select name="drpdnPropertyDetails">
				<option value="0">-select property-</option>
				<option value="1">Sunder villa</option>
				<option value="2">Satyagrah banglow</option>
				<option value="3">Samay residency</option>			
				</select>
		</tr>
		
		<tr>
			<th>Select Amenities:</th>
			<td><select name="drpdnAmenities">
				<option value="0">-select -</option>
				<% List<AmenitiesBean> amenities = new AmenitiesDAO().list();
					for(int i=0;i<amenities.size();i++){
						AmenitiesBean amenitiesBean = amenities.get(i);
						if(propertyDetailsAmenitiesBean.getAmenities_id()== amenitiesBean.getAmenitiesId()){
				%>
				<option value="<%=amenitiesBean.getAmenitiesId()%>" selected="selected"><%=amenitiesBean.getAmenitiesName() %></option>
				<%}else{ %>
				<option value="<%=amenitiesBean.getAmenitiesId()%>"><%=amenitiesBean.getAmenitiesName() %></option>
				<%} %>	
				<%} %>	
				</select>
		</tr>
		<tr>
		<th></th>
		<td></td>
		<td><input type="submit" name="submit" value="UPDATE">
			<input type="reset" name="reset" value="RESET">
			<a href="propertyDetailsAmenitiesList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
<%} %>
</form>
</body>
</html>