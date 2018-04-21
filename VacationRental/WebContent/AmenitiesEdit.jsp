<%@page import="digimation.vacationrental.bean.AmenitiesBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%AmenitiesBean amenitiesBean = (AmenitiesBean)request.getAttribute("amenitiesBean");
		if(amenitiesBean!=null){	
	%>
	<form action="amenitiesUpdate" name="amenitiesEditPage" id="amenitiesEditPage">
	<input type="hidden" name="amenitiesId" id="amenitiesId" value="<%=amenitiesBean.getAmenitiesId() %>"/>
		<table>
		
			<tr>
				<td>Amenities Name :</td>
				<td><input type="text" name="txtamenitiesName" id="txtamenitiesName" value="${amenitiesBean.amenitiesName}"/>${amenitiesName}</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="submit" value="UPDATE">
					<a href="amenitiesList"><input type="button" name="SkipUpdation" value="Skip Updation"></a></td>
			</tr>
		</table>
	</form>
	<%} %>
</center>
</body>
</html>