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
<body>
<% 
		Connection conn = null;

		String txtAnswer =request.getParameter("txtAnswer");
		System.out.println("Answer :"+txtAnswer);
		
		String adminId =request.getParameter("adminId");
		System.out.println("admin Id :"+adminId);
		
		conn = DBConnection.getConnection();
		
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM ADMIN inner join QUE_TABLE on ADMIN.que_id=QUE_TABLE.que_id where ADMIN.answer='"+txtAnswer+"' and admin.admin_id='"+adminId+"'";
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()){
%>
<form action="adminEdit">
		
		
		<div class="element-main">
	
		<h1>Congratulations...</h1>
		<p> Your old password is <font color="red"><%=rs.getString("password") %></font></p>
		<h5>Go to login page <a href="UserLogin.jsp"><input type="button" value="Click here"></a></h5>
		<h5>For change your password <a href="ChangePassword.jsp?adminId=<%=rs.getInt("admin_id")%>"><input type="button" value="Click here"></a>
	</div>
	</form>
	<%}else{ 
		
		request.setAttribute("answer", "<font color=red>Wrong answer..please enter your email again....</font>");
		request.getRequestDispatcher("Forgotpassword.jsp").forward(request, response);
	} %>
</body>
</html>