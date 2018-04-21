<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.ResataurantDetailsBean"%>
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
            <b>RESTAURANTS</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Restaurants</li>
          </ol>
          </br>
<form name="PropertyListPage">
			<center>
				<table border="1">
					<%
						List<ResataurantDetailsBean> listOfRestaurant = (ArrayList) request.getAttribute("listOfRestaurant");
						if (listOfRestaurant != null) {
					%>
					<tr bgcolor="orange">
						<th>ID</th>
						<th>RESTAURANT NAME</th>
						<th>DESCRIPTION</th>
						<th>ADDRESS</th>
						<th>MANAGER NAME</th>
						<th>E-MAIL</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>IS AVAILABLE</th>
						<th>AREA</th>
						<th>CITY</th>
						<th>CATEGORY</th>
						<th>Action</th>

					</tr>
					<%
						for (int i = 0; i < listOfRestaurant.size(); i++) {

								ResataurantDetailsBean resataurantDetailsBean = listOfRestaurant.get(i);
					%>

					<tr>
						<td><%=resataurantDetailsBean.getRestaurant_id()%></td>
						<td><%=resataurantDetailsBean.getRestaurant_name()%></td>
						<td><%=resataurantDetailsBean.getDescription()%></td>
						<td><%=resataurantDetailsBean.getAddress()%></td>
						<td><%=resataurantDetailsBean.getManager_name()%></td>
						<td><%=resataurantDetailsBean.getEmail_id()%></td>
						<td><%=resataurantDetailsBean.getMobile()%></td>
						<td><%=resataurantDetailsBean.getLandline()%></td>
						<%if(resataurantDetailsBean.getisIsavailable()){%>
						<td><a href="restaurantDetailsIsAvailable?action=true&restaurantId=<%=resataurantDetailsBean.getRestaurant_id()%>"><font color=Green><%=resataurantDetailsBean.getisIsavailable()%></font></a></td>
						<%}else{ %>
						<td><a href="restaurantDetailsIsAvailable?action=false&restaurantId=<%=resataurantDetailsBean.getRestaurant_id()%>"><font color=red><%=resataurantDetailsBean.getisIsavailable()%></font></a></td>
						<%} %>
						<td><%=resataurantDetailsBean.getArea_name()%></td>
						<td><%=resataurantDetailsBean.getCity_name()%></td>
						<td><%=resataurantDetailsBean.getHrcategory_name()%></td>
						
						 <td><a href="restaurantDetailsEdit?restaurantId=<%=resataurantDetailsBean.getRestaurant_id()%>">
						 <input type="button" name="EDIT" value="EDIT"></a>
							<a href="restaurantDetailsDelete?restaurantId=<%=resataurantDetailsBean.getRestaurant_id()%>"><input
								type="button" name="DELETE" value="DELETE"></a>
								<a href="RestaurantPhotos.jsp?restaurantId=<%=resataurantDetailsBean.getRestaurant_id()%>"><input
								type="button" name="DELETE" value="Add photo"></a>
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
				</br> <a href="RestaurantDetails.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" />
			</center>
		</form>
		</section>
		</div>
</body>
</html>