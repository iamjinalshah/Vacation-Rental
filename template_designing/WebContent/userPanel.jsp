<!DOCTYPE html>
<%@page import="digimation.vacationrental.dao.QuestionDAO"%>
<%@page import="digimation.vacationrental.bean.QuestionBean"%>
<%@page import="java.util.List"%>
<html>
 <head>
 <title>User Panel dashboard</title>
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
  <body>
  <%if(userSession!=null){ %>
  <div class="wrapper">
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
                <a href="userPanel.jsp" class="small-box-footer">All info <i class="fa fa-arrow-circle-down"></i></a>
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
          <form action="userUpdate" name="RegistrationPage" class="form-horizontal" role="form">
          				${updateProfile}
						<input type="hidden" name="userId" value="<%=userSession.getUser_id()%>">
							 <div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">First Name :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" name="txtFirstName" type="text" value="<%=userSession.getFirst_name()%>" required>
     						 </div>
    						 </div>				

							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Middle Name :</label>
    						 <div class="col-sm-10"> 
       						 <input class="form-control"  name="txtMiddleName" type="text" value="<%=userSession.getMiddle_name()%>" required> 
     						 </div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Last Name :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" name="txtLastName" type="text" value="<%=userSession.getLast_name()%>" required>
     						 </div>
    						 </div>	
							

							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Email :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" name="txtEmail" type="text" value="<%=userSession.getEmail_id()%>" required>
     						 </div>
    						 </div>	
							
					
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Password :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtPassword" value="<%=userSession.getPassword()%>" required>
     						 </div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Mobile :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtMobileNo" value="<%=userSession.getMobile()%>" required>
     						 </div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Landline :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtLandline" value="<%=userSession.getLandline()%>" required>
     						 </div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Address :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtAddress" value="<%=userSession.getAddress()%>" required>
     						 </div>
    						 </div>	
							
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">DOB :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="dateDOB" value="<%=userSession.getDob()%>" required>
     						 </div>
    						 </div>	
   							 
   							 <div class="form-group">
     						 <label for="inputPassword3" class="col-sm-2 control-label">Question:</label>
											<div class="col-sm-10">
												<select name="drpdnQuestion" class="form-control">
													<option value="0">-Select Question-</option>
													<%
														List<QuestionBean> question = new QuestionDAO().list();
														for (int i = 0; i < question.size(); i++) {
															QuestionBean questionBean = question.get(i);
															
															if(questionBean.getQue_id()==userSession.getQue_id()){
													%>
													<option value="<%=questionBean.getQue_id()%>" selected="selected"><%=questionBean.getQuestion()%></option>
													<%}else{%>
													<option value="<%=questionBean.getQue_id()%>"><%=questionBean.getQuestion()%></option>
													<%} }%>
												</select>
											</div>
    						 </div>	
							
							<div class="form-group">
     						 <label for="inputPassword" class="col-sm-2 control-label">Answer :</label>
    						 <div class="col-sm-10">
       						 <input class="form-control" type="text" name="txtAnswer" value="<%=userSession.getAnswer()%>" required>
     						 </div>
    						 </div>	
						
							<div class="form-group">        
							<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-success btn-lg" name="edit" value="EDIT">
							</div>
							</div>
							
				</form>

          </section>            
          </div><!-- /.row (main row) -->
          <%}else{ 
          response.sendRedirect("login.jsp");
          }%>
  </body>
   <%@include file="footer.jsp" %>
  
</html>
