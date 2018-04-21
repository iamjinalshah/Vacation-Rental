<%@page import="digimation.vacationrental.bean.CategoryBean"%>
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
            <b>HOTELS RESTAURANT CATEGORY</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Categories</li>
          </ol>
          </br>
    
<center>      
 <form action="" name="">
<%List<CategoryBean> listOfCategory = (ArrayList)request.getAttribute("listOfCategory"); 
if(listOfCategory!=null) {%>
	<table border="1">
		<tr bgcolor="orange">
			<th>Category-Id</th>
			<th>Category-Name</th>
			<th colspan="2">Action</th>
		</tr>
		<%for(int i=0;i<listOfCategory.size();i++){
			CategoryBean categoryBean =listOfCategory.get(i); %>
		<tr>
			<td><%=categoryBean.getCategory_Id()%></td>
			<td><%=categoryBean.getCategory_Name()%></td>
			<td><a href="categoryEdit?categoryId=<%=categoryBean.getCategory_Id()%>">Update</a></td>
			<td><a href="categoryDelete?categoryId=<%=categoryBean.getCategory_Id()%>">Delete</a></td>
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