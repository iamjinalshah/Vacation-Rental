<%@page import="java.util.ArrayList"%>
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
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>STATE</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Coverd Location</li>
          </ol>
          </br>
<form action="" name="StateListPage">
	<center>
	${fkchecking}
	<table border="1">
		<% List<StateBean> listOfState = (ArrayList)request.getAttribute("listOfState");
		if(listOfState!=null){
		%>
		<tr bgcolor="orange">
		<td>STATE-ID</td>
		<td>STATE NAME</td>
		<td>COUNTRY NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfState.size();i++){
			StateBean stateBean = listOfState.get(i);
			%>
		<tr>
			<td><%=stateBean.getState_id()%></td>
			<td><%=stateBean.getState_name() %></td>
			<td><%=stateBean.getCountry_name() %></td>
			<td><a href="stateEdit?stateId=<%=stateBean.getState_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="stateDelete?stateId=<%=stateBean.getState_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="State.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>