<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.QuestionBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function updt(questionId){
alert("Id :"+questionId);
var f=document.QuestionListPage;
f.questionId.value=questionId;
f.action="questionEdit";
f.submit();
}
</script>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
<div class="content-wrapper">
 <section class="content-header">
 <h1>
            <b>QUESTIONS</b>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Question</li>
          </ol>
          </br>
<form action="" name="QuestionListPage">
	<center>
	<table border="1">
		<input type="hidden" name="questionId" id="questionId"/>
		<% List<QuestionBean> question = (ArrayList)request.getAttribute("question");
		if(question!=null){
		%>
		<tr bgcolor="orange">
		<td>QUE-ID</td>
		<td>QUESTION</td>
		<td colspan="2">ACTION</td>
		</tr>
		<% for (int i=0;i<question.size();i++){
			QuestionBean questionBean = question.get(i);
			%>
		<tr>
			<td><%=questionBean.getQue_id()%></td>
			<td><%=questionBean.getQuestion() %></td>
			<td><a href="#" onclick="updt(questionId=<%=questionBean.getQue_id()%>)")><input type="button" name="Update" value="UPDATE"></a></td>
			<td><a href="questionDelete?questionId=<%=questionBean.getQue_id()%>"><input type="button" name="Delete" value="DELETE"></a></a></td>
			
		</tr>
		<%} %>
		<%} else {%>
			<h1>Data not found...</h1>
			<%} %>
	</table></br>
	<p><a href="Question.jsp"><input type="button" value="Add Data"></a></p>
	</center>
</form>
</section>
</div>
</body>
</html>