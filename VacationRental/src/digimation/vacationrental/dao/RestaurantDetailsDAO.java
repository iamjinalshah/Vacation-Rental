package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.ResataurantDetailsBean;
import digimation.vacationrental.util.DBConnection;

public class RestaurantDetailsDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(ResataurantDetailsBean resataurantDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO RESTAURANT_DETAILS(restaurant_name,address,description,manager_name,email_id,mobile,landline,isavailable,area_id,city_id,hrcategory_id,state_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,resataurantDetailsBean.getRestaurant_name());
				pstmt.setString(2, resataurantDetailsBean.getAddress());
				pstmt.setString(3, resataurantDetailsBean.getDescription());
				pstmt.setString(4, resataurantDetailsBean.getManager_name());
				pstmt.setString(5,resataurantDetailsBean.getEmail_id());
				pstmt.setInt(6, resataurantDetailsBean.getMobile());
				pstmt.setInt(7,resataurantDetailsBean.getLandline());
				pstmt.setInt(8,0);
				pstmt.setInt(9,resataurantDetailsBean.getArea_id());
				pstmt.setInt(10,resataurantDetailsBean.getCity_id());
				pstmt.setInt(11,resataurantDetailsBean.getHrcategory_id());
				pstmt.setInt(12, resataurantDetailsBean.getState_id());
				
				
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
	
	public List<ResataurantDetailsBean> list(){
		List<ResataurantDetailsBean> listOfRestaurant = new ArrayList<ResataurantDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM RESTAURANT_DETAILS inner join AREA on RESTAURANT_DETAILS.area_id=AREA.area_id join CITY on RESTAURANT_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=RESTAURANT_DETAILS.hrcategory_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				ResataurantDetailsBean resataurantDetailsBean = null;
				while(rs.next()){
					
					resataurantDetailsBean = new ResataurantDetailsBean();
					
					resataurantDetailsBean.setRestaurant_id(rs.getInt("restaurant_id"));
					resataurantDetailsBean.setRestaurant_name(rs.getString("restaurant_name"));
					resataurantDetailsBean.setAddress(rs.getString("address"));
					resataurantDetailsBean.setDescription(rs.getString("description"));
					resataurantDetailsBean.setManager_name(rs.getString("manager_name"));
					resataurantDetailsBean.setEmail_id(rs.getString("email_id"));
					resataurantDetailsBean.setMobile(rs.getInt("mobile"));
					resataurantDetailsBean.setLandline(rs.getInt("landline"));
					resataurantDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					resataurantDetailsBean.setArea_name(rs.getString("area_name"));
					resataurantDetailsBean.setCity_name(rs.getString("city_name"));
					resataurantDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					
					listOfRestaurant.add(resataurantDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfRestaurant;
			
	}
	
	public boolean delete(String restaurantId){
		boolean result=false;
		ResataurantDetailsBean resataurantDetailsBean = new ResataurantDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM RESTAURANT_DETAILS WHERE restaurant_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,restaurantId);
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
	
	public ResataurantDetailsBean getDatabyPK(String restaurantId){
		ResataurantDetailsBean resataurantDetailsBean = new ResataurantDetailsBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM RESTAURANT_DETAILS WHERE restaurant_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, restaurantId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					resataurantDetailsBean.setRestaurant_id(rs.getInt("restaurant_id"));
					resataurantDetailsBean.setRestaurant_name(rs.getString("restaurant_name"));
					resataurantDetailsBean.setAddress(rs.getString("address"));
					resataurantDetailsBean.setDescription(rs.getString("description"));
					resataurantDetailsBean.setManager_name(rs.getString("manager_name"));
					resataurantDetailsBean.setEmail_id(rs.getString("email_id"));
					resataurantDetailsBean.setMobile(rs.getInt("mobile"));
					resataurantDetailsBean.setLandline(rs.getInt("landline"));
					resataurantDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					resataurantDetailsBean.setArea_id(rs.getInt("area_id"));
					resataurantDetailsBean.setCity_id(rs.getInt("city_id"));
					resataurantDetailsBean.setHrcategory_id(rs.getInt("hrcategory_id"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return resataurantDetailsBean;
		
	}
	
	public boolean update(ResataurantDetailsBean  resataurantDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE RESTAURANT_DETAILS SET RESTAURANT_name=?,address=?,description=?,manager_name=?,email_id=?,mobile=?,landline=?,area_id=?,city_id=?,hrcategory_id=? WHERE restaurant_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,resataurantDetailsBean.getRestaurant_name());
				pstmt.setString(2, resataurantDetailsBean.getAddress());
				pstmt.setString(3, resataurantDetailsBean.getDescription());
				pstmt.setString(4, resataurantDetailsBean.getManager_name());
				pstmt.setString(5,resataurantDetailsBean.getEmail_id());
				pstmt.setInt(6,resataurantDetailsBean.getMobile());
				pstmt.setInt(7,resataurantDetailsBean.getLandline());
				pstmt.setInt(8,resataurantDetailsBean.getArea_id());
				pstmt.setInt(9,resataurantDetailsBean.getCity_id());
				pstmt.setInt(10,resataurantDetailsBean.getHrcategory_id());
				pstmt.setInt(11, resataurantDetailsBean.getRestaurant_id());
				
				
				
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
	
	public List<ResataurantDetailsBean> Blockedlist(){
		List<ResataurantDetailsBean> listOfRestaurant = new ArrayList<ResataurantDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM RESTAURANT_DETAILS inner join AREA on RESTAURANT_DETAILS.area_id=AREA.area_id join CITY on RESTAURANT_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=RESTAURANT_DETAILS.hrcategory_id where isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 0);
				rs= pstmt.executeQuery();
				
				ResataurantDetailsBean resataurantDetailsBean = null;
				while(rs.next()){
					
					resataurantDetailsBean = new ResataurantDetailsBean();
					
					resataurantDetailsBean.setRestaurant_id(rs.getInt("restaurant_id"));
					resataurantDetailsBean.setRestaurant_name(rs.getString("restaurant_name"));
					resataurantDetailsBean.setAddress(rs.getString("address"));
					resataurantDetailsBean.setDescription(rs.getString("description"));
					resataurantDetailsBean.setManager_name(rs.getString("manager_name"));
					resataurantDetailsBean.setEmail_id(rs.getString("email_id"));
					resataurantDetailsBean.setMobile(rs.getInt("mobile"));
					resataurantDetailsBean.setLandline(rs.getInt("landline"));
					resataurantDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					resataurantDetailsBean.setArea_name(rs.getString("area_name"));
					resataurantDetailsBean.setCity_name(rs.getString("city_name"));
					resataurantDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					
					listOfRestaurant.add(resataurantDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfRestaurant;
			
	}
	public boolean isAvailableTrue(String restaurantId){
		boolean result=false;
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE RESTAURANT_DETAILS SET isavailable=? WHERE restaurant_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,1);
				pstmt.setString(2,restaurantId);
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
	
	public boolean isAvailableFalse(String restaurantId){
		boolean result=false;
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE RESTAURANT_DETAILS SET isavailable=? WHERE restaurant_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,0);
				pstmt.setString(2,restaurantId);
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
	
	public List<ResataurantDetailsBean> Searchlist(String search){
		List<ResataurantDetailsBean> listOfRestaurant = new ArrayList<ResataurantDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM RESTAURANT_DETAILS inner join AREA on RESTAURANT_DETAILS.area_id=AREA.area_id join CITY on RESTAURANT_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=RESTAURANT_DETAILS.hrcategory_id where city.city_name=? or area.area_name=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs= pstmt.executeQuery();
				
				ResataurantDetailsBean resataurantDetailsBean = null;
				while(rs.next()){
					
					resataurantDetailsBean = new ResataurantDetailsBean();
					
					resataurantDetailsBean.setRestaurant_id(rs.getInt("restaurant_id"));
					resataurantDetailsBean.setRestaurant_name(rs.getString("restaurant_name"));
					resataurantDetailsBean.setAddress(rs.getString("address"));
					resataurantDetailsBean.setDescription(rs.getString("description"));
					resataurantDetailsBean.setManager_name(rs.getString("manager_name"));
					resataurantDetailsBean.setEmail_id(rs.getString("email_id"));
					resataurantDetailsBean.setMobile(rs.getInt("mobile"));
					resataurantDetailsBean.setLandline(rs.getInt("landline"));
					resataurantDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					resataurantDetailsBean.setArea_name(rs.getString("area_name"));
					resataurantDetailsBean.setCity_name(rs.getString("city_name"));
					resataurantDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					
					
					listOfRestaurant.add(resataurantDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfRestaurant;
			
	}
}


