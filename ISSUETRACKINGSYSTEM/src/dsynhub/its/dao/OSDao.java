package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.OSBean;
import dsynhub.its.util.DBConnection;

public class OSDao {
	public boolean insert(OSBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_os(os_id,os) values(tbl_os_seq.nextval,?)";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setString(1,bean.getOs());
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
	public ArrayList<OSBean> select()
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<OSBean> list=new ArrayList<OSBean>();
	    OSBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_os";
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new OSBean();
				bean.setOsid(rs.getInt("os_id"));
				bean.setOs(rs.getString("os"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(OSBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from tbl_os where  os_id=?";
				pstmt=con.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getOsid());
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
	    OSDao pstmtd=new OSDao();
		String str1="";
		ArrayList<OSBean> list=pstmtd.select();
		OSBean bean=null;
		for(int i=0;i<list.size();i++)
		{
			bean=(OSBean)list.get(i);
			String str2=bean.getOs();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		
		return flag1;
		
	}
	public ArrayList<OSBean> selectData(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<OSBean> list=new ArrayList<OSBean>();
	    OSBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_os where os_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new OSBean();
				bean.setOsid(rs.getInt("os_id"));
				bean.setOs(rs.getString("os"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(OSBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_os set os=? where os_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setString(1,bean.getOs());
				pstmt.setInt(2,bean.getOsid());
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