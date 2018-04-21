<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.GLDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
<div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>Guide Language</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Guide Language</li>
          </ol>
          </br>

<form action="" name="">
<%List<GLDetailsBean> listOfLanguages = (ArrayList)request.getAttribute("listOfLanguages"); 
if(listOfLanguages!=null) {%>
	<table border="1">
		<tr>
			<th>Language-Id</th>
			<th>TOURGUIDE ID</th>
			<th>Language-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfLanguages.size();i++){
			GLDetailsBean glDetailsBean =listOfLanguages.get(i); %>
		<tr>
			<td><%=glDetailsBean.getLanguage_id()%></td>
			<td><%=glDetailsBean.getTourguide_name()%></td>
			<td><%=glDetailsBean.getGl_name()%></td>
			<td><a href="glDetailsEdit?languageId=<%=glDetailsBean.getLanguage_id()%>">Update</a></td>
			<td><a href="glDetailsDelete?languageId=<%=glDetailsBean.getLanguage_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>
</section>
</div>
</body>
</html>