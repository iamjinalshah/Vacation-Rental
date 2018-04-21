<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.HotelTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function updt(htypeId){
alert("Id :"+htypeId);
var f=document.HotelTypeListPage;
f.htypeId.value=htypeId;
f.action="hotelTypeEdit";
f.submit();
}
</script>

</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>HOTEL TYPE</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Hotel Type</li>
          </ol>
          </br>
<form action="" name="HotelTypeListPage">
	<center>
	${fkchecking}
	<table border="1">
		<input type="hidden" name="htypeId" id="htypeId"/>
		<% List<HotelTypeBean> hotel = (ArrayList)request.getAttribute("hotel");
		if(hotel!=null){
		%>
		<tr bgcolor="orange">
		<td>HTYPE_ID</td>
		<td>HOTEL TYPE</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<hotel.size();i++){
			HotelTypeBean hotelTypeBean = hotel.get(i);
			%>
		<tr>
			<td><%=hotelTypeBean.getHtype_id()%></td>
			<td><%=hotelTypeBean.getType_name() %></td>
			<td><a href="#" onclick="updt(htypeId=<%=hotelTypeBean.getHtype_id()%>)")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="hotelTypeDelete?htypeId=<%=hotelTypeBean.getHtype_id()%>"><input type="button" name="Delete" value="DELETE"></a></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="HotelType.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>

</body>
</html>