package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dsynhub.its.bean.TaskBean;
import dsynhub.its.util.DBConnection;

public class AjaxTaskDao {
	public ArrayList<TaskBean> selectTask(String moduleid) {
		Statement stmt=null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<TaskBean> list = new ArrayList<TaskBean>();
		TaskBean bean = null;

		try {

				con = DBConnection.getConnection();

			if (con != null)
			{
				stmt = con.createStatement();
				String Query = "SELECT * FROM TBL_task WHERE module_ID="+moduleid;
				
				rs = stmt.executeQuery(Query);
				
				if (rs != null) {
					bean = new TaskBean();
					list = new ArrayList();
					//bean.setstateId();
					bean.setTaskName(" -- Select task NAME -- ");
					list.add(bean);
					for (long infinit = 0; infinit <= 4000000; infinit++) {

						/*
						 * This code will generate delay.Remove this for loop for in
						 * project.
						 */
					}
				
					while(rs.next())
					{
						bean=new TaskBean();
						bean.setTaskId(rs.getInt("task_id"));
						//System.out.println("T ID::"+rs.getInt("task_id"));
						bean.setTaskName(rs.getString("task_name"));
				
						bean.setModuleId(rs.getInt("module_ID"));
						//System.out.println("m ID"+rs.getInt("module_ID"));
							
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
