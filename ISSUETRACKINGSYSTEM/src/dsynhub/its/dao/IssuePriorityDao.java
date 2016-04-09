package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.IssuePriorityBean;
import dsynhub.its.util.DBConnection;
public class IssuePriorityDao
{
	public boolean dataInsert(IssuePriorityBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into ISSUE_PRIORITY values(ISSUE_PRIORITY_SEQ.nextval,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1,bean.getIssuePrioritylevel());
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

	public ArrayList<IssuePriorityBean> dataSelect()
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssuePriorityBean bean=null;
		ArrayList< IssuePriorityBean> list=new ArrayList<IssuePriorityBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from ISSUE_PRIORITY";
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssuePriorityBean();
					bean.setIssuePriorityId(rs.getInt(1));
					bean.setIssuePrioritylevel(rs.getString(2));
					list.add(bean);
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
		
		
		return list;
	}

	public ArrayList<IssuePriorityBean> dataSelect1(int id)
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		IssuePriorityBean bean=null;
		ArrayList< IssuePriorityBean> list=new ArrayList<IssuePriorityBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from ISSUE_PRIORITY where ISSUE_PRIORITY_ID="+id;
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new IssuePriorityBean();
					bean.setIssuePriorityId(rs.getInt(1));
					bean.setIssuePrioritylevel(rs.getString(2));
					list.add(bean);
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
		
		
		return list;
	}
	public boolean dataDelete(int str)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
				try 
				{
					String strDelete="delete from ISSUE_PRIORITY where ISSUE_PRIORITY_ID=?";
					pstmt=conn.prepareStatement(strDelete);
					pstmt.setInt(1, str);
				int result=	pstmt.executeUpdate();
				
				if(result>0)
				{
					flag=true;
					System.out.println("deleted.....");
				}
				else
				{
					System.out.println("not deleted..???....");
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

	public boolean duplicate(String strselect1)
	{
		Boolean flag1 = false;		
		IssuePriorityBean bean = null;
		ArrayList<IssuePriorityBean> list = dataSelect();
		String query="";
		for(int i=0;i<list.size();i++)
					{	
						bean=(IssuePriorityBean)list.get(i);
						String str2=bean.getIssuePrioritylevel();
						query=str2.toLowerCase().trim();
						if(strselect1.toLowerCase().trim().equals(query))
						{
							flag1=true;
						}
					}
					return flag1;
			}
	public boolean dataUpdate(IssuePriorityBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update ISSUE_PRIORITY set ISSUE_LEVEL=? where ISSUE_PRIORITY_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getIssuePrioritylevel());
				pstmt.setInt(2,bean.getIssuePriorityId());
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

}
