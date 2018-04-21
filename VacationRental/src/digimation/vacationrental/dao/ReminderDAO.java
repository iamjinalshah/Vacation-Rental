package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.bean.ReminderBean;
import digimation.vacationrental.util.DBConnection;

public class ReminderDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(ReminderBean reminderBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO REMINDER(details,date,user_id) values(?,?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,reminderBean.getDetails());
				pstmt.setString(2,reminderBean.getDate());
				pstmt.setInt(3, reminderBean.getUser_id());
				
				
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
	
	public List<ReminderBean> list(){
		List<ReminderBean> lsitOfReminder = new ArrayList<ReminderBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM REMINDER inner join USER on REMINDER.user_id=USER.user_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				ReminderBean reminderBean = null;
				while(rs.next()){
					
					reminderBean = new ReminderBean();
					
					reminderBean.setReminder_id(rs.getInt("reminder_id"));
					reminderBean.setDetails(rs.getString("details"));
					reminderBean.setDate(rs.getString("date"));
					reminderBean.setFirst_name(rs.getString("first_name"));
					reminderBean.setLast_name(rs.getString("last_name"));
					
					
					lsitOfReminder.add(reminderBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lsitOfReminder;
			
	}
	
	public boolean delete(String reminderId){
		boolean result=false;
		ReminderBean reminderBean = new ReminderBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM REMINDER WHERE reminder_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, reminderId);
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
	
	public ReminderBean getDatabyPK(String reminderId){
		ReminderBean reminderBean = new  ReminderBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM REMINDER WHERE reminder_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, reminderId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					reminderBean.setReminder_id(rs.getInt("reminder_id"));
					reminderBean.setDetails(rs.getString("details"));
					reminderBean.setDate(rs.getString("date"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return reminderBean;
		
		
	}
	
	public boolean update(ReminderBean reminderBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE REMINDER SET details=?,date=? WHERE reminder_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,reminderBean.getDetails());
				pstmt.setString(2,reminderBean.getDate());
				pstmt.setInt(3, reminderBean.getReminder_id());
				
				
				
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
