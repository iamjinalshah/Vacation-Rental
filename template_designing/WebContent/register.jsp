<%@page import="digimation.vacationrental.dao.QuestionDAO"%>
<%@page import="digimation.vacationrental.bean.QuestionBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<%@include file="header2.jsp"%>
<body>
	<div id="wrapper">


		<section id="page-header" class="section background">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h3>Register</h3>
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- end container --> </section>
		<!-- end section -->

		<section class="section clearfix">
		<div class="container">
			<div class="row">
				<div id="fullwidth" class="col-sm-12">

					<!-- START CONTENT -->
					<div class="row">
						<div id="content" class="col-md-12 col-sm-12 col-xs-12">
							<div class="post-wrapper row clearfix">
								<div class="col-md-4">
									<h5>NEW COSTUMER</h5>
									<p>By creating an account you will be able to shop faster,
										be up to date on an order’s status, and keep track of the
										orders you have previously made.</p>
									<hr>
									<a href="login.jsp"><button type="submit"
											class="btn btn-primary btn-normal border-radius">Login
											Now</button></a>
								</div>
								<!-- end col -->

								<div class="col-md-8">
									<h5>FOR NEW COSTUMER</h5>
									<br>

									<form class="form-horizontal"
										action="userInsert"
										method="post" enctype="multipart/form-data">
										<div class="form-group">
											<label for="firstName" class="col-sm-2 control-label">First
												Name:</label>
											<div class="col-sm-10">
												<input type="text" name="txtFirstName" class="form-control"
													id="inputEmail3" placeholder="First Name" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Middle
												Name:</label>
											<div class="col-sm-10">
												<input type="text" name="txtMiddleName" class="form-control"
													id="inputPassword3" placeholder="Middle Name" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Last
												Name:</label>
											<div class="col-sm-10">
												<input type="text" name="txtLastName" class="form-control"
													id="inputPassword3" placeholder="Last Name" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Email:</label>
											<div class="col-sm-10">
												<input type="email" name="txtEmail" class="form-control"
													id="inputPassword3" placeholder="Email" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Password:</label>
											<div class="col-sm-10">
											${password}
												<input type="password" name="txtPassword"
													class="form-control" id="inputPassword3"
													placeholder="Password" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">MobileNo1:</label>
											<div class="col-sm-10">
											${mobile1}
												<input type="text" name="txtMobileNo1" class="form-control"
													id="inputPassword3" placeholder="Mobile" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Landline:</label>
											<div class="col-sm-10">
											${mobile2}
												<input type="text" name="txtMobileNo2" class="form-control"
													id="inputPassword3" placeholder="Landline" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Address:</label>
											<div class="col-sm-10">
												<input type="text" name="txtAddress" class="form-control"
													id="inputPassword3" placeholder="Address" required>
											</div>


											<label for="inputPassword3" class="col-sm-2 control-label">DOB:</label>
											<div class="col-sm-10">
												<input type="text" name="dateDOB" class="form-control"
													id="inputPassword3" placeholder="Date of Birth" required >
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Question:</label>
											<div class="col-sm-10">
												<select name="drpdnQuestion" class="form-control">
													<option value="0">-Select Question-</option>
													<%
														List<QuestionBean> question = new QuestionDAO().list();
														for (int i = 0; i < question.size(); i++) {
															QuestionBean questionBean = question.get(i);
													%>
													<option value="<%=questionBean.getQue_id()%>"><%=questionBean.getQuestion()%></option>
													<%
														}
													%>
												</select>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Answer:</label>
											<div class="col-sm-10">
												<input type="text" name="txtAnswer" class="form-control"
													id="txtAnswer" placeholder="Answer" required>
											</div>
											<label for="inputPassword3" class="col-sm-2 control-label">Gender:</label>
											<div class="col-sm-10">
												<input type="radio" name="rdbGender" id="rdbGender"
													value="MALE">Male <input type="radio"
													name="rdbGender" id="rdbGender" value="FEMALE">Female

											</div>
											
											<center><label for="inputPassword3" class="col-sm-2 control-label">Photo:</label></center>
											<div class="col-sm-12">
												<input type="file" name="filePhoto" class="form-control"
													id="filePhoto"  placeholder="Upload your photo" value="choose photo" required>
											</div>
											

											<div class="col-sm-offset-2 col-sm-10">
												<hr>
												<input type="submit"
													class="btn btn-primary btn-normal border-radius pull-right"
													value="Register">
											</div>
										</div>
									</form>

								</div>
								<!-- end col -->


							</div>
							<!-- end post-wrapper -->
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->
					<!-- END CONTENT -->

				</div>
				<!-- end fullwidth -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container --> </section>
		<!-- end section -->

	</div>
	<!-- end wrapper -->
	<%@include file="footer.jsp"%>
	<!-- Template core JavaScript's
    ================================================== -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/retina.js"></script>
	<script src="js/sidebar.js"></script>
	<script src="js/circle.js"></script>
	<script src="js/progress.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/parallax.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/custom.js"></script>

	<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
	<script src="rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script src="js/revslider.js"></script>
</body>
</html>