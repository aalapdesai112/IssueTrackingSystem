package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.util.DBConnection;

public class IssueStatusDao {
	public boolean insert(IssueStatusBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_issue_status(issue_status_id,issue_status) values(tbl_issue_status_seq.nextval,?)";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setString(1,bean.getIssuestatus());
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
	public ArrayList<IssueStatusBean> select()
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<IssueStatusBean> list=new ArrayList<IssueStatusBean>();
	    IssueStatusBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_issue_status";
			pstmt=conn.prepareStatement(selectquery);
			
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			
			
			while(rs.next())
			{
				bean=new IssueStatusBean();
				bean.setIssuestatusid(rs.getInt("issue_status_id"));
				bean.setIssuestatus(rs.getString("issue_status"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(IssueStatusBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from tbl_issue_status where  issue_status_id=?";
				pstmt=con.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getIssuestatusid());
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
				if(con!=null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
		}
	public boolean duplicate(String str)
	{
		boolean flag1=false;
	    IssueStatusDao pstmtd=new IssueStatusDao();
		String str1="";
		ArrayList<IssueStatusBean> list=pstmtd.select();
		IssueStatusBean bean=null;
		
		for(int i=0;i<list.size();i++)
		{
			
			bean=(IssueStatusBean)list.get(i);
			String str2=bean.getIssuestatus();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		
		return flag1;
		
	}
	public ArrayList<IssueStatusBean> selectData(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<IssueStatusBean> list=new ArrayList<IssueStatusBean>();
	    IssueStatusBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_issue_status where issue_status_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new IssueStatusBean();
				bean.setIssuestatusid(rs.getInt("issue_status_id"));
				bean.setIssuestatus(rs.getString("issue_status"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(IssueStatusBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_issue_status set issue_status=? where issue_status_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setString(1,bean.getIssuestatus());
				pstmt.setInt(2,bean.getIssuestatusid());
				//pstmt.setString(2,bean.getMiddeleName());
				int result=pstmt.executeUpdate();
				if(result>0)
				{
					flag=true;
					System.out.println("updated");
				}
				else
				{
					System.out.println(" not updated");
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
				if(con!=null)
				{
					try
					{
						con.close();
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}return flag;
		}
}