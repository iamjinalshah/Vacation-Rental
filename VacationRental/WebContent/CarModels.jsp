<%@page import="digimation.vacationrental.dao.CarBrandDAO"%>
<%@page import="digimation.vacationrental.bean.CarBrandBean"%>
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

<form action="carModelInsert" name="" method="get">

<table>
	<tr>
		<th>Car-Model Name</th>
		<td>:</td>
		<td><input type="text" name="txtCarModel" id="txtCarModel">${carModel}</td>
	</tr>
	
	<tr>
		<th>Car-Brand</th>
		<td>:</td>
		<td><select name="drpdnCarBrand">
			<option value="0">-Select CarBrand-</option>
			<% List<CarBrandBean> car = new CarBrandDAO().list();
				for(int i=0;i<car.size();i++){
					CarBrandBean carBrandBean = car.get(i);
			%>
			<option value="<%=carBrandBean.getCarBrand_id()%>"><%=carBrandBean.getCarBrand_Name()%></option>
			<%} %>
			</select>
	</tr>
	
		<td><input type="submit" name="submit" value="SUBMIT"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	<tr>
</table>
</form>

</body>
</html>