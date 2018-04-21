package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CarDetailsBean;
import digimation.vacationrental.util.DBConnection;

public class CarDetailsDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(CarDetailsBean carDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CAR_DETAILS(capacity,manager_name,email_id,mobile,landline,isavailable,area_id,city_id,carbrand_id,carmodel_id,state_id) values(?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, carDetailsBean.getCapacity());
				pstmt.setString(2, carDetailsBean.getManager_name());
				pstmt.setString(3,carDetailsBean.getEmail_id());
				pstmt.setInt(4, carDetailsBean.getMobile());
				pstmt.setInt(5,carDetailsBean.getLandline());
				pstmt.setInt(6,0);
				pstmt.setInt(7,carDetailsBean.getArea_id());
				pstmt.setInt(8,carDetailsBean.getCity_id());
				pstmt.setInt(9,carDetailsBean.getCarbrand_id());
				pstmt.setInt(10, carDetailsBean.getCarmodel_id());
				pstmt.setInt(11, carDetailsBean.getState_id());
				
				
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
	
	public List<CarDetailsBean> list(){
		List<CarDetailsBean> listOfcar = new ArrayList<CarDetailsBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM CAR_DETAILS inner join AREA on CAR_DETAILS.area_id=AREA.area_id join CITY on CAR_DETAILS.city_id=CITY.city_id join CAR_BRANDS on CAR_BRANDS.carbrand_id=CAR_DETAILS.carbrand_id join CAR_MODELS on CAR_DETAILS.carmodel_id=CAR_MODELS.carmodel_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				CarDetailsBean carDetailsBean = null;
				while(rs.next()){
					
					carDetailsBean = new CarDetailsBean();
					
					carDetailsBean.setCar_id(rs.getInt("car_id"));
					carDetailsBean.setCapacity(rs.getInt("capacity"));
					carDetailsBean.setManager_name(rs.getString("manager_name"));
					carDetailsBean.setEmail_id(rs.getString("email_id"));
					carDetailsBean.setMobile(rs.getInt("mobile"));
					carDetailsBean.setLandline(rs.getInt("landline"));
					carDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					carDetailsBean.setArea_name(rs.getString("area_name"));
					carDetailsBean.setCity_name(rs.getString("city_name"));
					carDetailsBean.setCarbrand_name(rs.getString("carbrand_name"));
					carDetailsBean.setCarmodel_name(rs.getString("carmodel_name"));
					
					listOfcar.add(carDetailsBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfcar;
			
	}
	
	public boolean delete(String carId){
		boolean result=false;
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM CAR_DETAILS WHERE car_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,carId);
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
	
	public CarDetailsBean getDatabyPK(String carId){
		CarDetailsBean carDetailsBean = new CarDetailsBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM CAR_DETAILS WHERE car_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, carId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					carDetailsBean.setCar_id(rs.getInt("car_id"));
					carDetailsBean.setCapacity(rs.getInt("capacity"));
					carDetailsBean.setManager_name(rs.getString("manager_name"));
					carDetailsBean.setEmail_id(rs.getString("email_id"));
					carDetailsBean.setMobile(rs.getInt("mobile"));
					carDetailsBean.setLandline(rs.getInt("landline"));
					carDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
					carDetailsBean.setArea_id(rs.getInt("area_id"));
					carDetailsBean.setCity_id(rs.getInt("city_id"));
					carDetailsBean.setCarbrand_id(rs.getInt("carbrand_id"));
					carDetailsBean.setCarmodel_id(rs.getInt("carmodel_id"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return carDetailsBean;
		
	}
	
	public boolean update(CarDetailsBean carDetailsBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE CAR_DETAILS SET capacity=?,manager_name=?,email_id=?,mobile=?,landline=?,area_id=?,city_id=?,carbrand_id=?,carmodel_id=? WHERE car_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, carDetailsBean.getCapacity());
				pstmt.setString(2, carDetailsBean.getManager_name());
				pstmt.setString(3,carDetailsBean.getEmail_id());
				pstmt.setInt(4,carDetailsBean.getMobile());
				pstmt.setInt(5,carDetailsBean.getLandline());
				pstmt.setInt(6,carDetailsBean.getArea_id());
				pstmt.setInt(7,carDetailsBean.getCity_id());
				pstmt.setInt(8,carDetailsBean.getCarbrand_id());
				pstmt.setInt(9,carDetailsBean.getCarmodel_id());
				pstmt.setInt(10,carDetailsBean.getCar_id());
				
				
				
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
