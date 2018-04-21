package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.bean.LanguageBean;
import digimation.vacationrental.util.DBConnection;

public class GLDetailsDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(GLDetailsBean glDetailsBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO GUIDE_LANGUAGES_DETAILS(tourguide_id,GL_id) values(?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1,glDetailsBean.getTourguide_id());
				pstmt.setInt(2,glDetailsBean.getGL_id());
				
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
	
public List<GLDetailsBean> list(){
		
		List<GLDetailsBean> listOfLanguages = new ArrayList<GLDetailsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from GUIDE_LANGUAGES_DETAILS join GUIDE_LANGUAGES on GUIDE_LANGUAGES_DETAILS.gl_id=GUIDE_LANGUAGES.guidelanguage_id join TOUR_GUIDE on TOUR_GUIDE.tourguide_id=GUIDE_LANGUAGES_DETAILS.tourguide_id";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				GLDetailsBean glDetailsBean = null;
				while(rs.next()){
					glDetailsBean = new GLDetailsBean();
				
					glDetailsBean.setLanguage_id(rs.getInt("language_id"));
					glDetailsBean.setTourguide_name(rs.getString("first_name"));
					glDetailsBean.setGl_name(rs.getString("guidelanguage_name"));
				
					listOfLanguages.add(glDetailsBean);
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
		 String deleteSQL = "DELETE FROM GUIDE_LANGUAGES_DETAILS WHERE language_id=?";
		 
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

public GLDetailsBean getDataByPK(String languageId){
	
	GLDetailsBean glDetailsBean = new GLDetailsBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from GUIDE_LANGUAGES_DETAILS WHERE language_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, languageId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			
				glDetailsBean.setLanguage_id(rs.getInt("language_id"));
				glDetailsBean.setTourguide_id(rs.getInt("tourguide_id"));
				glDetailsBean.setGL_id(rs.getInt("gl_id"));
			
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return glDetailsBean;
}

public boolean update(GLDetailsBean glDetailsBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE GUIDE_LANGUAGES_DETAILS set tourguide_id=?,gl_id=? WHERE language_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setInt(1,glDetailsBean.getTourguide_id());
			pstmt.setInt(2, glDetailsBean.getGL_id());
			pstmt.setInt(3, glDetailsBean.getLanguage_id());
			
			
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
