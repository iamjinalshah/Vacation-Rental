<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.TourGuideBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tour Guide List</title>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
 <div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>TOUR GUIDE</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">TOUR GUIDE</li>
          </ol>
          </br>
<form name="TourGuideListPage">
			<center>
				<input type="hidden" name="tourguideId" id="tourguideId">
				<table border="1">
					<%
						List<TourGuideBean> listOfTourGuide = (ArrayList) request.getAttribute("listOfTourGuide");
						if (listOfTourGuide != null) {
					%>
					<tr bgcolor="orange"> 
						<th>TOURGUIDE_ID</th>
						<th>FIRST_NAME</th>
						<th>MIDDLE_NAME</th>
						<th>LAST_NAME</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>PHOTO</th>
						<th>RATE</th>
						<th>AREA_ID</th>
						<th>CITY_ID</th>
						<th>ACTION</th>
						

					</tr>
					<%
						for (int i = 0; i < listOfTourGuide.size(); i++) {

								TourGuideBean tourGuideBean = listOfTourGuide.get(i);
					%>

					<tr>
						<td><%=tourGuideBean.getTourguide_id()%>
						<td><%=tourGuideBean.getFirst_name()%>
						<td><%=tourGuideBean.getMiddle_name()%>
						<td><%=tourGuideBean.getLast_name()%>
						<td><%=tourGuideBean.getMobile()%>
						<td><%=tourGuideBean.getLandline()%>
						<td><%=tourGuideBean.getPhoto()%>
						<td><%=tourGuideBean.getRate()%>
						<td><%=tourGuideBean.getArea_id()%>
						<td><%=tourGuideBean.getCity_id()%>
						
						 <td><a href="tourGuideEdit?tourguideId=<%=tourGuideBean.getTourguide_id()%>"><input type="button" name="EDIT" value="EDIT"></a>
							 <a href="tourGuideDelete?tourguideId=<%=tourGuideBean.getTourguide_id()%>"><input type="button" name="DELETE" value="DELETE"></a></td>
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
				</br> <a href="TourGuide.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" /></a>
			</center>
		</form>
		</section>
		</div>
</body>
</html>