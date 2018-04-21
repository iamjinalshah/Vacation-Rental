package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.util.DBConnection;

public class TourGuideDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(TourGuideBean tourGuideBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO TOUR_GUIDE(first_name,middle_name,last_name,mobile,landline,photo,rate,area_id,city_id,,state_id) values(?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,tourGuideBean.getFirst_name());
				pstmt.setString(2, tourGuideBean.getMiddle_name());
				pstmt.setString(3, tourGuideBean.getLast_name());
				pstmt.setInt(4,tourGuideBean.getMobile());
				pstmt.setInt(5,tourGuideBean.getLandline());
				pstmt.setString(6, tourGuideBean.getPhoto());
				pstmt.setInt(7,tourGuideBean.getRate());
				pstmt.setInt(8, tourGuideBean.getArea_id());
				pstmt.setInt(9, tourGuideBean.getCity_id());
				pstmt.setInt(10, tourGuideBean.getState_id());
				
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
	
	public List<TourGuideBean> list(){
		List<TourGuideBean> listOfTourGuide = new ArrayList<TourGuideBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM TOUR_GUIDE";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				TourGuideBean tourGuideBean = null;
				while(rs.next()){
					
					tourGuideBean = new TourGuideBean();
					
					tourGuideBean.setTourguide_id(rs.getInt("tourguide_id"));
					tourGuideBean.setFirst_name(rs.getString("first_name"));
					tourGuideBean.setMiddle_name(rs.getString("middle_name"));
					tourGuideBean.setLast_name(rs.getString("last_name"));
					tourGuideBean.setMobile(rs.getInt("mobile"));
					tourGuideBean.setLandline(rs.getInt("landline"));
					tourGuideBean.setPhoto(rs.getString("photo"));
					tourGuideBean.setRate(rs.getInt("rate"));
					tourGuideBean.setArea_id(rs.getInt("area_id"));
					tourGuideBean.setCity_id(rs.getInt("city_id"));
					
					listOfTourGuide.add(tourGuideBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfTourGuide;
			
	}
	
	public boolean delete(String tourguideId){
		boolean result=false;
		TourGuideBean tourGuideBean = new TourGuideBean();
		
		conn= DBConnection.getConnection();
		if(conn!=null){
			
			String query = "DELETE FROM TOUR_GUIDE WHERE tourguide_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, tourguideId);
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
	
	public TourGuideBean getDatabyPK(String tourguideId){
		TourGuideBean tourGuideBean = new TourGuideBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM TOUR_GUIDE WHERE tourguide_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, tourguideId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					tourGuideBean.setTourguide_id(rs.getInt("tourguide_id"));
					tourGuideBean.setFirst_name(rs.getString("first_name"));
					tourGuideBean.setMiddle_name(rs.getString("middle_name"));
					tourGuideBean.setLast_name(rs.getString("last_name"));
					tourGuideBean.setMobile(rs.getInt("mobile"));
					tourGuideBean.setLandline(rs.getInt("landline"));
					tourGuideBean.setPhoto(rs.getString("photo"));
					tourGuideBean.setRate(rs.getInt("rate"));
					tourGuideBean.setArea_id(rs.getInt("area_id"));
					tourGuideBean.setCity_id(rs.getInt("city_id"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return tourGuideBean;
		
	}
	
	public boolean update(TourGuideBean tourGuideBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "UPDATE TOUR_GUIDE SET first_name=?,middle_name=?,last_name=?,mobile=?,landline=?,photo=?,rate=?,area_id=?,city_id=? WHERE tourguide_id=?";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				
				pstmt.setString(1,tourGuideBean.getFirst_name());
				pstmt.setString(2, tourGuideBean.getMiddle_name());
				pstmt.setString(3, tourGuideBean.getLast_name());
				pstmt.setInt(4,tourGuideBean.getMobile());
				pstmt.setInt(5,tourGuideBean.getLandline());
				pstmt.setString(6, tourGuideBean.getPhoto());
				pstmt.setInt(7,tourGuideBean.getRate());
				pstmt.setInt(8, tourGuideBean.getArea_id());
				pstmt.setInt(9, tourGuideBean.getCity_id());
				pstmt.setInt(10, tourGuideBean.getTourguide_id());
				
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
	
	public List<TourGuideBean> Searchlist(String search){
		List<TourGuideBean> listOfGuide = new ArrayList<TourGuideBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM TOUR_GUIDE inner join AREA on TOUR_GUIDE.area_id=AREA.area_id join CITY on TOUR_GUIDE.city_id=CITY.city_id  where city.city_name=? or area.area_name=? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs= pstmt.executeQuery();
				
				TourGuideBean tourGuideBean = null;
				while(rs.next()){
					
					tourGuideBean = new TourGuideBean();
					
					tourGuideBean.setTourguide_id(rs.getInt("tourguide_id"));
					tourGuideBean.setFirst_name(rs.getString("first_name"));
					tourGuideBean.setMiddle_name(rs.getString("middle_name"));
					tourGuideBean.setLast_name(rs.getString("last_name"));
					tourGuideBean.setMobile(rs.getInt("mobile"));
					tourGuideBean.setLandline(rs.getInt("landline"));
					tourGuideBean.setPhoto(rs.getString("photo"));
					tourGuideBean.setRate(rs.getInt("rate"));
					tourGuideBean.setArea_id(rs.getInt("area_id"));
					tourGuideBean.setCity_id(rs.getInt("city_id"));
					
					
					listOfGuide.add(tourGuideBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfGuide;
			
	}
	
	

}
