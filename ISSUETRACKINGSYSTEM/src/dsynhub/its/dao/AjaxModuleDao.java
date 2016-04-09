package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dsynhub.its.bean.ModuleBean;
import dsynhub.its.util.DBConnection;

public class AjaxModuleDao {
	
	
	public ArrayList<ModuleBean> selectModule(String projid) {
		Statement stmt=null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<ModuleBean> list = new ArrayList<ModuleBean>();
		ModuleBean bean = null;

		try {

				con = DBConnection.getConnection();

			if (con != null)
			{
				stmt = con.createStatement();
				String countryQuery = "SELECT * FROM TBL_module WHERE proj_ID="+projid;
				rs = stmt.executeQuery(countryQuery);
				
				if (rs != null) {
					bean = new ModuleBean();
					list = new ArrayList();
					//bean.setstateId();
					bean.setModuleName(" -- Select Module NAME -- ");
					list.add(bean);
					for (long infinit = 0; infinit <= 4000000; infinit++) {

						/*
						 * This code will generate delay.Remove this for loop for in
						 * project.
						 */
					}
				
					while(rs.next())
					{
						bean=new ModuleBean();
						bean.setModuleId(rs.getInt("module_id"));
						//System.out.println("module ID::"+rs.getInt("module_id"));
						bean.setModuleName(rs.getString("module_name"));
						//System.out.println("name=="+rs.getString("module_name"));
						bean.setProjectId(rs.getInt("proj_ID"));
						//System.out.println("Project ID"+rs.getInt("proj_ID"));
							
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
