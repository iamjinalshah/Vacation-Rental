<%@page import="digimation.vacationrental.dao.QuestionDAO"%>
<%@page import="digimation.vacationrental.bean.QuestionBean"%>
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
<center>
<form action="adminInsert" method="post" enctype="multipart/form-data">
	<table>
		<tr>
		<th>First name</th>
		<td>:</td>
		<td><input type="text" name="txtFirstName" id="txtFirstName">${firstName}</td>
		</tr>
		
		<tr>
		<th>Middle name</th>
		<td>:</td>
		<td><input type="text" name="txtMiddleName" id="txtMiddleName">${middleName}</td>
		</tr>
		
		<tr>
		<th>Last name</th>
		<td>:</td>
		<td><input type="text" name="txtLastName" id="txtLastName">${lastName}</td>
		</tr>
		
		<tr>
		<th>Email Id</th>
		<td>:</td>
		<td><input type="email" name="txtEmail" id="txtEmail">${emailId}</td>
		</tr>
		
		<tr>
		<th>Password</th>
		<td>:</td>
		<td><input type="password" name="txtPassword" id="txtPassword">${password}</td>
		</tr>
		
		<tr>
		<th>Mobile</th>
		<td>:</td>
		<td><input type="text" name="txtMobile" id="txtMobile">${mobile}</td>
		</tr>
		
		<tr>
		<th>LandLine</th>
		<td>:</td>
		<td><input type="text" name="txtLandline" id="txtLandline"></td>
		</tr>
		
		<tr>
		<th>Gender</th>
		<td>:</td>
		<td><input type="radio" name="rdbGender" id="rdbGender" value="MALE">Male
			<input type="radio" name="rdbGender" id="rdbGender" value="FEMALE">Female ${gender}</td>
		</tr>
		
		<tr>
		<th>Address</th>
		<td>:</td>
		<td><input type="text" name="txtAddress" id="txtAddress">${address}</td>
		</tr>
		
		<tr>
		<th>Date Of Birth</th>
		<td>:</td>
		<td><input type="txt" name="dateDOB" id="dateDOB"></td>
		</tr>
		
		<tr>
		<th>Question</th>
		<td>:</td>
		<td><select name="drpdnQuestion">
			<option value="0">-Select State-</option>
			<% List<QuestionBean> question = new QuestionDAO().list();
				for(int i=0;i<question.size();i++){
					QuestionBean questionBean = question.get(i);
			%>
			<option value="<%=questionBean.getQue_id()%>"><%=questionBean.getQuestion()%></option>
			<%} %>
			</select>
		</tr>
		
		<tr>
		<th>Answer</th>
		<td>:</td>
		<td><input type="text" name="txtAnswer" id="txtAnswer">${answer}</td>
		</tr>
		
		<tr>
		<th>Upload your ID proof</th>
		<td>:</td>
		<td><input type="file" name="filePhoto" id="filePhoto">${photo}</td>
		</tr>
		
		<tr>
		<th></th>
		<td></td>
		<td><input type="submit" name="submit" value="SUBMIT">
			<input type="reset" name="reset" value="RESET">
			<a href="adminList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
</form>
</center>
</body>
</html>