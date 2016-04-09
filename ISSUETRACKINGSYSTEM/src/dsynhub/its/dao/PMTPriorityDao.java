package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.PMTPriorityBean;
import dsynhub.its.util.DBConnection;
public class PMTPriorityDao {
	
	public boolean dataInsert(PMTPriorityBean bean)
	{

		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		//SequrityQuestionBean bean= new SequrityQuestionBean();
		
		if(conn!=null)
		{
			String strInsert="insert into TBL_PMT_PRIORITY values(tbl_pmt_priority_seq.nextval,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1,bean.getPMTPriorityName());
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

	public ArrayList<PMTPriorityBean> dataSelect()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		PMTPriorityBean bean=null;
		ArrayList< PMTPriorityBean> list=new ArrayList<PMTPriorityBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from tbl_pmt_priority";
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new PMTPriorityBean();
					bean.setPMTPriorityId(rs.getInt(1));
					bean.setPMTPriorityName(rs.getString(2));
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

	public ArrayList<PMTPriorityBean> dataSelect1(int id)
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		PMTPriorityBean bean=null;
		ArrayList< PMTPriorityBean> list=new ArrayList<PMTPriorityBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from tbl_pmt_priority where pmt_priority_id="+id;
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new PMTPriorityBean();
					bean.setPMTPriorityId(rs.getInt(1));
					bean.setPMTPriorityName(rs.getString(2));
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
					String strDelete="delete from TBL_PMT_PRIORITY where pmt_priority_id=?";
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
					System.out.println("not deleted......");
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
		Boolean flag = false;		
		PMTPriorityBean bean = null;
		ArrayList<PMTPriorityBean> list = dataSelect();
		String query="";
					
					for(int i=0;i<list.size();i++)
					{
					//	bean=new UserBean1();
						
						bean=(PMTPriorityBean)list.get(i);
						query=bean.getPMTPriorityName();	
						String str2=bean.getPMTPriorityName();
						query=str2.toLowerCase().trim();
						if(strselect1.toLowerCase().trim().equals(query))
						{
							flag=true;
						}
						
						
					}
					
					return flag;
			
	}
	public boolean dataUpdate(PMTPriorityBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update TBL_PMT_PRIORITY set PMT_PRIORITY=? where pmt_priority_id=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getPMTPriorityName());
				pstmt.setInt(2,bean.getPMTPriorityId());
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
