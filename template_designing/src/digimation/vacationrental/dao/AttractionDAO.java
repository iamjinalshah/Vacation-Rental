package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AttractionBean;
import digimation.vacationrental.bean.AttractionPhotoBean;
import digimation.vacationrental.bean.HotelDetailsBean;
import digimation.vacationrental.bean.HotelPhotoBean;
import digimation.vacationrental.bean.TourGuideBean;
import digimation.vacationrental.util.DBConnection;

public class AttractionDAO {

	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(AttractionBean attractionBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO ATTRACTION (attraction_name,description,area_id,city_id,state_id) values(?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,attractionBean.getAttraction_name());
				pstmt.setString(2, attractionBean.getDescription());
				pstmt.setInt(3,attractionBean.getArea_id());
				pstmt.setInt(4,attractionBean.getCity_id());
				pstmt.setInt(5,attractionBean.getState_id());
				
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
	
	public List<AttractionBean> list(){
		List<AttractionBean> listOfAttraction = new ArrayList<AttractionBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ATTRACTION inner join CITY on ATTRACTION.city_id=CITY.city_id join AREA on AREA.area_id=ATTRACTION.area_id join STATE on STATE.state_id=ATTRACTION.state_id";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				AttractionBean attractionBean = null;
				while(rs.next()){
					
					attractionBean = new AttractionBean();
					
					attractionBean.setAttraction_id(rs.getInt("attraction_id"));
					attractionBean.setAttraction_name(rs.getString("attraction_name"));
					attractionBean.setDescription(rs.getString("description"));
					attractionBean.setArea_name(rs.getString("area_name"));
					attractionBean.setCity_name(rs.getString("city_name"));
					attractionBean.setState_name(rs.getString("state_name"));
					
					
					listOfAttraction.add(attractionBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfAttraction;
		
	}
	
	public boolean photoinsert(AttractionPhotoBean attractionPhotoBean) {
		 boolean result = false;
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO ATTRACTION_PHOTOS (photo_name,attraction_id,isvisible,iscoverphoto) values(?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,attractionPhotoBean.getPhoto_name());
				pstmt.setString(2, attractionPhotoBean.getAttraction_id());
				pstmt.setInt(3,1);
				pstmt.setInt(4,0);
				
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

	public List<AttractionBean> Searchlist(String search){
		List<AttractionBean> listOfAttraction = new ArrayList<AttractionBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ATTRACTION inner join AREA on ATTRACTION.area_id=AREA.area_id join CITY on ATTRACTION.city_id=CITY.city_id join STATE on ATTRACTION.state_id=STATE.state_id where city.city_name=? or area.area_name=? or state.state_name=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				pstmt.setString(3, search);
				rs= pstmt.executeQuery();
				
				AttractionBean attractionBean = null;
				while(rs.next()){
					
					attractionBean = new AttractionBean();
					
					attractionBean.setAttraction_id(rs.getInt("attraction_id"));
					int attractionId = rs.getInt("attraction_id");
					
					String sql1 = "SELECT * FROM ATTRACTION_PHOTOS WHERE attraction_id=? and iscoverphoto=?";
					pstmt = conn.prepareStatement(sql1);
					pstmt.setInt(1, attractionId);
					pstmt.setInt(2, 1);
					ResultSet rs1= pstmt.executeQuery();
					
					if(rs1.next()){
						
						attractionBean.setPhoto_name(rs1.getString("photo_name"));
					}
					attractionBean.setAttraction_name(rs.getString("attraction_name"));
					attractionBean.setDescription(rs.getString("description"));
					attractionBean.setArea_name(rs.getString("area_name"));
					attractionBean.setCity_name(rs.getString("city_name"));
					attractionBean.setState_name(rs.getString("state_name"));
					
					
					listOfAttraction.add(attractionBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("size:"+listOfAttraction.size());
		return listOfAttraction;
			
	}
	
	public List<AttractionBean> AllSearchlist(){
		List<AttractionBean> listOfAttraction = new ArrayList<AttractionBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ATTRACTION inner join AREA on ATTRACTION.area_id=AREA.area_id join CITY on ATTRACTION.city_id=CITY.city_id join STATE on ATTRACTION.state_id=STATE.state_id ";
			try {
				pstmt = conn.prepareStatement(sql);
				rs= pstmt.executeQuery();
				
				AttractionBean attractionBean = null;
				while(rs.next()){
					
					attractionBean = new AttractionBean();
					
					attractionBean.setAttraction_id(rs.getInt("attraction_id"));
					int attractionId = rs.getInt("attraction_id");
					
					String sql1 = "SELECT * FROM ATTRACTION_PHOTOS WHERE attraction_id=? and iscoverphoto=?";
					pstmt = conn.prepareStatement(sql1);
					pstmt.setInt(1, attractionId);
					pstmt.setInt(2, 1);
					ResultSet rs1= pstmt.executeQuery();
					
					if(rs1.next()){
						
						attractionBean.setPhoto_name(rs1.getString("photo_name"));
					}
					attractionBean.setAttraction_name(rs.getString("attraction_name"));
					attractionBean.setDescription(rs.getString("description"));
					attractionBean.setArea_name(rs.getString("area_name"));
					attractionBean.setCity_name(rs.getString("city_name"));
					attractionBean.setState_name(rs.getString("state_name"));
					
					
					listOfAttraction.add(attractionBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("size:"+listOfAttraction.size());
		return listOfAttraction;
			
	}
	
	public AttractionBean attractionFullInfo(String attractionId){
		AttractionBean attractionBean = new AttractionBean();
		
		conn=DBConnection.getConnection();
		
		if(conn!=null){
			
			String query = "SELECT * FROM ATTRACTION inner join AREA on ATTRACTION.area_id=AREA.area_id join CITY on ATTRACTION.city_id=CITY.city_id join STATE on ATTRACTION.state_id=STATE.state_id WHERE attraction_id=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, attractionId);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					attractionBean = new AttractionBean();
					
					attractionBean.setAttraction_id(rs.getInt("attraction_id"));
					
					String sql1 = "SELECT * FROM ATTRACTION_PHOTOS WHERE attraction_id=? and iscoverphoto=?";
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, attractionId);
					pstmt.setInt(2, 1);
					ResultSet rs1= pstmt.executeQuery();
					
					if(rs1.next()){
						
						attractionBean.setPhoto_name(rs1.getString("photo_name"));
					}
					attractionBean.setAttraction_name(rs.getString("attraction_name"));
					attractionBean.setDescription(rs.getString("description"));
					attractionBean.setArea_name(rs.getString("area_name"));
					attractionBean.setCity_name(rs.getString("city_name"));
					attractionBean.setState_name(rs.getString("state_name"));
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return attractionBean;
	}
	
	public List<AttractionPhotoBean> attractionphotolist(String attractionId){
		List<AttractionPhotoBean> listOfAttractionPhotos = new ArrayList<AttractionPhotoBean>();
		conn = DBConnection.getConnection();
		
		if(conn!=null){
			String sql = "SELECT * FROM ATTRACTION_PHOTOS WHERE attraction_id=? AND iscoverphoto=? ";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, attractionId);
				pstmt.setInt(2, 0);
				rs= pstmt.executeQuery();
				
				AttractionPhotoBean attractionPhotoBean = null;
				while(rs.next()){
					
					attractionPhotoBean = new AttractionPhotoBean();
					
					attractionPhotoBean.setAttraction_photoid(rs.getString("attraction_photoid"));
					attractionPhotoBean.setPhoto_name(rs.getString("photo_name"));
					System.out.println("photoname:"+rs.getString("photo_name"));
					listOfAttractionPhotos.add(attractionPhotoBean);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listOfAttractionPhotos;
			
	}

	
}
