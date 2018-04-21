<%@page import="digimation.vacationrental.dao.CountryDAO"%>
<%@page import="digimation.vacationrental.bean.CountryBean"%>
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
<form action="stateInsert">
	<table>
		<tr>
		<th>State Name</th>
		<td>:</td>
		<td><input type="text" name="txtState" id="txtState">${state}</td>
	</tr>
	
	<tr>
		<th>Country</th>
		<td>:</td>
		<td><select name="drpdnCountry">
			<option value="0">-Select Country-</option>
			<% List<CountryBean> country = new CountryDAO().list();
				for(int i=0;i<country.size();i++){
					CountryBean countryBean = country.get(i);
			%>
			<option value="<%=countryBean.getCountry_id()%>"><%=countryBean.getCountry_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="stateList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>	
	</table>
</form>

</body>
</html>