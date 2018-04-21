package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.FeedbackBean;
import digimation.vacationrental.bean.RoomDetailsBean;
import digimation.vacationrental.util.DBConnection;

public class FeedbackDAO {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public boolean insert(FeedbackBean feedbackBean){
		
		boolean result=false;
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String insertQuery = "INSERT INTO FEEDBACK(feedback_details,date,isvisisble,user_id,hotel_id,property_id,restaurant_id,car_id,tourguide_id) values(?,?,?,?,?,?,?,?,?)";
			
			try{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1,feedbackBean.getFeedback_details());
				pstmt.setString(2,feedbackBean.getDate());
				pstmt.setInt(3,0);
				pstmt.setInt(4,1);
				pstmt.setInt(5,feedbackBean.getHotel_id());
				pstmt.setInt(6,feedbackBean.getProperty_id());
				pstmt.setInt(7,feedbackBean.getRestaurant_id());
				pstmt.setInt(8,feedbackBean.getCar_id());
				pstmt.setInt(9,feedbackBean.getTourguide_id());
				
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
public List<FeedbackBean> list(){
		
		List<FeedbackBean> listOfFeedback = new ArrayList<FeedbackBean>();
		conn=DBConnection.getConnection();
		
		if(conn!=null){
				
				String selectSQL = "SELECT *from FEEDBACK inner join USER on USER.user_id=FEEDBACK.user_id join HOTEL_DETAILS on HOTEL_DETAILS.hotel_id=FEEDBACK.hotel_id join PROPERTY_DETAILS on PROPERTY_DETAILS.property_id=FEEDBACK.property_id join RESTAURANT_DETAILS on RESTAURANT_DETAILS.restaurant_id=FEEDBACK.restaurant_id join CAR_DETAILS on CAR_DETAILS.car_id=FEEDBACK.car_id";
				try{
					
					PreparedStatement pstmt = conn.prepareStatement(selectSQL);
					rs=pstmt.executeQuery();
					
					FeedbackBean feedbackBean=null;
					while(rs.next()){
						
						feedbackBean = new FeedbackBean();
						
						feedbackBean.setFeedback_id(rs.getInt("feedback_id"));
						feedbackBean.setFeedback_details(rs.getString("feedback_details"));
						feedbackBean.setDate(rs.getString("date"));
						feedbackBean.setIsavailable(rs.getBoolean("isvisisble"));
						feedbackBean.setHotel_name(rs.getString("hotel_name"));
						feedbackBean.setProperty_title(rs.getString("property_title"));
						feedbackBean.setRestaurant_name(rs.getString("restaurant_name"));
						feedbackBean.setManager_name(rs.getString("manager_name"));
						feedbackBean.setFirst_name(rs.getString("first_name"));
						feedbackBean.setLast_name(rs.getString("last_name"));
						
						
						listOfFeedback.add(feedbackBean);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		return  listOfFeedback;
		
	}

public boolean delete(String feedbackId){
	
	boolean result=false;
	conn=DBConnection.getConnection();			
	if(conn!=null){
		String deleteSQl="DELETE from FEEDBACK WHERE feedback_id=?";
		
		try{
			PreparedStatement pstmt = conn.prepareStatement(deleteSQl);
			
			pstmt.setString(1,feedbackId);
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

public FeedbackBean getDatabyPK(String feedbackId){
	FeedbackBean feedbackBean = new FeedbackBean();
	
	conn=DBConnection.getConnection();
	
	if(conn!=null){
		
		String query = "SELECT * FROM FEEDBACK WHERE feedback_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, feedbackId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				feedbackBean.setFeedback_id(rs.getInt("feedback_id"));
				feedbackBean.setFeedback_details(rs.getString("feedback_details"));
				feedbackBean.setDate(rs.getString("date"));
				feedbackBean.setIsavailable(rs.getBoolean("isvisisble"));
				feedbackBean.setHotel_id(rs.getInt("hotel_id"));
				feedbackBean.setProperty_id(rs.getInt("property_id"));
				feedbackBean.setRestaurant_id(rs.getInt("restaurant_id"));
				feedbackBean.setCar_id(rs.getInt("car_id"));
				feedbackBean.setTourguide_id(rs.getInt("tourguide_id"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	return feedbackBean;
	
}

}
