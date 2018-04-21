package digimation.vacationrental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import digimation.vacationrental.bean.AreaBean;
import digimation.vacationrental.bean.CityBean;
import digimation.vacationrental.util.DBConnection;

public class AjaxDataDAO {
	
	
	
	public List<CityBean> getAllCity(String stateId) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<CityBean> allCity = null;

		CityBean bean = null;

		con = DBConnection.getConnection();

		if (con != null) {
		
			stmt = con.createStatement();
			String selectSQL = "SELECT * FROM  CITY WHERE state_id = "+ stateId;
			System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new CityBean();
				allCity = new ArrayList<CityBean>();
				bean.setCity_id(0);
				bean.setCity_name(" -- Select City -- ");
				allCity.add(bean);
				
				for (long infinit = 0; infinit <= 200000000; infinit++) {
					
					/*This code will generate delay.
					 *Remove this for loop  in project.
					*/
				}
				
				while (rs.next()) {
					bean = new CityBean();
					bean.setCity_id(rs.getInt("city_id"));
					bean.setCity_name(rs.getString("city_name"));
					bean.setState_id(rs.getInt("state_id"));
					allCity.add(bean);
				}
			}
		}
		System.out.println("Area List : "+allCity.size());
		return allCity;
	}
	
	
	

	public List<AreaBean> getAllArea(String cityId) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<AreaBean> allArea = null;

		AreaBean bean = null;

		con = DBConnection.getConnection();

		if (con != null) {
		
			stmt = con.createStatement();
			String selectSQL = "SELECT * FROM  AREA WHERE city_id = "+ cityId;
			System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new AreaBean();
				allArea = new ArrayList<AreaBean>();
				bean.setArea_id(0);
				bean.setArea_name(" -- Select Area -- ");
				allArea.add(bean);
				
				for (long infinit = 0; infinit <= 200000000; infinit++) {
					
					/*This code will generate delay.
					 *Remove this for loop  in project.
					*/
				}
				
				while (rs.next()) {
					bean = new AreaBean();
					bean.setArea_id(rs.getInt("area_id"));
					bean.setArea_name(rs.getString("area_name"));
					bean.setCity_id(rs.getInt("city_id"));
					allArea.add(bean);
				}
			}
		}
		System.out.println("Area List : "+allArea.size());
		return allArea;
	}
}
