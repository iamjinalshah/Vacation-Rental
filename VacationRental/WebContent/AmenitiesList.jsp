<%@page import="digimation.vacationrental.bean.AmenitiesBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	
	function update(amenitiesId) {
		alert("Amenities ID:"+amenitiesId);
		var f=document.amenitiesListPage;
		f.amenitiesId.value = amenitiesId;
		f.action="amenitiesEdit";
		f.submit();
		
	}
</script>
</head>
<body>
	<center>
		
		<form action="" name="amenitiesListPage" id="amenitiesListPage">
			${fkchecking}
			<table border ="1">
			<input type="hidden" name="amenitiesId" id="amenitiesId"/>
			<%  List<AmenitiesBean> listOfAmenities = (ArrayList)request.getAttribute("listOfAmenities");
			if(listOfAmenities!=null){
			%>
					<tr bgcolor="orange">
						<td>ID</td>
						<td>Amenities NAme</td>
						<td colspan="2">Action</td>
					</tr>
					
					<%  for(int i=0;i<listOfAmenities.size();i++){
						AmenitiesBean bean = listOfAmenities.get(i); %> 
						
					<tr>
						<td><%=bean.getAmenitiesId()%></td>
						<td><%=bean.getAmenitiesName() %></td>
						<td><a href="#"onclick="update(<%= bean.getAmenitiesId()%>)">EDIT</a></td>
						<td><a href="amenitiesDelete?amenitiesId=<%=bean.getAmenitiesId() %>">DELETE</a></td>
					</tr>
					<%} %>
			</table>
		<%}else{ %>
			<h2><font color=red>Record not found for display....sorry</font></h2>
			<%} %>
			<p><a href="Amenities.jsp"><input type="button" value="Add Data"></a></p>
		</form>
	</center>
</body>
</html>