<%@page import="digimation.vacationrental.bean.CarDetailsBean"%>
<%@page import="digimation.vacationrental.dao.CarModelsDAO"%>
<%@page import="digimation.vacationrental.bean.CarModelBean"%>
<%@page import="digimation.vacationrental.dao.CarBrandDAO"%>
<%@page import="digimation.vacationrental.bean.CarBrandBean"%>
<%@page import="digimation.vacationrental.dao.HotelTypeDAO"%>
<%@page import="digimation.vacationrental.bean.HotelTypeBean"%>
<%@page import="digimation.vacationrental.dao.CategoryDAO"%>
<%@page import="digimation.vacationrental.bean.CategoryBean"%>
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
<form action="carDetailsUpdate">

<% CarDetailsBean carDetailsBean = (CarDetailsBean)request.getAttribute("carDetailsBean"); 
if(carDetailsBean!=null){
%>
	<table>
		<input type="hidden"  name="carId" value="<%=carDetailsBean.getCar_id()%>">
		<tr>
		<th>Capacity</th>
		<td>:</td>
		<td><input type="text" name="txtCapacity" id="txtCapacity" value="<%=carDetailsBean.getCapacity()%>">${capacity}</td>
		</tr>
		
		<tr>
		<th>Manager name</th>
		<td>:</td>
		<td><input type="text" name="txtManagerName" id="txtManagerName" value="<%=carDetailsBean.getManager_name()%>">${manager}</td>
		</tr>
		
		<tr>
		<th>Email-id</th>
		<td>:</td>
		<td><input type="email" name="txtEmail" id="txtEmail" value="<%=carDetailsBean.getEmail_id()%>">${email}</td>
		</tr>
		
		<tr>
		<th>Mobile</th>
		<td>:</td>
		<td><input type="text" name="txtMobile" id="txtMobile" value="<%=carDetailsBean.getMobile()%>">${mobile}</td>
		</tr>
		
		<tr>
		<th>Landline</th>
		<td>:</td>
		<td><input type="text" name="txtLandline" id="txtLandline" value="<%=carDetailsBean.getLandline()%>"></td>
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
	  		 if(carDetailsBean.getCity_id()==cityBean.getCity_id()){
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
		<th>Car_Brand</th>
		<td>:</td>
		<td><select name="drpdnBrand">
			<option value="0">-Select Brand-</option>
			<% List<CarBrandBean> brand = new CarBrandDAO().list();
				for(int i=0;i<brand.size();i++){
					CarBrandBean carBrandBean = brand.get(i);
					if(carBrandBean.getCarBrand_id()==carDetailsBean.getCarbrand_id()){
			%>
			<option value="<%=carBrandBean.getCarBrand_id()%>" selected="selected"><%=carBrandBean.getCarBrand_Name()%></option>
			<%}else {%>
			<option value="<%=carBrandBean.getCarBrand_id()%>"><%=carBrandBean.getCarBrand_Name()%></option>
			<%} %>
			<%} %>
			</select></td>
	</tr>
	
	<tr>
		<th>Car-Model</th>
		<td>:</td>
		<td><select name="drpdnModel">
			<option value="0">-Select Model-</option>
			<% List<CarModelBean> model = new CarModelsDAO().list();
				for(int i=0;i<model.size();i++){
					CarModelBean carModelBean = model.get(i);
					if(carDetailsBean.getCarmodel_id()==carModelBean.getCarmodel_id()){
			%>
			<option value="<%=carModelBean.getCarmodel_id()%>" selected="selected"><%=carModelBean.getCarmodel_name()%></option>
			<%} else{%>
			<option value="<%=carModelBean.getCarmodel_id()%>"><%=carModelBean.getCarmodel_name()%></option>
			<%} %>
			<%} %>
			</select>
	</tr>
		
		<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="carDetailsList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
	<%} %>
</form>
</body>
</html>