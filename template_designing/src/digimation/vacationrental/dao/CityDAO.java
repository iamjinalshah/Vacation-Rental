package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.util.DBConnection;

public class CityDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean fkchecking(String cityId){
		boolean result=false;
		conn=DBConnection.getConnection();
		if(conn!=null){
			
			String query = "SELECT * FROM AREA WHERE city_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,cityId);
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
	
	public boolean insert(CityBean cityBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CITY(city_name,state_id) values(?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,cityBean.getCity_name());
				pstmt.setInt(2,cityBean.getState_id());
				
				
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
	
	public List<CityBean> list(){
		List<CityBean> listOfCity = new ArrayList<CityBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT CITY.city_id,CITY.city_name,STATE.state_name FROM CITY inner join STATE on CITY.state_id=STATE.state_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				CityBean cityBean = null;
				while(rs.next()){
					
					cityBean = new CityBean();
					
					cityBean.setCity_id(rs.getInt("city_id"));
					cityBean.setCity_name(rs.getString("city_name"));
					cityBean.setState_name(rs.getString("state_name"));
					
					
					listOfCity.add(cityBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfCity;
		
	}
	
	public boolean delete(String cityId){
		boolean result=false;
		CityBean cityBean = new CityBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM CITY WHERE city_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, cityId);
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
	
	public CityBean getDaatabyPK(String cityId){
		CityBean cityBean = new CityBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM CITY WHERE city_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, cityId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					cityBean.setState_id(rs.getInt("state_id"));
					cityBean.setCity_name(rs.getString("city_name"));
					cityBean.setCity_id(rs.getInt("city_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return cityBean;
		
		
	}
	
	public boolean update(CityBean cityBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE CITY SET city_name=?,state_id=? WHERE city_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,cityBean.getCity_name());
				pstmt.setInt(2, cityBean.getState_id());
				pstmt.setInt(3, cityBean.getCity_id());
				
				
				
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
