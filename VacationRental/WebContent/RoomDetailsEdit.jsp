<%@page import="digimation.vacationrental.dao.RoomTypeDAO"%>
<%@page import="digimation.vacationrental.bean.RoomTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="digimation.vacationrental.bean.RoomDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="roomDetailsUpdate">
<%RoomDetailsBean roomDetailsBean = (RoomDetailsBean)request.getAttribute("roomDetailsBean");
if(roomDetailsBean!=null){
%>
	<table>
	<input type="hidden" name="roomId" value="<%=roomDetailsBean.getRoom_id()%>">
		<table>
		<tr>
			<th>Room Type</th>
			<td>:</td>
			<td><select name="drpdnRoomType">
				<option value="0">-select roomtype -</option>
				<% List<RoomTypeBean> roomtype = new RoomTypeDAO().list();
					for(int i=0;i<roomtype.size();i++){
						RoomTypeBean roomTypeBean = roomtype.get(i);
						if(roomDetailsBean.getRtype_id()==roomTypeBean.getRtype_id()){
				%>
				<option value="<%=roomTypeBean.getRtype_id()%>" selected="selected"><%=roomTypeBean.getType_name()%></option>
				<%}else{ %>
				<option value="<%=roomTypeBean.getRtype_id()%>"><%=roomTypeBean.getType_name()%></option>
				<%} %>
				<%} %>		
				</select>
		</tr>
		
		<tr>
			<th>Hotel</th>
			<td>:</td>
			<td><select name="drpdnHotel">
				<option value="0">-select Hotel-</option>
				<option value="1">Hayat</option>
				<option value="2">Taj Hotel</option>
				<option value="3">OakDel</option>			
				</select>
		</tr>
		<tr>
		<th></th>
		<td></td>
		<td><input type="submit" name="submit" value="UPDATE">
			<input type="reset" name="reset" value="RESET">
			<a href="roomDetailsList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
<%} %>
</form>
</body>
</html>