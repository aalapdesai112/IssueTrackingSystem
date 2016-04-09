package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.util.DBConnection;
public class CountryDao {
	public boolean insert(CountryBean bean)
	{
		Connection conn=null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(conn!=null)
		{
			String insertQuery="insert into tbl_country(country_id,country_name) values(tbl_country_seq.nextval,?)";
				try {
					pstmt=conn.prepareStatement(insertQuery);
					pstmt.setString(1,bean.getCountryName());
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
	public ArrayList<CountryBean> select()
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<CountryBean> list=new ArrayList<CountryBean>();
	    CountryBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_country";
			pstmt=conn.prepareStatement(selectquery);
			
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			
			
			while(rs.next())
			{
				bean=new CountryBean();
				bean.setCountryID(rs.getInt("country_id"));
				bean.setCountryName(rs.getString("country_name"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(CountryBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from tbl_country where  country_id=?";
				pstmt=con.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getCountryID());
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
	public ArrayList<CountryBean> selectData(int id)
	{
		Connection conn=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ArrayList<CountryBean> list=new ArrayList<CountryBean>();
	    CountryBean bean=null;
		try {
			PreparedStatement pstmt=null;
			String selectquery="select * from tbl_country where country_id="+id;
			pstmt=conn.prepareStatement(selectquery);
			rs=pstmt.executeQuery();
			System.out.println(selectquery);
			while(rs.next())
			{
				bean=new CountryBean();
				bean.setCountryID(rs.getInt("country_id"));
				bean.setCountryName(rs.getString("country_name"));
				list.add(bean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean update(CountryBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_country set country_name=? where country_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setString(1,bean.getCountryName());
				pstmt.setInt(2,bean.getCountryID());
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
	public boolean checkReference(int id)
	{
		Connection conn =null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		boolean flag=false;
		String str="select * from tbl_state  where  country_id="+id;
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
}