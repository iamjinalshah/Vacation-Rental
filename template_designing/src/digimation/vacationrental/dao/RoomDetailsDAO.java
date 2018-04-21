package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.PropertyDetailsAmenitiesBean;
import digimation.vacationrental.bean.RoomDetailsBean;
import digimation.vacationrental.util.DBConnection;

public class RoomDetailsDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public boolean insert(RoomDetailsBean roomDetailsBean){
		
		boolean result=false;
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String insertQuery = "INSERT INTO room_details(isavailable,rtype_id,hotel_id) values(?,?,?)";
			
			try{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setInt(1, 0);
				pstmt.setInt(2,roomDetailsBean.getRtype_id());
				pstmt.setInt(3, roomDetailsBean.getHotel_id());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected>0){
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");
				}
				else{
					System.out.println(rowsAffected + " Row(s) Inserted......");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		return result;
}
	
public List<RoomDetailsBean> list(){
		
		List<RoomDetailsBean> listOfRooms = new ArrayList<RoomDetailsBean>();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
				
				String selectSQL = "SELECT *from room_details inner join room_type on room_details.rtype_id=room_type.rtype_id";
				try{
					
					PreparedStatement pstmt = conn.prepareStatement(selectSQL);
					rs=pstmt.executeQuery();
					
					RoomDetailsBean roomDetailsBean=null;
					while(rs.next()){
						
						roomDetailsBean = new RoomDetailsBean();
						
						roomDetailsBean.setRoom_id(rs.getInt("room_id"));
						roomDetailsBean.setIsavailable(rs.getBoolean("isavailable"));
						roomDetailsBean.setType_name(rs.getString("type_name"));
						roomDetailsBean.setHotel_id(rs.getInt("hotel_id"));
						
						listOfRooms.add(roomDetailsBean);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		return  listOfRooms;
		
	}

public boolean delete(String roomId){
	
	boolean result=false;
	conn=DBConnection.getConnection();			
	if(conn!=null){
		String deleteSQl="DELETE from room_details WHERE room_id=?";
		
		try{
			PreparedStatement pstmt = conn.prepareStatement(deleteSQl);
			
			pstmt.setString(1,roomId);
			int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				result=true;
				System.out.println(rowsAffected + " Row(s) Deleted......");

			} else {
				System.out.println(rowsAffected + " Row(s) Deleted......");

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return false;
}

public RoomDetailsBean getDataByPK(String roomId){
	
	RoomDetailsBean roomDetailsBean = new RoomDetailsBean();
	conn=DBConnection.getConnection();
	
	if(conn!=null){
		 
		String selectSQL = "SELECT * from room_details WHERE room_id=?";
		try{
			pstmt = conn.prepareStatement(selectSQL);
			
			pstmt.setString(1,roomId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				roomDetailsBean.setRoom_id(rs.getInt("room_id"));
				roomDetailsBean.setRtype_id(rs.getInt("rtype_id"));
				roomDetailsBean.setHotel_id(rs.getInt("hotel_id"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return roomDetailsBean;
}
public boolean update(RoomDetailsBean roomDetailsBean){
	
	boolean result=false;
	conn=DBConnection.getConnection();
	
	if(conn!=null){
		String updateSQL = "UPDATE room_details Set rtype_id=?, hotel_id=? WHERE room_id=?";
		try{
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setInt(1,roomDetailsBean.getRtype_id());
			pstmt.setInt(2,roomDetailsBean.getHotel_id());
			pstmt.setInt(3, roomDetailsBean.getRoom_id());
			
			int rowsAffected=pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				result=true;
				System.out.println(rowsAffected + " Row(s) Updated......");

			} else {
				System.out.println(rowsAffected + " Row(s) Updated......");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return result;
}

}
