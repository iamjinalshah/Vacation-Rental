package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.StateBean;
import digimation.vacationrental.util.DBConnection;

public class StateDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean fkchecking(String stateId){
		boolean result=false;
		conn=DBConnection.getConnection();
		if(conn!=null){
			
			String query = "SELECT * FROM CITY WHERE state_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,stateId);
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
	
	public boolean insert(StateBean stateBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO STATE(state_name,country_id) values(?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,stateBean.getState_name());
				pstmt.setInt(2,stateBean.getState_id());
				
				
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
	
	public List<StateBean> list(){
		List<StateBean> listOfState = new ArrayList<StateBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT STATE.state_id,STATE.state_name,COUNTRY.country_name FROM STATE inner join COUNTRY on STATE.country_id=COUNTRY.country_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				StateBean stateBean = null;
				while(rs.next()){
					
					stateBean = new StateBean();
					
					stateBean.setState_id(rs.getInt("state_id"));
					stateBean.setState_name(rs.getString("state_name"));
					stateBean.setCountry_name(rs.getString("country_name"));
					
					
					listOfState.add(stateBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfState;
		
	}
			
	public boolean delete(String stateId){
		boolean result=false;
		StateBean stateBean = new StateBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM STATE WHERE state_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, stateId);
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
	
	public StateBean getDaatabyPK(String stateId){
		StateBean stateBean = new StateBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM STATE WHERE state_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, stateId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					stateBean.setCountry_id(rs.getInt("country_id"));
					stateBean.setState_name(rs.getString("state_name"));
					stateBean.setState_id(rs.getInt("state_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return stateBean;
		
		
	}
	
	public boolean update(StateBean stateBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE STATE SET state_name=?,country_id=? WHERE state_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,stateBean.getState_name());
				pstmt.setInt(2, stateBean.getCountry_id());
				pstmt.setInt(3, stateBean.getState_id());
				
				
				
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
