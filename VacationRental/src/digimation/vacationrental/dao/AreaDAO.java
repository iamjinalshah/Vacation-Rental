package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AreaBean;
import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.util.DBConnection;

public class AreaDAO {
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(AreaBean areaBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO AREA(area_name,pincode,city_id) values(?,?,?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,areaBean.getArea_name());
				pstmt.setString(2,areaBean.getPincode());
				pstmt.setInt(3,areaBean.getCity_id());
				
				
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
	
	public List<AreaBean> list(){
		List<AreaBean> listOfArea = new ArrayList<AreaBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT AREA.area_id,AREA.area_name,AREA.pincode,CITY.city_name FROM AREA inner join CITY on AREA.city_id=CITY.city_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				AreaBean areaBean = null;
				while(rs.next()){
					
					areaBean = new AreaBean();
					
					areaBean.setArea_id(rs.getInt("area_id"));
					areaBean.setArea_name(rs.getString("area_name"));
					areaBean.setPincode(rs.getString("pincode"));
					areaBean.setCity_name(rs.getString("city_name"));
					
					
					listOfArea.add(areaBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfArea;
		
	}
	
	public boolean delete(String areaId){
		boolean result=false;
		AreaBean areaBean = new  AreaBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM AREA WHERE area_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, areaId);
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
	
	public AreaBean getDaatabyPK(String areaId){
		AreaBean areaBean = new AreaBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM AREA WHERE area_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, areaId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					areaBean.setCity_id(rs.getInt("city_id"));
					areaBean.setArea_name(rs.getString("area_name"));
					areaBean.setArea_id(rs.getInt("area_id"));
					areaBean.setPincode(rs.getString("pincode"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return areaBean;
		
		
	}
	
	public boolean update(AreaBean areaBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE AREA SET area_name=?,pincode=?,city_id=? WHERE area_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,areaBean.getArea_name());
				pstmt.setString(2, areaBean.getPincode());
				pstmt.setInt(3, areaBean.getCity_id());
				pstmt.setInt(4, areaBean.getArea_id());
				
				
				
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
