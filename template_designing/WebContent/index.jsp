<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->


<!-- Mirrored from trendingtemplates.com/demos/trips/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 13 Mar 2016 13:39:38 GMT -->
<head>

  
    <title>Welcome to The Vacation Rental Website :: Life is Trip Plan Your Next Vacation</title>

    
    
</head>
<%@include file="header.jsp"%>
<body>
<div id="wrapper">
    
   

    <section class="section fullscreen background parallax" style="background-image:url('upload/parallax_04.jpg');" data-img-width="1920" data-img-height="1133" data-diff="100">
        <div class="container">
            <div class="row homeform">
                <div class="col-md-5 col-xs-12">
                    <div class="home-form">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#tab_01" aria-controls="tab_01" role="tab" data-toggle="tab"><i class="icon-hotel68"></i></a></li>
                            <li><a href="#tab_02" aria-controls="tab_02" role="tab" data-toggle="tab"><i class="icon-home"></i></a></li>
                            <li><a href="#tab_03" aria-controls="tab_03" role="tab" data-toggle="tab"><i class="icon-sedan3"></i></a></li>
                            <li><a href="#tab_04" aria-controls="tab_04" role="tab" data-toggle="tab"><i class="icon-location38"></i></a></li>
                            <li><a href="#tab_05" aria-controls="tab_05" role="tab" data-toggle="tab"><i class="icon-bicycle12"></i></a></li>
                        </ul>

                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="tab_01">
                            	<h6>Hotels / Restaurnat</h6>
                                <h6>WHERE WOULD YOU LIKE TO GO?</h6>
                                <form class="bookform form-inline row" action="searchByFiltering">
                                <input type="hidden" name="action" value="hotelRestaurantSearch">
                                    <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                        <input type="text" class="form-control" name="txtSearch" placeholder=" Destination: Country or City">
                                    </div>
                                   <div class="form-group make-margin col-md-12 col-sm-12 col-xs-12">
                                        <div class="dropdown">
                                            <select name="category" class="selectpicker" data-style="btn-white">
                                                <option value="">--Select Category--</option>
                                                <option value="Hotel">Hotel</option>
                                                <option value="Restaurant">Restaurant</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-block"><i class="icon-search"></i> Search Now</button>
                                    </div>
                                </form>
                            </div><!-- end tab-pane -->

                            <div role="tabpanel" class="tab-pane" id="tab_02">
                            	<h6>Home Rental</h6>
                                <h6>WHEN WOULD YOU LIKE TO GO?</h6>
                                <form class="bookform form-inline row" action="searchByFiltering">
                                <input type="hidden" name="action" value="homeRentalSearch">
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <input type="text" class="form-control" name="txtSearch" placeholder=" Destination: Country, City,Airport...">
                                    </div>
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-block"><i class="icon-search"></i> BOOK NOW</button>
                                    </div>
                                </form>
                            </div><!-- end tab-pane -->

                            <div role="tabpanel" class="tab-pane" id="tab_03">
                            	<h6>Car Rental</h6>
                                <h6>WHICH WOULD YOU LIKE TO GO?</h6>
                                <form class="bookform form-inline row" action="searchByFiltering">
                                <input type="hidden" name="action" value="carRentalSearch">
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12" >
                                        <input type="text" class="form-control" name="txtSearch"  placeholder=" Destination: Country, City,Airport,...">
                                    </div>
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-block"><i class="icon-search"></i> BOOK NOW</button>
                                    </div>
                                </form>
                            </div><!-- end tab-pane -->

                            <div role="tabpanel" class="tab-pane" id="tab_04">
                            	<h6>Attraction</h6>
                                <h6>HOW WOULD YOU LIKE TO GO?</h6>
                                <form class="bookform form-inline row" action="searchByFiltering">
                                <input type="hidden" name="action" value="attractionSearch">
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <input type="text" class="form-control" name="txtSearch" placeholder=" Destination: Country, City,Airport...">
                                    </div>
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-block"><i class="icon-search"></i> BOOK NOW</button>
                                    </div>
                                </form>
                            </div><!-- end tab-pane -->

                            <div role="tabpanel" class="tab-pane" id="tab_05">
                            	<h6>Tour Guide</h6>
                                <h6>REALLY? YOU LIKE TO GO?</h6>
                                <form class="bookform form-inline row" action="searchByFiltering">
                                <input type="hidden" name="action" value="tourGuideSearch">
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <input type="text" class="form-control" name="txtSearch"  placeholder=" Destination: Country, City,Airport...">
                                    </div>
                                    <div class="form-group col-md-12 col-sm-6 col-xs-12">
                                        <button type="submit" class="btn btn-primary btn-block"><i class="icon-search"></i> BOOK NOW</button>
                                    </div>
                                </form>
                            </div><!-- end tab-pane -->
                        </div><!-- end tab-content -->
                    </div><!-- end homeform -->
                </div><!-- end col -->

                <div class="col-md-7 col-xs-12">
                    <div class="home-message">
                        <h1>LET'S DISCOVER THE<br>WORLD TOGETHER</h1>
                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia, priceline, hotels.com, travelocity, kayak, orbitz, etc. This guys can’t be wrong. You should definitely give it a shot :)</p>
                        <a href="#" class="btn btn-primary btn-lg border-radius">READ MORE</a>
                    </div><!-- end homemessage -->
                </div><!-- end col -->            
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

 

    <section class="section clearfix">
        <div class="container">
            <div class="hotel-title">
                <h4>TOP POPULAR DESTINATIONS</h4>
            </div><!-- end hotel-title -->

            <div class="row">
                <div class="col-md-6">
                    <div class="mini-desti row">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_01.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>VALLE AURINA</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->

                    <div class="mini-desti row">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_02.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>PRINCIPE FORTE DEI MARMI</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->

                    <div class="mini-desti row noborder">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_03.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>VOGLAUER QUADRO</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->
                </div><!-- end col -->

                <div class="col-md-6">
                    <div class="mini-desti row">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_04.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>VALLE AURINA</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->

                    <div class="mini-desti row">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_05.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>PRINCIPE FORTE DEI MARMI</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->

                    <div class="mini-desti row noborder">
                        <div class="col-md-4">
                            <img src="upload/mini_desti_06.jpg" alt="" class="img-responsive">
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="mini-desti-title">
                                <div class="pull-left">
                                    <h6>VOGLAUER QUADRO</h6>
                                    <span class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </span><!-- end rating -->
                                </div>
                                <div class="pull-right">
                                    <h6>$500</h6>
                                </div>  
                                <div class="clearfix"></div>   
                                <div class="mini-desti-desc">
                                    <p>Template based on deep research on the most popular travel booking websites such as</p>
                                </div>
                            </div><!-- end title -->
                        </div><!-- end col -->
                    </div><!-- end mini-desti -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->  

    <section class="section fullscreen background parallax" style="background-image:url('upload/parallax_03.jpg');" data-img-width="1920" data-img-height="586" data-diff="10">
        <div class="container">
            <div id="testimonials">
                <div class="testi-item">
                    <div class="hotel-title text-center">
                        <h3>THE TRIPS SAVED MY LIFE!</h3>
                        <hr>
                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo<br>
                            travel, expedia, priceline, hotels.com, travelocity, kayak, orbitz, etc. This guys can’t be wrong.<br>
                            You should definitely give it a shot :)</p>
                        <h6>- DAVID / CEO AGODA -</h6>
                    </div>
                </div><!-- end testi-item -->

                <div class="testi-item">
                    <div class="hotel-title text-center">
                        <h3>THANKS YOU TRIPS! THIS IS AMAZING TRAVEL!</h3>
                        <hr>
                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo<br>
                            travel, expedia, priceline, hotels.com, travelocity, kayak, orbitz, etc. This guys can’t be wrong.<br>
                            You should definitely give it a shot :)</p>
                        <h6>- DAVID / CEO AGODA -</h6>
                    </div>
                </div><!-- end testi-item -->
            </div><!-- end testimonials -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="nopadding clearfix">
        <div class="owl-fullwidth">
            <div class="owl-item-full">
                <img src="upload/home_mini_slider_02.jpg" alt="">
            </div>
            <div class="owl-item-full">
                <img src="upload/home_mini_slider_01.jpg" alt="">
            </div>
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section clearfix section-bottom">
        <div class="container">
            <div class="hotel-title">
                <h3>OUR SERVICES</h3>
                <hr class="left">
            </div><!-- end hotel-title -->
            <div class="row">
                <div class="col-md-9">
                    <div class="service-style row">
                        <div class="icon-container border-radius col-md-3 col-sm-3 col-xs-3">
                            <i class="icon-hotel16"></i>
                        </div>
                        <div class="col-md-10 col-xs-10 col-sm-10">
                        <h5>HOTEL ONLINE BOOKING SERVICE</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aut dignissimos ea est, impedit incidunt, laboriosam maxime molestias numquam odio officiis. Ab aut dignissimos ea est, impedit incidunt.</p>
                        </div>
                    </div><!-- end service -->

                    <div class="service-style row">
                        <div class="icon-container border-radius col-md-3 col-sm-3 col-xs-3">
                            <i class="icon-airplane51"></i>
                        </div>
                        <div class="col-md-10 col-xs-10 col-sm-10">
                        <h5>BOOK CHEAP FLIGHTS ONLINE</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aut dignissimos ea est, impedit incidunt, laboriosam maxime molestias numquam odio officiis. Ab aut dignissimos ea est, impedit incidunt.</p>
                        </div>
                    </div><!-- end service -->

                    <div class="service-style row">
                        <div class="icon-container border-radius col-md-3 col-sm-3 col-xs-3">
                            <i class="icon-sedan3"></i>
                        </div>
                        <div class="col-md-10 col-xs-10 col-sm-10">
                        <h5>TAXI CAB BOOKING HOTLINES</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aut dignissimos ea est, impedit incidunt, laboriosam maxime molestias numquam odio officiis. Ab aut dignissimos ea est, impedit incidunt.</p>
                        </div>
                    </div><!-- end service -->

                    <div class="service-style row">
                        <div class="icon-container border-radius col-md-3 col-sm-3 col-xs-3">
                            <i class="icon-location38"></i>
                        </div>
                        <div class="col-md-10 col-xs-10 col-sm-10">
                        <h5>TOUR GUIDE & PRIVATE GUIDED TOURS</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aut dignissimos ea est, impedit incidunt, laboriosam maxime molestias numquam odio officiis. Ab aut dignissimos ea est, impedit incidunt.</p>
                        </div>
                    </div><!-- end service -->
                </div><!-- end col -->

                <div class="col-md-3">
                    <img src="upload/girl.png" alt="" class="img-responsive">
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->  

    <section class="section section-light clearfix">
        <div class="container">
            <div class="top-destinations clearfix">
                <div class="hotel-title text-center">
                    <h3>BEST DESTINATIONS FOR SUMMER</h3>
                    <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo<br> travel, expedia, priceline, hotels.com,travelocity, kayak, orbitz, etc. This guys can’t be wrong.<br> You should definitely give it a shot :)</p>
                    <hr>
                </div>

                <div class="row">
                    <div class="col-sm-6">
                        <div class="clearfix">
                            <div class="post-media clearfix">
                                <a href="blog-single.html"><img src="upload/home_desti_02.jpg" alt="" class="img-responsive"></a>
                            </div><!-- end post-media -->

                            <div class="post-title clearfix">
                                <div class="pull-left">
                                    <h5><a href="blog-single.html">AUSTRALIA</a></h5>
                                    <h6>990 PLACES</h6>
                                </div>
                                <div class="pull-right">
                                    <h5>FROM <span>$490</span></h5>
                                </div>
                            </div><!-- end ost-title -->
                            <div class="post-content clearfix">
                                <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia, priceline, hotels.com, kayak, orbitz, etc. This guys can’t be wrong. You should definitely give it a shot :)</p>
                            </div><!-- end post-content -->
                        </div><!-- end post-wrapper -->
                    </div><!-- end col -->

                    <div class="col-sm-6">
                        <div class="clearfix">
                            <div class="post-media clearfix">
                                <a href="blog-single.html"><img src="upload/home_desti_01.jpg" alt="" class="img-responsive"></a>
                            </div><!-- end post-media -->

                            <div class="post-title clearfix">
                                <div class="pull-left">
                                    <h5><a href="blog-single.html">ISTANBUL</a></h5>
                                    <h6>120 PLACES</h6>
                                </div>
                                <div class="pull-right">
                                    <h5>FROM <span>$331</span></h5>
                                </div>
                            </div><!-- end ost-title -->
                            <div class="post-content clearfix">
                                <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia, priceline, hotels.com, kayak, orbitz, etc. This guys can’t be wrong. You should definitely give it a shot :)</p>
                            </div><!-- end post-content -->
                        </div><!-- end post-wrapper -->
                    </div><!-- end col -->
                </div><!-- end row -->
            </div><!-- end related-hotels -->

            <hr>
            <br>

            <div class="clearfix">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="clearfix">
                            <div class="hotel-wrapper">
                                <div class="post-media">
                                    <a href="hotel-single.html"><img src="upload/hotel_01.png" alt="" class="img-responsive"></a>
                                </div><!-- end media -->
                                <div class="post-title clearfix">
                                    <div class="pull-left">
                                        <h5><a href="hotel-single.html" title="">VALLE AURINA</a></h5>
                                    </div><!-- end left -->
                                    <div class="pull-right">
                                        <h6>$500</h6>
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
                        </div><!-- end clearfix -->
                    </div><!-- end col -->

                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="clearfix">
                            <div class="hotel-wrapper">
                                <div class="post-media">
                                    <a href="hotel-single.html"><img src="upload/hotel_02.png" alt="" class="img-responsive"></a>
                                </div><!-- end media -->
                                <div class="post-title clearfix">
                                    <div class="pull-left">
                                        <h5><a href="hotel-single.html" title="">DELUXE HOTEL</a></h5>
                                    </div><!-- end left -->
                                    <div class="pull-right">
                                        <h6>$500</h6>
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
                        </div><!-- end clearfix -->
                    </div><!-- end col -->

                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="clearfix">
                            <div class="hotel-wrapper">
                                <div class="post-media">
                                    <a href="hotel-single.html"><img src="upload/hotel_03.png" alt="" class="img-responsive"></a>
                                </div><!-- end media -->
                                <div class="post-title clearfix">
                                    <div class="pull-left">
                                        <h5><a href="hotel-single.html" title="">5STAR ARGANTINE</a></h5>
                                    </div><!-- end left -->
                                    <div class="pull-right">
                                        <h6>$500</h6>
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
                        </div><!-- end clearfix -->
                    </div><!-- end col -->
                </div><!-- end row -->
            </div>
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section fullscreen background parallax" style="background-image:url('upload/parallax_05.jpg');" data-img-width="1921" data-img-height="665" data-diff="20">
        <div class="container">
            <div class="home-message text-center">
                <h1>LET'S DISCOVER THE<br>WORLD TOGETHER</h1>
                <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo<br> travel, expedia, priceline, hotels.com, travelocity, kayak, orbitz, etc. This guys can’t be wrong.<br> You should definitely give it a shot :)</p>
                <a href="#" class="btn btn-primary btn-lg border-radius">READ MORE</a>
            </div><!-- end homemessage -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section clearfix">
        <div class="container">
            <div class="popular-destinations clearfix">
                <div class="hotel-title">
                    <h5>NEWS AND UPDATES</h5>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="clearfix">
                            <div class="post-media clearfix">
                                <a href="blog-single.html"><img src="upload/home_blog_05.jpg" alt="" class="img-responsive"></a>
                            </div><!-- end post-media -->

                            <div class="post-title clearfix">
                                <h5><a href="blog-single.html">THAILAND BY TRAIN WITH EASTERN AND ORIENTAL EXPRESS</a></h5>
                            </div><!-- end ost-title -->

                            <div class="post-meta home-blog-list clearfix">
                                <span><i class="icon-attach"></i> 03 Feb 2015</span>
                                <span><i class="icon-map110"></i> Asia, Thailand</span>
                            </div><!-- ne dpost-meta -->
                            
                            <div class="post-content clearfix">
                                <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia, priceline, hotels.com, travelocity, kayak, orbitz, etc. This guys can’t be wrong. You should definitely give it a shot :) ed on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia.</p>
                            </div><!-- end post-content -->
                        </div><!-- end post-wrapper -->
                    </div><!-- end col -->

                    <div class="col-md-6">
                        <div class="row">
                            <div class="clearfix">
                                <div class="col-sm-6">
                                    <div class="post-media clearfix">
                                        <a href="blog-single.html"><img src="upload/home_blog_06.jpg" alt="" class="img-responsive"></a>
                                    </div><!-- end post-media -->
                                </div>
                                <div class="col-sm-6">
                                    <div class="post-title clearfix">
                                        <h5><a href="blog-single.html">SANTORINI - GREECE</a></h5>
                                    </div><!-- end ost-title -->

                                    <div class="post-meta home-blog-list clearfix">
                                        <span><i class="icon-map110"></i> Greece, Santorina</span>
                                    </div><!-- ne dpost-meta -->
                                    
                                    <div class="post-content clearfix">
                                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia</p>
                                    </div><!-- end post-content -->
                                </div><!-- end col -->
                            </div><!-- end clearfix -->

                            <div class="clearfix">
                                <div class="col-sm-6">
                                    <div class="post-media clearfix">
                                        <a href="blog-single.html"><img src="upload/home_blog_07.jpg" alt="" class="img-responsive"></a>
                                    </div><!-- end post-media -->
                                </div>
                                <div class="col-sm-6">
                                    <div class="post-title clearfix">
                                        <h5><a href="blog-single.html">YUCATAN - MEXICO..</a></h5>
                                    </div><!-- end ost-title -->

                                    <div class="post-meta home-blog-list clearfix">
                                        <span><i class="icon-map110"></i> Amerika, Mexico</span>
                                    </div><!-- ne dpost-meta -->
                                    
                                    <div class="post-content clearfix">
                                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia</p>
                                    </div><!-- end post-content -->
                                </div><!-- end col -->
                            </div><!-- end clearfix -->

                            <div class="clearfix">
                                <div class="col-sm-6">
                                    <div class="post-media clearfix">
                                        <a href="blog-single.html"><img src="upload/home_blog_08.jpg" alt="" class="img-responsive"></a>
                                    </div><!-- end post-media -->
                                </div>
                                <div class="col-sm-6">
                                    <div class="post-title clearfix">
                                        <h5><a href="blog-single.html">ISTANBUL - TURKEY..</a></h5>
                                    </div><!-- end ost-title -->

                                    <div class="post-meta home-blog-list clearfix">
                                        <span><i class="icon-map110"></i> Asia, Turkey</span>
                                    </div><!-- ne dpost-meta -->
                                    
                                    <div class="post-content clearfix">
                                        <p>Template based on deep research on the most popular travel booking websites such as booking.com, tripadvisor, yahoo travel, expedia</p>
                                    </div><!-- end post-content -->
                                </div><!-- end col -->
                            </div><!-- end clearfix -->
                        </div><!-- end row -->
                    </div><!-- end col -->
                </div><!-- end row -->
            </div><!-- end related-hotels -->
        </div><!-- end container -->
    </section><!-- end section -->

</div>



        <!-- Template core JavaScript's
    ================================================== -->
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
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
<%@include file="footer.jsp"%>
</html>