<%@page import="digimation.vacationrental.bean.CarModelBean"%>
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
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>CAR MODEL</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Car Model</li>
          </ol>
          </br>
<form action="" name="CaModelsListPage">
	<center>
	<table border="1">
		<% List<CarModelBean> listOfCarModels = (ArrayList)request.getAttribute("listOfCarModels");
		if(listOfCarModels!=null){
		%>
		<tr bgcolor="orange">
		<td>CARMODEL-ID</td>
		<td>MODEL NAME</td>
		<td>BAND NAME</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<listOfCarModels.size();i++){
			CarModelBean carModelBean = listOfCarModels.get(i);
			%>
		<tr>
			<td><%=carModelBean.getCarmodel_id()%></td>
			<td><%=carModelBean.getCarmodel_name() %></td>
			<td><%=carModelBean.getCarbrand_name() %></td>
			<td><a href="carModelEdit?carModelId=<%=carModelBean.getCarmodel_id()%>")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="carModelDelete?carModelId=<%=carModelBean.getCarmodel_id()%>"><input type="button" name="Delete" value="DELETE"></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="CarModels.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>