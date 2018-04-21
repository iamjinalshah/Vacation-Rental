<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function updt(ptypeId){
alert("Id :"+ptypeId);
var f=document.PropertyTypeListPage;
f.ptypeId.value=ptypeId;
f.action="propertyTypeEdit";
f.submit();
}
</script>

</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>PROPERTY TYPE</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">property type</li>
          </ol>
          </br>
<form action="" name="PropertyTypeListPage">
	<center>
	
${fkchecking}
	<table border="1">
		<input type="hidden" name="ptypeId" id="ptypeId"/>
		<% List<PropertyTypeBean> property = (ArrayList)request.getAttribute("property");
		if(property!=null){
		%>
		<tr bgcolor="orange">
		<td>PTYPE_ID</td>
		<td>PROPETY TYPE</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<property.size();i++){
			PropertyTypeBean propertyTypeBean = property.get(i);
			%>
		<tr>
			<td><%=propertyTypeBean.getPtype_id()%></td>
			<td><%=propertyTypeBean.getType_name() %></td>
			<td><a href="#" onclick="updt(ptypeId=<%=propertyTypeBean.getPtype_id()%>)")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="propertyTypeDelete?ptypeId=<%=propertyTypeBean.getPtype_id()%>"><input type="button" name="Delete" value="DELETE"></a></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="PropertyType.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>

</body>
</html>