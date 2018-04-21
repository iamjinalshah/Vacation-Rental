<%@page import="java.sql.ResultSet"%>
<%@page import="digimation.vacationrental.util.DBConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="digimation.vacationrental.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email varification</title>
<link href="dist/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>

<% 
	Connection conn = null;

		String txtEmail=request.getParameter("txtEmail");
		System.out.println("Email :"+txtEmail);
		
		conn = DBConnection.getConnection();
		
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM ADMIN inner join QUE_TABLE on ADMIN.que_id=QUE_TABLE.que_id where ADMIN.email_id='"+txtEmail+"'";
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()){
%>
<form action="PasswordDisplay.jsp">
	<table>
		<input type="hidden" name="adminId" value="<%=rs.getInt("admin_id")%>">
	<div class="element-main">
	${answer}
		<h1>Question Verification</h1>
		<p> Give your answer for password</p>
			${invalidEmail}
			<input type="text" name="question" value="<%=rs.getString("question")%>">
			<input type="text" name="txtAnswer" value="Enter your answer" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Answer';}">
			<input type="submit" value="SUBMIT">
	</div>
	</form>
	<%}else{ 
		request.setAttribute("invalidEmail", "<font color=red>invalid Email Id</font>");
		request.getRequestDispatcher("Forgotpassword.jsp").forward(request, response);
	}%>
	

</body>
</html>