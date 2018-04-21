<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<%@include file="header2.jsp" %>
<body>

<div id="wrapper">
    

    <section id="page-header" class="section background">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h3>Login & Register</h3>
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
                                <div class="col-md-6">
                                    <h5>NEW COSTUMER</h5>
                                    <p>By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.</p>
                                    <hr>
                                    <a href="register.jsp"><button type="submit" class="btn btn-primary btn-normal border-radius">Register Now</button></a>
                                </div><!-- end col -->
 
                                <div class="col-md-6">
                                    <h5>RETURN COSTUMER</h5>
                                    <p>I am a returning customer</p>
                                    ${invalidLogin }
									${success}
									${reset}
                                    <form class="form-horizontal" action="login">
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-sm-2 control-label">Username:</label> 
                                        <div class="col-sm-10">
                                            ${email}<input type="email" name="txtEmail" class="form-control" id="inputEmail3" placeholder="Email" required>
                                        </div>
                                            <label for="inputPasswor" class="col-sm-2 control-label">Password:</label>
                                        <div class="col-sm-10">
                                            ${password}<input type="password" name="txtPassword" class="form-control" id="inputPassword3" placeholder="Password" required>
                                        </div>
                                        <label for="forgotPassword" class="col-sm-2 control-label"></label>
                                        <div class="col-sm-10">
                                        <h7>Forgot Password?<a href="forgotPassword.jsp"> Click here</a></h7>
                                        </div>
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <hr>
                                            <input type="submit" class="btn btn-primary btn-normal border-radius pull-right" value="Sign In">
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
        </div><!-- en -->
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