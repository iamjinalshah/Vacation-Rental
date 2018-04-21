package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.util.DBConnection;

public class HotelTypeDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean fkchecking(String htypeId){
		boolean result=false;
		conn=DBConnection.getConnection();
		if(conn!=null){
			
			String query = "SELECT * FROM HOTEL_DETAILS WHERE htype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,htypeId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return result;
		
		
	}
	
	public boolean insert(HotelTypeBean hotelTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO HOTEL_TYPE(type_name) values(?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelTypeBean.getType_name());
				
				
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
	
	public List<HotelTypeBean> list(){
		List<HotelTypeBean> hotel = new ArrayList<HotelTypeBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM HOTEL_TYPE";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				HotelTypeBean hotelTypeBean = null;
				while(rs.next()){
					
					hotelTypeBean = new HotelTypeBean();
					
					hotelTypeBean.setHtype_id(rs.getInt("htype_id"));
					hotelTypeBean.setType_name(rs.getString("type_name"));
					
					
					hotel.add(hotelTypeBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return hotel;
			
	}
	
	public HotelTypeBean getDatabyPK(String Id){
		HotelTypeBean hotelTypeBean = new HotelTypeBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM HOTEL_TYPE WHERE htype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					hotelTypeBean.setHtype_id(rs.getInt("htype_id"));
					hotelTypeBean.setType_name(rs.getString("type_name"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return hotelTypeBean;
		
	}
	
	public boolean update(HotelTypeBean hotelTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE HOTEL_TYPE SET type_name=? WHERE htype_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelTypeBean.getType_name());
				pstmt.setInt(2, hotelTypeBean.getHtype_id());
				
				
				
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
	public boolean delete(String htypeId){
		boolean result=false;
		HotelTypeBean hotelTypeBean = new HotelTypeBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM HOTEL_TYPE WHERE htype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, htypeId);
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
}
