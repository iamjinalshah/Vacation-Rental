package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.CarModelBean;
import digimation.vacationrental.util.DBConnection;

public class CarModelsDAO {
	
	private Connection conn= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	public boolean insert(CarModelBean carModelBean) {
		 boolean result = false;
		 conn= DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CAR_MODELS(carmodel_name,carbrand_id) values(?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,carModelBean.getCarmodel_name());
				pstmt.setInt(2, carModelBean.getCarbarnd_id());
				
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
	
	
	public List<CarModelBean> list(){
		
		List<CarModelBean> listOfCarModels = new ArrayList<CarModelBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from CAR_MODELS inner join CAR_BRANDS on CAR_MODELS.carbrand_id=CAR_BRANDS.carbrand_id";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				CarModelBean carModelBean = null;
				while(rs.next()){
					carModelBean = new CarModelBean();
				
					carModelBean.setCarmodel_id(rs.getInt("carmodel_id"));
					carModelBean.setCarmodel_name(rs.getString("carmodel_name"));
					carModelBean.setCarbrand_name(rs.getString("carbrand_name"));
				
					listOfCarModels.add(carModelBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return listOfCarModels;
	}


public boolean delete(String carModelId) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String deleteSQL = "DELETE FROM CAR_MODELS WHERE carmodel_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,carModelId);
		
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

public CarModelBean getDataByPK(String carModelId){
	
	CarModelBean carModelBean = new CarModelBean();
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String selectSQL = "Select * from CAR_MODELS WHERE carmodel_id=?";
		 try {
			pstmt = conn.prepareStatement(selectSQL);
		
			pstmt.setString(1, carModelId);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
			
				carModelBean.setCarmodel_id(rs.getInt("carmodel_id"));
				carModelBean.setCarmodel_name(rs.getString("carmodel_name"));
				carModelBean.setCarbarnd_id(rs.getInt("carbrand_id"));
			
				
			}
			
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 
	 }
	return carModelBean;
}

public boolean update(CarModelBean carModelBean) {
	 boolean result = false;
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE CAR_MODELS set carmodel_name=?,carbrand_id=? WHERE carmodel_id=?";
		 
		 try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setString(1,carModelBean.getCarmodel_name());
			pstmt.setInt(2, carModelBean.getCarbarnd_id());
			pstmt.setInt(3, carModelBean.getCarmodel_id());
			
			
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
