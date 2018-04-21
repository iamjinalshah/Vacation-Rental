<%@page import="digimation.vacationrental.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% UserBean sessionBean = (UserBean)session.getAttribute("bean");

if(sessionBean!=null){
%>
    <div class="wrapper">

      <header class="main-header">
        <a href="AdminPanel.jsp" class="logo">
          <span class="logo-mini"><b>VR</b></span>
          <span class="logo-lg"><b>Vacation</b> Rental</span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
				  <li class="dropdown user user-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					  <img src="dist/img/img 2.jpg" class="user-image" alt="User Image">
					  <span class="hidden-xs"><%=sessionBean.getFirst_name().toUpperCase()+" "+sessionBean.getLast_name().toUpperCase() %></span>
					</a>
					<ul class="dropdown-menu">
					  <!-- User image -->
					  <li class="user-header">
						<img src="dist/img/img 2.jpg" class="img-circle" alt="User Image">
						<p>
						  <%=sessionBean.getFirst_name().toUpperCase()+" "+sessionBean.getLast_name().toUpperCase() %>
						  <small>Member since Nov. 2012</small>
						</p>
					  </li>
					  <li class="user-footer">
						<div class="pull-left">
						  <a href="#" class="btn btn-default btn-flat">Profile</a>
						</div>
						<div class="pull-right">
						  <a href="AdminLogin.jsp" class="btn btn-default btn-flat">Sign out</a>
						</div>
					  </li>
					</ul>
				  </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="UserPanel.jsp">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-map-marker"></i>
                <span>All listed Property</span>
              </a>
             </li>
             <li class="treeview">
              <a href="#">
                <i class="fa fa-map-marker"></i>
                <span>Booking History</span>
              </a>
             </li>
            
        </section>
      </aside>

	
<div class="content-wrapper">
	<section class="content-header"></section>
        <section class="content">
          <!-- Small boxes (Stat box) -->
          
          
          <div class="row">
		<div class="col-sm-12 col-md-12 user-details">
            <div class="user-image">
                <img src="dist/img/img 2 100-100.jpg" alt="Akash Ramani" title="Akash Ramani" class="img-circle">
            </div>
            <div class="user-info-block">
                <div class="user-heading">
                    <h3><%=sessionBean.getFirst_name().toUpperCase()+" "+sessionBean.getLast_name().toUpperCase() %></h3>
                    <span class="help-block">Ahmedanad, IN</span>
                </div>
            </div>
        </div>
	</div>
            </section><!-- /.Left col -->
	<section class="content">
               <div class="row">
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3></h3>
                  <p>Profile</p>
                </div>
                <a href="userContinue?userId=<%=sessionBean.getUser_id() %>" class="small-box-footer">All info <i class="fa fa-arrow-circle-down"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h3></h3>
                  <p>Listed property</p>
                </div>
                <a href="userPropertyList?userId=<%=sessionBean.getUser_id()%>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h3></h3>
                  <p>Booking History</p>
                </div>
                <a href="userBookingList?userId=<%=sessionBean.getUser_id() %>" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-red">
                <div class="inner">
                  <h3></h3>
                  <p>All Restaurant</p>
                </div>
                <a href="restaurantDetailsList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
          </div><!-- /.row -->
            </section>            
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="plugins/morris/morris.min.js"></script>
    <script src="plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="plugins/knob/jquery.knob.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="plugins/daterangepicker/daterangepicker.js"></script>
    <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="plugins/fastclick/fastclick.min.js"></script>
    <script src="dist/js/app.min.js"></script>
    <script src="dist/js/pages/dashboard.js"></script>
    <script src="dist/js/demo.js"></script>
    <%}else{
    	response.sendRedirect("UserLogin.jsp");
    } %>
</body>
</html>