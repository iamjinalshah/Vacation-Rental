<!DOCTYPE html>
<%@page import="digimation.vacationrental.bean.AdminBean"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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

  </head>
  <body class="hold-transition skin-blue sidebar-mini">
  <%AdminBean sessionBean = (AdminBean)session.getAttribute("bean");
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
					  <img src="upload/Idproof/<%=sessionBean.getPhoto()%>" class="img-circle" alt="User Image" height="40px" width="60px">
					  <span class="hidden-xs"><%=sessionBean.getFirst_name()+" "+sessionBean.getLast_name() %></span>
					</a>
					<ul class="dropdown-menu">
					  <!-- User image -->
					  <li class="user-header">
						<img src="upload/Idproof/<%=sessionBean.getPhoto()%>" class="img-circle" alt="User Image" height="40px" width="60px">
						<p>
						  <%=sessionBean.getFirst_name()+" "+sessionBean.getLast_name() %>
						  <small>Member since Nov. 2012</small>
						</p>
					  </li>
					  <li class="user-footer">
						<div class="pull-left">
						  <a href="#" class="btn btn-default btn-flat">Profile</a>
						</div>
						<div class="pull-right">
						  <a href="logout" class="btn btn-default btn-flat">Sign out</a>
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
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="upload/Idproof/<%=sessionBean.getPhoto()%>" class="img-circle" alt="User Image" height="40px" width="60px">
            </div>
            <div class="pull-left info">
              <p><%=sessionBean.getFirst_name()+" "+sessionBean.getLast_name() %></p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="AdminPanel.jsp">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-map-marker"></i>
                <span>Covered Locations</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="countryList"><i class="fa  fa-caret-right"></i>Country</a></li>
                <li><a href="stateList"><i class="fa  fa-caret-right"></i>State</a></li>
                <li><a href="cityList"><i class="fa  fa-caret-right"></i>City</a></li>
                <li><a href="areaList"><i class="fa  fa-caret-right"></i>Area</a></li>
              </ul>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-users"></i>
                <span>Users</span>
				<i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="userList"><i class="fa  fa-user"></i>All User</a></li>
                <li><a href="blockedUserList"><i class="fa fa-user-times"></i>Blocked Users</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>Properties</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="propertyDetailsList"><i class="fa  fa-caret-right"></i> All Properties</a></li>
                <li><a href="propertyBlockedList"><i class="fa  fa-caret-right"></i>Property Request</a></li>
                <li><a href="propertyAcceptedList"><i class="fa  fa-caret-right"></i> Accepted Property</a></li>
                <li><a href="propertyTypeList"><i class="fa  fa-caret-right"></i>Property Type</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>Hotels</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="hotelDetailsList"><i class="fa  fa-caret-right"></i> All Hotels</a></li>
                <li><a href="hotelBlockedList"><i class="fa  fa-caret-right"></i> Blocked Hotels</a></li>
                <li><a href="hotelTypeList"><i class="fa  fa-caret-right"></i>Hotel Type</a></li>
                <li><a href="categoryList"><i class="fa  fa-caret-right"></i>Hotel Restaurant Category</a></li>
                <li><a href="roomDetailsList"><i class="fa  fa-caret-right"></i>Room Details</a></li>
                <li><a href="roomTypeList"><i class="fa  fa-caret-right"></i>Room Type</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>Restaurants</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="restaurantDetailsList"><i class="fa  fa-caret-right"></i> All Restaurants</a></li>
                <li><a href="restaurantBlockedList"><i class="fa  fa-caret-right"></i> Blocked Restaurants</a></li>
                <li><a href="cousinList"><i class="fa  fa-caret-right"></i> Cusines</a></li>
                <li><a href="rdcList"><i class="fa  fa-caret-right"></i> Restaurant cusines details</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-car"></i>
                <span>Car provider</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              	<li><a href="carBrandList"><i class="fa  fa-caret-right"></i>Car Brand</a></li>
              	<li><a href="carModelList"><i class="fa  fa-caret-right"></i>Car Model</a></li>
                <li><a href="carDetailsList"><i class="fa  fa-caret-right"></i> All Car provider</a></li>
                <li><a href="hotelBlockedList"><i class="fa  fa-caret-right"></i> Blocked Car provider</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="reminderList">
                <i class="fa fa-bell-o"></i>
                <span>Reminder</span>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>TOUR GUIDE</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="tourGuideList"><i class="fa  fa-caret-right"></i> All TOUR GUIDE</a></li>
                <li><a href="languageList"><i class="fa  fa-caret-right"></i> All Language</a></li>
                <li><a href="glDetailsList"><i class="fa  fa-caret-right"></i> GUIDE LANGUAGE DETAIL</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>Booking</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="bookingList"><i class="fa  fa-caret-right"></i> All Bookings</a></li>
                <li><a href="bookingStatusList"><i class="fa  fa-caret-right"></i> Booking status</a></li>
              </ul>
             </li>
             <li class="treeview">
              <a href="questionList">
                <i class="fa fa-bell-o"></i>
                <span>Questions</span>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building"></i>
                <span>Rate & Review</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa  fa-caret-right"></i> Rate</a></li>
                <li><a href="feedbackList"><i class="fa  fa-caret-right"></i> Feedback</a></li>
              </ul>
             </li>
        </section>
        <!-- /.sidebar -->
      </aside>


      
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
   		response.sendRedirect("login.jsp");
    } %>
  </body>
</html>
