<%@page import="digimation.vacationrental.bean.CousinBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="cousinUpdate" name="" method="get">
<% CousinBean cousinBean = (CousinBean)request.getAttribute("cousinBean");
	if(cousinBean!=null){
%>
<table>
	<input type="hidden" name="cousinId" value="<%=cousinBean.getCousin_id()%>">
	<tr>
		<th>Cousin Name</th>
		<td>:</td>
		<td><input type="text" name="txtCousinName" id="txtCousinName" value="<%=cousinBean.getCousin_name()%>"></td>
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