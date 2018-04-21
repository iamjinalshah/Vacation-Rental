<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
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
            <b>PROPERTIES</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Properties</li>
          </ol>
          </br>
 
<form name="PropertyListPage">
			<center>
				<table border="1" >
					<%
						List<PropertyDetailsBean> listOfProperty = (ArrayList) request.getAttribute("listOfProperty");
						if (listOfProperty != null) {
					%>
					<input type="hidden" name="action">
					<tr bgcolor="orange">
						<th>ID</th>
						<th>TITLE</th>
						<th>ADDRESS</th>
						<th>OWNER NAME</th>
						<th>E-MAIL</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>RATE</th>
						<th>IS AVAILABLE</th>
						<th>AREA</th>
						<th>CITY</th>
						<th>PROPERTY TYPE</th>
						<th>Action</th>

					</tr>
					<%
						for (int i = 0; i < listOfProperty.size(); i++) {

								PropertyDetailsBean propertyDetailsBean = listOfProperty.get(i);
					%>

					<tr>
						<td><%=propertyDetailsBean.getProperty_id()%></td>
						<td><%=propertyDetailsBean.getProperty_title()%></td>
						<td><%=propertyDetailsBean.getAddress()%></td>
						<td><%=propertyDetailsBean.getOwner_name()%></td>
						<td><%=propertyDetailsBean.getEmail_id()%></td>
						<td><%=propertyDetailsBean.getMobile()%></td>
						<td><%=propertyDetailsBean.getLandline()%></td>
						<td><%=propertyDetailsBean.getRate()%></td>
						<%if(propertyDetailsBean.getIsavailable()){%>
						<td><a href="propertyDetailsIsAvailable?action=true&propertyId=<%=propertyDetailsBean.getProperty_id()%>"><font color=Green><%=propertyDetailsBean.getIsavailable()%></font></a></td>
						<%}else{ %>
						<td><a href="propertyDetailsIsAvailable?action=false&propertyId=<%=propertyDetailsBean.getProperty_id()%>"><font color=red><%=propertyDetailsBean.getIsavailable()%></font></a></td>
						<%} %>
						<td><%=propertyDetailsBean.getArea_name()%></td>
						<td><%=propertyDetailsBean.getCity_name()%></td>
						<td><%=propertyDetailsBean.getType_name()%></td>
						
						 <td><a href="propertyDetailsEdit?propertyId=<%=propertyDetailsBean.getProperty_id()%>">
						 <input type="button" name="EDIT" value="EDIT"></a>
							<a href="propertyDetailsDelete?propertyId=<%=propertyDetailsBean.getProperty_id()%>"><input
								type="button" name="DELETE" value="DELETE"></a>
							<a href="PropertyPhoto.jsp?propertyId=<%=propertyDetailsBean.getProperty_id()%>"><input
								type="button" name="photo" value="Add photo"></a>
								<a href="PropertyDetailsAmenities.jsp?propertyId=<%=propertyDetailsBean.getProperty_id()%>"><input
								type="button" name="Amenities" value="Add Amenities"></a>
								</td>
								
					</tr>


					<%
						}
					%>

					<%
						} else {
					%>

					<h2>No Records Found To Display.......</h2>
					<%
						}
					%>
				</table>
				</br> <a href="PropertyDetails.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" />
			</center>
		</form>
		</section>
	</div>
</body>
</html>