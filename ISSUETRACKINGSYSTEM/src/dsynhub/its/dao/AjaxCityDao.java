package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.StateBean;

import dsynhub.its.util.DBConnection;

public class AjaxCityDao {
	
	public ArrayList<CityBean> selectCity(String stateid) throws SQLException, Exception {

		Statement stmt=null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<CityBean> list = new ArrayList<CityBean>();
		CityBean bean = null;

		try {

				con = DBConnection.getConnection();

			if (con != null)
			{
				stmt = con.createStatement();
				String countryQuery = "SELECT * FROM TBL_city WHERE STATE_ID="+stateid;
				System.out.println(countryQuery);
				rs = stmt.executeQuery(countryQuery);
				
				if (rs != null) {
					bean = new CityBean();
					list = new ArrayList();
					//bean.setstateId();
					bean.setCityName(" -- Select City -- ");
					list.add(bean);
					for (long infinit = 0; infinit <= 2000000000; infinit++) {

						/*
						 * This code will generate delay.Remove this for loop for in
						 * project.
						 */
					}
				
					while(rs.next())
					{
						bean=new CityBean();
						bean.setCityId(rs.getInt("city_id"));
						bean.setCityName(rs.getString("city_name"));
						bean.setStateId(rs.getInt("state_ID"));
						System.out.println("cityname:"+bean.getCityName());
							System.out.println(rs.getInt("state_ID"));
					list.add(bean);
					}
		
				}
				
			}	
		}	
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}
}