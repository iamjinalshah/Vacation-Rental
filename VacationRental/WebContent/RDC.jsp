<%@page import="digimation.vacationrental.dao.CousinDAO"%>
<%@page import="digimation.vacationrental.bean.CousinBean"%>
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
<form action="rdcInsert">
	<table>
	
	<tr>
		<th>Restaurant name</th>
		<td>:</td>
		<td><select name="drpdnRestaurant">
			<option value="0">select Reataurant</option>
			<option value="1">Hayat</option>
			<option value="2">taj</option>
			<option value="3">patang</option>
			</select>
	</tr>
	
	<tr>
		<th>Cousins type</th>
		<td>:</td>
		<td><select name="drpdnType">
			<option value="0">select Cousins type</option>
			<option value="Vegetarian">Vegetarian</option>
			<option value="Non-Vegtarian">Non-Vegtarian</option>
			</select>
	</tr>
	<tr>
		<th>Cousins</th>
		<td>:</td>
		<td><select name="drpdnCousins">
			<option value="0">select Cousins</option>
			<% List<CousinBean> cousins = new CousinDAO().list();
				for(int i=0;i<cousins.size();i++){
					CousinBean cousinBean = cousins.get(i);
			%>
			<option value="<%=cousinBean.getCousin_id()%>"><%=cousinBean.getCousin_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
	</tr>	
	</table>
</form>

</body>
</html>