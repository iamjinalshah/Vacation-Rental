<!DOCTYPE html>
<%@page import="digimation.vacationrental.dao.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="digimation.vacationrental.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html>
 <head>
 <title>User Account dashboard</title>
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
  <%@include file="header2.jsp"%>	
  <body>
  
  
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
                <a href="userBlockedPropertyList?userId=<%=userSession.getUser_id()%>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-2 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h6>Account Info</h6>
                </div>
                <a href="userAccount?userId=<%=userSession.getUser_id()%>" class="small-box-footer">All info <i class="fa fa-arrow-circle-down"></i></a>
              </div>
            </div><!-- ./col -->
          </div><!-- /.row -->
          <form action="userAccountUpdate" name="RegistrationPage" class="form-horizontal" role="form">
          
					<% UserBean accountInfo = (UserBean)request.getAttribute("accountInfo"); 
					if(accountInfo!=null){
					%>
							<input type="hidden" name="userId" value="<%=userSession.getUser_id()%>">
					
							 <div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Bank Name :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" name="txtBankName" type="text" value="<%=accountInfo.getBank_name()%>" required>
     						 </div>x
    						 </div>				

							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Account No :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtAccNo" value="<%=accountInfo.getAccount_no()%>" required>
     						 </div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">IFSC Code :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control"  type="text" name="txtIfscCode" value="<%=accountInfo.getIfsc_code()%>" required>
     						 </div>
    						 </div>	
							
							<div class="form-group">        
							<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" name="edit" class="btn btn-success btn-lg" value="EDIT">
							</div>
							</div>
						<%}else{ %>
						<h3>data not found...</h3>
						<%} %>
						
				</form>
          </section>            
          </div><!-- /.row (main row) -->
  </body>
   <%@include file="footer.jsp" %>
</html>
