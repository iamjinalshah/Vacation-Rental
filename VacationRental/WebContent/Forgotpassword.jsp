<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot password</title>
<link href="dist/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<form action="EmailChecker.jsp">
	
	<div class="element-main">
	${answer}
		<h1>Forgot Password</h1>
		<p> Give your Email for resetting your password</p>
			${invalidEmail}
			<input type="text" name="txtEmail" value="Your e-mail address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your e-mail address';}">
			<input type="submit" value="SUBMIT">
	</div>

</form>
</body>
</html>