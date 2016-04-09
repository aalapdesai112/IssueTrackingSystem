package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.util.DBConnection;

public class IssueDetailDao {
	public Boolean DataInsertIssueDetail(IssueDetailBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into TBL_ISSUE_DETAIL(issue_id,issue_name,issue_description,issue_creation_date,ISSUE_TYPE_ID,task_id,os_id,issue_priority_id,issue_status_id,issue_status_date,issue_snap_shot,user_id) values(TBL_ISSUE_DETAIL_SEQ.nextval,?,?,to_date(?,'dd-mm-yy'),?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getIssueName());
				pstmt.setString(2, bean.getIssueDescription());
				pstmt.setString(3, bean.getIssueCreationDate());
				pstmt.setInt(4, bean.getIssueTypeId());
				
				pstmt.setInt(5, bean.getTaskId());
				pstmt.setInt(6, bean.getOsId());
				pstmt.setInt(7, bean.getIssuePriorityId());
				pstmt.setInt(8, bean.getIssueStatusId());
				pstmt.setString(9, bean.getIssueStatusDate());
				pstmt.setString(10, bean.getIssueSnapShot());
				pstmt.setInt(11, bean.getUserId());
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
	
	public boolean dataDeleteIssueDetail(IssueDetailBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_ISSUE_DETAIL where  ISSUE_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getIssueId());
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
	public boolean dataUpdateIssueDetail(IssueDetailBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			 	String strUpdate="update tbl_issue_detail set issue_NAME=?,issue_DESCRIPTION=?,issue_creation_DATE=to_date(?,'dd-mm-yy'),ISSUE_TYPE_ID=?,TASK_ID=?,OS_ID=?,ISSUE_PRIORITY_ID=?,ISSUE_STATUS_ID=?,ISSUE_STATUS_DATE=to_date(?,'dd-mm-yy'),ISSUE_SNAP_SHOT=?,user_id=? where ISSUE_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getIssueName());
				pstmt.setString(2, bean.getIssueDescription());
				pstmt.setString(3, bean.getIssueCreationDate());
				pstmt.setInt(4, bean.getIssueTypeId());				
				pstmt.setInt(5, bean.getTaskId());
				pstmt.setInt(6, bean.getOsId());
				pstmt.setInt(7, bean.getIssuePriorityId());
				pstmt.setInt(8, bean.getIssueStatusId());
				pstmt.setString(9, bean.getIssueStatusDate());
				pstmt.setString(10, bean.getIssueSnapShot());
				pstmt.setInt(11, bean.getUserId());
				pstmt.setInt(12, bean.getIssueId());
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
	public boolean duplicateIssueDetail(String strselect1)
	{
		Boolean flag = false;		
		IssueDetailBean bean1 = null;
		ArrayList<IssueDetailBean> list = dataSelectIssueDetail();
		String query="";
		for(int i=0;i<list.size();i++)
		{	
			bean1=(IssueDetailBean)list.get(i);
			query=bean1.getIssueName();			
			if(query.equals(strselect1))
			{
				flag=true;
			}
		}
		return flag;
	}
public ArrayList<IssueDetailBean> dataSelectIssueDetail()
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	IssueDetailBean bean=null;
	ArrayList< IssueDetailBean> list=new ArrayList<IssueDetailBean>();
	if(conn!=null)
	{
			try
			{
				//String strselect="select m.module_id,m.module_name,m.MODULE_DESCRIPTION,to_char(m.MODULE_ESTIMATE_START_DATE)MODULE_ESTIMATE_START_DATE,to_char(m.MODULE_ACTUAL_START_DATE)MODULE_ACTUAL_START_DATE,to_char(m.MODULE_ESTIMATE_END_DATE)MODULE_ESTIMATE_END_DATE,to_char(m.MODULE_ACTUAL_END_DATE)MODULE_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_MODULE m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.pmt_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID ";
				String strselect1="SELECT i.issue_id,i.issue_name,i.ISSUE_DESCRIPTION,to_char(i.issue_creation_date)issue_creation_date,to_char(i.ISSUE_STATUS_DATE)ISSUE_STATUS_DATE,i.ISSUE_SNAP_SHOT,it.ISSUE_TYPE,t.task_name,o.os,ip.ISSUE_LEVEL,is1.ISSUE_STATUS,u.USER_FIRSTNAME from TBL_ISSUE_DETAIL i,tbl_task t,tbl_issue_type it,tbl_os o,ISSUE_PRIORITY ip,TBL_ISSUE_STATUS is1,TBL_USER_REGISTRATION u where i.task_id=t.task_id and i.issue_type_id=it.issue_type_id and i.os_id=o.os_id and i.ISSUE_PRIORITY_ID=ip.ISSUE_PRIORITY_ID and i.ISSUE_STATUS_ID=is1.ISSUE_STATUS_ID and i.user_id=u.user_id";
				pstmt=conn.prepareStatement(strselect1);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssueDetailBean();
					bean.setIssueId(rs.getInt("ISSUE_ID"));
					bean.setIssueName(rs.getString("ISSUE_NAME"));
					bean.setIssueDescription(rs.getString("ISSUE_DESCRIPTION"));
					
					bean.setIssueCreationDate(rs.getString("ISSUE_CREATION_DATE"));
					bean.setIssueType(rs.getString("issue_type"));
					bean.setTaskName(rs.getString("TASK_NAME"));
					bean.setOs(rs.getString("os"));
					bean.setIssueLevel(rs.getString("ISSUE_LEVEL"));
					bean.setIssueStatus(rs.getString("ISSUE_STATUS"));
					bean.setIssueStatusDate(rs.getString("ISSUE_STATUS_DATE"));
					bean.setIssueSnapShot(rs.getString("ISSUE_SNAP_SHOT"));
					bean.setUserName(rs.getString("USER_FIRSTNAME"));
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

public ArrayList<IssueDetailBean> dataSelectIssueDetail1(int id)
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	IssueDetailBean bean=null;
	ArrayList< IssueDetailBean> list=new ArrayList<IssueDetailBean>();
	if(conn!=null)
	{
			try
			{
				//String strselect="select m.module_id,m.module_name,m.MODULE_DESCRIPTION,to_char(m.MODULE_ESTIMATE_START_DATE)MODULE_ESTIMATE_START_DATE,to_char(m.MODULE_ACTUAL_START_DATE)MODULE_ACTUAL_START_DATE,to_char(m.MODULE_ESTIMATE_END_DATE)MODULE_ESTIMATE_END_DATE,to_char(m.MODULE_ACTUAL_END_DATE)MODULE_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_MODULE m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.pmt_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID ";
				String strselect1="SELECT i.issue_id,i.issue_name,i.ISSUE_DESCRIPTION,to_char(i.issue_creation_date)issue_creation_date,to_char(i.ISSUE_STATUS_DATE)ISSUE_STATUS_DATE,i.ISSUE_SNAP_SHOT,it.ISSUE_TYPE,t.task_name,o.os,ip.ISSUE_LEVEL,is1.ISSUE_STATUS,u.USER_FIRSTNAME from TBL_ISSUE_DETAIL i,tbl_task t,tbl_issue_type it,tbl_os o,ISSUE_PRIORITY ip,TBL_ISSUE_STATUS is1,TBL_USER_REGISTRATION u where i.task_id=t.task_id and i.issue_type_id=it.issue_type_id and i.os_id=o.os_id and i.ISSUE_PRIORITY_ID=ip.ISSUE_PRIORITY_ID and i.ISSUE_STATUS_ID=is1.ISSUE_STATUS_ID and i.user_id=u.user_id and i.issue_id="+id;
				
				//String str="SELECT i.issue_id,i.issue_name,i.ISSUE_DESCRIPTION from TBL_ISSUE_DETAIL i where i.issue_id="+id;
				pstmt=conn.prepareStatement(strselect1);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssueDetailBean();
					bean.setIssueId(rs.getInt("ISSUE_ID"));
					System.out.println("id............"+rs.getInt("ISSUE_ID"));
					bean.setIssueName(rs.getString("ISSUE_NAME"));
					System.out.println("............"+rs.getString("ISSUE_NAME"));
					
					bean.setIssueDescription(rs.getString("ISSUE_DESCRIPTION"));
					System.out.println(rs.getString("ISSUE_DESCRIPTION"));
					bean.setIssueCreationDate(rs.getString("ISSUE_CREATION_DATE"));
					bean.setIssueType(rs.getString("issue_type"));
					bean.setTaskName(rs.getString("TASK_NAME"));
					bean.setOs(rs.getString("os"));
					bean.setIssueLevel(rs.getString("ISSUE_LEVEL"));
					bean.setIssueStatus(rs.getString("ISSUE_STATUS"));
					bean.setIssueStatusDate(rs.getString("ISSUE_STATUS_DATE"));
					bean.setIssueSnapShot(rs.getString("ISSUE_SNAP_SHOT"));
					bean.setUserName(rs.getString("USER_FIRSTNAME"));
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
public ArrayList<IssueDetailBean> dataListIssueDetail(int id)
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	IssueDetailBean bean=null;
	ArrayList< IssueDetailBean> list=new ArrayList<IssueDetailBean>();
	if(conn!=null)
	{
		try
		{
			String strselect="select i.issue_id,i.issue_NAME,i.issue_DESCRIPTION,to_char(i.ISSUE_CREATION_DATE)ISSUE_CREATION_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_MODULE m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.PMT_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.pmt_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID and module_id="+id;
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new IssueDetailBean();
				bean.setIssueId(rs.getInt("ISSUE_ID"));
				bean.setIssueName(rs.getString("ISSUE_NAME"));
				bean.setIssueDescription(rs.getString("ISSUE_DESCRIPTION"));
				bean.setIssueCreationDate(rs.getString("ISSUE_CREATION_DATE"));
				bean.setIssueType(rs.getString("ISSUE_TYPE"));
			//	bean.setProjectUserId(rs.getInt("PROJECT_USER_ID"));
				
				bean.setTaskName(rs.getString("TASK_NAME"));
				bean.setIssueLevel(rs.getString("PMT_PRIORITY"));
				bean.setIssueStatus(rs.getString("PMT_STATUS"));
				//bean.setProjectName(rs.getString("PROJ_NAME"));		
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
