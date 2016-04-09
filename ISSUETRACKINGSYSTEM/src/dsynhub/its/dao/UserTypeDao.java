package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.UserTypeBean;
import dsynhub.its.util.DBConnection;
public class UserTypeDao {
	public boolean insert(UserTypeBean bean)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		Statement stmt=null;
		boolean flag=false;
		if(con!=null)
		{
			try
			{
				String userType = bean.getUserType();
				String insertQuery="insert into tbl_user_type  values(tbl_user_type_seq.nextval,'"+userType+"')";
				stmt=con.createStatement();			
				int result = stmt.executeUpdate(insertQuery);
				System.out.println(result);
				if(result>0)
				{
					System.out.println("inserted");
					flag=true;
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
				if(stmt!=null)
				{
					try {
						stmt.close();
					}
					catch (SQLException e)
					{
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
	public boolean update(UserTypeBean bean)
	{
	boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		if(con!=null)
		{
			try
			{
				String insertQuery="update tbl_user_type  set user_type=?  where user_type_id=?";
				pstmt=con.prepareStatement(insertQuery);
				pstmt.setString(1,bean.getUserType());
				pstmt.setInt(2,bean.getUserTypeId());
				System.out.println("id:"+bean.getUserTypeId());
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
		}return flag;
	}
	public boolean delete(UserTypeBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		if(con!=null)
		{
		int id=	bean.getUserTypeId();
			try
			{
				String insertQuery="delete from tbl_user_type  where  user_type_id=?";
				pstmt=con.prepareStatement(insertQuery);
				pstmt.setInt(1,id);
				System.out.println(bean.getUserType());
				int result=pstmt.executeUpdate();
				if(result>0)
				{
					flag=true;
					System.out.println("deleted");
				}
				else
				{
					System.out.println("not deleted");
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
	
	public  ArrayList<UserTypeBean> selectData()
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		  ArrayList<UserTypeBean> list=new ArrayList<UserTypeBean>();
		  UserTypeBean bean=new UserTypeBean();
		try {
			PreparedStatement pstmt=null;
			String selectSql="select * from tbl_user_type ";
			pstmt=conn.prepareStatement(selectSql);
			ResultSet rs=null;
			rs=pstmt.executeQuery();
			System.out.println(selectSql);
			while(rs.next())
			{
				bean=new UserTypeBean();
				bean.setUserTypeId(rs.getInt("user_type_id"));
				bean.setUserType(rs.getString("user_type"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public  ArrayList<UserTypeBean> select(int id)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		  ArrayList<UserTypeBean> list=new ArrayList<UserTypeBean>();
		  UserTypeBean bean=new UserTypeBean();
		try {
			PreparedStatement pstmt=null;
			String selectSql="select * from tbl_user_type  where user_type_id="+id;
			pstmt=conn.prepareStatement(selectSql);
			ResultSet rs=null;
			rs=pstmt.executeQuery();
			System.out.println(selectSql);
			while(rs.next())
			{
				bean=new UserTypeBean();
				bean.setUserTypeId(rs.getInt("user_type_id"));
				bean.setUserType(rs.getString("user_type"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean duplicateUserType(String str)
	{
		boolean flag1=false;
	    CountryDao pstmtd=new CountryDao();
		String str1="";
		
		ArrayList<CountryBean> list=pstmtd.select();
		CountryBean bean=null;
		for(int i=0;i<list.size();i++)
		{
			bean=(CountryBean)list.get(i);
			String str2=bean.getCountryName();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		
		return flag1;
		
	}
}