<%@page import="digimation.vacationrental.bean.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="categoryUpdate" name="" method="get">
<% CategoryBean categoryBean = (CategoryBean)request.getAttribute("categoryBean");
	if(categoryBean!=null){
%>
<table>
	<input type="hidden" name="categoryId" value="<%=categoryBean.getCategory_Id()%>">
	<tr>
		<th>Category Name</th>
		<td>:</td>
		<td><input type="text" name="txtCategoryName" id="txtCategoryName" value="<%=categoryBean.getCategory_Name()%>"></td>
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