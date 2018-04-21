<%@page import="digimation.vacationrental.dao.LanguageDAO"%>
<%@page import="digimation.vacationrental.bean.LanguageBean"%>
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
<form action="glDetailsInsert">
	<table>
	
	<tr>
		<th>Guide-Name</th>
		<td>:</td>
		<td><select name="drpdnGuides">
			<option value="0">select guide</option>
			<option value="1">Mr. patel</option>
			<option value="2">Mr. Shah</option>
			<option value="3">Mr. Modi</option>
			</select>
	</tr>
	<tr>
		<th>Guide-Languages</th>
		<td>:</td>
		<td><select name="drpdnLanguages">
			<option value="0">select language</option>
			<% List<LanguageBean> languages = new LanguageDAO().list();
				for(int i=0;i<languages.size();i++){
					LanguageBean languageBean = languages.get(i);
			%>
			<option value="<%=languageBean.getLanguage_Id()%>"><%=languageBean.getLanguage_Name()%></option>
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