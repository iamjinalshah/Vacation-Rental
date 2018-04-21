<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="StudentListPage">
			<center>
				<input type="hidden" name="studentId" id="studentId">
				<table border="1">
					<%
						List<AdminBean> listOfAdmin = (ArrayList) request.getAttribute("listOfAdmin");
						if (listOfAdmin != null) {
					%>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>E-MAIL</th>
						<th>MOBILE</th>
						<th>LANDLINE</th>
						<th>GENDER</th>
						<th>ADDRESS</th>
						<th>DOB</th>
						<th>PASSWORD</th>
						<th>Is Active</th>
						<th>IdProof</th>
						<th>Question</th>
						<th>Answer</th>
						<th>Action</th>
						

					</tr>
					<%
						for (int i = 0; i < listOfAdmin.size(); i++) {

								AdminBean adminBean = listOfAdmin.get(i);
					%>

					<tr>
						<td><%=adminBean.getAdmin_id()%>
						<td><%=adminBean.getFirst_name() + " " + adminBean.getLast_name()%></td>
						<td><%=adminBean.getEmail_id()%></td>
						<td><%=adminBean.getMobile()%></td>
						<td><%=adminBean.getLandline()%></td>
						<td><%=adminBean.getGender()%></td>
						<td><%=adminBean.getAddress()%></td>
						<td><%=adminBean.getDob()%></td>
						<td><%=adminBean.getPassword()%></td>
						<td><%=adminBean.getIsactive()%></td>
						<td><%=adminBean.getPhoto()%></td>
						<td><%=adminBean.getQuestion()%></td>
						<td><%=adminBean.getAnswer()%></td>
						 <td><a href="adminEdit?adminId=<%=adminBean.getAdmin_id()%>">
						 <input type="button" name="EDIT" value="EDIT"></a>
							<a href="adminDelete?adminId=<%= adminBean.getAdmin_id()%>"><input
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
				</br> <a href="Admin.jsp"><input type="button" name="ADD DATA"
					value="ADD DATA" />
			</center>
		</form>
</body>
</html>