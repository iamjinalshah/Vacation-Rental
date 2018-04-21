package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import digimation.vacationrental.bean.CarBrandBean;
import digimation.vacationrental.util.DBConnection;

public class CarBrandDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(CarBrandBean carBrandBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CAR_BRANDS(carbrand_name) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,carBrandBean.getCarBrand_Name());
				
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
	
	public List<CarBrandBean> list(){
		
		List<CarBrandBean> listOfCarBrands = new ArrayList<CarBrandBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from CAR_BRANDS";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				CarBrandBean carBrandBean = null;
				while(rs.next()){
					carBrandBean = new CarBrandBean();
				
					carBrandBean.setCarBrand_id(rs.getInt("carbrand_id"));
					carBrandBean.setCarBrand_Name(rs.getString("carbrand_name"));
				
					listOfCarBrands.add(carBrandBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfCarBrands;
	}
	
	public boolean delete(String carBrandId) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM CAR_BRANDS WHERE carbrand_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,carBrandId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public CarBrandBean getDataByPK(String carBrandId){
		
		CarBrandBean carBrandBean = new CarBrandBean();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from CAR_BRANDS WHERE carbrand_id=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, carBrandId);
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					
				
					carBrandBean.setCarBrand_id(rs.getInt("carbrand_id"));
					carBrandBean.setCarBrand_Name(rs.getString("carbrand_name"));
				
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return carBrandBean;
	}
	public boolean update(CarBrandBean carBrandBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE CAR_BRANDS set carbrand_name=? WHERE carbrand_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,carBrandBean.getCarBrand_Name());
				pstmt.setInt(2, carBrandBean.getCarBrand_id());
				
				
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
