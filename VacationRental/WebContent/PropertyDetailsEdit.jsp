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
<form action="propertyDetailsUpdate">
<% PropertyDetailsBean propertyDetailsBean = (PropertyDetailsBean)request.getAttribute("propertyDetailsBean");
	if(propertyDetailsBean!=null){
%>
	<input type="hidden" name="propertyId" id="propertyId" value="<%=propertyDetailsBean.getProperty_id()%>"> 
	<table>
		<tr>
		<th>Property-title</th>
		<td>:</td>
		<td><input type="text" name="txtTitle" id="txtTitle" value="<%=propertyDetailsBean.getProperty_title()%>">${title}</td>
		</tr>
		
		<tr>
		<th>Address</th>
		<td>:</td>
		<td><input type="text" name="txtAddress" id="txtAddress" value="<%=propertyDetailsBean.getAddress()%>">${address}</td>
		</tr>
		
		<tr>
		<th>Owner name</th>
		<td>:</td>
		<td><input type="text" name="txtOwnerName" id="txtOwnerName" value="<%=propertyDetailsBean.getOwner_name()%>">${owner}</td>
		</tr>
		
		<tr>
		<th>Email-id</th>
		<td>:</td>
		<td><input type="email" name="txtEmail" id="txtEmail" value="<%=propertyDetailsBean.getEmail_id()%>">${email}</td>
		</tr>
		
		<tr>
		<th>Mobile</th>
		<td>:</td>
		<td><input type="text" name="txtMobile" id="txtMobile" value="<%=propertyDetailsBean.getMobile()%>">${mobile}</td>
		</tr>
		
		<tr>
		<th>Landline</th>
		<td>:</td>
		<td><input type="text" name="txtLandline" id="txtLandline" value="<%=propertyDetailsBean.getLandline()%>"></td>
		</tr>
		
		<tr>
		<th>Rate</th>
		<td>:</td>
		<td><input type="text" name="txtRate" id="txtRate" value="<%=propertyDetailsBean.getRate()%>">${rate}</td>
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
	  		 if(propertyDetailsBean.getCity_id()==cityBean.getCity_id()){
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
		<th>Property type</th>
		<td>:</td>
		<td><select name="drpdnproperty">
			<option value="0">-Select Property type-</option>
			<% List<PropertyTypeBean> property = new PropertyTypeDAO().list();
				for(int i=0;i<property.size();i++){
					PropertyTypeBean propertyTypeBean = property.get(i);
					if(propertyDetailsBean.getPtype_id()==propertyTypeBean.getPtype_id()){
			%>
			<option value="<%=propertyTypeBean.getPtype_id()%>" selected="selected"><%=propertyTypeBean.getType_name()%></option>
			<%}else{%>
			<option value="<%=propertyTypeBean.getPtype_id()%>"><%=propertyTypeBean.getType_name()%></option>
			<%} %>
			<%} %>
			</select>
	</tr>
		
		<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="Update">
		<input type="reset" name="reset" value="RESET">
		<a href="propertyDetailsList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
	<%} %>
</form>
</body>
</html>