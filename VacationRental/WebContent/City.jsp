<%@page import="digimation.vacationrental.dao.StateDAO"%>
<%@page import="digimation.vacationrental.bean.StateBean"%>
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
<form action="cityInsert">
	<table>
		<tr>
		<th>City Name</th>
		<td>:</td>
		<td><input type="text" name="txtCity" id="txtCity">${city}</td>
	</tr>
	
	<tr>
		<th>State</th>
		<td>:</td>
		<td><select name="drpdnState">
			<option value="0">-Select State-</option>
			<% List<StateBean> state = new StateDAO().list();
				for(int i=0;i<state.size();i++){
					StateBean stateBean = state.get(i);
			%>
			<option value="<%=stateBean.getState_id()%>"><%=stateBean.getState_name()%></option>
			<%} %>
			</select>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="cityList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>	
	</table>
</form>
</body>
</html>