package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.StateBean;
import dsynhub.its.util.DBConnection;

public class StateDao {
	public boolean insert(StateBean bean)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(con!=null)
		{
			try
			{
				String insertQuery="insert into tbl_state(state_id,state_name,country_id) values(tbl_state_seq.nextval,?,?)";
				pstmt=con.prepareStatement(insertQuery);
				pstmt.setString(1,bean.getStateName().toLowerCase());
				pstmt.setInt(2,bean.getCountryId());
				int result=pstmt.executeUpdate();
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
	public boolean update(StateBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_state set state_name=? where state_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setInt(2,bean.getStateId());
				pstmt.setString(1,bean.getStateName());
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
	public boolean delete(StateBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String insertQuery="delete from tbl_state where  state_id=?";
				pstmt=con.prepareStatement(insertQuery);
				pstmt.setInt(1,bean.getStateId());
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
	
	public ArrayList<StateBean> selectData()
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StateBean bean=null;
		ArrayList<StateBean>list=new ArrayList<StateBean>();
		if(con!=null)
		{
		try 
		{
			String strSelect="select Distinct s.state_id,s.state_name,c.country_name,c.country_id from tbl_state s,tbl_country c where c.COUNTRY_ID=s.COUNTRY_ID";
			pstmt=con.prepareStatement(strSelect);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				
				bean=new StateBean();
				bean.setStateId(rs.getInt("state_id"));
				bean.setStateName(rs.getString("state_name"));				
				bean.setCountryId(rs.getInt("COUNTRY_ID"));
				bean.setCountryName(rs.getString("country_name"));
				list.add(bean);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		return list;	
	}	
	public boolean duplicate(String str)
	{
		boolean flag=false;
		StateDao psex=new StateDao();
		String str1="";
		ArrayList<StateBean> list=psex.selectData();
		StateBean bean=null;
		for(int i=0;i<list.size();i++)
		{
			bean=(StateBean)list.get(i);
			String str2=bean.getStateName();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().equals(str1))
			{
				flag=true;
			}
		}
		return flag;
	}
	public boolean duplicateState(String str)
	{
		boolean flag1=false;
		StateDao psex=new StateDao();
		String str1="";
		ArrayList<StateBean> list=psex.selectData();
		StateBean bean=null;
		
		for(int i=0;i<list.size();i++)
		{
			bean=(StateBean)list.get(i);
			String str2=bean.getStateName();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		return flag1;
	}
	public boolean checkReference(int id)
	{
		Connection conn =null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		boolean flag=false;
		String str="select * from tbl_country c,tbl_state s where c.country_id=s.country_id && c.country_id="+id;
		try {
			pstmt=conn.prepareStatement(str);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
			flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public ArrayList<StateBean> select(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<StateBean> list=new ArrayList<StateBean>();
	    StateBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_state where state_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new StateBean();
				bean.setStateId(rs.getInt("state_id"));
				bean.setStateName(rs.getString("state_name"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}