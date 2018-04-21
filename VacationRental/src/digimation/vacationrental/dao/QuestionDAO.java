package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import digimation.vacationrental.bean.QuestionBean;
import digimation.vacationrental.util.DBConnection;


public class QuestionDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(QuestionBean questionBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO QUE_TABLE(question) values(?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,questionBean.getQuestion());
				
				
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
	
	public List<QuestionBean> list(){
		List<QuestionBean> question = new ArrayList<QuestionBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM que_table";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				QuestionBean questionBean = null;
				while(rs.next()){
					
					questionBean = new QuestionBean();
					
					questionBean.setQue_id(rs.getInt("que_id"));
					questionBean.setQuestion(rs.getString("question"));
					
					
					question.add(questionBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return question;
			
	}
	
	public QuestionBean getDatabyPK(String Id){
		QuestionBean questionBean = new QuestionBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM que_table WHERE que_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					questionBean.setQue_id(rs.getInt("que_id"));
					questionBean.setQuestion(rs.getString("question"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return questionBean;
		
		
	}
	
	public boolean update(QuestionBean questionBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE QUE_TABLE SET question=? WHERE que_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,questionBean.getQuestion());
				pstmt.setInt(2, questionBean.getQue_id());
				
				
				
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
	
	
	public boolean delete(String questionId){
		boolean result=false;
		QuestionBean questionBean = new QuestionBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM que_table WHERE que_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, questionId);
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

