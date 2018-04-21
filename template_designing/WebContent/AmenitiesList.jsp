<%@page import="digimation.vacationrental.bean.AmenitiesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsAmenitiesBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="header2.jsp" %>
<body>
<section id="page-header" class="section background">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h3>Property Amenities</h3>
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
                                    <br>
			<table border ="1" class="table table-hover">
			<input type="hidden" name="amenitiesId" id="amenitiesId"/>
			<%  List<AmenitiesBean> listOfAmenities = (ArrayList)request.getAttribute("amenitiesBeans");
			if(listOfAmenities!=null){
			%>
			<div class="col-md-8">
                        <h5>List Of Amenities</h5>
                 </div>
			<thead>
					<tr bgcolor="orange">
						<td>Id</td>
						<td>Amenities NAme</td>
						<th>Action</th>
					</tr>
			</thead>
					<%  for(int i=0;i<listOfAmenities.size();i++){
						AmenitiesBean bean = listOfAmenities.get(i); %> 
						
				<tbody>
					<tr>
						<td><%=bean.getAmenitiesId() %></td>
						<td><%=bean.getAmenitiesName() %></td>
						<td><a href="amenitiesDelete?amenitiesId=<%=bean.getAmenitiesId()%>&propertyId=<%=bean.getProperty_id()%>">DELETE</a></td>
					</tr>
				</tbody>
					<%} %>
			</table>
			
			<form action="amenitiesInsert">
				<div class="col-md-8">
                        <h5>Add Amenities Here</h5>
                 </div>
                		<input type="hidden" name="propertyId" value="<%=request.getAttribute("propertyId")%>">
                      		 <div class="col-sm-10">
                                            <input type="checkbox" name="chkAmenities" id="chkgame" value="Wi-Fi"> Wi-Fi </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="A.C"> A.C </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="Broadband"> Broadband </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="T.V"> T.V </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="Gym"> Gym </br>
											<input type="checkbox" name="chkAmenities" id="chkgame" value="SwimmingPull"> SwimmingPull </br>
                                        </div>
                       
                       <div class="col-sm-offset-2 col-sm-10">
                             <hr>
                             <input type="submit" class="btn btn-primary btn-normal border-radius pull-left" value="NEXT">
                             <a href="userPanel.jsp"><input type="button" class="btn btn-primary btn-normal border-radius pull-left" value="Back to dashboard"></a>
                        </div>
              </form> 
			
		<%}else{ %>
			<h2><font color=red>Record not found for display....sorry</font></h2>
			<%} %>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</section>
</body>
 <%@include file="footer.jsp" %>
</html>