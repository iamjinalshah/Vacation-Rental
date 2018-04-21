package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.util.DBConnection;

public class BookingStatusDAO {
	
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(BookingStatusBean bookingStatusBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO BOOKING_STATUS(bookingstatus) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,bookingStatusBean.getBookingstatus());
				
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

	
public List<BookingStatusBean> list(){
		
		List<BookingStatusBean> listOfBookings = new ArrayList<BookingStatusBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from BOOKING_STATUS";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				BookingStatusBean bookingStatusBean = null;
				while(rs.next()){
					bookingStatusBean = new BookingStatusBean();
				
					bookingStatusBean.setBookingstatusid(rs.getInt("bookingstatusid"));
					bookingStatusBean.setBookingstatus(rs.getString("bookingstatus"));
				
					listOfBookings.add(bookingStatusBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfBookings;
	}

public boolean delete(String bookingStatusId) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM BOOKING_STATUS WHERE bookingstatusid=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,bookingStatusId);
		
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

public BookingStatusBean getDataByPK(String bookingStatusId){
	
	BookingStatusBean bookingStatusBean = new BookingStatusBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from BOOKING_STATUS WHERE bookingstatusid=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, bookingStatusId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			
				bookingStatusBean.setBookingstatusid(rs.getInt("bookingstatusid"));
				bookingStatusBean.setBookingstatus(rs.getString("bookingStatus"));
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return bookingStatusBean;
}

public boolean update(BookingStatusBean bookingStatusBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE BOOKING_STATUS set bookingstatus=? WHERE bookingstatusid=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setString(1,bookingStatusBean.getBookingstatus());
			pstmt.setInt(2, bookingStatusBean.getBookingstatusid());
			
			
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
