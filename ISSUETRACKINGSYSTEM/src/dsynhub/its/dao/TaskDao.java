package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.TaskBean;
import dsynhub.its.util.DBConnection;

public class TaskDao {
	public Boolean DataInsertTask(TaskBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into TBL_TASK(task_id,task_name,task_description,task_estimate_start_date,task_actual_start_date,task_estimate_end_date,task_actual_end_date,PMT_PRIORITY_ID,pmt_status_id,module_id) values(tbl_task_seq.nextval,?,?,to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),?,?,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getTaskName());
				pstmt.setString(2, bean.getTaskDescription());
				pstmt.setString(3, bean.getTaskEstimateStartDate());
				pstmt.setString(4, bean.getTaskActualStartDate());
				pstmt.setString(5, bean.getTaskEstimateEndDate());
				pstmt.setString(6, bean.getTaskActualEndDate());
				pstmt.setInt(7, bean.getPmtPriorityId());
				pstmt.setInt(8, bean.getPmtStatusId());
				pstmt.setInt(9, bean.getModuleId());
				int result=pstmt.executeUpdate();
				if(result>0)
				{
					flag=true;
					System.out.println("Insert Successfully'''''''");
				}
				else
				{
					System.out.println("Insert Failed.....");
				}
		} 
		
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		finally
		{if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		}
		
		return flag;
		
	}
	
	public boolean dataDeleteTask(TaskBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_task where  task_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getTaskId());
				int result=pstmt.executeUpdate();
				if(result>0)
				{
					flag=true;
					System.out.println("deleted");
				}
				else
				{
					System.out.println(" not deleted");
				}
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if(pstmt!=null)
				{
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn!=null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}
	public boolean dataUpdateTask(TaskBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update tbl_task set task_NAME=?,task_DESCRIPTION=?,task_ESTIMATE_START_DATE=to_date(?,'dd-mm-yy'),task_ACTUAL_START_DATE=to_date(?,'dd-mm-yy'),task_ESTIMATE_END_DATE=to_date(?,'dd-mm-yy'),task_ACTUAL_END_DATE=to_date(?,'dd-mm-yy'),PMT_PRIORITY_ID=?,PMT_STATUS_ID=?,MODULE_ID=? where task_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getTaskName());			
				pstmt.setString(2,bean.getTaskDescription());
				pstmt.setString(3, bean.getTaskEstimateStartDate());
				pstmt.setString(4, bean.getTaskActualStartDate());
				pstmt.setString(5, bean.getTaskEstimateEndDate());
				pstmt.setString(6, bean.getTaskActualEndDate());
				pstmt.setInt(7, bean.getPmtPriorityId());
				pstmt.setInt(8, bean.getPmtStatusId());
				pstmt.setInt(9, bean.getModuleId());
				pstmt.setInt(10, bean.getTaskId());
				int result=pstmt.executeUpdate();
				if(result>0)
				{
					flag=true;
					System.out.println("updtaed..");
				}
				else
				{
					System.out.println("not updated..??????...");
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if(conn!=null)
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
		return flag;
		
	}
	public boolean duplicateTask(String strselect1)
	{
		Boolean flag = false;		
		TaskBean bean1 = null;
		ArrayList<TaskBean> list = dataSelectTask();
		String query="";
		for(int i=0;i<list.size();i++)
		{	
			bean1=(TaskBean)list.get(i);
			query=bean1.getTaskName();			
			if(query.equals(strselect1))
			{
				flag=true;
			}
		}
		return flag;
	}
public ArrayList<TaskBean> dataSelectTask()
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	TaskBean bean=null;
	ArrayList< TaskBean> list=new ArrayList<TaskBean>();
	if(conn!=null)
	{
			try
			{
				String strselect="select m.task_id,m.task_name,m.task_DESCRIPTION,to_char(m.task_ESTIMATE_START_DATE)task_ESTIMATE_START_DATE,to_char(m.task_ACTUAL_START_DATE)task_ACTUAL_START_DATE,to_char(m.task_ESTIMATE_END_DATE)task_ESTIMATE_END_DATE,to_char(m.task_ACTUAL_END_DATE)task_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_task m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.pmt_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID ";
				
				String strselect1="select task_id,task_name,to_char(task_ACTUAL_START_DATE)task_ACTUAL_START_DATE,to_char(task_ACTUAL_END_DATE)task_ACTUAL_END_DATE from TBL_task";
				pstmt=conn.prepareStatement(strselect1);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new TaskBean();
					bean.setTaskId(rs.getInt("task_ID"));
					bean.setTaskName(rs.getString("task_NAME"));
					//bean.settaskDescription(rs.getString("task_DESCRIPTION"));
					//bean.settaskEstimateStartDate(rs.getString("task_ESTIMATE_START_DATE"));
					bean.setTaskActualStartDate(rs.getString("task_ACTUAL_START_DATE"));
					//bean.settaskEstimateEndDate(rs.getString("task_ESTIMATE_END_DATE"));
					bean.setTaskActualEndDate(rs.getString("task_ACTUAL_END_DATE"));
					//bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
					//bean.setPmtStatus(rs.getString("PMT_STATUS"));
					//bean.setProjectName(rs.getString("PROJECT_NAME"));
					list.add(bean);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
				if(conn!=null)
				{
					try
					{
						conn.close();
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}	
		}
		return list;
	}
public ArrayList<TaskBean> dataListTask(int id)
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	TaskBean bean=null;
	ArrayList< TaskBean> list=new ArrayList<TaskBean>();
	if(conn!=null)
	{
		try
		{
			String strselect="select m.task_id,m.task_NAME,m.task_DESCRIPTION,to_char(m.task_ESTIMATE_START_DATE)task_ESTIMATE_START_DATE,to_char(m.task_ACTUAL_START_DATE)task_ACTUAL_START_DATE,to_char(m.task_ESTIMATE_END_DATE)task_ESTIMATE_END_DATE,to_char(m.task_ACTUAL_END_DATE)task_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.MODULE_NAME from TBL_task m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_module p3 where m.PMT_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.pmt_PRIORITY_ID and m.MODULE_ID=p3.MODULE_ID and task_id="+id;
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new TaskBean();
				bean.setTaskId(rs.getInt("task_ID"));
				bean.setTaskName(rs.getString("task_NAME"));
				bean.setTaskDescription(rs.getString("task_DESCRIPTION"));
				bean.setTaskEstimateStartDate(rs.getString("task_ESTIMATE_START_DATE"));
				bean.setTaskActualStartDate(rs.getString("task_ACTUAL_START_DATE"));
				bean.setTaskEstimateEndDate(rs.getString("task_ESTIMATE_END_DATE"));
				bean.setTaskActualEndDate(rs.getString("task_ACTUAL_END_DATE"));
				bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
				bean.setPmtStatus(rs.getString("PMT_STATUS"));
				bean.setModuleName(rs.getString("MODULE_NAME"));		
				list.add(bean);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
		finally
		{
			if(pstmt!=null)
			{
				try	
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	return list;
	}
}