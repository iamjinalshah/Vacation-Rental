<%@page import="digimation.vacationrental.dao.StateDAO"%>
<%@page import="digimation.vacationrental.bean.StateBean"%>
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

     function getResponse(stateId){
	     //  stateId='';
			alert(stateId);
			dwr.util.removeAllOptions("city");
			
		document.getElementById('areaLoader').style.visibility = 'hidden';
			
			if(stateId==''){
				var data=[{ city_name:'-- Select --', city_id:'' }];
				dwr.util.addOptions("city",data,"city_id","city_name");
			document.getElementById('areaLoader').style.visibility = 'hidden';
			}else{
				//alert(cityId);
		    document.getElementById('areaLoader').style.visibility = 'visible';
				AjaxDataDAO.getAllCity(stateId,function(data){
				dwr.util.addOptions("city",data,"city_id","city_name");
 		   document.getElementById('areaLoader').style.visibility = 'hidden';
				});
			}
}	
     
     

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
<form action="restaurantDetailsInsert">
	<table>
		<tr>
		<th>Restaurant-name</th>
		<td>:</td>
		<td><input type="text" name="txtRestaurant" id="txtRestaurant">${restaurant}</td>
		</tr>
		
		<tr>
		<th>Address</th>
		<td>:</td>
		<td><input type="text" name="txtAddress" id="txtAddress">${address}</td>
		</tr>
		
		<tr>
		<th>Description</th>
		<td>:</td>
		<td><input type="text" name="txtDescription" id="txtDescription">${description}</td>
		</tr>
		
		<tr>
		<th>Manager name</th>
		<td>:</td>
		<td><input type="text" name="txtManagerName" id="txtManagerName">${manager}</td>
		</tr>
		
		<tr>
		<th>Email-id</th>
		<td>:</td>
		<td><input type="email" name="txtEmail" id="txtEmail">${email}</td>
		</tr>
		
		<tr>
		<th>Mobile</th>
		<td>:</td>
		<td><input type="text" name="txtMobile" id="txtMobile">${mobile}</td>
		</tr>
		
		<tr>
		<th>Landline</th>
		<td>:</td>
		<td><input type="text" name="txtLandline" id="txtLandline"></td>
		</tr>
		
		<tr>
    	<th>State</th>
    	<td>:</td>
    	<td><select name="state" id="state" onChange="java:getResponse(this.value)">
		<option value="">---Select State---</option>
		<% List<StateBean> listOfState = new StateDAO().list(); 
	 	if(listOfState!=null)
	 	{
	   		for(int i =0;i<listOfState.size();i++)
	  	 {
	  		 StateBean stateBean = listOfState.get(i);
		%>
		<option value="<%=stateBean.getState_id()%>"><%=stateBean .getState_name().toUpperCase()%></option><%} }%>
    	</select></td>
  		</tr>
		
		<tr>
    	<th>City</th>
    	<td>:</td>
    	<td><select name="city" id="city" onChange="java:getReply(this.value)">
    	<option value="">---Select City---</option>
    	</select>
    	<span id="areaLoader" style="visibility:hidden;">
		    <img src="images/ajax-loader.gif">		
	    </span>
    	</td>
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
			%>
			<option value="<%=categoryBean.getCategory_Id()%>"><%=categoryBean.getCategory_Name()%></option>
			<%} %>
			</select>
	</tr>
		
		<tr>
	<th></th>
	<td></td>
	<td><input type="submit" name="submit" value="SUBMIT">
		<input type="reset" name="reset" value="RESET">
		<a href="restaurantDetailsList"><input type="button" name="showdata" value="Show All Data"></a></td>
	</tr>
		
	</table>
</form>
</body>
</html>