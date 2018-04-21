<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link href="dist/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<form action="adminPasswordUpdate">

		<% String adminId = request.getParameter("adminId"); %>
		<input type="hidden" name="adminId" value="<%=adminId%>">
	
	<div class="element-main">
		<h1>Change Password</h1>
		<p>Enter your new password</p>
		${same}
		<input type="text" name="txtPassword" value="Enter Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Password';}">
		<input type="text" name="txtConfirmPassword" value="Enter Confirm password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Confirm Password';}">
		<input type="submit" value="SUBMIT">
	</div>
	</form>
</body>
</html>