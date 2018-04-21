package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.util.DBConnection;

public class CountryDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	
	public boolean fkchecking(String countryId){
		boolean result=false;
		conn=DBConnection.getConnection();
		if(conn!=null){
			
			String query = "SELECT * FROM STATE WHERE country_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,countryId);
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
	
	public boolean duplicate(CountryBean countryBean){
		boolean result=false;
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM COUNTRY WHERE country_name=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, countryBean.getCountry_name());
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					countryBean.setCountry_name(rs.getString("country_name"));
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return result;
		
		
	}
	
	public boolean insert(CountryBean countryBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO COUNTRY(country_name) values(?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,countryBean.getCountry_name());
				
				
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
	
	public List<CountryBean> list(){
		List<CountryBean> country = new ArrayList<CountryBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM COUNTRY";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				CountryBean countryBean = null;
				while(rs.next()){
					
					countryBean = new CountryBean();
					
					countryBean.setCountry_id(rs.getInt("country_id"));
					countryBean.setCountry_name(rs.getString("country_name"));
					
					
					country.add(countryBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return country;
			
	}
	
	public CountryBean getDatabyPK(String Id){
		CountryBean countryBean = new CountryBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM COUNTRY WHERE country_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					countryBean.setCountry_id(rs.getInt("country_id"));
					countryBean.setCountry_name(rs.getString("country_name"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return countryBean;
		
		
	}
	
	public boolean update(CountryBean countryBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE COUNTRY SET country_name=? WHERE country_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,countryBean.getCountry_name());
				pstmt.setInt(2, countryBean.getCountry_id());
				
				
				
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
	
	
	public boolean delete(String countryId){
		boolean result=false;
		CountryBean countryBean = new CountryBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM COUNTRY WHERE country_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, countryId);
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
