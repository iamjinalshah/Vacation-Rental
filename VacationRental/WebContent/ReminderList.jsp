<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.ReminderBean"%>
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
            <b>REMINDER</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Reminder</li>
          </ol>
          </br>
<form action="" name="ReminderListPage">
	<center>
	<table border="1">
		<% List<ReminderBean> listOfReminder = (ArrayList)request.getAttribute("listOfReminder");
		if(listOfReminder!=null){
		%>
		<tr bgcolor="orange">
		<td>REMINDER-ID</td>
		<td>DETAILS</td>
		<td>DATE</td>
		<td>NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfReminder.size();i++){
			ReminderBean reminderBean = listOfReminder.get(i);
			%>
		<tr>
			<td><%=reminderBean.getReminder_id()%></td>
			<td><%=reminderBean.getDetails() %></td>
			<td><%=reminderBean.getDate() %></td>
			<td><%=reminderBean.getFirst_name()+" "+ reminderBean.getLast_name()%></td>
			<td><a href="reminderEdit?reminderId=<%=reminderBean.getReminder_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="reminderDelete?reminderId=<%=reminderBean.getReminder_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="userList"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</body>
</html>