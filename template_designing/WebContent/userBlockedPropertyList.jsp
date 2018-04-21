<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@page import="java.util.List"%>
<html>
 <head>
 <title>UserRequestedPropertyList</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" href="plugins/morris/morris.css">
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="dist/css/profile.css">
 </head>
  <%@include file="header2.jsp"%>	
  <body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper1">
	<section class="content-header"></section>
        <section class="content">
          <!-- Small boxes (Stat box) -->
          
          
          <div class="row">
		<div class="col-sm-12 col-md-12 user-details">
            <div class="user-image">
                <img src="upload/ProfilePhoto/<%=userSession.getPhoto()%>" height="100px" width="100px" alt="<%=userSession.getFirst_name()+" "+userSession.getLast_name()%>" title="<%=userSession.getFirst_name()+" "+userSession.getLast_name()%>" class="img-circle">
            </div>
            <div class="user-info-block">
                <div class="user-heading">
                </br>
                    <h3><%=userSession.getFirst_name().toUpperCase()+" "+userSession.getLast_name().toUpperCase() %></h3>
                    <h6>Ahmedabad, IN</h6>
                </div>
            </div>
        </div>
	</div>
            </section><!-- /.Left col -->
	<section class="content">
               <div class="row">
            <div class="col-lg-2 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h6>Listed property</h6>
                </div>
                <a href="userPropertyList?userId=<%=userSession.getUser_id()%>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-2 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h6>Booking History</h6>
                </div>
                <a href="userBookingList?userId=<%=userSession.getUser_id() %>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-4 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h6>Profile of <h6><%=userSession.getFirst_name().toUpperCase()+" "+userSession.getLast_name().toUpperCase() %></h6></h6>
                </div>
                <a href="userPanel.jsp" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-2 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h6>Property Request</h6>
                </div>
                <a href="userBlockedPropertyList?userId=<%=userSession.getUser_id()%>" class="small-box-footer">All info <i class="fa fa-arrow-circle-down"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-2 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h6>Account Info</h6>
                </div>
                <a href="userAccount?userId=<%=userSession.getUser_id()%>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
          </div><!-- /.row -->
          <form name="PropertyListPage">
			<center>
				<table border="1" class="table table-hover">
					<%
						List<PropertyDetailsBean> listOfUserProperty = (ArrayList)request.getAttribute("listOfUserProperty");
					if(listOfUserProperty!=null){
					%>
					<input type="hidden" name="action">
					<thead>
					<tr bgcolor="orange">
						<th>TITLE</th>
						<th>ADDRESS</th>
						<th>RATE</th>
						<th>AREA</th>
						<th>CITY</th>
						<th>PROPERTY TYPE</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					</thead>
					<%
						for (int i = 0; i < listOfUserProperty.size(); i++) {

								PropertyDetailsBean propertyDetailsBean = listOfUserProperty.get(i);
					%>
					<tbody>
					<tr>
						<td><%=propertyDetailsBean.getProperty_title()%></td>
						<td><%=propertyDetailsBean.getAddress()%></td>
						<td><%=propertyDetailsBean.getRate()%></td>
						<td><%=propertyDetailsBean.getArea_name()%></td>
						<td><%=propertyDetailsBean.getCity_name()%></td>
						<td><%=propertyDetailsBean.getType_name()%></td>
						
						 <td>
                   		 <a href="propertyEdit?propertyId=<%=propertyDetailsBean.getProperty_id()%>">
						 <input type="button" name="ShowFullData" value="Show Full Data" class="btn btn-info btn-sm"></a>
                   		 </td>
                   		 
                   		 <td>
                   		 <a href="propertyAmenities?propertyId=<%=propertyDetailsBean.getProperty_id()%>">
						 <input type="button" name="Show Amenities" value="Show Amenities" class="btn btn-normal btn-sm"></a>
                   		 </td>
                   		 
                   		 <td>
                   		 <a href="propertyPhotos?propertyId=<%=propertyDetailsBean.getProperty_id()%>">
						 <input type="button" name="Show photos" value="Show photos" class="btn btn-danger btn-sm"></a>
                   		 </td>
					</tr>
					</tbody>	


					<%
						}
					%>

					<%
						} else {
					%>

					<h2>No Records Found To Display.......</h2>
					<%
						}
					%>
				</table>
			</center>
		</form>
          </section>            
          </div><!-- /.row (main row) -->
          
          <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
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
