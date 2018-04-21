<%@page import="digimation.vacationrental.dao.StateDAO"%>
<%@page import="digimation.vacationrental.dao.CountryDAO"%>
<%@page import="digimation.vacationrental.bean.CountryBean"%>
<%@page import="java.util.List"%>
<%@page import="digimation.vacationrental.bean.StateBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="stateUpdate">
	<table>
		<% StateBean stateBean = (StateBean)request.getAttribute("stateBean");
		if(stateBean!=null){%>
		<input type="text" name="stateId" value="<%=stateBean.getState_id()%>">
		<tr>
		<th>State Name</th>
		<td>:</td>
		<td><input type="text" name="txtState" id="txtState" value="<%=stateBean.getState_name()%>">${state}</td>
	</tr>
	
	<tr>
		<th>Country</th>
		<td>:</td>
		<td><select name="drpdnCountry">
			<% List<CountryBean> country = new CountryDAO().list();
				for(int i=0;i<country.size();i++){
					CountryBean countryBean = country.get(i);
					if(stateBean.getCountry_id() == countryBean.getCountry_id()){
			%>
				<option value="<%=countryBean.getCountry_id()%>" selected="selected"><%=countryBean.getCountry_name()%></option>
				<%} else {%>
				<option value="<%=countryBean.getCountry_id()%>"><%=countryBean.getCountry_name()%></option>
				<%} %>
			<%} %>
			</select></td>
	</tr>
	
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="UPDATE">
		<a href="stateList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
	<%} %>	
	</table>
</form>
</body>
</html>