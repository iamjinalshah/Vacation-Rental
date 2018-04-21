<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.CountryBean"%>
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

<script type="text/javascript">
function updt(countryId){
alert("Id :"+countryId);
var f=document.CountryListPage;
f.countryId.value=countryId;
f.action="countryEdit";
f.submit();
}
</script>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>COUNTRY</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Coverd Location</li>
          </ol>
          </br>
<form action="" name="CountryListPage">
	<center>
	${fkchecking}
	<table class="table table-hover">
		<input type="hidden" name="countryId" id="countryId"/>
		<% List<CountryBean> country = (ArrayList)request.getAttribute("country");
		if(country!=null){
		%>
		<thead>
		<tr bgcolor="orange">
		<td>QUE-ID</td>
		<td>QUESTION</td>
		<td colspan="2">ACTION</td>
		</tr>
		</thead>
		<% for (int i=0;i<country.size();i++){
			CountryBean countryBean = country.get(i);
			%>
		<tbody>
		<tr>
			<td><%=countryBean.getCountry_id()%></td>
			<td><%=countryBean.getCountry_name() %></td>
			<td><a href="#" onclick="updt(countryId=<%=countryBean.getCountry_id()%>)")><input type="button" name="Update" value="UPDATE" class="btn btn-primary"></a>
			<a href="countryDelete?countryId=<%=countryBean.getCountry_id()%>"><input type="button" name="Delete" value="DELETE" class="btn btn-danger"></a></a></td>
			
		</tr>
		</tbody>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="Country.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>