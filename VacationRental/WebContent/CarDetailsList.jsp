<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.CarDetailsBean"%>
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
            <b>CAR</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Car</li>
          </ol>
          </br>
<form name="PropertyListPage">
			<center>
				<table border="1">
					<%
						List<CarDetailsBean> listOfCar = (ArrayList) request.getAttribute("listOfCar");
						if (listOfCar != null) {
					%>
					<input type="hidden"  name="action">
					<tr bgcolor="orange">
						<th>ID</th>
						<th>CAPACITY</th>
						<th>MANAGER NAME</th>
						<th>E-MAIL</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>IS AVAILABLE</th>
						<th>AREA</th>
						<th>CITY</th>
						<th>BRAND</th>
						<th>MODEL</th>
						<th>Action</th>

					</tr>
					<%
						for (int i = 0; i < listOfCar.size(); i++) {

								CarDetailsBean carDetailsBean = listOfCar.get(i);
					%>

					<tr>
						<td><%=carDetailsBean.getCar_id()%></td>
						<td><%=carDetailsBean.getCapacity()%></td>
						<td><%=carDetailsBean.getManager_name()%></td>
						<td><%=carDetailsBean.getEmail_id()%></td>
						<td><%=carDetailsBean.getMobile()%></td>
						<td><%=carDetailsBean.getLandline()%></td>
						<%if(carDetailsBean.getisIsavailable()){%>
						<td><a href="hotelDetailsIsAvailable?action=true&hotelId=<%=carDetailsBean.getCar_id()%>"><font color=Green><%=carDetailsBean.getisIsavailable()%></font></a></td>
						<%}else{ %>
						<td><a href="hotelDetailsIsAvailable?action=false&hotelId=<%=carDetailsBean.getCar_id()%>"><font color=red><%=carDetailsBean.getisIsavailable()%></font></a></td>
						<%} %>
						<td><%=carDetailsBean.getArea_name()%></td>
						<td><%=carDetailsBean.getCity_name()%></td>
						<td><%=carDetailsBean.getCarbrand_name()%></td>
						<td><%=carDetailsBean.getCarmodel_name()%></td>
						
						 <td><a href="carDetailsEdit?carId=<%=carDetailsBean.getCar_id()%>">
						 <input type="button" name="EDIT" value="EDIT"></a>
							<a href="carDetailsDelete?carId=<%=carDetailsBean.getCar_id()%>"><input
								type="button" name="DELETE" value="DELETE"></a></td>
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
				</br> <a href="CarDetails.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" />
			</center>
		</form>
		</section>
		</div>
</body>
</html>