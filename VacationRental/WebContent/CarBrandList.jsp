<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.CarBrandBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="header.jsp" %>

<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>CAR BRAND</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Car Brand</li>
          </ol>
          </br>
<center>
<form action="" name="" method="post">
<%List<CarBrandBean> listOfCarBrands = (ArrayList)request.getAttribute("listOfCarBrands"); 
if(listOfCarBrands!=null) {%>
	<table border="1">
		<tr bgcolor="orange">
			<th>CarBrand-Id</th>
			<th>CarBrand-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfCarBrands.size();i++){
			CarBrandBean carBrandBean =listOfCarBrands.get(i); %>
		<tr>
			<td><%=carBrandBean.getCarBrand_id()%></td>
			<td><%=carBrandBean.getCarBrand_Name()%></td>
			<td><a href="carBrandEdit?carBrandId=<%=carBrandBean.getCarBrand_id()%>">Update</a></td>
			<td><a href="carBrandDelete?carBrandId=<%=carBrandBean.getCarBrand_id()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
</form>
</center>
</section>
</div>
</body>
</html>