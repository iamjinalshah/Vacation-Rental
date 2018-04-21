package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.util.DBConnection;

public class LanguageDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(LanguageBean languageBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO GUIDE_LANGUAGES(guidelanguage_name) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,languageBean.getLanguage_Name());
				
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

		public List<LanguageBean> list(){
		
		List<LanguageBean> listOfLanguages = new ArrayList<LanguageBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from GUIDE_LANGUAGES";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				LanguageBean languageBean = null;
				while(rs.next()){
					languageBean = new LanguageBean();
				
					languageBean.setLanguage_Id(rs.getInt("guidelanguage_id"));
					languageBean.setLanguage_Name(rs.getString("guidelanguage_name"));
				
					listOfLanguages.add(languageBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfLanguages;
	}
		
		public boolean delete(String languageId) {
			 boolean result = false;
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "DELETE FROM GUIDE_LANGUAGES WHERE guidelanguage_id=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,languageId);
				
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
		
		public LanguageBean getDataByPK(String languageId){
			
			LanguageBean languageBean = new LanguageBean();
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String selectSQL = "Select * from GUIDE_LANGUAGES WHERE guidelanguage_id=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, languageId);
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						
					
						languageBean.setLanguage_Id(rs.getInt("guidelanguage_id"));
						languageBean.setLanguage_Name(rs.getString("guidelanguage_name"));
					
						
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
				 
			 }
			return languageBean;
		}
		
		public boolean update(LanguageBean languageBean) {
			 boolean result = false;
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String updateSQL = "UPDATE GUIDE_LANGUAGES set guidelanguage_name=? WHERE guidelanguage_id=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					pstmt.setString(1,languageBean.getLanguage_Name());
					pstmt.setInt(2, languageBean.getLanguage_Id());
					
					
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
