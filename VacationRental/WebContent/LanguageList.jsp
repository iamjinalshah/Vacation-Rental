<%@page import="digimation.vacationrental.bean.LanguageBean"%>
<%@page import="java.util.ArrayList"%>
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
<form action="" name="">
<%List<LanguageBean> listOfLanguages = (ArrayList)request.getAttribute("listOfLanguages"); 
if(listOfLanguages!=null) {%>
	<table border="1">
		<tr>
			<th>Language-Id</th>
			<th>Language-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfLanguages.size();i++){
			LanguageBean languageBean =listOfLanguages.get(i); %>
		<tr>
			<td><%=languageBean.getLanguage_Id()%></td>
			<td><%=languageBean.getLanguage_Name()%></td>
			<td><a href="languageEdit?languageId=<%=languageBean.getLanguage_Id()%>">Update</a></td>
			<td><a href="languageDelete?languageId=<%=languageBean.getLanguage_Id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>

</body>
</html>