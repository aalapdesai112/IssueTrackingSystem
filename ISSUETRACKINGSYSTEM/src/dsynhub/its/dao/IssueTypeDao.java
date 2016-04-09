package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.IssueTypeBean;
import dsynhub.its.util.DBConnection;
public class IssueTypeDao {
	public boolean insert(IssueTypeBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
				String insertQuery="insert into tbl_issue_type(issue_type_id,issue_type) values(tbl_issue_type_seq.nextval,?)";
				try
				{
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setString(1,bean.getIssuetype());
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

		return flag;
	}
	public ArrayList<IssueTypeBean> select()
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<IssueTypeBean> list=new ArrayList<IssueTypeBean>();
	    IssueTypeBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_issue_type";
			pstmt=conn.prepareStatement(selectquery);
			
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			
			
			while(rs.next())
			{
				bean=new IssueTypeBean();
				bean.setIssuetypeid(rs.getInt("issue_type_id"));
				bean.setIssuetype(rs.getString("issue_type"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<IssueTypeBean> selectData(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<IssueTypeBean> list=new ArrayList<IssueTypeBean>();
	    IssueTypeBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_issue_type where issue_type_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			
			
			while(rs.next())
			{
				bean=new IssueTypeBean();
				bean.setIssuetypeid(rs.getInt("issue_type_id"));
				bean.setIssuetype(rs.getString("issue_type"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(IssueTypeBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from tbl_issue_type where  issue_type_id=?";
				pstmt=con.prepareStatement(deleteQuery);
				
				pstmt.setInt(1,bean.getIssuetypeid());
				
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
public boolean update(IssueTypeBean bean)
{
	boolean flag=false;
	Connection con=null;
	con=DBConnection.getConnection();
	PreparedStatement pstmt=null;	
	if(con!=null)
	{
		try
		{
			String updateQuery="update tbl_issue_type set issue_type=? where issue_type_id=?";
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setString(1,bean.getIssuetype());
			pstmt.setInt(2,bean.getIssuetypeid());
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
	}
	return flag;
}
public boolean duplicate(String str)
{
	boolean flag1=false;
	IssueTypeDao dao=new IssueTypeDao();
	String str1="";
	ArrayList<IssueTypeBean> list=dao.select();
	IssueTypeBean bean=null;
	for(int i=0;i<list.size();i++)
	{
		bean=(IssueTypeBean)list.get(i);
		String str2=bean.getIssuetype();
		str1=str2.toLowerCase().trim();
		if(str.toLowerCase().trim().equals(str1))
		{
			flag1=true;
		}
	}
return flag1;
	}
}