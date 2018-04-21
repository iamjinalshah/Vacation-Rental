<%@page import="digimation.vacationrental.bean.CousinBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
  <script src="bootstrap/js/bootstrap.min.js"></script>

</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>CUSINES</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Cusines</li>
          </ol>
          </br>

<form action="" name="">
<%List<CousinBean> listOfCousins = (ArrayList)request.getAttribute("listOfCousins"); 
if(listOfCousins!=null) {%>
<center>
	<table class="table table-hover">
		<thead>
		<tr bgcolor="orange">
			<th>Cousin-Id</th>
			<th>Cousin-Name</th>
			<th colspan="2">Action</th>
		</tr>
		</thead>
		<%for(int i=0;i<listOfCousins.size();i++){
			CousinBean cousinBean =listOfCousins.get(i); %>
		<tbody>
		<tr>
			<td><%=cousinBean.getCousin_id()%></td>
			<td><%=cousinBean.getCousin_name()%></td>
			<td><a href="cousinEdit?cousinId=<%=cousinBean.getCousin_id()%>" class="btn btn-primary">UPDATE</a>
			<a href="cousinDelete?cousinId=<%=cousinBean.getCousin_id()%>" class="btn btn-danger">DELETE</a></td>
		</tr>
		</tbody>
		<%} %>
	
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
	</table><br>
	<p><a href="Cousin.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>