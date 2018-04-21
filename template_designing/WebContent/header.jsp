<%@page import="digimation.vacationrental.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<title>Welcome to The Vacation Rental Website :: Life is Trip Plan Your Next Vacation</title>

<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png" />

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    
</head>
<body>
<%
	UserBean userSession = (UserBean)session.getAttribute("bean2");
if(userSession!=null) {%>
<div id="wrapper">
 <div class="topbar">
        <div class="container">
            <div class="pull-left">
                <ul class="topbar-drops list-inline">
                     <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-wallet17"></i> RUPI</a> 
                     </li>                      <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-globe"></i> ENGLISH</a> -->
                    </li> 
                </ul><!-- end list-style -->
            </div><!-- end left -->
            <div class="pull-right">
                <ul class="topbar-social list-inline">
                    <li><a href="#"><i class="icon-twitter"></i></a></li> 
                     <li><a href="#"><i class="icon-facebook"></i></a></li>
                     <li><a href="#"><i class="icon-linkedin"></i></a></li>
                    <li class="dropdown"><a href="userPanel.jsp">Welcome, <%=userSession.getFirst_name()+" "+userSession.getLast_name()%></a></li>
                   	<li><a href="listYourProperty.jsp">List Your Property</a></li>
                   	<li><a href="logout">LOGOUT</a></li>
                </ul><!-- end list-style -->
            </div><!-- end right -->
        </div><!-- end container -->
    </div><!-- end topbar -->

    <header class="header fixedheader nobg">
        <div class="menu-container">
            <div class="container">
                <div class="menu-wrapper">
                    <nav id="navigation" class="navbar" role="navigation">
                        <div class="navbar-inner">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <i class="icon-menu27"></i>
                                </button>
                                
                                <a id="brand" class="clearfix navbar-brand1" href="index.jsp"><img src="images/logo.png" alt="Trips">&nbsp&nbsp&nbsp<h3><span>Vacation</span> Trip</a>
                                
                            </div>
                            <!-- end navbar-header -->
                            <div id="navbar-collapse" class="navbar-right navbar-collapse collapse clearfix">
                                <ul class="nav navbar-nav yamm">
                                    <li class="dropdown">
                                        <a href="allSearch?action=attractionSearch">Attraction</a>
                                    </li><!-- end yamm-fw -->
                                    <li><a href="allSearch?action=hotelSearch">HOTELS</a></li>
                                    <li><a href="allSearch?action=restaurantSearch">Restaurant</a></li>
                                    <li><a href="allSearch?action=homeRentalSearch" >Home Rentals</a></li>
                                    <li><a href="allSearch?action=carRentalSearch">Car Rentals</a></li>
                                    <li><a href="allSearch?action=tourGuideSearch">Tour Guides</a></li>
                                </ul><!-- end navbar-right -->
                            </div><!-- end navbar-callopse -->
                        </div><!-- end navbar-inner -->
                    </nav><!-- end navigation -->
                </div><!-- menu wrapper -->
            </div><!-- end container -->
        </div><!-- end menu-container -->
    </header><!-- end header -->
 </div>
    <%}else{ %>
    <div id="wrapper">
 <div class="topbar">
        <div class="container">
            <div class="pull-left">
                <ul class="topbar-drops list-inline">
                     <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-wallet17"></i> RUPI</a> 
                     </li> 
                     <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-globe"></i> ENGLISH</a> 
                     </li> 
                </ul><!-- end list-style -->
            </div><!-- end left -->
            <div class="pull-right">
                <ul class="topbar-social list-inline">
                    
                    <li><a href="login.jsp">LOGIN / REGISTER</a></li>
                </ul><!-- end list-style -->
            </div><!-- end right -->
        </div><!-- end container -->
    </div><!-- end topbar -->

    <header class="header fixedheader nobg">
        <div class="menu-container">
            <div class="container">
                <div class="menu-wrapper">
                    <nav id="navigation" class="navbar" role="navigation">
                        <div class="navbar-inner">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <i class="icon-menu27"></i>
                                </button>
                                
                                <a id="brand" class="clearfix navbar-brand1" href="index.jsp"><img src="images/logo.png" alt="Trips">&nbsp&nbsp&nbsp<h3>Vacation Trip</h3></a>
                                
                            </div>
                            <!-- end navbar-header -->
                            <div id="navbar-collapse" class="navbar-right navbar-collapse collapse clearfix">
                                <ul class="nav navbar-nav yamm">
                                    <li class="dropdown">
                                        <a href="allSearch?action=attractionSearch">Attraction</a>
                                    </li><!-- end yamm-fw -->
                                    <li><a href="allSearch?action=hotelSearch">HOTELS</a></li>
                                    <li><a href="allSearch?action=restaurantSearch">Restaurant</a></li>
                                    <li><a href="allSearch?action=homeRentalSearch" >Home Rentals</a></li>
                                    <li><a href="allSearch?action=carRentalSearch">Car Rentals</a></li>
                                    <li><a href="allSearch?action=tourGuideSearch">Tour Guides</a></li>
                                </ul><!-- end navbar-right -->
                            </div><!-- end navbar-callopse -->
                        </div><!-- end navbar-inner -->
                    </nav><!-- end navigation -->
                </div><!-- menu wrapper -->
            </div><!-- end container -->
        </div><!-- end menu-container -->
    </header><!-- end header -->
 </div>
    <%} %>
</body>
</html>