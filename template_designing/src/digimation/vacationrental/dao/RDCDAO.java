package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.GLDetailsBean;
import digimation.vacationrental.bean.RDCBean;
import digimation.vacationrental.util.DBConnection;

public class RDCDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(RDCBean rdcBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO restaurant_details_cusines(res_id,cusines_type,cusine_id) values(?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1,rdcBean.getRes_id());
				pstmt.setString(2,rdcBean.getCousins_type());
				pstmt.setInt(3,rdcBean.getCousin_id());
				
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
	
public List<RDCBean> list(){
		
		List<RDCBean> listOfRDC = new ArrayList<RDCBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from restaurant_details_cusines join cusines_details on RESTAURANT_DETAILS_CUSINES.cusine_id=CUSINES_DETAILS.cusine_id";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				RDCBean rdcBean = null;
				while(rs.next()){
					rdcBean = new RDCBean();
				
					rdcBean.setRDC_id(rs.getInt("RDC_id"));
					rdcBean.setRes_id(rs.getInt("res_id"));
					rdcBean.setCousins_type(rs.getString("cusines_type"));
					rdcBean.setCousin_name(rs.getString("cusine_name"));
					
					listOfRDC.add(rdcBean);
				}
				
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfRDC;
	}
public boolean delete(String rdcId) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM restaurant_details_cusines WHERE rdc_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,rdcId);
		
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

public RDCBean getDataByPK(String rdcId){
	
	RDCBean rdcBean = new RDCBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from restaurant_details_cusines WHERE rdc_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, rdcId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
				rdcBean.setRDC_id(rs.getInt("rdc_id"));
				rdcBean.setRes_id(rs.getInt("res_id"));
				rdcBean.setCousins_type(rs.getString("cusines_type"));
				rdcBean.setCousin_id(rs.getInt("cusine_id"));
			
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return rdcBean;
}
public boolean update(RDCBean rdcBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE restaurant_details_cusines set res_id=?,cusines_type=?,cusine_id=? WHERE rdc_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setInt(1,rdcBean.getRes_id());
			pstmt.setString(2, rdcBean.getCousins_type());
			pstmt.setInt(3, rdcBean.getCousin_id());
			pstmt.setInt(4, rdcBean.getRDC_id());
			
			
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

