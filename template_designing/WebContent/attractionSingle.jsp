<%@page import="digimation.vacationrental.dao.AttractionDAO"%>
<%@page import="digimation.vacationrental.bean.AttractionPhotoBean"%>
<%@page import="digimation.vacationrental.bean.AttractionBean"%>
<%@page import="digimation.vacationrental.dao.HotelDetailsDAO"%>
<%@page import="digimation.vacationrental.dao.HotelPhotoDAO"%>
<%@page import="digimation.vacationrental.bean.HotelPhotoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attraction single</title>
</head>
<%@include file="header2.jsp" %>
<body>
<%AttractionBean attractionBean = (AttractionBean)request.getAttribute("attractionBean"); 
if(attractionBean!=null){
%>
<section id="page-header" class="section background">
        <div class=	"container">
            <div class="row">
                <div class="col-sm-12">
                    <h3><%=attractionBean.getAttraction_name()%></h3>
                    <p>
                    <span class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </span><!-- end rating -->
                    <%=attractionBean.getCity_name()%>(<%=attractionBean.getState_name()%>)</p>
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section clearfix">
        <div class="container">
            <div class="row">
                <div id="fullwidth" class="col-sm-12">

                    <!-- START CONTENT -->
                    <div class="single-hotel-wrapper">
                        <div class="single-hotel-image">
                            <img src="upload/attraction/<%=attractionBean.getPhoto_name()%>" alt="" height="682px" width="1170px">
							
                            <div class="thumbnails">
                            <%List<AttractionPhotoBean> listOfAttractionPhotos = (ArrayList)request.getAttribute("listOfAttractionPhotos"); 
							if(listOfAttractionPhotos!=null){
								for(int i=0;i<listOfAttractionPhotos.size();i++){
									AttractionPhotoBean attractionPhotoBean = listOfAttractionPhotos.get(i); 
							%>
                                <a data-gal="prettyPhoto[product-gallery]" rel="bookmark" title="" href="upload/attraction/<%=attractionPhotoBean.getPhoto_name()%>"><img src="upload/attraction/<%=attractionPhotoBean.getPhoto_name()%>" alt="<%=attractionPhotoBean.getPhoto_name()%>" class="img-responsive"></a>
                            <%}} %>
                            </div><!-- end price -->
                            

                        </div><!-- end image -->

                        <hr class="hotel-hr">

                        <div class="row">
                            <div id="content" class="col-md-9 col-sm-12 col-xs-12">
                                <div class="book-widget">
                                    <div class="hotel-title">
                                        <h5>ENTER DATE TO SEE PRICES AND AVAILABILITY</h5>
                                    </div>

                                    <form class="bookform form-inline row">
                                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Check in" id="datepicker">
                                                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>

                                        <div class="form-group col-md-3 col-sm-6 col-xs-12">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Check out" id="datepicker1">
                                                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>

                                        <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                            <div class="dropdown">
                                                <select class="selectpicker" data-style="btn-white">
                                                    <option>Adults</option>
                                                    <option>2+1 with Bedroom + 2 Child</option>
                                                    <option>1+1 with Bedroom + 1 Child</option>
                                                    <option>2+1 with Bedroom + Full</option>
                                                    <option>Full Services 15 Days</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-2 col-sm-6 col-xs-12">
                                            <button type="submit" class="btn btn-primary btn-block btn-normal"><i class="icon-search"></i></button>
                                        </div>
                                    </form>

                                    <div class="clearfix"></div>

                                    <div class="hotel-list">
                                        <div class="row border-bottom2">
                                            <div class="col-sm-5">
                                                <h6>ROOM TYPES</h6>
                                            </div>
                                            <div class="col-sm-2">
                                                <h6>PRICE</h6>
                                            </div>
                                            <div class="col-sm-2">
                                                <h6>NO.ROOMS</h6>
                                            </div>
                                            <div class="col-sm-3">
                                                <h6>ACTION</h6>
                                            </div>
                                        </div>

                                        <div class="clearfix"></div>

                                        <div class="row">
                                            <div class="col-sm-5">
                                                <img src="upload/single_hotel_01.png" alt="" class="img-responsive alignleft">
                                                <p>Luxury Suite</p>
                                                <p class="lead">Double or twin beds, en-suite bathrooms, a large living</p>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <h5>$523<span>/NIGHT</span></h5>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <div class="dropdown selectmini">
                                                    <select class="selectpicker" data-style="btn-white">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-3 list-style-hotel">
                                                <a href="#" class="btn btn-primary btn-normal border-radius">BOOK NOW</a>
                                            </div>
                                        </div>

                                        <div class="clearfix"></div>
                                        <hr>

                                        <div class="row">
                                            <div class="col-sm-5">
                                                <img src="upload/single_hotel_02.png" alt="" class="img-responsive alignleft">
                                                <p>Luxury Suite</p>
                                                <p class="lead">Double or twin beds, en-suite bathrooms, a large living</p>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <h5>$523<span>/NIGHT</span></h5>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <div class="dropdown selectmini">
                                                    <select class="selectpicker" data-style="btn-white">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-3 list-style-hotel">
                                                <a href="#" class="btn btn-primary btn-normal border-radius">BOOK NOW</a>
                                            </div>
                                        </div>

                                        <div class="clearfix"></div>
                                        <hr>

                                        <div class="row">
                                            <div class="col-sm-5">
                                                <img src="upload/single_hotel_03.png" alt="" class="img-responsive alignleft">
                                                <p>Luxury Suite</p>
                                                <p class="lead">Double or twin beds, en-suite bathrooms, a large living</p>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <h5>$523<span>/NIGHT</span></h5>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <div class="dropdown selectmini">
                                                    <select class="selectpicker" data-style="btn-white">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-3 list-style-hotel">
                                                <a href="#" class="btn btn-primary btn-normal border-radius">BOOK NOW</a>
                                            </div>
                                        </div>

                                        <div class="clearfix"></div>
                                        <hr>

                                        <div class="row">
                                            <div class="col-sm-5">
                                                <img src="upload/single_hotel_04.png" alt="" class="img-responsive alignleft">
                                                <p>Luxury Suite</p>
                                                <p class="lead">Double or twin beds, en-suite bathrooms, a large living</p>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <h5>$523<span>/NIGHT</span></h5>
                                            </div>
                                            <div class="col-sm-2 list-style-hotel">
                                                <div class="dropdown selectmini">
                                                    <select class="selectpicker" data-style="btn-white">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-3 list-style-hotel">
                                                <a href="#" class="btn btn-primary btn-normal border-radius">BOOK NOW</a>
                                            </div>
                                        </div>   

                                        <div class="clearfix"></div>
                                    </div><!-- end hotel-list -->

                                    <hr>
                                    <br>


                                    <hr>
                                    <br>

                                    <div class="row hotel-desc">
                                        <div class="col-md-12">
                                            <h5>ABOUT THE ATTRACTION</h5>
                                            <p><%=attractionBean.getDescription()%></p>

                                            <!-- <p>Praesent eros turpis, commodo vel justo at, pulvinar mollis eros. Mauris aliquet eu quam id ornare. Morbi ac quam enim. Cras vitae nulla condimentum, semper dolor non, faucibus dolor. Vivamus adipiscing eros quis orci fringilla, sed pretium lectus viverra. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec nec velit non odio aliquam suscipit. Sed non neque faucibus, condimentum lectus at, accumsan enim. Fusce pretium egestas cursus. Etiam consectetur, orci vel rutrum volutpat, odio odio pretium nisiodo tellus libero et urna. Sed commodo ipsum ligula, id volutpat risus vehicula in. Pellentesque non massa eu nibh posuere bibendum non sed enim. Maecenas lobortis nulla sem, vel egestas dui ullamcorper ac.</p> 

                                            <p>Sed scelerisque lectus sit amet faucibus sodales. Proin ut risus tortor. Etiam fermentum tellus auctor, fringilla sapien et, congue quam. In a luctus tortor. Suspendisse eget tempor libero, ut sollicitudin ligula. Nulla vulputate tincidunt est non congue. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus at est imperdiet, dapibus ipsum vel, lacinia nulla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus id interdum lectus, ut elementum elit. Nullam a molestie magna. Praesent eros turpis, commodo vel justo at, pulvinar mollis eros. Mauris aliquet eu quam id ornare. Morbi ac quam enim. Cras vitae nulla condimentum, semper dolor non, faucibus dolor. Vivamus adipiscing eros quis orci fringilla, sed pretium lectus viverra.</p> -->
                                        </div><!-- end col -->
                                    </div><!-- end hotels-desc -->
                                </div><!-- end book-widget -->

                                
                                <hr>
                                <br>

                                <div class="review-widget">
                                    <div class="hotel-title">
                                        <h5>REVIEWS</h5>
                                    </div>

                                    <div class="row hotel-review">
                                        <div class="col-md-4 col-sm-6 col-xs-12">
                                            <div class="review-list">
                                                <h5>SERVICE:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>SLEEP QUALITY:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>LOCATION:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>SWIMMING POOL:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>
                                        </div><!-- end col -->

                                        <div class="col-md-4 col-sm-6 col-xs-12">
                                            <div class="review-list">
                                                <h5>VALUE:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>CLEANLINESS:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>ROOMS:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>

                                            <div class="review-list">
                                                <h5>FITNESS FACILITY:</h5> 
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div>
                                        </div><!-- end col -->

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <div class="review-total text-center">
                                                <h1>10/10</h1>
                                                <span class="rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->
                                            </div><!-- end review-total -->
                                        </div><!-- end col -->
                                    </div><!-- end hotel-review -->
                                </div><!-- end review widget -->

                                <hr>

                                <div class="comments">
                                    <ul class="media-list clearfix">
                                        <li class="media clearfix">
                                            <a class="pull-left" href="#">
                                                <img class="media-object" src="upload/comment_01.png" alt="Generic placeholder image">
                                            </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">Luke Bring</h4>
                                                <p class="comment-meta pull-left">
                                                   January 10, 2015 . 11:05 PM
                                                </p>

                                                <span class="rating pull-right">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->

                                                <div class="clearfix"></div>

                                                <p>This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
                                            </div>
                                        </li>
                                        
                                        <li class="media clearfix">
                                            <a class="pull-left" href="#">
                                                <img class="media-object" src="upload/comment_02.png" alt="Generic placeholder image">
                                            </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">Jenny DOE</h4>
                                                <p class="comment-meta pull-left">
                                                   January 10, 2015 . 11:05 PM
                                                </p>

                                                <span class="rating pull-right">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </span><!-- end rating -->

                                                <div class="clearfix"></div>

                                                <p>This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
                                            </div>
                                        </li>
                                    </ul>
                                </div><!-- end comments -->
								<%if(userSession==null) {%>
                                <div class="leave-a-feedback text-center clearfix">
                                    <h6>PLEASE <a href="login.jsp">LOGIN / REGISTER</a> TO LEAVE A FEEDBACK</h6>
                                </div><!-- end leave-a-feedback -->
								<%} %>
                                <div class="related-hotels clearfix">
                                    <div class="hotel-title">
                                        <h5>RELATED HOTELS</h5>
                                    </div>

                                    <div class="row">
                                    <%List<AttractionBean> listOfAllAttraction = new AttractionDAO().AllSearchlist();
                                    if(listOfAllAttraction!=null){
                                    	for(int i=0;i<3;i++){
                                    	AttractionBean bean =listOfAllAttraction.get(i); 
                                    %>
                                        <div class="col-md-4 col-sm-6 col-xs-12">
                                            <div class="post-wrapper clearfix border-bottom">
                                                <div class="hotel-wrapper">
                                                    <div class="post-media">
                                                        <a href="attractionFullInfo?attractionId=<%=bean.getAttraction_id()%>"><img src="upload/attraction/<%=bean.getPhoto_name()%>" alt="" height="250px" width="300px"></a>
                                                    </div><!-- end media -->
                                                    <div class="post-title clearfix">
                                                        <div class="pull-left">
                                                            <h5><a href="attractionFullInfo?attractionId=<%=bean.getAttraction_id()%>" title=""><%=bean.getAttraction_name()%></a></h5>
                                                        </div><!-- end left -->
                                                    </div><!-- end title -->
                                                    <span class="rating">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                    </span><!-- end rating -->
                                                    <p><%=bean.getDescription() %></p>
                                                </div><!-- end hotel-wrapper -->                            
                                            </div><!-- end post-wrapper -->
                                        </div><!-- end col -->
                                        <%}} %>
                                    </div><!-- end row -->
                                </div><!-- end related-hotels -->
                            </div><!-- end content -->

                            <div id="sidebar" class="col-md-3 col-sm-12 col-xs-12">
                                <div class="widget clearfix">
                                    <div class="widget-title">
                                        <h6>CLIENTS LIKE THIS HOTEL FOR:</h6>
                                    </div><!-- end title -->

                                    <div class="hotel-widget clearfix">
                                        <p><i class="icon-car82"></i> Nearest transport:</p>
                                        <small>Marina Bay MRT Station (0.8 Km / 10 min walk)</small>
                                    </div><!-- end listwidget -->

                                    <div class="hotel-widget clearfix">
                                        <p><i class="icon-location38"></i> Area recommended for:</p>
                                        <small>restaurants</small>
                                        <small>shopping</small>
                                        <small>sightseeing</small>
                                    </div><!-- end listwidget -->

                                    <div class="hotel-widget clearfix">
                                        <p><i class="icon-air6"></i> Distance to airport:</p>
                                        <small>Seletar Airport (14.9 Km)</small>
                                        <small>Changi International Airport (16.8 Km)</small>
                                    </div><!-- end listwidget -->

                                    <div class="hotel-widget clearfix">
                                        <p><i class="icon-comment43"></i> Customer comments:</p>
                                        <small>“Casino” , “New hotel” , “Nice pool” , “Room design”</small>
                                    </div><!-- end listwidget -->

                                    <div class="hotel-widget clearfix">
                                        <p><i class="icon-camera"></i> Top attractions in the area:</p>
                                        <small>Marina Bay Sands Casino (0.0 Km)</small>
                                        <small>Merlion (0.7 Km / 9 min walk)</small>
                                        <small>Marina Bay Floating Platform (0.8 Km / 10 min walk)</small>
                                        <small>Esplanade Theatres on the Bay (0.9 Km / 11 min walk)</small>
                                    </div><!-- end listwidget -->

                                    <div class="hotel-widget clearfix">
                                        <span class="notice">Note:Note: Distances are measured as a straight line, calculated from a starting point to a destination point.</span>
                                    </div><!-- end listwidget -->


                                </div><!-- end widget -->
                            </div><!-- end sidebar -->
                        </div><!-- end row -->
                    </div><!-- end single-hotel-wrapper -->
                    <!-- END CONTENT -->

                </div><!-- end fullwidth -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->


</div><!-- end wrapper -->
<%} %>

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