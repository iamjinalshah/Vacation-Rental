package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.util.DBConnection;

public class PropertyDetailsAmenitiesDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public boolean insert(PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean){
		
		boolean result=false;
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String insertQuery = "INSERT INTO property_details_amenities(property_id,amenities_id) values(?,?)";
			
			try{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setInt(1,propertyDetailsAmenitiesBean.getProperty_id());
				pstmt.setInt(2, propertyDetailsAmenitiesBean.getAmenities_id());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");
				}
				else{
					System.out.println(rowsAffected + " Row(s) Inserted......");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		return result;
	}
	
	public List<PropertyDetailsAmenitiesBean> list(){
		
		List<PropertyDetailsAmenitiesBean> listOfPDA = new ArrayList<PropertyDetailsAmenitiesBean>();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
				
				String selectSQL = "SELECT *from property_details_amenities inner join amenities on property_details_amenities.amenities_id=amenities.amenities_id";
				try{
					
					PreparedStatement pstmt = conn.prepareStatement(selectSQL);
					rs=pstmt.executeQuery();
					
					PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean=null;
					while(rs.next()){
						
						propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesBean();
						
						propertyDetailsAmenitiesBean.setPDA_id(rs.getInt("PDA_id"));
						propertyDetailsAmenitiesBean.setProperty_id(rs.getInt("property_id"));
						propertyDetailsAmenitiesBean.setAmenities_name(rs.getString("amenities_name"));
						listOfPDA.add(propertyDetailsAmenitiesBean);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		return listOfPDA;
		
	}
	
	public boolean delete(String pdaId){
		
		boolean result=false;
		conn=DBConnection.getConnection();			
		if(conn!=null){
			String deleteSQl="DELETE from property_details_amenities WHERE PDA_id=?";
			
			try{
				PreparedStatement pstmt = conn.prepareStatement(deleteSQl);
				
				pstmt.setString(1,pdaId);
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public PropertyDetailsAmenitiesBean getDataByPK(String pdaId){
		
		PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesBean();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			 
			String selectSQL = "SELECT * from property_details_amenities WHERE pda_id=?";
			try{
				pstmt = conn.prepareStatement(selectSQL);
				
				pstmt.setString(1,pdaId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					propertyDetailsAmenitiesBean.setPDA_id(rs.getInt("PDA_id"));
					propertyDetailsAmenitiesBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsAmenitiesBean.setAmenities_id(rs.getInt("amenities_id"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return propertyDetailsAmenitiesBean;
	}
	
	public boolean update(PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean){
		
		boolean result=false;
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			String updateSQL = "UPDATE property_details_amenities Set property_id=?, amenities_id=? WHERE pda_id=?";
			try{
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setInt(1,propertyDetailsAmenitiesBean.getProperty_id());
				pstmt.setInt(2,propertyDetailsAmenitiesBean.getAmenities_id());
				pstmt.setInt(3, propertyDetailsAmenitiesBean.getPDA_id());
				
				int rowsAffected=pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Updated......");

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
