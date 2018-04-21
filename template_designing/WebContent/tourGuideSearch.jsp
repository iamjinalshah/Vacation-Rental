<%@page import="digimation.vacationrental.bean.TourGuideBean"%>
<%@page import="digimation.vacationrental.bean.CarDetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%@include file="header2.jsp" %>
<body>

<section id="page-header" class="section background">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h3>Tour Guide of <%=request.getAttribute("search") %></h3>
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
 </section><!-- end section -->
    
    
    
    
 <section class="section clearfix">
        <div class="container">
            <div class="row">
           			 <%
						List<TourGuideBean> listOfGuide = (ArrayList) request.getAttribute("listOfGuide");
						if (listOfGuide != null) {
							%>
                <div id="fullwidth" class="col-sm-12">
                    <!-- START CONTENT -->
                    <div class="row">
                    <%for (int i = 0; i < listOfGuide.size(); i++) {

                    	TourGuideBean tourGuideBean = listOfGuide.get(i);
					%>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <div class="post-wrapper clearfix border-bottom">
                                <div class="hotel-wrapper">
                                    <div class="post-media">
                                        <a href="tourguideFullInfo?tourguideId=<%=tourGuideBean.getTourguide_id()%>"><img src="upload/tourguide/<%=tourGuideBean.getPhoto() %>" alt="HotelImage"  height="300px" width="300px"></a>
                                    </div><!-- end media -->
                                    <div class="post-title clearfix">
                                        <div class="pull-left">
                                            <h5><a href="tourguideFullInfo?tourguideId=<%=tourGuideBean.getTourguide_id()%>" title="">Tour guide name: <%=tourGuideBean.getFirst_name()+ " "+tourGuideBean.getLast_name()%> <span>(<%=tourGuideBean.getCity_name()%>)</span></a></h5>
                                        </div><!-- end left -->
                                        <div class="pull-right">
                                            <h6>500</h6>
                                        </div><!-- end left -->
                                    </div><!-- end title -->
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                    <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia..</p>
                                </div><!-- end hotel-wrapper -->                            
                            </div><!-- end post-wrapper -->
                        </div><!-- end col -->
                        <%}%>
                    </div><!-- end row -->
                    <!-- END CONTENT -->
                </div><!-- end fullwidth -->
                <%}else{%>
    <h3>Data not found...</h3>
    <%} %>
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->
    
    

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