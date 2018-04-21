<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
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
            <b>HOTELS</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Hotels</li>
          </ol>
          </br>
<form name="PropertyListPage">
			<center>
				<table border="1">
					<%
						List<HotelDetailsBean> listOfHotel = (ArrayList) request.getAttribute("listOfHotel");
						if (listOfHotel != null) {
					%>
					<input type="hidden"  name="action">
					<tr bgcolor="orange">
						<th>ID</th>
						<th>HOTEL NAME</th>
						<th>DESCRIPTION</th>
						<th>ADDRESS</th>
						<th>MANAGER NAME</th>
						<th>E-MAIL</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>WEBSITE</th>
						<th>IS AVAILABLE</th>
						<th>AREA</th>
						<th>CITY</th>
						<th>CATEGORY</th>
						<th>TYPE</th>
						<th>Action</th>

					</tr>
					<%
						for (int i = 0; i < listOfHotel.size(); i++) {

								HotelDetailsBean hotelDetailsBean = listOfHotel.get(i);
					%>

					<tr>
						<td><%=hotelDetailsBean.getHotel_id()%></td>
						<td><%=hotelDetailsBean.getHotel_name()%></td>
						<td><%=hotelDetailsBean.getDescription()%></td>
						<td><%=hotelDetailsBean.getAddress()%></td>
						<td><%=hotelDetailsBean.getManager_name()%></td>
						<td><%=hotelDetailsBean.getEmail_id()%></td>
						<td><%=hotelDetailsBean.getMobile()%></td>
						<td><%=hotelDetailsBean.getLandline()%></td>
						<td><%=hotelDetailsBean.getWebsite()%></td>
						<%if(hotelDetailsBean.getisIsavailable()){%>
						<td><a href="hotelDetailsIsAvailable?action=true&hotelId=<%=hotelDetailsBean.getHotel_id()%>"><font color=Green><%=hotelDetailsBean.getisIsavailable()%></font></a></td>
						<%}else{ %>
						<td><a href="hotelDetailsIsAvailable?action=false&hotelId=<%=hotelDetailsBean.getHotel_id()%>"><font color=red><%=hotelDetailsBean.getisIsavailable()%></font></a></td>
						<%} %>
						<td><%=hotelDetailsBean.getArea_name()%></td>
						<td><%=hotelDetailsBean.getCity_name()%></td>
						<td><%=hotelDetailsBean.getHrcategory_name()%></td>
						<td><%=hotelDetailsBean.getType_name()%></td>
						
						 <td><a href="hotelDetailsEdit?hotelId=<%=hotelDetailsBean.getHotel_id()%>">
						 <input type="button" name="EDIT" value="EDIT"></a>
							<a href="hotelDetailsDelete?hotelId=<%=hotelDetailsBean.getHotel_id()%>"><input
								type="button" name="DELETE" value="DELETE"></a>
							<a href="HotelPhotos.jsp?hotelId=<%=hotelDetailsBean.getHotel_id()%>"><input
								type="button" name="photo" value="Add Photo"></a>
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
				</br> <a href="HotelDetails.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" />
			</center>
		</form>
		</section>
		</div>
</body>
</html>