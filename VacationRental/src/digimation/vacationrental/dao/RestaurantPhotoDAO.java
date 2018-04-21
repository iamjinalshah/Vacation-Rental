package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.RestaurantPhotoBean;
import digimation.vacationrental.util.DBConnection;

public class RestaurantPhotoDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(RestaurantPhotoBean restaurantPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO RESTAURANT_PHOTOS(photo_name,isvisible,iscoverphoto,restaurant_id) values(?,?,?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,restaurantPhotoBean.getPhoto_name());
				pstmt.setInt(2, 1);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, restaurantPhotoBean.getRestaurant_id());
				
				
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
	
	public List<RestaurantPhotoBean> list(){
		List<RestaurantPhotoBean> photo = new ArrayList<RestaurantPhotoBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM RESTAURANT_PHOTOS INNER JOIN RESTAURANT_DETAILS on RESTAURANT_DETAILS.restaurant_id=RESTAURANT_PHOTOS.restaurant_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				RestaurantPhotoBean restaurantPhotoBean = null;
				while(rs.next()){
					
					restaurantPhotoBean = new RestaurantPhotoBean();
					
					restaurantPhotoBean.setRestaurantphoto_id(rs.getInt("restaurantphoto_id"));
					restaurantPhotoBean.setPhoto_name(rs.getString("photo_name"));
					restaurantPhotoBean.setIsvisible(rs.getBoolean("isvisible"));
					restaurantPhotoBean.setIscoverpage(rs.getBoolean("iscoverphoto"));
					restaurantPhotoBean.setRestaurant_name(rs.getString("restaurant_name"));
					
					photo.add(restaurantPhotoBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return photo;
			
	}
	
	public boolean delete(String photoId){
		boolean result=false;
		RestaurantPhotoBean restaurantPhotoBean = new RestaurantPhotoBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM RESTAURANT_PHOTOS WHERE restaurantphoto_id=?";
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
	
	public RestaurantPhotoBean getDatabyPK(String Id){
		RestaurantPhotoBean restaurantPhotoBean = new RestaurantPhotoBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM RESTAURANT_PHOTOS WHERE restaurantphoto_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					restaurantPhotoBean.setRestaurantphoto_id(rs.getInt("restaurantphoto_id"));
					restaurantPhotoBean.setPhoto_name(rs.getString("photo_name"));
					restaurantPhotoBean.setRestaurant_id(rs.getInt("restaurant_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return restaurantPhotoBean;
		
	}
	
	public boolean update(RestaurantPhotoBean restaurantPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE RESTAURANT_PHOTOS SET photo_name=?,restaurant_id=? WHERE restaurantphoto_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,restaurantPhotoBean.getPhoto_name());
				pstmt.setInt(2, restaurantPhotoBean.getRestaurant_id());
				pstmt.setInt(3, restaurantPhotoBean.getRestaurantphoto_id());
				
				
				
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
