package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.bean.IssueResolutionBean;
import dsynhub.its.util.DBConnection;

public class IssueResolutionDao {
	public boolean insertIssueResolution(IssueResolutionBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_issue_resolution(issue_resolution_id,issue_id,issue_action_type,issue_action_description,issue_resolved_by,issue_resolved_date) values(tbl_issue_resolution_seq.nextval,?,?,?,?,to_date(?,'dd-mm-yy'))";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setInt(1, bean.getIssueId());
					System.out.println("id"+bean.getIssueId());
					pstmt.setString(2,bean.getIssueActionType());
					pstmt.setString(3,bean.getIssueActionDescription());
					pstmt.setInt(4, bean.getIssueResolvedBy());
					pstmt.setString(5, bean.getIssueResolvedDate());
					int result = pstmt.executeUpdate();
					if(result>0)
					{
						flag=true;
						System.out.println("inserted");
					
					}
					else
					{
						System.out.println("not inserted");
					}
					}catch (SQLException e) {
						// TODO Auto-generated catch block
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


		return flag;
	}
	public ArrayList<IssueResolutionBean> dataSelectIssueResolution()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssueResolutionBean bean=null;
		ArrayList< IssueResolutionBean> list=new ArrayList<IssueResolutionBean>();
		if(conn!=null)
		{
				try
				{
					String strselect1="select distinct i.issue_resolution_id,i.issue_id,id1.issue_name,i.issue_action_type,i.issue_action_description,i.issue_resolved_by,to_char(i.issue_resolved_date)issue_resolved_date,u.user_firstname from tbl_issue_resolution i,tbl_issue_detail id1,tbl_user_registration u where i.issue_id=id1.issue_id and i.issue_resolved_by=u.user_id";
					pstmt=conn.prepareStatement(strselect1);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						
						bean=new IssueResolutionBean();
						bean.setIssueResolutionId(rs.getInt("ISSUE_RESOLUTION_ID"));
						bean.setIssueId(rs.getInt("ISSUE_ID"));
						bean.setIssueName(rs.getString("ISSUE_NAME"));
						bean.setIssueActionType(rs.getString("ISSUE_ACTION_TYPE"));											
						bean.setIssueActionDescription(rs.getString("ISSUE_ACTION_DESCRIPTION"));
						bean.setIssueResolvedBy(rs.getInt("ISSUE_RESOLVED_BY"));
						bean.setIssueResolvedDate(rs.getString("ISSUE_RESOLVED_DATE"));
						bean.setUserFirstName(rs.getString("user_firstname"));
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
	public boolean dataDeleteIssueResolution(IssueResolutionBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_ISSUE_RESOLUTION where  ISSUE_RESOLUTION_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getIssueResolutionId());
				System.out.println("......................issue"+bean.getIssueResolutionId());
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
	public boolean dataUpdateIssueResolution(IssueResolutionBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update tbl_issue_resolution set ISSUE_Id=?,ISSUE_ACTION_TYPE=?,ISSUE_ACTION_DESCRIPTION=?,ISSUE_RESOLVED_BY=?,ISSUE_RESOLVED_DATE=to_date(?,'dd-mm-yy') where ISSUE_RESOLUTION_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setInt(1, bean.getIssueId());
				pstmt.setString(2,bean.getIssueActionType());
				pstmt.setString(3, bean.getIssueActionDescription());
				//System.out.println("...project estimated strat datee..."+bean.getProj_estimated_start_date());
				System.out.println("resolvedby======"+ bean.getIssueResolvedBy());
				pstmt.setInt(4, bean.getIssueResolvedBy());
				pstmt.setString(5, bean.getIssueResolvedDate());
				//System.out.println("...project actual strat datee..."+ bean.getProj_actual_start_date());
				
				pstmt.setInt(6, bean.getIssueResolutionId());
				//System.out.println("ProjId=="+bean.getProjectId());
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
	public ArrayList<IssueResolutionBean> dataListIssueResolution(int id)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssueResolutionBean bean=null;
		ArrayList< IssueResolutionBean> list=new ArrayList<IssueResolutionBean>();
		if(conn!=null)
		{
			try
			{
				String select="select distinct i.issue_resolution_id,i.issue_id,id1.issue_name,i.issue_action_type,i.issue_action_Description,i.issue_resolved_by,to_char(i.issue_resolved_date)issue_resolved_date,u.user_firstname,u.user_id from tbl_issue_resolution i,tbl_issue_detail id1,tbl_user_registration u where i.issue_id=id1.issue_id and i.issue_resolved_by=u.user_id and i.issue_resolution_id="+id;
				pstmt=conn.prepareStatement(select);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssueResolutionBean();
					bean.setIssueResolutionId(rs.getInt("ISSUE_RESOLUTION_ID"));
					bean.setIssueName(rs.getString("ISSUE_NAME"));
					bean.setIssueActionType(rs.getString("ISSUE_ACTION_TYPE"));
					bean.setIssueActionDescription(rs.getString("ISSUE_ACTION_DESCRIPTION"));
					bean.setIssueResolvedBy(rs.getInt("ISSUE_RESOLVED_BY"));
					bean.setUserFirstName(rs.getString("USER_FIRSTNAME"));
					System.out.println("name------------------------------------"+rs.getString("USER_FIRSTNAME"));
					System.out.println("........name=============="+bean.getUserFirstName());
					bean.setIssueResolvedDate(rs.getString("ISSUE_RESOLVED_DATE"));
					bean.setUserId(rs.getInt("user_id"));
					list.add(bean);
				}
			}
			catch (SQLException e)
			{
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
		return list;
	}
}