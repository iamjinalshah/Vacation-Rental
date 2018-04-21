<%@page import="digimation.vacationrental.dao.StateDAO"%>
<%@page import="digimation.vacationrental.bean.StateBean"%>
<%@page import="digimation.vacationrental.dao.PropertyTypeDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyTypeBean"%>
<%@page import="digimation.vacationrental.dao.CityDAO"%>
<%@page import="digimation.vacationrental.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Your Property</title>
<script type='text/javascript' src='/template_designing/dwr/interface/AjaxDataDAO.js'></script>
  <script type='text/javascript' src='/template_designing/dwr/engine.js'></script>
 <script type='text/javascript' src='/template_designing/dwr/util.js'></script>

<script type="text/javascript">

function getResponse(stateId){
    //  stateId='';
		alert(stateId);
		dwr.util.removeAllOptions("city");
		
	document.getElementById('areaLoader').style.visibility = 'hidden';
		
		if(stateId==''){
			var data=[{ city_name:'-- Select --', city_id:'' }];
			dwr.util.addOptions("city",data,"city_id","city_name");
		document.getElementById('areaLoader').style.visibility = 'hidden';
		}else{
			//alert(cityId);
	    document.getElementById('areaLoader').style.visibility = 'visible';
			AjaxDataDAO.getAllCity(stateId,function(data){
			dwr.util.addOptions("city",data,"city_id","city_name");
	   document.getElementById('areaLoader').style.visibility = 'hidden';
			});
		}
}	



function getReply(cityId){
    //  stateId='';
		//alert(cityId);
		dwr.util.removeAllOptions("area");
		
	document.getElementById('areaLoader').style.visibility = 'hidden';
		
		if(cityId==''){
			var data=[{ area_name:'-- Select --', area_id:'' }];
			dwr.util.addOptions("area",data,"area_id","area_name");
		document.getElementById('areaLoader').style.visibility = 'hidden';
		}else{
			//alert(cityId);
	    document.getElementById('areaLoader').style.visibility = 'visible';
			AjaxDataDAO.getAllArea(cityId,function(data){
			dwr.util.addOptions("area",data,"area_id","area_name");
	   document.getElementById('areaLoader').style.visibility = 'hidden';
			});
		}
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
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section clearfix">
        <div class="container">
            <div class="row">
                <div id="fullwidth" class="col-sm-12">

                    <!-- START CONTENT -->
                    <div class="row">
                        <div id="content" class="col-md-12 col-sm-12 col-xs-12">
                            <div class="post-wrapper row clearfix">

                                <div class="col-md-8">
                                    <h5>List Your Property</h5>
                                    <br>
									
                                    <form class="form-horizontal" action="propertyDetailsInsert" method="post" >
                                        <div class="form-group">
                                        <input type="hidden" name="userId" value="<%=userSession.getUser_id()%>">
                                            <label for="propertyTitle" class="col-sm-2 control-label">Property-title:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="txtTitle" class="form-control" id="txtTitle" placeholder="Property-title" required>
                                        </div>
                                        
                                            <label for="address" class="col-sm-2 control-label">Address:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="txtAddress" class="form-control" id="txtAddress" placeholder="Address" required>
                                        </div>
                                        
                                        <label for="ownername" class="col-sm-2 control-label">Owner name:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="txtOwnerName" class="form-control" id="txtOwnerName" placeholder="Owner name" required>
                                        </div>
                                        
                                        <label for="email" class="col-sm-2 control-label">Email:</label>
                                        <div class="col-sm-10">
                                            <input type="email" name="txtEmail" class="form-control" id="txtEmail" placeholder="Email">
                                        </div>
                                        
                                        <label for="mobile" class="col-sm-2 control-label">Mobile:</label>
                                        <div class="col-sm-10">
                                        ${mobile}
                                            <input type="text" name="txtMobile" class="form-control" id="txtMobile" placeholder="Mobile" required>
                                        </div>
                                        
                                        <label for="landline" class="col-sm-2 control-label">Landline:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="txtLandline" class="form-control" id="txtLandline" placeholder="Landline">
                                        </div>
                                        
                                        <label for="rate" class="col-sm-2 control-label">Rate:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="txtRate" class="form-control" id="txtRate" placeholder="Rate" required>
                                        </div>


										<label for="State" class="col-sm-2 control-label">State:</label>
										<div class="col-sm-10">
											<select name="state" id="state" class="form-control"
												onChange="java:getResponse(this.value)">
												<option value="">---Select State---</option>
												<%
													List<StateBean> listOfState = new StateDAO().list();
													if (listOfState != null) {
														for (int i = 0; i < listOfState.size(); i++) {
															StateBean stateBean = listOfState.get(i);
												%>
												<option value="<%=stateBean.getState_id()%>"><%=stateBean.getState_name().toUpperCase()%></option>
												<%
													}
													}
												%>
											</select>
										</div>


										<label for="City" class="col-sm-2 control-label">City:</label>
										<div class="col-sm-10">
											<select name="city" id="city" class="form-control"
												onChange="java:getReply(this.value)">
												<option value="">---Select City---</option>
											</select> <span id="areaLoader" style="visibility: hidden;"> <img
												src="images/ajax-loader.gif">
											</span>
										</div>

										<label for="Area:" class="col-sm-2 control-label">Area:</label>
                                        <div class="col-sm-10">
											<select name="area" id="area" class="form-control">
												<option value="">---Select Area---</option>
												</select>
													<span id="areaLoader" style="visibility:hidden;">
		  														  <img src="images/ajax-loader.gif">		
	    													</span>	
                                        </div>
                                        
                                        <label for="propertytype" class="col-sm-2 control-label">Property type:</label>
                                        <div class="col-sm-10">
											<select name="drpdnproperty" class="form-control">
												<option value="0">-Select Property type-</option>
												<%
													List<PropertyTypeBean> property = new PropertyTypeDAO().list();
													for (int i = 0; i < property.size(); i++) {
														PropertyTypeBean propertyTypeBean = property.get(i);
												%>
												<option value="<%=propertyTypeBean.getPtype_id()%>"><%=propertyTypeBean.getType_name()%></option>
												<%
													}
												%>
											</select>
										</div>
                                        
                                        <label for="amenities" class="col-sm-2 control-label">Select Amenities:</label>
                                        <div class="col-sm-10">
                                            <input type="checkbox" name="chkAmenities" id="chkgame" value="Wi-Fi"> Wi-Fi </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="A.C"> A.C </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="Broadband"> Broadband </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="T.V"> T.V </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="Gym"> Gym </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="SwimmingPull"> SwimmingPull </br>
                                        </div>
                                        
                                       	<!-- <label for="inputPassword3" class="col-sm-2 control-label">Property photo:</label>
                                        <div class="col-sm-10">
                                            <input type="file" name="filePhoto"  id="filePhoto" class="form-control">
                                     	</div> -->
                                        </br>
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <hr>
                                            <input type="submit" class="btn btn-primary btn-normal border-radius pull-right" value="NEXT">
                                        </div>
                                        </div>
                                    </form>

                                </div><!-- end col -->


                            </div><!-- end post-wrapper -->
                        </div><!-- end col -->
                    </div><!-- end row -->
                    <!-- END CONTENT -->

                </div><!-- end fullwidth -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->


</div><!-- end wrapper -->



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