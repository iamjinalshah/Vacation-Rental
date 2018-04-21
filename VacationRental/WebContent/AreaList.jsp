<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.AreaBean"%>
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
            <b>AREA</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Coverd Location</li>
          </ol>
          </br>
<form action="" name="AreaListPage">
	<center>
	<table border="1">
		<% List<AreaBean> listOfArea = (ArrayList)request.getAttribute("listOfArea");
		if(listOfArea!=null){
		%>
		<tr bgcolor="orange">
		<td>AREA-ID</td>
		<td>AREA NAME</td>
		<td>PINCODE</td>
		<td>CITY NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfArea.size();i++){
			AreaBean areaBean = listOfArea.get(i);
			%>
		<tr>
			<td><%=areaBean.getArea_id()%></td>
			<td><%=areaBean.getArea_name() %></td>
			<td><%=areaBean.getPincode() %></td>
			<td><%=areaBean.getCity_name() %></td>
			<td><a href="areaEdit?areaId=<%=areaBean.getArea_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="areaDelete?areaId=<%=areaBean.getArea_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="Area.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>