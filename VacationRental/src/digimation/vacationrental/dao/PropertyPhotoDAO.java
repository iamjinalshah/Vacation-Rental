package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.HotelTypeBean;
import digimation.vacationrental.bean.PropertyPhotoBean;
import digimation.vacationrental.util.DBConnection;

public class PropertyPhotoDAO {
  
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(PropertyPhotoBean propertyPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO PROPERTY_PHOTOS(photo_name,isvisible,iscoverphoto,property_id) values(?,?,?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyPhotoBean.getPhoto_name());
				pstmt.setInt(2, 1);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, propertyPhotoBean.getProperty_id());
				
				
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
	
	public List<PropertyPhotoBean> list(){
		List<PropertyPhotoBean> photo = new ArrayList<PropertyPhotoBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_PHOTOS INNER JOIN PROPERTY_DETAILS on PROPERTY_DETAILS.property_id=PROPERTy_PHOTOS.property_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				PropertyPhotoBean propertyPhotoBean = null;
				while(rs.next()){
					
					propertyPhotoBean = new PropertyPhotoBean();
					
					propertyPhotoBean.setPropertyphoto_id(rs.getInt("propertyphoto_id"));
					propertyPhotoBean.setPhoto_name(rs.getString("photo_name"));
					propertyPhotoBean.setIsvisible(rs.getBoolean("isvisible"));
					propertyPhotoBean.setIscoverpage(rs.getBoolean("iscoverphoto"));
					propertyPhotoBean.setProperty_name(rs.getString("property_title"));
					
					photo.add(propertyPhotoBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return photo;
			
	}
	
	public boolean delete(String photoId){
		boolean result=false;
		PropertyPhotoBean propertyPhotoBean = new PropertyPhotoBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM PROPERTY_PHOTOS WHERE propertyphoto_id=?";
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
	
	public PropertyPhotoBean getDatabyPK(String Id){
		PropertyPhotoBean propertyPhotoBean = new PropertyPhotoBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM PROPERTY_PHOTOS WHERE propertyphoto_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					propertyPhotoBean.setPropertyphoto_id(rs.getInt("propertyphoto_id"));
					propertyPhotoBean.setPhoto_name(rs.getString("photo_name"));
					propertyPhotoBean.setProperty_id(rs.getInt("property_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return propertyPhotoBean;
		
	}
	
	public boolean update(PropertyPhotoBean propertyPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE PROPERTY_PHOTOS SET photo_name=?,property_id=? WHERE propertyphoto_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyPhotoBean.getPhoto_name());
				pstmt.setInt(2, propertyPhotoBean.getProperty_id());
				pstmt.setInt(3, propertyPhotoBean.getPropertyphoto_id());
				
				
				
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
