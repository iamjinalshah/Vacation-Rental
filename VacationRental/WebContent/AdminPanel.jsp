<%@page import="digimation.vacationrental.dao.TourGuideDAO"%>
<%@page import="digimation.vacationrental.bean.TourGuideBean"%>
<%@page import="digimation.vacationrental.dao.CarDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.CarDetailsBean"%>
<%@page import="digimation.vacationrental.dao.RestaurantDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.ResataurantDetailsBean"%>
<%@page import="digimation.vacationrental.dao.HotelDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@page import="digimation.vacationrental.dao.PropertyDetailsDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@page import="digimation.vacationrental.dao.UserDAO"%>
<%@page import="digimation.vacationrental.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="AdminHeader.jsp" %>
<body>
<%
List<UserBean> listOfUser = new UserDAO().list();
List<PropertyDetailsBean> listOfProperty = new PropertyDetailsDAO().list();
List<HotelDetailsBean> listOfHotel = new HotelDetailsDAO().list();
List<ResataurantDetailsBean> listOfRestaurant = new RestaurantDetailsDAO().list();
List<CarDetailsBean> listOfCar = new CarDetailsDAO().list();
List<TourGuideBean> listOfTourGuide = new TourGuideDAO().list();
%>
	
	
	<div class="content-wrapper">
	
        <section class="content-header">
          <h1>
            Dashboard
            <small>Control panel</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
          <div class="row">
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-aqua">
                <div class="inner">
                  <h3><%=listOfUser.size()%></h3>
                  <p>New Users</p>
                </div>
                <a href="userList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-green">
                <div class="inner">
                  <h3><%=listOfProperty.size()%></h3>
                  <p>All properties</p>
                </div>
                <a href="propertyDetailsList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-yellow">
                <div class="inner">
                  <h3><%=listOfHotel.size()%></h3>
                  <p>All Hotels</p>
                </div>
                <a href="hotelDetailsList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-3 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-red">
                <div class="inner">
                  <h3><%=listOfRestaurant.size()%></h3>
                  <p>All Restaurant</p>
                </div>
                <a href="restaurantDetailsList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-6 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-orange">
                <div class="inner">
                  <h3><%=listOfCar.size()%></h3>
                  <p>All Car Provider</p>
                </div>
                <a href="carDetailsList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
            <div class="col-lg-6 col-xs-6">
              <!-- small box -->
              <div class="small-box bg-blue">
                <div class="inner">
                  <h3><%=listOfTourGuide.size()%></h3>
                  <p>All TourGuides</p>
                </div>
                <a href="tourGuideList" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
              </div>
            </div><!-- ./col -->
          </div><!-- /.row -->
          <!-- Main row -->
                 
            </section><!-- /.Left col -->
            <!-- right col (We are only adding the ID to make the widgets sortable)-->
            
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

</body>
</html>