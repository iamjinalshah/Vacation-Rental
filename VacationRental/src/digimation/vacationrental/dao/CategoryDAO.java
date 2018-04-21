package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CategoryBean;
import digimation.vacationrental.util.DBConnection;

public class CategoryDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(CategoryBean categoryBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO HOTEL_RESTAURANT_CATEGORIES(hrcategory_name) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,categoryBean.getCategory_Name());
				
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
	
	
public List<CategoryBean> list(){
		
		List<CategoryBean> listOfCategory = new ArrayList<CategoryBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from HOTEL_RESTAURANT_CATEGORIES";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				CategoryBean categoryBean  = null;
				while(rs.next()){
					categoryBean = new CategoryBean();
				
					categoryBean.setCategory_Id(rs.getInt("hrcategory_id"));
					categoryBean.setCategory_Name(rs.getString("hrcategory_name"));
				
					listOfCategory.add(categoryBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfCategory;
	}


public boolean delete(String categoryId) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM HOTEL_RESTAURANT_CATEGORIES WHERE hrcategory_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,categoryId);
		
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

public CategoryBean getDataByPK(String categoryId){
	
	CategoryBean categoryBean = new CategoryBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from HOTEL_RESTAURANT_CATEGORIES WHERE hrcategory_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, categoryId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			
				categoryBean.setCategory_Id(rs.getInt("hrcategory_id"));
				categoryBean.setCategory_Name(rs.getString("hrcategory_name"));
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return categoryBean;
}

public boolean update(CategoryBean categoryBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE HOTEL_RESTAURANT_CATEGORIES set hrcategory_name=? WHERE hrcategory_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setString(1,categoryBean.getCategory_Name());
			pstmt.setInt(2, categoryBean.getCategory_Id());
			
			
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