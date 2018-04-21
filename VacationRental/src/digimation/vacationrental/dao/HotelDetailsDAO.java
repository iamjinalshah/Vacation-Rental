package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.PropertyDetailsBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.util.DBConnection;

public class HotelDetailsDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(HotelDetailsBean hotelDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO HOTEL_DETAILS(hotel_name,address,description,manager_name,email_id,mobile,landline,website,isavailable,area_id,city_id,hrcategory_id,htype_id,state_id,charge) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelDetailsBean.getHotel_name());
				pstmt.setString(2, hotelDetailsBean.getAddress());
				pstmt.setString(3, hotelDetailsBean.getDescription());
				pstmt.setString(4, hotelDetailsBean.getManager_name());
				pstmt.setString(5,hotelDetailsBean.getEmail_id());
				pstmt.setInt(6, hotelDetailsBean.getMobile());
				pstmt.setInt(7,hotelDetailsBean.getLandline());
				pstmt.setString(8,hotelDetailsBean.getWebsite());
				pstmt.setInt(9,0);
				pstmt.setInt(10,hotelDetailsBean.getArea_id());
				pstmt.setInt(11,hotelDetailsBean.getCity_id());
				pstmt.setInt(12,hotelDetailsBean.getHrcategory_id());
				pstmt.setInt(13, hotelDetailsBean.getHtype_id());
				pstmt.setInt(14, hotelDetailsBean.getState_id());
				pstmt.setString(15, hotelDetailsBean.getCharge());
				
				
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
	
	public List<HotelDetailsBean> list(){
		List<HotelDetailsBean> listOfHotel = new ArrayList<HotelDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM HOTEL_DETAILS inner join AREA on HOTEL_DETAILS.area_id=AREA.area_id join CITY on HOTEL_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=HOTEL_DETAILS.hrcategory_id join hotel_type on HOTEL_DETAILS.htype_id=HOTEL_TYPE.htype_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				HotelDetailsBean hotelDetailsBean = null;
				while(rs.next()){
					
					hotelDetailsBean = new HotelDetailsBean();
					
					hotelDetailsBean.setHotel_id(rs.getInt("hotel_id"));
					hotelDetailsBean.setHotel_name(rs.getString("hotel_name"));
					hotelDetailsBean.setAddress(rs.getString("address"));
					hotelDetailsBean.setDescription(rs.getString("description"));
					hotelDetailsBean.setManager_name(rs.getString("manager_name"));
					hotelDetailsBean.setEmail_id(rs.getString("email_id"));
					hotelDetailsBean.setMobile(rs.getInt("mobile"));
					hotelDetailsBean.setLandline(rs.getInt("landline"));
					hotelDetailsBean.setWebsite(rs.getString("website"));
					hotelDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					hotelDetailsBean.setArea_name(rs.getString("area_name"));
					hotelDetailsBean.setCity_name(rs.getString("city_name"));
					hotelDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					hotelDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfHotel.add(hotelDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfHotel;
			
	}
	
	public boolean delete(String hotelId){
		boolean result=false;
		HotelDetailsBean hotelDetailsBean = new HotelDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM HOTEL_DETAILS WHERE hotel_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, hotelId);
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
	
	public HotelDetailsBean getDatabyPK(String hotelId){
		HotelDetailsBean hotelDetailsBean = new HotelDetailsBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM HOTEL_DETAILS WHERE hotel_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, hotelId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					hotelDetailsBean.setHotel_id(rs.getInt("hotel_id"));
					hotelDetailsBean.setHotel_name(rs.getString("hotel_name"));
					hotelDetailsBean.setAddress(rs.getString("address"));
					hotelDetailsBean.setDescription(rs.getString("description"));
					hotelDetailsBean.setManager_name(rs.getString("manager_name"));
					hotelDetailsBean.setEmail_id(rs.getString("email_id"));
					hotelDetailsBean.setMobile(rs.getInt("mobile"));
					hotelDetailsBean.setLandline(rs.getInt("landline"));
					hotelDetailsBean.setWebsite(rs.getString("website"));
					hotelDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					hotelDetailsBean.setArea_id(rs.getInt("area_id"));
					hotelDetailsBean.setCity_id(rs.getInt("city_id"));
					hotelDetailsBean.setHrcategory_id(rs.getInt("hrcategory_id"));
					hotelDetailsBean.setHtype_id(rs.getInt("htype_id"));
					hotelDetailsBean.setCharge(rs.getString("charge"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return hotelDetailsBean;
		
	}
	
	public boolean update(HotelDetailsBean hotelDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE HOTEL_DETAILS SET hotel_name=?,address=?,description=?,manager_name=?,email_id=?,mobile=?,landline=?,website=?,area_id=?,city_id=?,hrcategory_id=?,htype_id=?,charge=? WHERE hotel_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelDetailsBean.getHotel_name());
				pstmt.setString(2,hotelDetailsBean.getAddress());
				pstmt.setString(3,hotelDetailsBean.getDescription());
				pstmt.setString(4,hotelDetailsBean.getManager_name());
				pstmt.setString(5,hotelDetailsBean.getEmail_id());
				pstmt.setInt(6,hotelDetailsBean.getMobile());
				pstmt.setInt(7,hotelDetailsBean.getLandline());
				pstmt.setString(8,hotelDetailsBean.getWebsite());
				pstmt.setInt(9,hotelDetailsBean.getArea_id());
				pstmt.setInt(10,hotelDetailsBean.getCity_id());
				pstmt.setInt(11,hotelDetailsBean.getHrcategory_id());
				pstmt.setInt(12,hotelDetailsBean.getHtype_id());
				pstmt.setString(13,hotelDetailsBean.getCharge());
				pstmt.setInt(14,hotelDetailsBean.getHotel_id());
				
				
				
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
	
	
	public boolean isAvailableTrue(String hotelId){
		boolean result=false;
		HotelDetailsBean hotelDetailsBean = new HotelDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE HOTEL_DETAILS SET isavailable=? WHERE hotel_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,1);
				pstmt.setString(2,hotelId);
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
	
	public boolean isAvailableFalse(String hotelId){
		boolean result=false;
		HotelDetailsBean hotelDetailsBean = new HotelDetailsBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE HOTEL_DETAILS SET isavailable=? WHERE hotel_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,0);
				pstmt.setString(2,hotelId);
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
	
	public List<HotelDetailsBean> Blockedlist(){
		List<HotelDetailsBean> listOfHotel = new ArrayList<HotelDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM HOTEL_DETAILS inner join AREA on HOTEL_DETAILS.area_id=AREA.area_id join CITY on HOTEL_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=HOTEL_DETAILS.hrcategory_id join hotel_type on HOTEL_DETAILS.htype_id=HOTEL_TYPE.htype_id where isavailable=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 0);
				rs= pstmt.executeQuery();
				
				HotelDetailsBean hotelDetailsBean = null;
				while(rs.next()){
					
					hotelDetailsBean = new HotelDetailsBean();
					
					hotelDetailsBean.setHotel_id(rs.getInt("hotel_id"));
					hotelDetailsBean.setHotel_name(rs.getString("hotel_name"));
					hotelDetailsBean.setAddress(rs.getString("address"));
					hotelDetailsBean.setDescription(rs.getString("description"));
					hotelDetailsBean.setManager_name(rs.getString("manager_name"));
					hotelDetailsBean.setEmail_id(rs.getString("email_id"));
					hotelDetailsBean.setMobile(rs.getInt("mobile"));
					hotelDetailsBean.setLandline(rs.getInt("landline"));
					hotelDetailsBean.setWebsite(rs.getString("website"));
					hotelDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					hotelDetailsBean.setArea_name(rs.getString("area_name"));
					hotelDetailsBean.setCity_name(rs.getString("city_name"));
					hotelDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					hotelDetailsBean.setType_name(rs.getString("type_name"));
					
					listOfHotel.add(hotelDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfHotel;
			
	}
	
	public List<HotelDetailsBean> Searchlist(String search){
		List<HotelDetailsBean> listOfHotel = new ArrayList<HotelDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM HOTEL_DETAILS inner join AREA on HOTEL_DETAILS.area_id=AREA.area_id join CITY on HOTEL_DETAILS.city_id=CITY.city_id join HOTEL_RESTAURANT_CATEGORIES on HOTEL_RESTAURANT_CATEGORIES.hrcategory_id=HOTEL_DETAILS.hrcategory_id where city.city_name=? or area.area_name=? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs= pstmt.executeQuery();
				
				HotelDetailsBean hotelDetailsBean = null;
				while(rs.next()){
					
					hotelDetailsBean = new HotelDetailsBean();
					
					hotelDetailsBean.setHotel_id(rs.getInt("hotel_id"));
					hotelDetailsBean.setHotel_name(rs.getString("hotel_name"));
					hotelDetailsBean.setAddress(rs.getString("address"));
					hotelDetailsBean.setDescription(rs.getString("description"));
					hotelDetailsBean.setManager_name(rs.getString("manager_name"));
					hotelDetailsBean.setEmail_id(rs.getString("email_id"));
					hotelDetailsBean.setMobile(rs.getInt("mobile"));
					hotelDetailsBean.setLandline(rs.getInt("landline"));
					hotelDetailsBean.setWebsite(rs.getString("website"));
					hotelDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					hotelDetailsBean.setArea_name(rs.getString("area_name"));
					hotelDetailsBean.setCity_name(rs.getString("city_name"));
					hotelDetailsBean.setHrcategory_name(rs.getString("hrcategory_name"));
					
					
					listOfHotel.add(hotelDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfHotel;
			
	}
	
}
