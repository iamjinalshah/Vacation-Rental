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
	
public List<PropertyDetailsAmenitiesBean> Amenitieslist(String propertyId){
		
		List<PropertyDetailsAmenitiesBean> listOfPDA = new ArrayList<PropertyDetailsAmenitiesBean>();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
				
				String selectSQL = "SELECT *from property_details_amenities inner join amenities on property_details_amenities.amenities_id=amenities.amenities_id join property_photos on property_photos.propertyphoto_id=property_details_amenities.propertyphoto_id join property_details on property_details.property_id=property_photos.property_id where property_details.property_id=?";
				try{
					
					PreparedStatement pstmt = conn.prepareStatement(selectSQL);
					pstmt.setString(1, propertyId);
					rs=pstmt.executeQuery();
					
					PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean=null;
					while(rs.next()){
						
						propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesBean();
						
						propertyDetailsAmenitiesBean.setAmenities_id(rs.getInt("amenities_id"));
						propertyDetailsAmenitiesBean.setPDA_id(rs.getInt("PDA_id"));
						propertyDetailsAmenitiesBean.setProperty_id(rs.getInt("property_id"));
						propertyDetailsAmenitiesBean.setAmenities_name(rs.getString("amenities_name"));
						
						listOfPDA.add(propertyDetailsAmenitiesBean);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		System.out.println("List:"+listOfPDA);
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
	
		public PropertyDetailsAmenitiesBean PropertyAllInfo(int pdaId){
		
		PropertyDetailsAmenitiesBean propertyDetailsAmenitiesBean = new PropertyDetailsAmenitiesBean();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			 
			String selectSQL = "SELECT *from property_details_amenities inner join amenities on property_details_amenities.amenities_id=amenities.amenities_id join property_details on property_details.property_id=property_details_amenities.property_id join user on user.user_id=property_details.user_id join user_account_info on user_account_info.user_id=user.user_id join city on city.city_id=property_details.city_id join area on area.area_id=property_details.area_id join property_type on property_type.ptype_id=property_details.ptype_id where property_details.property_id=?";
			try{
				pstmt = conn.prepareStatement(selectSQL);
				
				pstmt.setInt(1,pdaId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					propertyDetailsAmenitiesBean.setPDA_id(rs.getInt("PDA_id"));
					propertyDetailsAmenitiesBean.setAmenities_id(rs.getInt("amenities_id"));
					propertyDetailsAmenitiesBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsAmenitiesBean.setAccount_id(rs.getInt("account_id"));
					propertyDetailsAmenitiesBean.setFirst_name(rs.getString("first_name"));
					propertyDetailsAmenitiesBean.setMiddle_name(rs.getString("middle_name"));
					propertyDetailsAmenitiesBean.setLast_name(rs.getString("last_name"));
					propertyDetailsAmenitiesBean.setEmail_id(rs.getString("email_id"));
					propertyDetailsAmenitiesBean.setPmobile(rs.getString("pmobile"));
					propertyDetailsAmenitiesBean.setPlandline(rs.getString("plandline"));
					propertyDetailsAmenitiesBean.setProperty_id(rs.getInt("property_id"));
					propertyDetailsAmenitiesBean.setProperty_title(rs.getString("property_title"));
					propertyDetailsAmenitiesBean.setAddress(rs.getString("address"));
					propertyDetailsAmenitiesBean.setRate(rs.getInt("rate"));
					propertyDetailsAmenitiesBean.setArea_name(rs.getString("area_name"));
					propertyDetailsAmenitiesBean.setCity_name(rs.getString("city_name"));
					propertyDetailsAmenitiesBean.setCity_id(rs.getInt("city_id"));
					propertyDetailsAmenitiesBean.setPtype_id(rs.getInt(rs.getInt("ptype_id")));
					propertyDetailsAmenitiesBean.setType_name(rs.getString("type_name"));
					propertyDetailsAmenitiesBean.setAmenities_name(rs.getString("amenities_name"));
					propertyDetailsAmenitiesBean.setAccount_no(rs.getString("account_no"));
					propertyDetailsAmenitiesBean.setBank_name(rs.getString("bank_name"));
					propertyDetailsAmenitiesBean.setIfsc_code(rs.getString("ifsc_code"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return propertyDetailsAmenitiesBean;
	}
		
		
		public boolean allPropertyInfodelete(int pda_id,int amenities_id,int property_id,int account_id){
			
			boolean result=false;
			conn=DBConnection.getConnection();			
			if(conn!=null){
				String deleteSQl="DELETE from property_details_amenities WHERE PDA_id=?";
				
				try{
					PreparedStatement pstmt = conn.prepareStatement(deleteSQl);
					pstmt.setInt(1,pda_id);
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;
						System.out.println(rowsAffected + " Row(s) pda Deleted......");

					} else {
						System.out.println(rowsAffected + " Row(s) pda Deleted......");

					}
					
					if(result==true){
						
						/*String deleteSQl1="DELETE from property_photos WHERE propertyphoto_id=?";
						
						
							PreparedStatement pstmt1 = conn.prepareStatement(deleteSQl1);
							pstmt1.setInt(1,photo_id);
							int rowsAffected1 = pstmt1.executeUpdate();
							
							if (rowsAffected1 > 0) {
								result=true;
								System.out.println(rowsAffected1 + " Row(s) photo Deleted......");

							} else {
								System.out.println(rowsAffected1 + " Row(s) photo Deleted......");

							}
							
							if(result==true){*/
								
								String deleteSQl2="DELETE from amenities WHERE amenities_id=?";
								
								
								PreparedStatement pstmt2 = conn.prepareStatement(deleteSQl2);
								pstmt2.setInt(1,amenities_id);
								int rowsAffected2 = pstmt2.executeUpdate();
								
								if (rowsAffected2 > 0) {
									result=true;
									System.out.println(rowsAffected2 + " Row(s) amenities Deleted......");

								} else {
									System.out.println(rowsAffected2 + " Row(s) amenities Deleted......");

							
								}
								if(result==true){
									
									String deleteSQl3="DELETE from property_details WHERE property_id=?";
									
									
									PreparedStatement pstmt3 = conn.prepareStatement(deleteSQl3);
									pstmt3.setInt(1,property_id);
									int rowsAffected3 = pstmt3.executeUpdate();
									
									if (rowsAffected3 > 0) {
										result=true;
										System.out.println(rowsAffected3 + " Row(s) property Deleted......");

									} else {
										System.out.println(rowsAffected3 + " Row(s) property Deleted......");

									}
									if(result==true){
										String deleteSQl4="DELETE from user_account_info WHERE account_id=?";
										
										
										PreparedStatement pstmt4 = conn.prepareStatement(deleteSQl4);
										pstmt4.setInt(1,account_id);
										int rowsAffected4 = pstmt4.executeUpdate();
										
										if (rowsAffected3 > 0) {
											result=true;
											System.out.println(rowsAffected4 + " Row(s) account  Deleted......");

										} else {
											System.out.println(rowsAffected4 + " Row(s) account Deleted......");

										}
									}
								
							}
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return false;
		}
		
	
}
