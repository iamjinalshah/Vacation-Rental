<%@page import="digimation.vacationrental.bean.TourGuideBean"%>
<%@page import="digimation.vacationrental.dao.CityDAO"%>
<%@page import="digimation.vacationrental.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript' src='/VacationRental/dwr/interface/AjaxDataDAO.js'></script>
  <script type='text/javascript' src='/VacationRental/dwr/engine.js'></script>
   <script type='text/javascript' src='/VacationRental/dwr/util.js'></script>
     
     <script type="text/javascript">

function getReply(cityId){
	     //  stateId='';
			//alert(cityId);
			dwr.util.removeAllOptions("area");
			
		document.getElementById('areaLoader').style.visibility = 'hidden';
			
			if(cityId==''){
				var data=[{ area_name:'-- Select --', area_id:'' }];
				dwr.util.addOptions("area",data,"area_id","area_name");
			document.getElementById('areaLoader').style.visibility = 'hidden';
			}else{
				//alert(cityId);
		    document.getElementById('areaLoader').style.visibility = 'visible';
				AjaxDataDAO.getAllArea(cityId,function(data){
				dwr.util.addOptions("area",data,"area_id","area_name");
 		   document.getElementById('areaLoader').style.visibility = 'hidden';
				});
			}
}	

</script>
</head>
<body>
	<form action="tourGuideUpdate" method="post" enctype="multipart/form-data">
	<% TourGuideBean tourGuideBean = (TourGuideBean)request.getAttribute("tourGuideBean"); 
	if(tourGuideBean!=null) {%>
	<input type="hidden" name="tourguideId" value="<%=tourGuideBean.getTourguide_id()%>">
		<table border="1">
			<tr>
				<th>FIRST_NAME	:</th>
				<td><input type="text" name="txtFirstName" id="txtFirstName" value="<%=tourGuideBean.getFirst_name()%>">${firstName}</td>
			</tr>
			<tr>
				<th>MIDDLE_NAME	:</th>
				<td><input type="text" name="txtMiddleName" id="txtMiddleName" value="<%=tourGuideBean.getMiddle_name()%>">${middleName}</td>
			</tr>
			<tr>
				<th>LAST_NAME	:</th>
				<td><input type="text" name="txtLastName" id="txtLastName" value="<%=tourGuideBean.getLast_name()%>">${lastName}</td>
			</tr>
			<tr>
				<th>MOBILE	:</th>
				<td><input type="text" name="txtMobile" id="txtMobile" value="<%=tourGuideBean.getMobile()%>">${mobile}</td>
			</tr>
			<tr>
				<th>LANDLINE	:</th>
				<td><input type="text" name="txtLandline" id="txtLandline" value="<%=tourGuideBean.getLandline()%>">${landline}</td>
			</tr>
			<tr>
				<th>RATE	:</th>
				<td><input type="text" name="txtRate" id="txtRate" value="<%=tourGuideBean.getRate()%>">${rate}</td>
			</tr>
			<tr>
    			<th>CITY	:</th>
    			<td><select name="city" id="city" onChange="java:getReply(this.value)">
				<option value="">---select city---</option>
				<% List<CityBean> listOfCity = new CityDAO().list(); 
	 			if(listOfCity!=null)
	 			{
	  	 		for(int i =0;i<listOfCity.size();i++)
	  			 {
	  			 CityBean cityBean = listOfCity.get(i);
				%>
				<option value="<%=cityBean.getCity_id()%>"><%=cityBean .getCity_name().toUpperCase()%></option><%} }%>
    			</select>
    			</td>
  		</tr>
  
  		<tr>
    	<th>AREA	:</th>
    	<td>
		<select name="area" id="area" >
		<option value="">---select area---</option>
		</select>
		<span id="areaLoader" style="visibility:hidden;">
		    <img src="images/ajax-loader.gif">		
	    </span>	
		</td>
 		 </tr>
 		 <tr>
				<th>PHOTO	:</th>
				<td><input type="file" name="filephoto" id="filephoto">${photo}</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="SUBMIT"></td>
				<td><input type="reset" name="reset" value="RESET"></td>
			</tr>
		</table>
		<%}%>
	</form>
</body>
</html>