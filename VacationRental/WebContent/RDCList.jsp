<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.RDCBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
<div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>Restaurant cusines</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Restaurant cusines</li>
          </ol>
          </br>
<form action="" name="">
<%List<RDCBean> listOfRDC = (ArrayList)request.getAttribute("listOfRDC"); 
if(listOfRDC!=null) {%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Res ID</th>
			<th>cousins type</th>
			<th>cousins Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfRDC.size();i++){
			RDCBean rdcBean =listOfRDC.get(i); %>
		<tr>
			<td><%=rdcBean.getRDC_id()%></td>
			<td><%=rdcBean.getRes_id()%></td>
			<td><%=rdcBean.getCousins_type()%></td>
			<td><%=rdcBean.getCousin_name() %></td>
			<td><a href="rdcEdit?rdcId=<%=rdcBean.getRDC_id()%>">Update</a></td>
			<td><a href="rdcDelete?rdcId=<%=rdcBean.getRDC_id()%>">Delete</a></td>
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