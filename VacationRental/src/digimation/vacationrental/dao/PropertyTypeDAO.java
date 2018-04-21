package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.PropertyTypeBean;
import digimation.vacationrental.util.DBConnection;

public class PropertyTypeDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean fkchecking(String ptypeId){
		boolean result=false;
		conn=DBConnection.getConnection();
		if(conn!=null){
			
			String query = "SELECT * FROM PROPERTY_DETAILS WHERE ptype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,ptypeId);
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
	
	public boolean insert(PropertyTypeBean propertyTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO PROPERTY_TYPE(type_name) values(?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyTypeBean.getType_name());
				
				
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
	
	public List<PropertyTypeBean> list(){
		List<PropertyTypeBean> property = new ArrayList<PropertyTypeBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM PROPERTY_TYPE";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				PropertyTypeBean propertyTypeBean = null;
				while(rs.next()){
					
					propertyTypeBean = new PropertyTypeBean();
					
					propertyTypeBean.setPtype_id(rs.getInt("ptype_id"));
					propertyTypeBean.setType_name(rs.getString("type_name"));
					
					
					property.add(propertyTypeBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return property;
			
	}
	
	public PropertyTypeBean getDatabyPK(String Id){
		PropertyTypeBean propertyTypeBean = new PropertyTypeBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM PROPERTY_TYPE WHERE ptype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					propertyTypeBean.setPtype_id(rs.getInt("ptype_id"));
					propertyTypeBean.setType_name(rs.getString("type_name"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return propertyTypeBean;
		
		
	}

	public boolean update(PropertyTypeBean propertyTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE PROPERTY_TYPE SET type_name=? WHERE ptype_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,propertyTypeBean.getType_name());
				pstmt.setInt(2, propertyTypeBean.getPtype_id());
				
				
				
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
	
	public boolean delete(String ptypeId){
		boolean result=false;
		PropertyTypeBean propertyTypeBean = new PropertyTypeBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM PROPERTY_TYPE WHERE ptype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, ptypeId);
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
