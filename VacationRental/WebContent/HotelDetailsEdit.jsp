<%@page import="digimation.vacationrental.dao.HotelTypeDAO"%>
<%@page import="digimation.vacationrental.bean.HotelTypeBean"%>
<%@page import="digimation.vacationrental.dao.CategoryDAO"%>
<%@page import="digimation.vacationrental.bean.CategoryBean"%>
<%@page import="digimation.vacationrental.bean.HotelDetailsBean"%>
<%@page import="digimation.vacationrental.bean.PropertyDetailsBean"%>
<%@page import="digimation.vacationrental.dao.PropertyTypeDAO"%>
<%@page import="digimation.vacationrental.bean.PropertyTypeBean"%>
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
<form action="hotelDetailsUpdate">
<% HotelDetailsBean hotelDetailsBean = (HotelDetailsBean)request.getAttribute("hotelDetailsBean");
	if(hotelDetailsBean!=null){
%>
	<input type="hidden" name="hotelId" id="hotelId" value="<%=hotelDetailsBean.getHotel_id()%>"> 
	<table>
		<tr>
		<th>Hotel-name</th>
		<td>:</td>
		<td><input type="text" name="txtHotel" id="txtHotel" value="<%=hotelDetailsBean.getHotel_name()%>">${hotel}</td>
		</tr>
		
		<tr>
		<th>Address</th>
		<td>:</td>
		<td><input type="text" name="txtAddress" id="txtAddress" value="<%=hotelDetailsBean.getAddress()%>">${address}</td>
		</tr>
		
		<tr>
		<th>Description</th>
		<td>:</td>
		<td><input type="text" name="txtDescription" id="txtDescription" value="<%=hotelDetailsBean.getDescription()%>">${description}</td>
		</tr>
		
		<tr>
		<th>Manager name</th>
		<td>:</td>
		<td><input type="text" name="txtManagerName" id="txtManagerName" value="<%=hotelDetailsBean.getManager_name()%>">${manager}</td>
		</tr>
		
		<tr>
		<th>Email-id</th>
		<td>:</td>
		<td><input type="email" name="txtEmail" id="txtEmail" value="<%=hotelDetailsBean.getEmail_id()%>">${email}</td>
		</tr>
		
		<tr>
		<th>Mobile</th>
		<td>:</td>
		<td><input type="text" name="txtMobile" id="txtMobile" value="<%=hotelDetailsBean.getMobile()%>">${mobile}</td>
		</tr>
		
		<tr>
		<th>Landline</th>
		<td>:</td>
		<td><input type="text" name="txtLandline" id="txtLandline" value="<%=hotelDetailsBean.getLandline()%>"></td>
		</tr>
		
		<tr>
		<th>Website</th>
		<td>:</td>
		<td><input type="text" name="txtWebsite" id="txtWebsite" value="<%=hotelDetailsBean.getWebsite()%>">${website}</td>
		</tr>
		
		<tr>
		<th>Charge</th>
		<td>:</td>
		<td><input type="text" name="txtCharge" id="txtCharge" value="<%=hotelDetailsBean.getCharge()%>">${charge}</td>
		</tr>
		
		
		<tr>
    	<th>City</th>
    	<td>:</td>
    	<td><select name="city" id="city" onChange="java:getReply(this.value)">
		<option value="">---Select City---</option>
		<% List<CityBean> listOfCity = new CityDAO().list(); 
	 	if(listOfCity!=null)
	 	{
	   		for(int i =0;i<listOfCity.size();i++)
	  	 {
	  		 CityBean cityBean = listOfCity.get(i);
	  		 if(hotelDetailsBean.getCity_id()==cityBean.getCity_id()){
		%>
		<option value="<%=cityBean.getCity_id()%>" selected="selected"><%=cityBean .getCity_name().toUpperCase()%></option>
		<%}else{ %>
		<option value="<%=cityBean.getCity_id()%>"><%=cityBean .getCity_name().toUpperCase()%></option>
		<%} %>
		<%} }%>
    	</select></td>
  		</tr>
  
  		<tr>
    	<th>Area</th>
    	<td>:</td>
    	<td>
		<select name="area" id="area" >
		<option value="">---Select Area---</option>
		</select>
		<span id="areaLoader" style="visibility:hidden;">
		    <img src="images/ajax-loader.gif">		
	    </span>	
		</td>
 		 </tr>
 		 
 		 <tr>
		<th>Category</th>
		<td>:</td>
		<td><select name="drpdncategory">
			<option value="0">-Select Category-</option>
			<% List<CategoryBean> category = new CategoryDAO().list();
				for(int i=0;i<category.size();i++){
					CategoryBean categoryBean = category.get(i);
					if(hotelDetailsBean.getHrcategory_id()==categoryBean.getCategory_Id()){
			%>
			<option value="<%=categoryBean.getCategory_Id()%>" selected="selected"><%=categoryBean.getCategory_Name()%></option>
			<%}else{ %>
			<option value="<%=categoryBean.getCategory_Id()%>"><%=categoryBean.getCategory_Name()%></option>
			<%} %>
			<%} %>
			</select>
	</tr>	
	
	<tr>
		<th>Hotel Type</th>
		<td>:</td>
		<td><select name="drpdnHotelType">
			<option value="0">-Select Type-</option>
			<% List<HotelTypeBean> type = new HotelTypeDAO().list();
				for(int i=0;i<type.size();i++){
					HotelTypeBean hotelTypeBean = type.get(i);
					if(hotelDetailsBean.getHtype_id()==hotelTypeBean.getHtype_id()){
			%>
			<option value="<%=hotelTypeBean.getHtype_id()%>" selected="selected"><%=hotelTypeBean.getType_name()%></option>
			<%}else{ %>
			<option value="<%=hotelTypeBean.getHtype_id()%>"><%=hotelTypeBean.getType_name()%></option>
			<%} %>
			<%} %>
			</select>
	</tr>
		
		<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="Update">
		<input type="reset" name="reset" value="RESET">
		<a href="hotelDetailsList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
	<%} %>
</form>
</body>
</html>