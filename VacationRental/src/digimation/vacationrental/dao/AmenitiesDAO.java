package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AmenitiesBean;
import digimation.vacationrental.util.DBConnection;
import digimation.vacationrental.bean.AmenitiesBean;

public class AmenitiesDAO {
	
		private Connection conn=null;
		private PreparedStatement pstmt=null;
		private ResultSet rs=null;
		
		public boolean fkchecking(String amenitiesId){
			boolean result=false;
			conn=DBConnection.getConnection();
			if(conn!=null){
				
				String query = "SELECT * FROM PROPERTY_DETAILS_AMENITIES WHERE amenities_id=?";
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1,amenitiesId);
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
		
		public boolean insert(AmenitiesBean amenitiesBean){
			
			boolean result=false;
			conn=DBConnection.getConnection();
			
			if(conn!=null){
				
				String insertQuery = "INSERT INTO amenities (amenities_name) values(?)";
				
				try{
					pstmt = conn.prepareStatement(insertQuery);
					
					pstmt.setString(1,amenitiesBean.getAmenitiesName());
					
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
		
		public List<AmenitiesBean> list(){
			
			List<AmenitiesBean> listOfAmenities = new ArrayList<AmenitiesBean>();
			conn=DBConnection.getConnection();
			
			if(conn!=null){
					
					String selectSQL = "SELECT *from amenities";
					try{
						
						PreparedStatement pstmt = conn.prepareStatement(selectSQL);
						rs=pstmt.executeQuery();
						
						AmenitiesBean amenitiesBean=null;
						while(rs.next()){
							
							amenitiesBean = new AmenitiesBean();
							
							amenitiesBean.setAmenitiesId(rs.getInt("amenities_id"));
							amenitiesBean.setAmenitiesName(rs.getString("amenities_name"));
							listOfAmenities.add(amenitiesBean);
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
			}System.out.println("Size of list:"+listOfAmenities.size());
			return listOfAmenities;
			
		}
		
		public AmenitiesBean getDataByPK(String amenitiesId){
			
			AmenitiesBean amenitiesBean = new AmenitiesBean();
			conn=DBConnection.getConnection();
			
			if(conn!=null){
				 
				String selectSQL = "SELECT *from amenities WHERE amenities_id=?";
				try{
					pstmt = conn.prepareStatement(selectSQL);
					
					pstmt.setString(1,amenitiesId);
					rs=pstmt.executeQuery();
					
					while(rs.next()){
						amenitiesBean.setAmenitiesId(rs.getInt("amenities_id"));
						amenitiesBean.setAmenitiesName(rs.getString("amenities_name"));
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return amenitiesBean;
		}
		
		public boolean update(AmenitiesBean amenitiesBean){
			
			boolean result=false;
			conn=DBConnection.getConnection();
			
			if(conn!=null){
				String updateSQL = "UPDATE amenities Set amenities_name=? WHERE amenities_id=?";
				try{
					pstmt = conn.prepareStatement(updateSQL);
					pstmt.setString(1,amenitiesBean.getAmenitiesName());
					pstmt.setInt(2,amenitiesBean.getAmenitiesId());
					
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
		
		public boolean delete(String amenitiesId){
			
			boolean result=false;
			conn=DBConnection.getConnection();			
			if(conn!=null){
				String deleteSQl="DELETE from amenities WHERE amenities_id=?";
				
				try{
					PreparedStatement pstmt = conn.prepareStatement(deleteSQl);
					
					pstmt.setString(1,amenitiesId);
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
}
