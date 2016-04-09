package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.bean.ModuleBean;
import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.util.DBConnection;
public class IssueAssignDao {
	public boolean insertIssueAssign(IssueAssignBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_issue_assign(issue_assign_id,issue_id,issue_assign_to,issue_reported_by,issue_assign_date) values(tbl_issue_assign_seq.nextval,?,?,?,to_date(?,'dd-mm-yy'))";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setInt(1, bean.getIssueId());
					System.out.println("id"+bean.getIssueId());
					pstmt.setInt(2,bean.getIssueAssignTo());
					pstmt.setString(3,bean.getIssueReportedBy());
					pstmt.setString(4, bean.getAssignDate());
					System.out.println("date"+bean.getAssignDate());
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
	public ArrayList<IssueAssignBean> dataSelectIssueAssign()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssueAssignBean bean=null;
		ArrayList< IssueAssignBean> list=new ArrayList<IssueAssignBean>();
		if(conn!=null)
		{
				try
				{
					String strselect1="select distinct i.issue_assign_id,i.issue_id,id1.issue_name,i.issue_assign_to,i.issue_reported_by,to_char(i.issue_assign_date)issue_assign_date,u.user_firstname from tbl_issue_assign i,tbl_issue_detail id1,tbl_user_registration u where i.issue_id=id1.issue_id and i.issue_assign_to=u.user_id";
					pstmt=conn.prepareStatement(strselect1);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						
						bean=new IssueAssignBean();
						bean.setIssueAssignId(rs.getInt("ISSUE_ASSIGN_ID"));
						System.out.println(rs.getInt("ISSUE_ASSIGN_ID"));
						bean.setIssueId(rs.getInt("ISSUE_ID"));
						bean.setIssueName(rs.getString("ISSUE_NAME"));
						bean.setIssueAssignTo(rs.getInt("ISSUE_ASSIGN_TO"));											
						bean.setIssueReportedBy(rs.getString("ISSUE_REPORTED_BY"));
							bean.setUserName(rs.getString("user_firstname"));
						bean.setAssignDate(rs.getString("ISSUE_ASSIGN_DATE"));
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
	public boolean dataDeleteIssueAssign(IssueAssignBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_ISSUE_ASSIGN where  ISSUE_ASSIGN_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getIssueAssignId());
				System.out.println("......................issue"+bean.getIssueAssignId());
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
	public boolean dataUpdateIssueAssign(IssueAssignBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update tbl_issue_assign set ISSUE_Id=?,ISSUE_ASSIGN_TO=?,ISSUE_REPORTED_BY=?,ISSUE_ASSIGN_DATE=to_date(?,'dd-mm-yy') where ISSUE_ASSIGN_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setInt(1, bean.getIssueId());
				//System.out.println("........"+bean.getProjectName());
				pstmt.setInt(2,bean.getIssueAssignTo());
				System.out.println("........"+bean.getIssueAssignTo());
				pstmt.setString(3, bean.getIssueReportedBy());
				//System.out.println("...project estimated strat datee..."+bean.getProj_estimated_start_date());
				pstmt.setString(4, bean.getAssignDate());
				//System.out.println("...project actual strat datee..."+ bean.getProj_actual_start_date());
				
				pstmt.setInt(5, bean.getIssueAssignId());
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
	public ArrayList<IssueAssignBean> dataListIssueAssign(int id)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssueAssignBean bean=null;
		ArrayList< IssueAssignBean> list=new ArrayList<IssueAssignBean>();
		if(conn!=null)
		{
			
			try
			{
				String select="select distinct i.issue_assign_id,i.issue_id,id1.issue_name,i.issue_assign_to,i.issue_reported_by,to_char(i.issue_assign_date)issue_assign_date,u.user_firstname,u.user_id from tbl_issue_assign i,tbl_issue_detail id1,tbl_user_registration u where i.issue_id=id1.issue_id and i.issue_assign_to=u.user_id and i.issue_assign_id="+id;
				pstmt=conn.prepareStatement(select);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssueAssignBean();
					bean.setIssueAssignId(rs.getInt("ISSUE_ASSIGN_ID"));
					bean.setIssueName(rs.getString("ISSUE_NAME"));
					
					bean.setUserName(rs.getString("USER_FIRSTNAME"));
					System.out.println("name------------------------------------"+rs.getString("USER_FIRSTNAME"));
					System.out.println("........name=============="+bean.getUserName());
					bean.setIssueReportedBy(rs.getString("ISSUE_REPORTED_BY"));
					bean.setAssignDate(rs.getString("ISSUE_ASSIGN_DATE"));
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