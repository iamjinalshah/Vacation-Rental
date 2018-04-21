<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.BookingBean"%>
<%@page import="java.util.List"%>
<html>
 <head>
 <title>UserBookingList</title>
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
                <a href="userBookingList?userId=<%=userSession.getUser_id() %>" class="small-box-footer">All info <i class="fa fa-arrow-circle-down"></i></a>
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
                <a href="userBlockedPropertyList?userId=<%=userSession.getUser_id()%>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
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
          <form action="" name="">
 
<%List<BookingBean> listOfUserBooking = (ArrayList)request.getAttribute("listOfUserBooking"); 
if(listOfUserBooking!=null) {%>
	<table border="1" class="table table-hover">
	<thead>
		<tr bgcolor="orange">
			<th>Id</th>
			<th>BOOKING DATE</th>
			<th>BookingStatus</th>
			<th>HOTEL NAME</th>
			<th>PROPERTY NAME</th>
			<th>USER NAME</th>
		</tr>
		</thead>
		<%for(int i=0;i<listOfUserBooking.size();i++){
			BookingBean bookingBean = listOfUserBooking.get(i); %>
		<tbody></tbody>
		<tr>
			<td><%=bookingBean.getBooking_id()%></td>
			<td><%=bookingBean.getBooking_date()%></td>
			<td><%=bookingBean.getBookingstatus()%></td>
			<td><%=bookingBean.getHotel_name()%></td>
			<td><%=bookingBean.getProperty_name()%></td>
			<td><%=bookingBean.getFirst_name()+" "+bookingBean.getLast_name()%></td>
			<%-- <td><a href="bookingEdit?bookingId=<%=bookingBean.getBooking_id()%>"><input type="button" class="btn btn-primary" value="UPDATE"></a></td>
			<td><a href="bookingDelete?bookingId=<%=bookingBean.getBooking_id()%>"><input type="button" class="btn btn-danger" value="EDIT"></a></td> --%>
		</tr>
		</tbody>
		<%} %>
	</table>
	
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>
	</section>
	</div>
</form>
          </section>            
          </div><!-- /.row (main row) -->
  </body>
  <%@include file="footer.jsp" %>
</html>
