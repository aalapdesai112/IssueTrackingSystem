package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.UserRoleBean;
import dsynhub.its.util.DBConnection;
public class UserRoleDao {
	public boolean dataInsert(UserRoleBean bean)
{

	Boolean flag=false;		
	Connection conn=null;
	PreparedStatement pstmt=null;
	conn=DBConnection.getConnection();
	//SequrityQuestionBean bean= new SequrityQuestionBean();
	
	if(conn!=null)
	{
		String strInsert="insert into TBL_USER_ROLE values(USERROLESEQUENCE.nextval,?)";
		try {
			pstmt=conn.prepareStatement(strInsert);
			pstmt.setString(1,bean.getRoleName());
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

public ArrayList<UserRoleBean> dataSelect()
{
	//boolean flag=false;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	UserRoleBean bean=null;
	ArrayList< UserRoleBean> list=new ArrayList<UserRoleBean>();
	if(conn!=null)
	{
		
		try
		{
			String strselect="select * from TBL_USER_ROLE";
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new UserRoleBean();
				bean.setRoleId(rs.getInt(1));
				bean.setRoleName(rs.getString(2));
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

public ArrayList<UserRoleBean> dataSelect1(int id)
{
	//boolean flag=false;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	UserRoleBean bean=null;
	ArrayList< UserRoleBean> list=new ArrayList<UserRoleBean>();
	if(conn!=null)
	{
		
		try
		{
			String strselect="select * from TBL_USER_ROLE where user_role_id="+id;
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new UserRoleBean();
				bean.setRoleId(rs.getInt(1));
				bean.setRoleName(rs.getString(2));
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
				String strDelete="delete from tbl_User_role where user_role_id=?";
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
	UserRoleBean bean = null;
	
	ArrayList<UserRoleBean> list = dataSelect();
	
	
	String query="";
				
				for(int i=0;i<list.size();i++)
				{
					bean=(UserRoleBean)list.get(i)	;
					String str2=bean.getRoleName();
					query=str2.toLowerCase().trim();
					if(strselect1.toLowerCase().trim().equals(query))
					{
						flag=true;
					}
				 }
				
				return flag;
		
}
public boolean dataUpdate(UserRoleBean bean)
{
	boolean flag=false;
	Connection conn=null;
	PreparedStatement pstmt=null;
	conn=DBConnection.getConnection();
	if(conn!=null)
	{			
		String strUpdate="update tbl_User_Role set USER_ROLE=? where user_role_id=?";
		try 
		{
			pstmt=conn.prepareStatement(strUpdate);
			pstmt.setString(1, bean.getRoleName());
			pstmt.setInt(2,bean.getRoleId());
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