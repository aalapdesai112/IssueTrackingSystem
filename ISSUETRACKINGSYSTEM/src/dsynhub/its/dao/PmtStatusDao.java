package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.util.DBConnection;

public class PmtStatusDao {
	public boolean insert(PMTStatusBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_pmt_status(pmt_status_id,pmt_status) values(tbl_pmt_status_seq.nextval,?)";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setString(1,bean.getPmtstatus());
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
	public ArrayList<PMTStatusBean> select()
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<PMTStatusBean> list=new ArrayList<PMTStatusBean>();
	    PMTStatusBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_pmt_status";
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new PMTStatusBean();
				bean.setPmtstatusid(rs.getInt("PMT_Status_ID"));
				bean.setPmtstatus(rs.getString("PMT_Status"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(PMTStatusBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from tbl_pmt_status where  pmt_status_id=?";
				pstmt=con.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getPmtstatusid());
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
	    PmtStatusDao pstmtd=new PmtStatusDao();
		String str1="";
		ArrayList<PMTStatusBean> list=pstmtd.select();
		PMTStatusBean bean=null;
		for(int i=0;i<list.size();i++)
		{
			bean=(PMTStatusBean)list.get(i);
			String str2=bean.getPmtstatus();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		return flag1;
		
	}
	public ArrayList<PMTStatusBean> selectData(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<PMTStatusBean> list=new ArrayList<PMTStatusBean>();
	    PMTStatusBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_pmt_status where pmt_status_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println("SELECTQUERY"+selectquery);
			while(rs.next())
			{
				bean=new PMTStatusBean();
				bean.setPmtstatusid(rs.getInt("pmt_status_id"));
				bean.setPmtstatus(rs.getString("pmt_status"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(PMTStatusBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_pmt_status set pmt_status=? where pmt_status_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setString(1,bean.getPmtstatus());
				pstmt.setInt(2,bean.getPmtstatusid());
				
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