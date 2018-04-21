package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.RoomTypeBean;
import digimation.vacationrental.util.DBConnection;

public class RoomTypeDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(RoomTypeBean roomTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO ROOM_TYPE(type_name) values(?)";			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,roomTypeBean.getType_name());
				
				
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
	
	public List<RoomTypeBean> list(){
		List<RoomTypeBean> room = new ArrayList<RoomTypeBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ROOM_TYPE";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				RoomTypeBean roomTypeBean = null;
				while(rs.next()){
					
					roomTypeBean = new RoomTypeBean();
					
					roomTypeBean.setRtype_id(rs.getInt("rtype_id"));
					roomTypeBean.setType_name(rs.getString("type_name"));
					
					
					room.add(roomTypeBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return room;
			
	}
	
	public RoomTypeBean getDatabyPK(String Id){
		RoomTypeBean roomTypeBean = new RoomTypeBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM ROOM_TYPE WHERE rtype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					roomTypeBean.setRtype_id(rs.getInt("rtype_id"));
					roomTypeBean.setType_name(rs.getString("type_name"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return roomTypeBean;
		
	}
	
	public boolean update(RoomTypeBean roomTypeBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE ROOM_TYPE SET type_name=? WHERE rtype_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,roomTypeBean.getType_name());
				pstmt.setInt(2, roomTypeBean.getRtype_id());
				
				
				
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
	public boolean delete(String rtypeId){
		boolean result=false;
		RoomTypeBean roomTypeBean = new RoomTypeBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM ROOM_TYPE WHERE rtype_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, rtypeId);
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
