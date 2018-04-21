package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.CountryBean;
import digimation.vacationrental.util.DBConnection;


public class AdminDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(AdminBean adminBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO ADMIN(first_name,middle_name,last_name,email_id,password,mobile,landline,gender,address,dob,isactive,idproof,que_id,answer) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,adminBean.getFirst_name());
				pstmt.setString(2, adminBean.getMiddle_name());
				pstmt.setString(3, adminBean.getLast_name());
				pstmt.setString(4,adminBean.getEmail_id());
				pstmt.setString(5, adminBean.getPassword());
				pstmt.setInt(6,adminBean.getMobile());
				pstmt.setInt(7,adminBean.getLandline());
				pstmt.setString(8,adminBean.getGender());
				pstmt.setString(9,adminBean.getAddress());
				pstmt.setString(10,adminBean.getDob());
				pstmt.setInt(11,0);
				pstmt.setString(12, adminBean.getPhoto());
				pstmt.setInt(13, adminBean.getQue_id());
				pstmt.setString(14, adminBean.getAnswer());
				
				
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
	
	public List<AdminBean> list(){
		List<AdminBean> listOfAdmin = new ArrayList<AdminBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ADMIN inner join QUE_TABLE on ADMIN.que_id=QUE_TABLE.que_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				AdminBean adminBean = null;
				while(rs.next()){
					
					adminBean = new AdminBean();
					
					adminBean.setAdmin_id(rs.getInt("admin_id"));
					adminBean.setFirst_name(rs.getString("first_name"));
					adminBean.setMiddle_name(rs.getString("middle_name"));
					adminBean.setLast_name(rs.getString("last_name"));
					adminBean.setEmail_id(rs.getString("email_id"));
					adminBean.setPassword(rs.getString("password"));
					adminBean.setMobile(rs.getInt("mobile"));
					adminBean.setLandline(rs.getInt("landline"));
					adminBean.setGender(rs.getString("gender"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setDob(rs.getString("dob"));
					adminBean.setIsactive(rs.getBoolean("isactive"));
					adminBean.setPhoto(rs.getString("idproof"));
					adminBean.setQuestion(rs.getString("question"));
					adminBean.setAnswer(rs.getString("answer"));
					
					
					listOfAdmin.add(adminBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfAdmin;
			
	}
	
	public boolean delete(String adminId){
		boolean result=false;
		AdminBean adminBean = new AdminBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM ADMIN WHERE admin_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, adminId);
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
	
	public AdminBean getDatabyPK(String adminId){
		AdminBean adminBean = new AdminBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM ADMIN WHERE admin_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, adminId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					adminBean.setAdmin_id(rs.getInt("admin_id"));
					adminBean.setFirst_name(rs.getString("first_name"));
					adminBean.setMiddle_name(rs.getString("middle_name"));
					adminBean.setLast_name(rs.getString("last_name"));
					adminBean.setEmail_id(rs.getString("email_id"));
					adminBean.setPassword(rs.getString("password"));
					adminBean.setMobile(rs.getInt("mobile"));
					adminBean.setLandline(rs.getInt("landline"));
					adminBean.setGender(rs.getString("gender"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setDob(rs.getString("dob"));
					adminBean.setIsactive(rs.getBoolean("isactive"));
					adminBean.setPhoto(rs.getString("idproof"));
					adminBean.setQue_id(rs.getInt("que_id"));
					adminBean.setAnswer(rs.getString("answer"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return adminBean;
		
	}

	public boolean update(AdminBean adminBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE ADMIN SET first_name=?,middle_name=?,last_name=?,email_id=?,password=?,mobile=?,landline=?,gender=?,address=?,dob=?,idproof=?,que_id=?,answer=? WHERE admin_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,adminBean.getFirst_name());
				pstmt.setString(2, adminBean.getMiddle_name());
				pstmt.setString(3, adminBean.getLast_name());
				pstmt.setString(4,adminBean.getEmail_id());
				pstmt.setString(5, adminBean.getPassword());
				pstmt.setInt(6,adminBean.getMobile());
				pstmt.setInt(7,adminBean.getLandline());
				pstmt.setString(8,adminBean.getGender());
				pstmt.setString(9,adminBean.getAddress());
				pstmt.setString(10,adminBean.getDob());
				pstmt.setString(11, adminBean.getPhoto());
				pstmt.setInt(12, adminBean.getQue_id());
				pstmt.setString(13, adminBean.getAnswer());
				pstmt.setInt(14,adminBean.getAdmin_id());
				
				
				
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
	
	public AdminBean login(AdminBean adminBean){
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM ADMIN WHERE email_id=? AND password=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, adminBean.getEmail_id());
				pstmt.setString(2, adminBean.getPassword());
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					adminBean.setAdmin_id(rs.getInt("admin_id"));
					adminBean.setFirst_name(rs.getString("first_name"));
					adminBean.setMiddle_name(rs.getString("middle_name"));
					adminBean.setLast_name(rs.getString("last_name"));
					adminBean.setEmail_id(rs.getString("email_id"));
					adminBean.setPassword(rs.getString("password"));
					adminBean.setMobile(rs.getString("mobile"));
					adminBean.setLandline(rs.getString("landline"));
					adminBean.setGender(rs.getString("gender"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setDob(rs.getString("dob"));
					adminBean.setIsactive(rs.getBoolean("isactive"));
					adminBean.setPhoto(rs.getString("idproof"));
					adminBean.setQue_id(rs.getInt("que_id"));
					adminBean.setAnswer(rs.getString("answer"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return adminBean;
		
	}
	public AdminBean ForgotPassword(String txtEmail){
		AdminBean adminBean = new AdminBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM ADMIN inner join QUE_TABLE on ADMIN.que_id=QUE_TABLE.que_id where ADMIN.email_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, txtEmail);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					adminBean.setAdmin_id(rs.getInt("admin_id"));
					adminBean.setFirst_name(rs.getString("first_name"));
					adminBean.setMiddle_name(rs.getString("middle_name"));
					adminBean.setLast_name(rs.getString("last_name"));
					adminBean.setEmail_id(rs.getString("email_id"));
					adminBean.setPassword(rs.getString("password"));
					adminBean.setMobile(rs.getInt("mobile"));
					adminBean.setLandline(rs.getInt("landline"));
					adminBean.setGender(rs.getString("gender"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setDob(rs.getString("dob"));
					adminBean.setIsactive(rs.getBoolean("isactive"));
					adminBean.setPhoto(rs.getString("idproof"));
					adminBean.setQuestion(rs.getString("question"));
					adminBean.setAnswer(rs.getString("answer"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return adminBean;
		
	}
	
	public boolean Passwordupdate(AdminBean adminBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE ADMIN SET password=? WHERE admin_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				
				pstmt.setString(1, adminBean.getPassword());
				pstmt.setInt(2,adminBean.getAdmin_id());
				
				
				
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
