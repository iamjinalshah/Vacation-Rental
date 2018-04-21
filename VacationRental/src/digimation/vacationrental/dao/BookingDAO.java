package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.BookingBean;
import digimation.vacationrental.bean.BookingStatusBean;
import digimation.vacationrental.util.DBConnection;

public class BookingDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(BookingBean bookingBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO BOOKING(booking_date,bookingstatusid,hotel_id,property_id,user_id) values(?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,bookingBean.getBooking_date());
				pstmt.setInt(2,bookingBean.getBookingstatusid());
				pstmt.setInt(3, bookingBean.getHotel_id());
				pstmt.setInt(4,bookingBean.getProperty_id());
				pstmt.setInt(5, 1);
				
				
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
	
public List<BookingBean> list(){
		
		List<BookingBean> listOfBooking = new ArrayList<BookingBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from BOOKING inner join BOOKING_STATUS on BOOKING_STATUS.bookingstatusid=BOOKING.bookingstatusid join HOTEl_DETAILS on HOTEL_DETAILS.hotel_id=BOOKING.hotel_id join USER on USER.user_id=BOOKING.user_id join property_details on booking.property_id=property_details.property_id";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				BookingBean bookingBean = null;
				while(rs.next()){
					bookingBean = new BookingBean();
				
					bookingBean.setBooking_id(rs.getInt("booking_id"));
					bookingBean.setBooking_date(rs.getString("booking_date"));
					bookingBean.setBookingstatus(rs.getString("bookingstatus"));
					bookingBean.setHotel_name(rs.getString("hotel_name"));
					bookingBean.setFirst_name(rs.getString("first_name"));
					bookingBean.setLast_name(rs.getString("last_name"));
					bookingBean.setProperty_name(rs.getString("property_title"));
				
					listOfBooking.add(bookingBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfBooking;
	}

public boolean delete(String bookingId) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM BOOKING WHERE booking_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,bookingId);
		
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

public BookingBean getDataByPK(String bookingId){
	
	BookingBean bookingBean = new BookingBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from BOOKING WHERE booking_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, bookingId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			
				bookingBean.setBooking_id(rs.getInt("booking_id"));
				bookingBean.setBooking_date(rs.getString("booking_date"));
				bookingBean.setBookingstatusid(rs.getInt("bookingstatusid"));
				bookingBean.setHotel_id(rs.getInt("hotel_id"));
				bookingBean.setProperty_id(rs.getInt("property_id"));
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return bookingBean;
}
public boolean update(BookingBean bookingBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE BOOKING set booking_date=?,bookingstatusid=?,hotel_id=?,property_id=? WHERE booking_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setString(1,bookingBean.getBooking_date());
			pstmt.setInt(2, bookingBean.getBookingstatusid());
			pstmt.setInt(3, bookingBean.getHotel_id());
			pstmt.setInt(4, bookingBean.getProperty_id());
			pstmt.setInt(5, bookingBean.getBooking_id());
			
			
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
public List<BookingBean> userBookinglist(String Id){
	
	List<BookingBean> listOfBooking = new ArrayList<BookingBean>();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from BOOKING inner join BOOKING_STATUS on BOOKING_STATUS.bookingstatusid=BOOKING.bookingstatusid join HOTEl_DETAILS on HOTEL_DETAILS.hotel_id=BOOKING.hotel_id join USER on USER.user_id=BOOKING.user_id join property_details on booking.property_id=property_details.property_id WHERE BOOKING.user_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, Id);
			rs = pstmt.executeQuery();

			BookingBean bookingBean = null;
			while(rs.next()){
				bookingBean = new BookingBean();
			
				bookingBean.setBooking_id(rs.getInt("booking_id"));
				bookingBean.setBooking_date(rs.getString("booking_date"));
				bookingBean.setBookingstatus(rs.getString("bookingstatus"));
				bookingBean.setHotel_name(rs.getString("hotel_name"));
				bookingBean.setFirst_name(rs.getString("first_name"));
				bookingBean.setLast_name(rs.getString("last_name"));
				bookingBean.setProperty_name(rs.getString("property_title"));
			
				listOfBooking.add(bookingBean);
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return listOfBooking;
}
}
