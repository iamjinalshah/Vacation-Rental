<%@page import="digimation.vacationrental.dao.CityDAO"%>
<%@page import="digimation.vacationrental.bean.CityBean"%>
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
<form action="areaInsert">
	<table>
		<tr>
		<th>Area Name</th>
		<td>:</td>
		<td><input type="text" name="txtArea" id=""txtArea"">${area}</td>
		</tr>
		
		<tr>
		<th>Pin Code</th>
		<td>:</td>
		<td><input type="text" name="txtPincode" id="txtPincode">${pincode}</td>
		</tr>
	
	<tr>
		<th>City</th>
		<td>:</td>
		<td><select name="drpdnCity">
			<option value="0">-Select City-</option>
			<% List<CityBean> city = new CityDAO().list();
				for(int i=0;i<city.size();i++){
					CityBean cityBean = city.get(i);
			%>
			<option value="<%=cityBean.getCity_id()%>"><%=cityBean.getCity_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="areaList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>	
	</table>
</form>
</body>
</html>