<%@page import="digimation.vacationrental.dao.CarBrandDAO"%>
<%@page import="digimation.vacationrental.bean.CarBrandBean"%>
<%@page import="java.util.List"%>
<%@page import="digimation.vacationrental.bean.CarModelBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="carModelUpdate" name="" method="get">
<% CarModelBean carModelBean = (CarModelBean)request.getAttribute("carModelBean");
	if(carModelBean!=null){
%>
<table>
	<input type="hidden" name="carModelId" value="<%=carModelBean.getCarmodel_id()%>">
	<tr>
		<th>Car-Model Name</th>
		<td>:</td>
		<td><input type="text" name="txtCarModel" id="txtCarModel" value="<%=carModelBean.getCarmodel_name()%>"></td>
	</tr>
	
	<tr>
		<th>Car-Brand</th>
		<td>:</td>
		<td><select name="drpdnCarBrand">
			<% List<CarBrandBean> car = new CarBrandDAO().list();
				for(int i=0;i<car.size();i++){
					CarBrandBean carBrandBean = car.get(i);
					if(carModelBean.getCarbarnd_id() == carBrandBean.getCarBrand_id()){
			%>
			<option value="<%=carBrandBean.getCarBrand_id()%>" selected="selected"><%=carBrandBean.getCarBrand_Name()%></option>
			<%} else{%>
			<option value="<%=carBrandBean.getCarBrand_id()%>"><%=carBrandBean.getCarBrand_Name()%></option>
			<%} %>
			<%} %>
			</select></td>
			
	</tr>
		<td><input type="submit" name="submit" value="SUBMIT"></td>
		<td><input type="reset" name="reset" value="RESET"></td>
	<tr>
</table>
<%}else{ %>
<h3>data not found for edit...</h3>
<%} %>
</form>
</body>
</html>