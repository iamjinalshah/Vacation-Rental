package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CousinBean;
import digimation.vacationrental.util.DBConnection;

public class CousinDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(CousinBean cousinBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CUSINES_DETAILS(cusine_name) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,cousinBean.getCousin_name());
				
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

	
public List<CousinBean> list(){
		
		List<CousinBean> listOfCousins = new ArrayList<CousinBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from CUSINES_DETAILS";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				CousinBean cousinBean = null;
				while(rs.next()){
					cousinBean = new CousinBean();
				
					cousinBean.setCousin_id(rs.getInt("cusine_id"));
					cousinBean.setCousin_name(rs.getString("cusine_name"));
				
					listOfCousins.add(cousinBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfCousins;
	}

		public boolean delete(String cousinId) {
		boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM CUSINES_DETAILS WHERE cusine_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,cousinId);
		
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
		
		public CousinBean getDataByPK(String cousinId){
			
			CousinBean cousinBean = new CousinBean();
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String selectSQL = "Select * from CUSINES_DETAILS WHERE cusine_id=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, cousinId);
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						
					
						cousinBean.setCousin_id(rs.getInt("cusine_id"));
						cousinBean.setCousin_name(rs.getString("cusine_name"));
					
						
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
				 
			 }
			return cousinBean;
		}
		
		public boolean update(CousinBean cousinBean) {
			 boolean result = false;
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String updateSQL = "UPDATE CUSINES_DETAILS set cusine_name=? WHERE cusine_id=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					pstmt.setString(1,cousinBean.getCousin_name());
					pstmt.setInt(2, cousinBean.getCousin_id());
					
					
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
