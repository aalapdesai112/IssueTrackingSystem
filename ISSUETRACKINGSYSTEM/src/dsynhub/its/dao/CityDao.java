package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.StateBean;
import dsynhub.its.util.DBConnection;
public class CityDao
{	
	public boolean dataInsertCity(CityBean bean)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(con!=null)
		{
			try
			{
				String insertQuery="insert into tbl_City(city_id,city_name,state_id) values(TBL_CITY_SEQ.nextval,?,?)";
				pstmt=con.prepareStatement(insertQuery);
				pstmt.setString(1,bean.getCityName());
				pstmt.setInt(2,bean.getStateId());
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
	public boolean checkReference(int id)
	{
		Connection conn =null;
		conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		String str="select * from tbl_city c,tbl_state s where c.state_id=s.state_id && c.state_id="+id;
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
					String strDelete="delete from  tbl_city where city_ID=?";
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
	public boolean dataUpdateCity(CityBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update tbl_city set city_name=? where city_id=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setString(1,bean.getCityName());
				pstmt.setInt(2,bean.getCityId());
				//pstmt.setInt(2,bean.getStateId());
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
	public boolean duplicate(String str)
	{
		boolean flag1=false;
	    CityDao pstmtd=new CityDao();
		String str1="";
		ArrayList<CityBean> list=pstmtd.dataSelectCity();
		CityBean bean=null;
		for(int i=0;i<list.size();i++)
		{		
			bean=(CityBean)list.get(i);
			String str2=bean.getCityName();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag1=true;
			}
		}
		return flag1;
	}
	public ArrayList<CityBean> dataSelectCity()
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CityBean bean=null;
		ArrayList<CityBean>list=new ArrayList<CityBean>();
		if(con!=null)
		{
		try 
		{
			String strSelect="select c.city_id,c.city_name,s.state_name,c.state_id from tbl_city c,tbl_state s where c.state_id=s.state_id";
			pstmt=con.prepareStatement(strSelect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new CityBean();
				bean.setCityId(rs.getInt("city_id"));
				bean.setCityName(rs.getString("city_name"));
				bean.setStateId(rs.getInt("state_id"));
				bean.setStateName(rs.getString("state_name"));
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
	
	public ArrayList<CityBean> dataSelectCity1(int id)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CityBean bean=null;
		ArrayList<CityBean>list=new ArrayList<CityBean>();
		if(con!=null)
		{
		try 
		{
			String strSelect="select * from tbl_city where city_id="+id;
			pstmt=con.prepareStatement(strSelect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new CityBean();
				bean.setCityId(rs.getInt("city_id"));
				bean.setCityName(rs.getString("city_name"));
				bean.setStateId(rs.getInt("state_id"));
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
	
	public boolean duplicateState(String str)
	{
		boolean flag=false;
		CityDao dao=new CityDao();
		String str1="";
		ArrayList<CityBean> list=dao.dataSelectCity();
		CityBean bean=null;
		
		for(int i=0;i<list.size();i++)
		{
			bean=(CityBean)list.get(i);
			String str2=bean.getCityName();
			str1=str2.toLowerCase().trim();
			if(str.toLowerCase().trim().equals(str1))
			{
				flag=true;
			}
		}
		return flag;
	}
	
}
