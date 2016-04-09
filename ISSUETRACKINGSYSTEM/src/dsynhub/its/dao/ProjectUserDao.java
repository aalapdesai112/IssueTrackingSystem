package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.bean.StateBean;
import dsynhub.its.util.DBConnection;

public class ProjectUserDao {
	
	private ArrayList<ProjectUserBean> serchmap;
	public boolean dataInsertProjectUser(ProjectUserBean bean)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		if(con!=null)
		{
			try
			{
				String insertQuery="insert into TBL_PROJ_USER(PROJECT_USER_ID,PROJ_ID,USER_ID,ROLE_ID) values(TBL_PROJ_USER_SEQ.nextval,?,?,?)";
				pstmt=con.prepareStatement(insertQuery);
				//pstmt.setInt(1,bean.getStateid());
				pstmt.setInt(1,bean.getProjId());
				pstmt.setInt(2,bean.getUserId());
				pstmt.setInt(3, bean.getRoleId());
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

	
	public ArrayList<ProjectUserBean> selectDataProjectUser()
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProjectUserBean bean=null;
		ArrayList<ProjectUserBean>list=new ArrayList<ProjectUserBean>();
		if(con!=null)
		{
		try 
		{
			String strSelect="select u.USER_FIRSTNAME,r.USER_ROLE,p.proj_name,p1.PROJECT_USER_ID from TBL_PROJ_USER p1,TBL_USER_REGISTRATION u,TBL_USER_ROLE r,TBL_PROJECTMASTER p where p1.user_id=u.user_id and p1.role_id=r.role_id and p1.proj_id=p.proj_id";
			pstmt=con.prepareStatement(strSelect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new ProjectUserBean();
				bean.setProjUserId(rs.getInt("PROJECT_USER_ID"));
				bean.setProjName(rs.getString("PROJ_NAME"));
				
				bean.setRoleName(rs.getString("USER_ROLE"));
				bean.setUserName(rs.getString("USER_FIRSTNAME"));
				
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
	
	public boolean dataDeleteProjectUser(int id)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_PROJ_USER where  PROJECT_USER_ID="+id;
				pstmt=con.prepareStatement(deleteQuery);
				//pstmt.setInt(1,bean.getProjUserId());
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
	
	
	public ArrayList<ProjectUserBean> selectDataProjectUser1(int id)
	{
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProjectUserBean bean=null;
		ArrayList<ProjectUserBean>list=new ArrayList<ProjectUserBean>();
		if(con!=null)
		{
		try 
		{
			String strSelect="select u.USER_FIRSTNAME,r.USER_ROLE,p.proj_name,p1.PROJECT_USER_ID from TBL_PROJ_USER p1,TBL_USER_REGISTRATION u,TBL_USER_ROLE r,TBL_PROJECTMASTER p where p1.user_id=u.user_id and p1.role_id=r.role_id and p1.proj_id=p.proj_id and p1.PROJECT_USER_ID="+id;
			pstmt=con.prepareStatement(strSelect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new ProjectUserBean();
				bean.setProjUserId(rs.getInt("PROJECT_USER_ID"));
				bean.setProjName(rs.getString("PROJ_NAME"));
				
				bean.setRoleName(rs.getString("USER_ROLE"));
				bean.setUserName(rs.getString("USER_FIRSTNAME"));
				
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
	
	
	
	public boolean dataUpdateProjectUser(ProjectUserBean bean)
	{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;	
		if(con!=null)
		{
			try
			{
				String updateQuery="update TBL_PROJ_USER set PROJ_ID=?,USER_ID=?,ROLE_ID=? where PROJECT_USER_ID=?";
				pstmt=con.prepareStatement(updateQuery);
				pstmt.setInt(1,bean.getProjId());
				pstmt.setInt(2, bean.getUserId());
				pstmt.setInt(3, bean.getRoleId());
				pstmt.setInt(4,bean.getProjUserId());
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
	public  ArrayList<ProjectUserBean> search(String name)
	{
			Connection con=null;
			con=DBConnection.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ProjectUserBean bean=null;
			ArrayList<ProjectUserBean>list=new ArrayList<ProjectUserBean>();
			if(con!=null)
			{
			try 
			{
				String strSelect="select u.USER_FIRSTNAME,r.USER_ROLE,p.proj_name,p1.PROJECT_USER_ID from TBL_PROJ_USER p1,TBL_USER_REGISTRATION u,TBL_USER_ROLE r,TBL_PROJECTMASTER p where p1.user_id=u.user_id and p1.role_id=r.role_id and p1.proj_id=p.proj_id and p.proj_name=?";
				pstmt=con.prepareStatement(strSelect);
				pstmt.setString(1,name);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ProjectUserBean();
					bean.setProjUserId(rs.getInt("PROJECT_USER_ID"));
					bean.setProjName(rs.getString("PROJ_NAME"));
					System.out.println("proj name........."+bean.getProjName());
					bean.setRoleName(rs.getString("USER_ROLE"));
					System.out.println("role name........."+bean.getRoleName());
					bean.setUserName(rs.getString("USER_FIRSTNAME"));
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
		
}