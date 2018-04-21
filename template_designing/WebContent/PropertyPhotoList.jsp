<%@page import="java.util.ArrayList"%>
<%@page import="digimation.vacationrental.bean.PropertyPhotoBean"%>
<%@page import="java.util.List"%>
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
                    <h3>Property photo</h3>
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
			<%List<PropertyPhotoBean> listOfPhoto = (ArrayList)request.getAttribute("listOfPhoto"); 
			if(listOfPhoto!=null) {%>
	<table border="1" class="table table-hover">
	<div class="col-md-8">
                        <h5>List Of Photos</h5>
                 </div>
          <thead>
		<tr bgcolor="orange">
			<th>Id</th>
			<th>PHOTO-Name</th>
			<th>PHOTO</th>
			<th colspan="2">Action</th>
		</tr>
		</thead>
		<%for(int i=0;i<listOfPhoto.size();i++){
			PropertyPhotoBean propertyPhotoBean =listOfPhoto.get(i); %>
		<tbody>
		<tr>
			<td><%=propertyPhotoBean.getPropertyphoto_id()%></td>
			<td><%=propertyPhotoBean.getPhoto_name()%></td>
			<td><img src="upload/Property/<%=propertyPhotoBean.getPhoto_name()%>" alt="profilePhoto" height="40px" width="60px">   </td>
			<td><a href="propertyPhotoDelete?photoId=<%=propertyPhotoBean.getPropertyphoto_id()%>&propertyId=<%=propertyPhotoBean.getProperty_id()%>">Delete</a></td>
		</tr>
		<%} %>
		</tbody>
	</table>
	
	<form action="addPropertyPhoto" method="post" enctype="multipart/form-data">
				<div class="col-md-8">
                        <h5>Add photo</h5>
                 </div>
                		<input type="hidden" name="propertyId" value="<%=request.getAttribute("propertyId")%>">
                       <input type="file" name="filePhoto"  id="filePhoto">
                       
                       <div class="col-sm-offset-2 col-sm-10">
                             <hr>
                             <input type="submit" class="btn btn-primary btn-normal border-radius pull-left" value="NEXT">
                             <a href="userPanel.jsp"><input type="button" class="btn btn-primary btn-normal border-radius pull-left" value="Back to dashboard"></a>
                        </div>
              </form> 
	<%}else{ %>
	<h3>Data not found...</h3>
	<%} %>

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