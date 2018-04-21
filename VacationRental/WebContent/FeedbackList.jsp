<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.FeedbackBean"%>
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
            <b>FEEDBACK</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Feedback</li>
          </ol>
          </br>
<form action="" name="AreaListPage">
	<center>
	<table border="1">
		<% List<FeedbackBean> listOfFeedback = (ArrayList)request.getAttribute("listOfFeedback");
		if(listOfFeedback!=null){
		%>
		<tr bgcolor="orange">
		<td>ID</td>
		<td>USER NAME</td>
		<td>FEEDBACK</td>
		<td>ISVISIBLE</td>
		<td>HOTEL NAME</td>
		<td>PROPERTY NAME</td>
		<td>RESTAURANT NAME</td>
		<td>CAR MANAGER-NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfFeedback.size();i++){
			FeedbackBean feedbackBean = listOfFeedback.get(i);
			%>
		<tr>
			<td><%=feedbackBean.getFeedback_id()%></td>
			<td><%=feedbackBean.getFirst_name()+" "+ feedbackBean.getLast_name() %></td>
			<td><%=feedbackBean.getFeedback_details() %></td>
			<td><%=feedbackBean.getisIsavailable()%></td>
			<td><%=feedbackBean.getHotel_name()%></td>
			<td><%=feedbackBean.getProperty_title()%></td>
			<td><%=feedbackBean.getRestaurant_name()%></td>
			<td><%=feedbackBean.getManager_name()%></td>
			<td><a href="feedbackEdit?feedbackId=<%=feedbackBean.getFeedback_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="feedbackDelete?feedbackId=<%=feedbackBean.getFeedback_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="Feedback.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>