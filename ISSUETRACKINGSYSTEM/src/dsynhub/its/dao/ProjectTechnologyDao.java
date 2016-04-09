package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.ProjectTechnologyBean;
import dsynhub.its.util.DBConnection;
public class ProjectTechnologyDao {
public boolean dataInsert(ProjectTechnologyBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into Project_categary values(project_categary_sequence.nextval,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1,bean.getProjectTechnology());
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

	public ArrayList<ProjectTechnologyBean> dataSelect()
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ProjectTechnologyBean bean=null;
		ArrayList< ProjectTechnologyBean> list=new ArrayList<ProjectTechnologyBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from Project_categary";
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ProjectTechnologyBean();
					bean.setTechnologyId(rs.getInt(1));
					bean.setProjectTechnology(rs.getString(2));
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

	public ArrayList<ProjectTechnologyBean> dataSelect1(int id)
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ProjectTechnologyBean bean=null;
		ArrayList<ProjectTechnologyBean> list=new ArrayList<ProjectTechnologyBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from Project_categary where CATEGARY_ID="+id;
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ProjectTechnologyBean();
					bean.setTechnologyId(rs.getInt(1));
					bean.setProjectTechnology(rs.getString(2));
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
					String strDelete="delete from Project_categary where CATEGARY_ID=?";
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
		ProjectTechnologyBean bean = null;
		ArrayList<ProjectTechnologyBean> list = dataSelect();
		String query="";
		for(int i=0;i<list.size();i++)
					{
						bean=(ProjectTechnologyBean)list.get(i);			
						String str2=bean.getProjectTechnology();
						query=str2.toLowerCase().trim();
						if(strselect1.toLowerCase().trim().equals(query))
						{
							flag=true;
						}
					}
					
					return flag;
			
	}
	public boolean dataUpdate(ProjectTechnologyBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update Project_categary set PROJECT_CATEGARY=? where CATEGARY_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getProjectTechnology());
				pstmt.setInt(2,bean.getTechnologyId());
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