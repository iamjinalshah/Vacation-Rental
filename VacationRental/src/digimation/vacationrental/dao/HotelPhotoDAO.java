package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.util.DBConnection;

public class HotelPhotoDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(HotelPhotoBean hotelPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO HOTEL_PHOTOS(photo_name,isvisible,iscoverphoto,hotel_id) values(?,?,?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelPhotoBean.getPhoto_name());
				pstmt.setInt(2, 1);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, hotelPhotoBean.getHotel_id());
				
				
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
	
	public List<HotelPhotoBean> list(){
		List<HotelPhotoBean> photo = new ArrayList<HotelPhotoBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM HOTEL_PHOTOS INNER JOIN HOTEL_DETAILS on HOTEL_DETAILS.hotel_id=HOTEL_PHOTOS.hotel_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				HotelPhotoBean hotelPhotoBean = null;
				while(rs.next()){
					
					hotelPhotoBean = new HotelPhotoBean();
					
					hotelPhotoBean.setHotelphoto_id(rs.getInt("hotelphoto_id"));
					hotelPhotoBean.setPhoto_name(rs.getString("photo_name"));
					hotelPhotoBean.setIsvisible(rs.getBoolean("isvisible"));
					hotelPhotoBean.setIscoverpage(rs.getBoolean("iscoverphoto"));
					hotelPhotoBean.setHotel_name(rs.getString("hotel_name"));
					
					photo.add(hotelPhotoBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return photo;
			
	}
	
	public boolean delete(String photoId){
		boolean result=false;
		HotelPhotoBean hotelPhotoBean = new HotelPhotoBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM HOTEL_PHOTOS WHERE hotelphoto_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, photoId);
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
	
	public HotelPhotoBean getDatabyPK(String Id){
		HotelPhotoBean hotelPhotoBean = new HotelPhotoBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM HOTEL_PHOTOS WHERE hotelphoto_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					hotelPhotoBean.setHotelphoto_id(rs.getInt("hotelphoto_id"));
					hotelPhotoBean.setPhoto_name(rs.getString("photo_name"));
					hotelPhotoBean.setHotel_id(rs.getInt("hotel_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return hotelPhotoBean;
		
	}
	
	public boolean update(HotelPhotoBean hotelPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE HOTEL_PHOTOS SET photo_name=?,hotel_id=? WHERE hotelphoto_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,hotelPhotoBean.getPhoto_name());
				pstmt.setInt(2, hotelPhotoBean.getHotel_id());
				pstmt.setInt(3, hotelPhotoBean.getHotelphoto_id());
				
				
				
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

}
