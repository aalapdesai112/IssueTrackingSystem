package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dsynhub.its.bean.StateBean;
import dsynhub.its.util.DBConnection;
public class AjaxStateDao
{
	public ArrayList<StateBean> selectState(String countryid) throws SQLException, Exception {

		Statement stmt=null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<StateBean> list = new ArrayList<StateBean>();
		StateBean bean = null;

		try {

				con = DBConnection.getConnection();

			if (con != null)
			{
				stmt = con.createStatement();
				String countryQuery = "SELECT * FROM TBL_STATE WHERE COUNTRY_ID="+countryid;
				System.out.println(countryQuery);
				rs = stmt.executeQuery(countryQuery);
				
				if (rs != null) {
					bean = new StateBean();
					list = new ArrayList();
					//bean.setstateId();
					bean.setStateName(" -- Select State -- ");
					list.add(bean);
					for (long infinit = 0; infinit <= 2000000000; infinit++) {

						/*
						 * This code will generate delay.Remove this for loop for in
						 * project.
						 */
					}
					while(rs.next())
					{
						bean=new StateBean();
						bean.setStateId(rs.getInt("state_id"));
						bean.setStateName(rs.getString("state_name"));
						bean.setCountryId(rs.getInt("COUNTRY_ID"));
						System.out.println("sname:"+bean.getStateName());
							System.out.println(rs.getInt("COUNTRY_ID"));
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