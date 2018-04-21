package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.util.DBConnection;

public class PropertyDetailsDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(PropertyDetailsBean propertyDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO PROPERTY_DETAILS(property_title,address,owner_name,email_id,pmobile,plandline,rate,isavailable,area_id,city_id,ptype_id,state_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyDetailsBean.getProperty_title());
				pstmt.setString(2, propertyDetailsBean.getAddress());
				pstmt.setString(3, propertyDetailsBean.getOwner_name());
				pstmt.setString(4,propertyDetailsBean.getEmail_id());
				pstmt.setInt(5, propertyDetailsBean.getMobile());
				pstmt.setInt(6,propertyDetailsBean.getLandline());
				pstmt.setDouble(7,propertyDetailsBean.getRate());
				pstmt.setInt(8,0);
				pstmt.setInt(9,propertyDetailsBean.getArea_id());
				pstmt.setInt(10,propertyDetailsBean.getCity_id());
				pstmt.setInt(11,propertyDetailsBean.getPtype_id());
				pstmt.setInt(12,propertyDetailsBean.getState_id());
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public List<PropertyDetailsBean> list(){
		List<PropertyDetailsBean> listOfProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfProperty;
			
	}
	
	public boolean delete(String propertyId){
		boolean result=false;
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM PROPERTY_DETAILS WHERE property_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, propertyId);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected>0){
					result=true;
					System.out.println(rowAffected+"Row(s) Deleted");
				}else{
					System.out.println(rowAffected+"Row(s) Deleted");
				}
			} catch (SQLException e) {
			}
			
		}
		return result;
		
		
	}
	
	public PropertyDetailsBean getDatabyPK(String propertyId){
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM PROPERTY_DETAILS WHERE property_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, propertyId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setMobile(rs.getInt("pmobile"));
					propertyDetailsBean.setLandline(rs.getInt("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_id(rs.getInt("area_id"));
					propertyDetailsBean.setCity_id(rs.getInt("city_id"));
					propertyDetailsBean.setPtype_id(rs.getInt("ptype_id"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return propertyDetailsBean;
		
	}
	
	public boolean update(PropertyDetailsBean propertyDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE PROPERTY_DETAILS SET property_title=?,address=?,Owner_name=?,email_id=?,pmobile=?,plandline=?,rate=?,area_id=?,city_id=?,ptype_id=?,state_id=? WHERE property_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyDetailsBean.getProperty_title());
				pstmt.setString(2, propertyDetailsBean.getAddress());
				pstmt.setString(3, propertyDetailsBean.getOwner_name());
				pstmt.setString(4,propertyDetailsBean.getEmail_id());
				pstmt.setInt(5,propertyDetailsBean.getMobile());
				pstmt.setInt(6,propertyDetailsBean.getLandline());
				pstmt.setDouble(7,propertyDetailsBean.getRate());
				pstmt.setInt(8,propertyDetailsBean.getArea_id());
				pstmt.setInt(9,propertyDetailsBean.getCity_id());
				pstmt.setInt(10,propertyDetailsBean.getPtype_id());
				pstmt.setInt(11,propertyDetailsBean.getState_id());				
				pstmt.setInt(12, propertyDetailsBean.getProperty_id());
				
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Updated......");

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public boolean isAvailableTrue(String propertyId){
		boolean result=false;
		PropertyDetailsBean propertyDetailsBean = new PropertyDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE PROPERTY_DETAILS SET isavailable=? WHERE property_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,1);
				pstmt.setString(2,propertyId);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected>0){
					result=true;
					System.out.println(rowAffected+"Row(s) updated");
				}else{
					System.out.println(rowAffected+"Row(s) updated");
				}
			} catch (SQLException e) {
			}
			
		}
		return result;
		
		
	}
	
	public boolean isAvailableFalse(String propertyId){
		boolean result=false;
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE PROPERTY_DETAILS SET isavailable=? WHERE property_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,0);
				pstmt.setString(2,propertyId);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected>0){
					result=true;
					System.out.println(rowAffected+"Row(s) updated");
				}else{
					System.out.println(rowAffected+"Row(s) updated");
				}
			} catch (SQLException e) {
			}
			
		}
		return result;
		
		
	}
	
	public List<PropertyDetailsBean> Blockedlist(){
		List<PropertyDetailsBean> listOfProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id where isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,0);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfProperty;
			
	}
	
	public List<PropertyDetailsBean> Acceptedlist(){
		List<PropertyDetailsBean> listOfProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id where isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,1);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfProperty;
			
	}
	
	
		
		
	public List<PropertyDetailsBean> Searchlist(String search){
		List<PropertyDetailsBean> listOfProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id where city.city_name=? or area.area_name=? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					
					listOfProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfProperty;
			
	}
	
	public List<PropertyDetailsBean> userPropertylist(String Id){
		List<PropertyDetailsBean> listOfUserProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id join user on USER.user_id=PROPERTY_DETAILS.user_id WHERE PROPERTY_DETAILS.user_id=? AND isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Id);
				pstmt.setInt(2, 1);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfUserProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfUserProperty;
			
	}
	
	public List<PropertyDetailsBean> userBlockedPropertylist(String Id){
		List<PropertyDetailsBean> listOfUserProperty = new ArrayList<PropertyDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_DETAILS inner join AREA on PROPERTY_DETAILS.area_id=AREA.area_id join CITY on PROPERTY_DETAILS.city_id=CITY.city_id join PROPERTY_TYPE on PROPERTY_DETAILS.ptype_id=PROPERTY_TYPE.ptype_id join user on USER.user_id=PROPERTY_DETAILS.user_id WHERE PROPERTY_DETAILS.user_id=? AND isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Id);
				pstmt.setInt(2, 0);
				rs= pstmt.executeQuery();
				
				PropertyDetailsBean propertyDetailsBean = null;
				while(rs.next()){
					
					propertyDetailsBean = new PropertyDetailsBean();
					
					propertyDetailsBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsBean.setAddress(rs.getString("address"));
					propertyDetailsBean.setOwner_name(rs.getString("owner_name"));
					propertyDetailsBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsBean.setPlandline(rs.getString("plandline"));
					propertyDetailsBean.setRate(rs.getInt("rate"));
					propertyDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					propertyDetailsBean.setArea_name(rs.getString("area_name"));
					propertyDetailsBean.setCity_name(rs.getString("city_name"));
					propertyDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfUserProperty.add(propertyDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfUserProperty;
			
	}
}

