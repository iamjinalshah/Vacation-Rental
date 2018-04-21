<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Account info</title>
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
<%@include file="header2.jsp" %>
<body>
<div id="wrapper">
    

    <section id="page-header" class="section background">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h3>List your Property</h3>
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
                                    <h5>Account Info</h5>
                                    <br>
									
                                    <form class="form-horizontal" action="userAccountInfo">
                                        
                                        <input type="hidden" name="pda_id" value="<%=request.getAttribute("pda_id")%>">
                                        <input type="hidden" name="userId" value="<%=userSession.getUser_id()%>">
                                        <div class="form-group">
                                        </br>
                                        
                                            <label for="bankname" class="col-sm-2 control-label">Bank Name:</label>
                                        <div class="col-sm-10">
										${bankName}
                                            <input type="text" name="txtBankName" class="form-control" id="txtBankName" placeholder="e.g panjab National Bank,Bapunagar" required>
                                        </div>
                                        
                                            <label for="accountno" class="col-sm-2 control-label">Account no:</label>
                                        <div class="col-sm-10">
                                        ${accno}
                                            <input type="text" name="txtAccountNo" class="form-control" id="txtAccountNo" placeholder="Account No" required>
                                        </div>
                                        
                                        <label for="ifsccode" class="col-sm-2 control-label">IFSC Code:</label>
                                        <div class="col-sm-10">
                                        ${ifscCode}
                                            <input type="text" name="txtIFSCCode" class="form-control" id="txtIFSCCode" placeholder="IFSC Code" required>
                                        </div>
                                        
                                        <div class="col-sm-10">
                                        <input type="checkbox"> *I agree terms and condition
                                        </div>
                                        
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
<%@include file="footer.jsp"%>

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