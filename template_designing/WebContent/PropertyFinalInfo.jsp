<%@page
	import="digimation.vacationrental.bean.PropertyDetailsAmenitiesBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation page</title>
<script type="text/javascript">
	function confirm() {
		alert("your property succefully Listed");
		alert("First our service checker check your property and than upload this property in our vacation rental's official website...");
		alert("Now can see this property into your dashboard and here you can edit details,add photos and add amenities...");
		var f = document.propertyFinalInfo;
		f.action = "index.jsp";
		f.submit();
	}
</script>
</head>
<%@include file="header2.jsp" %>
<body>
	<section id="page-header" class="section background">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h3>List Your Property</h3>
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
				<form name="propertyFinalInfo" action="propertyInfoDelete">
					<!-- START CONTENT -->
					<div class="row">
						<div id="content" class="col-md-12 col-sm-12 col-xs-12">
							<div class="post-wrapper clearfix border-bottom">
								<%
									PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = (PropertyDetailsAmenitiesBean) request
											.getAttribute("propertyDetailsAmenitiesBean");
									if (propertyDetailsAmenitiesBean != null) {
								%>
								
									<input type="hidden" name="pda_id" value="<%=propertyDetailsAmenitiesBean.getPDA_id()%>">
									<input type="hidden" name="amenities_id" value="<%=propertyDetailsAmenitiesBean.getAmenities_id()%>">
									<input type="hidden" name="property_id" value="<%=propertyDetailsAmenitiesBean.getProperty_id()%>">
									<input type="hidden" name="account_id" value="<%=propertyDetailsAmenitiesBean.getAccount_id()%>"> 
								<div class="post-title clearfix">
									<h3>
										<u>personal Info</u>
									</h3>
								</div>
								<!-- end ost-title -->

								<div class="post-content clearfix">
									
									<table>
										<tr>
											<div class="post-title clearfix">
												<th><h6>Owner Name</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=userSession.getFirst_name() + " "
						+ userSession.getMiddle_name() + " "
						+ userSession.getLast_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Email-Id</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getEmail_id()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Mobile</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getPmobile()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Landline</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getPlandline()%></td>
										</tr>


										<tr>
											<th>
												<div class="post-title clearfix">
													<h3>
														<u>Property Info</u>
													</h3>
												</div>
												<!-- end ost-title -->
											<th>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Propeerty Title</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getProperty_title()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Address</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getAddress()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Rate</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getRate()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Area</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getArea_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>City</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getCity_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Property Type</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getType_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Amenities</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getAmenities_name()%></td>
										</tr>

										<tr>
											<th>
												<div class="post-title clearfix">
													<h3>
														<u>Bank Account Info</u>
													</h3>
												</div>
												<!-- end ost-title -->
											<th>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Holder Name</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getFirst_name() + " "
						+ propertyDetailsAmenitiesBean.getMiddle_name() + " "
						+ propertyDetailsAmenitiesBean.getLast_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Bank Name</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getBank_name()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>Account no.</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getAccount_no()%></td>
										</tr>

										<tr>
											<div class="post-title clearfix">
												<th><h6>IFSC Code</h6></th>
											</div>
											<td>&nbsp;&nbsp;-->&nbsp;&nbsp;</td>
											<td><%=propertyDetailsAmenitiesBean.getIfsc_code()%></td>
										</tr>

										<tr>
											<th>
												<div class="col-sm-12">
													<div class="col-sm-4">
													<input type="button"
														class="btn btn-primary btn-normal border-radius pull-right"
														value="Confirm" onclick="confirm()"> 
													</div>
													<div class="col-sm-4">
												<%-- <a href="http://localhost:6018/Designing/propertyInfoDelete?pda_id=<%=propertyDetailsAmenitiesBean.getPDA_id()%>&amenities_id=<%=propertyDetailsAmenitiesBean.getAmenities_id()%>&photo_id=<%=propertyDetailsAmenitiesBean.getPropertyphoto_id()%>&propetrty_id=<%=propertyDetailsAmenitiesBean.getProperty_id()%>&account_id=<%=propertyDetailsAmenitiesBean.getAccount_id()%>"> --%>
														<input type="submit" class="btn btn-primary btn-normal border-radius pull-right"
														value="Cancel"></a>
														</div>
													<%-- <div class="col-sm-4">
													<a href="http://localhost:6018/Designing/propertyEdit?pda_id=<%=propertyDetailsAmenitiesBean.getPDA_id()%>"><input type="button"
														class="btn btn-primary btn-normal border-radius pull-right"
														value="Edit"></a>
													</div> --%>
														
												</div>
											</th>
										</tr>
									</table>

								</div>
								<!-- end post-content -->

							</div>
							<!-- end post-wrapper -->
							<%
								}
							%>
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->
					<!-- END CONTENT -->
				</form>
			</div>
			<!-- end fullwidth -->
		</div>
		<!-- end row -->
	</div>
	<!-- end container --> </section>
	<!-- end section -->

	</div>
	<!-- end wrapper -->
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
<%@include file="footer.jsp" %>
</html>