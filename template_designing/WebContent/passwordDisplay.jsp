<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="digimation.vacationrental.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password</title>
<link href="dist/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<%@include file="header2.jsp" %>
<body>
<% 
		Connection conn = null;

		String txtAnswer =request.getParameter("txtAnswer");
		System.out.println("Answer :"+txtAnswer);
		
		String userId =request.getParameter("userId");
		System.out.println("user Id :"+userId);
		
		conn = DBConnection.getConnection();
		
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM USER inner join QUE_TABLE on USER.que_id=QUE_TABLE.que_id where USER.answer='"+txtAnswer+"' and USER.user_id='"+userId+"'";
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()){
%>
<form action="adminEdit">
		
		
		<div class="element-main">
	
		<h1>Congratulations...</h1>
		 <p>Your old password is <font color="red"><%=rs.getString("password") %></font></p>
		<h7>Go to login page? <a href="login.jsp">Click Here</a></h7><br>
		<h7>You need change your password? <a href="changePassword.jsp?userId=<%=rs.getInt("user_id")%>">Click Here</a></h7>
	</div>
	</form>
	<%}else{ 
		
		request.setAttribute("answer", "<font color=red>Wrong answer..please enter your email again....</font>");
		request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
	} %>
</body>
<%@include file="footer.jsp" %>
</html>