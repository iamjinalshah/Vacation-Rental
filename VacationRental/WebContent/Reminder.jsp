<%@page import="digimation.vacationrental.dao.UserDAO"%>
<%@page import="digimation.vacationrental.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="reminderInsert">
<table>
	<input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
	<tr>
		<th>Details</th>
		<td>:</td>
		<td><input type="text" name="txtDetails" id="txtDetails">${details}</td>
	</tr>
	
	<tr>
		<th>Date</th>
		<td>:</td>
		<td><input type="text" name="txtDate" id="txtDate">${date}</td>
	</tr>
	
	<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="reminderList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>	
</table>	

	
</form>
</body>
</html>