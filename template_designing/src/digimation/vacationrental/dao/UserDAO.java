package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.chrono.IsoEra;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AdminBean;
import digimation.vacationrental.bean.UserBean;
import digimation.vacationrental.util.DBConnection;
import jsx3.net.Request;

public class UserDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(UserBean userBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO USER(first_name,middle_name,last_name,email_id,password,mobile,landline,gender,address,dob,isactive,que_id,answer,profile_photo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,userBean.getFirst_name());
				pstmt.setString(2, userBean.getMiddle_name());
				pstmt.setString(3, userBean.getLast_name());
				pstmt.setString(4,userBean.getEmail_id());
				pstmt.setString(5, userBean.getPassword());
				pstmt.setString(6,userBean.getMobile());
				pstmt.setString(7,userBean.getLandline());
				pstmt.setString(8,userBean.getGender());
				pstmt.setString(9,userBean.getAddress());
				pstmt.setString(10,userBean.getDob());
				pstmt.setInt(11,1);
				pstmt.setInt(12, userBean.getQue_id());
				pstmt.setString(13, userBean.getAnswer());
				pstmt.setString(14, userBean.getPhoto());
				
				
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
	
	public boolean accountInfoInsert(UserBean userBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO USER_ACCOUNT_INFO(bank_name,account_no,ifsc_code,user_id) values(?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,userBean.getBank_name());
				pstmt.setString(2, userBean.getAccount_no());
				pstmt.setString(3, userBean.getIfsc_code());
				pstmt.setInt(4,userBean.getUser_id());
				
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
	
	public List<UserBean> list(){
		List<UserBean> listOfUser = new ArrayList<UserBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM USER inner join QUE_TABLE on USER.que_id=QUE_TABLE.que_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				UserBean userBean = null;
				while(rs.next()){
					
					userBean = new UserBean();
					
					userBean.setUser_id(rs.getInt("user_id"));
					userBean.setFirst_name(rs.getString("first_name"));
					userBean.setMiddle_name(rs.getString("middle_name"));
					userBean.setLast_name(rs.getString("last_name"));
					userBean.setEmail_id(rs.getString("email_id"));
					userBean.setPassword(rs.getString("password"));
					userBean.setMobile(rs.getString("mobile"));
					userBean.setLandline(rs.getString("landline"));
					userBean.setGender(rs.getString("gender"));
					userBean.setAddress(rs.getString("address"));
					userBean.setDob(rs.getString("dob"));
					userBean.setIsactive(rs.getBoolean("isactive"));
					userBean.setQuestion(rs.getString("question"));
					userBean.setAnswer(rs.getString("answer"));
					userBean.setPhoto(rs.getString("profile_photo"));
					
					listOfUser.add(userBean);
					
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("users:"+listOfUser.size());
		return listOfUser;
			
	}
	
	
	public boolean delete(String userId){
		boolean result=false;
		UserBean  userBean = new UserBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM USER WHERE user_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
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
	public UserBean getDatabyPK(String userId){
		UserBean userBean = new UserBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM USER WHERE user_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					userBean.setUser_id(rs.getInt("user_id"));
					userBean.setFirst_name(rs.getString("first_name"));
					userBean.setMiddle_name(rs.getString("middle_name"));
					userBean.setLast_name(rs.getString("last_name"));
					userBean.setEmail_id(rs.getString("email_id"));
					userBean.setPassword(rs.getString("password"));
					userBean.setMobile(rs.getString("mobile"));
					userBean.setLandline(rs.getString("landline"));
					userBean.setGender(rs.getString("gender"));
					userBean.setAddress(rs.getString("address"));
					userBean.setDob(rs.getString("dob"));
					userBean.setIsactive(rs.getBoolean("isactive"));
					userBean.setQue_id(rs.getInt("que_id"));
					userBean.setAnswer(rs.getString("answer"));
					userBean.setPhoto(rs.getString("profile_photo"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return userBean;
		
	}
	
	public boolean update(UserBean userBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE USER SET first_name=?,middle_name=?,last_name=?,email_id=?,password=?,mobile=?,landline=?,address=?,dob=?,que_id=?,answer=? WHERE user_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,userBean.getFirst_name());
				pstmt.setString(2, userBean.getMiddle_name());
				pstmt.setString(3, userBean.getLast_name());
				pstmt.setString(4,userBean.getEmail_id());
				pstmt.setString(5, userBean.getPassword());
				pstmt.setString(6,userBean.getMobile());
				pstmt.setString(7,userBean.getLandline());
				pstmt.setString(8,userBean.getAddress());
				pstmt.setString(9,userBean.getDob());
				pstmt.setInt(10, userBean.getQue_id());
				pstmt.setString(11, userBean.getAnswer());
				pstmt.setInt(12,userBean.getUser_id());
				
				
				
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
	
	public boolean Accountupdate(UserBean userBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE USER_ACCOUNT_INFO SET bank_name=?,account_no=?,ifsc_code=? WHERE user_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,userBean.getBank_name());
				pstmt.setString(2,userBean.getAccount_no());
				pstmt.setString(3,userBean.getIfsc_code());
				pstmt.setInt(4,userBean.getUser_id());
				
				System.out.println(insertSQL);
				
				
				
				
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
	
	
	public boolean isActiveTrue(String userId){
		boolean result=false;
		UserBean userBean = new UserBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE USER SET isactive=? WHERE user_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,1);
				pstmt.setString(2,userId);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected>0){
					result=true;
					System.out.println(rowAffected+"Row(s) updated");
				}else{
					System.out.println(rowAffected+"Row(s) updated");
				}
			} catch (SQLException e) {
			}
			
		}
		return result;
		
		
	}
	
	public boolean isActiveFalse(String userId){
		boolean result=false;
		UserBean userBean = new UserBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "UPDATE USER SET isactive=? WHERE user_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,0);
				pstmt.setString(2,userId);
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected>0){
					result=true;
					System.out.println(rowAffected+"Row(s) updated");
				}else{
					System.out.println(rowAffected+"Row(s) updated");
				}
			} catch (SQLException e) {
			}
			
		}
		return result;
		
		
	}
	
	public List<UserBean> Blockedlist(){
		List<UserBean> listOfUser = new ArrayList<UserBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM USER inner join QUE_TABLE on USER.que_id=QUE_TABLE.que_id where isactive=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 0);
				rs= pstmt.executeQuery();
				
				UserBean userBean = null;
				while(rs.next()){
					
					userBean = new UserBean();
					
					userBean.setUser_id(rs.getInt("user_id"));
					userBean.setFirst_name(rs.getString("first_name"));
					userBean.setMiddle_name(rs.getString("middle_name"));
					userBean.setLast_name(rs.getString("last_name"));
					userBean.setEmail_id(rs.getString("email_id"));
					userBean.setPassword(rs.getString("password"));
					userBean.setMobile(rs.getString("mobile"));
					userBean.setLandline(rs.getString("landline"));
					userBean.setGender(rs.getString("gender"));
					userBean.setAddress(rs.getString("address"));
					userBean.setDob(rs.getString("dob"));
					userBean.setIsactive(rs.getBoolean("isactive"));
					userBean.setQuestion(rs.getString("question"));
					userBean.setAnswer(rs.getString("answer"));
					userBean.setPhoto(rs.getString("profile_photo"));
					
					listOfUser.add(userBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfUser;
			
	}
	
	public UserBean login(UserBean userBean){
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM USER join QUE_TABLE on USER.que_id=QUE_TABLE.que_id WHERE email_id=? AND password=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userBean.getEmail_id());
				pstmt.setString(2, userBean.getPassword());
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					userBean.setUser_id(rs.getInt("user_id"));
					userBean.setFirst_name(rs.getString("first_name"));
					userBean.setMiddle_name(rs.getString("middle_name"));
					userBean.setLast_name(rs.getString("last_name"));
					userBean.setEmail_id(rs.getString("email_id"));
					userBean.setPassword(rs.getString("password"));
					userBean.setMobile(rs.getString("mobile"));
					userBean.setLandline(rs.getString("landline"));
					userBean.setGender(rs.getString("gender"));
					userBean.setAddress(rs.getString("address"));
					userBean.setDob(rs.getString("dob"));
					userBean.setIsactive(rs.getBoolean("isactive"));
					userBean.setPhoto(rs.getString("profile_photo"));
					userBean.setQue_id(rs.getInt("que_id"));
					userBean.setQuestion(rs.getString("question"));
					userBean.setAnswer(rs.getString("answer"));
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return userBean;
		
	}
	
	public boolean Passwordupdate(UserBean userBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE USER SET password=? WHERE user_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				
				pstmt.setString(1, userBean.getPassword());
				pstmt.setInt(2,userBean.getUser_id());
				
				
				
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

	public UserBean Account_info(String userId){
		UserBean userBean = new UserBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM USER_ACCOUNT_INFO WHERE user_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					userBean.setAccount_no(rs.getString("account_no"));
					userBean.setBank_name(rs.getString("bank_name"));
					userBean.setIfsc_code(rs.getString("ifsc_code"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return userBean;
		
	}
	

}
