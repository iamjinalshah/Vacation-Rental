<%@page import="digimation.vacationrental.dao.StateDAO"%>
<%@page import="digimation.vacationrental.bean.StateBean"%>
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
	<form action="attractionInsert" method="post">
		<table>
			<tr>
				<th>Attraction name	:</th>
				<td><input type="text" name="txtAttractionName" id="txtAttractionName">${attractionName}</td>
			</tr>
			<tr>
				<th>Description :</th>
				<td><textarea cols="15" rows="3" name="txtDescription" id="txtDescription">${description}</textarea></td>
			</tr>
    	<th>State:</th>
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
    	<th>City :</th>
    	<td><select name="city" id="city" onChange="java:getReply(this.value)">
    	<option value="">---Select City---</option>
    	</select>
    	<span id="areaLoader" style="visibility:hidden;">
		    <img src="images/ajax-loader.gif">		
	    </span>
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
 		 
				<td><input type="submit" name="submit" value="SUBMIT"></td>
				<td><input type="reset" name="reset" value="RESET"></td>
			</tr>
		</table>
	</form>
</body>
</html>