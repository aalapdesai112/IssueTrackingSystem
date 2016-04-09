package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dsynhub.its.bean.IssuePriorityBean;
import dsynhub.its.bean.PMTPriorityBean;
import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.util.DBConnection;

public class ProjectMasterDao {
	
	
	public Boolean DataInsertProjectMaster(ProjectMasterBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		//ProjectMasterDao bean= new ProjectMasterDao();
		
		if(conn!=null)
		{
			String strInsert="insert into TBL_PROJECTMASTER(proj_id,proj_name,proj_description,proj_estimated_start_date,proj_actual_start_date,proj_estimated_end_date,proj_actual_end_date,PMT_PRIORITY_ID,PMT_STATUS_ID,CATEGARY_ID) values(Project_master_seq.nextval,?,?,to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),?,?,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getProjectName());
				pstmt.setString(2, bean.getProjectdescription());
				pstmt.setString(3, bean.getProj_estimated_start_date());
				pstmt.setString(4, bean.getProj_actual_start_date());
				pstmt.setString(5, bean.getProj_estimated_end_date());
				pstmt.setString(6, bean.getProj_actual_end_date());
				pstmt.setInt(7, bean.getPriorityId());
				pstmt.setInt(8, bean.getStatusId());
				pstmt.setInt(9, bean.getCategaryId());
				
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
	
	public boolean dataDeleteProjectMaster(ProjectMasterBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_PROJECTMASTER where  PROJ_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getProjectId());
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
	public boolean dataUpdateProjectMaster(ProjectMasterBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update tbl_projectmaster set PROJ_NAME=?,PROJ_DESCRIPTION=?,PROJ_ESTIMATED_START_DATE=to_date(?,'dd-mm-yy'),PROJ_ACTUAL_START_DATE=to_date(?,'dd-mm-yy'),PROJ_ESTIMATED_END_DATE=to_date(?,'dd-mm-yy'),PROJ_ACTUAL_END_DATE=to_date(?,'dd-mm-yy'),PMT_PRIORITY_ID=?,PMT_STATUS_ID=?,CATEGARY_ID=? where Proj_id=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getProjectName());
				System.out.println("........"+bean.getProjectName());
				pstmt.setString(2,bean.getProjectdescription());
				System.out.println("........"+bean.getProjectdescription());
				pstmt.setString(3, bean.getProj_estimated_start_date());
				System.out.println("...project estimated strat datee..."+bean.getProj_estimated_start_date());
				pstmt.setString(4, bean.getProj_actual_start_date());
				System.out.println("...project actual strat datee..."+ bean.getProj_actual_start_date());
				pstmt.setString(5, bean.getProj_estimated_end_date());
				System.out.println("peedate=="+bean.getProj_estimated_end_date());
				pstmt.setString(6, bean.getProj_actual_end_date());
				System.out.println("paedate==="+bean.getProj_actual_end_date());
				pstmt.setInt(7, bean.getPriorityId());
				System.out.println("PriorityId=="+ bean.getPriorityId());
				pstmt.setInt(8, bean.getStatusId());
				System.out.println("status Id=="+bean.getStatusId());
				pstmt.setInt(9, bean.getCategaryId());
				System.out.println("CategoryId=="+bean.getCategaryId());
				pstmt.setInt(10, bean.getProjectId());
				System.out.println("ProjId=="+bean.getProjectId());
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
	public boolean duplicateProjectMaster(String strselect1)
	{
		Boolean flag = false;		
		ProjectMasterBean bean1 = null;
		
		ArrayList<ProjectMasterBean> list = dataSelectProjectMaster();
		
		
		String query="";
					
					for(int i=0;i<list.size();i++)
					{
					//	bean=new UserBean1();
						
						bean1=(ProjectMasterBean)list.get(i)	;
					//	System.out.println("value"+list.get(i));
						query=bean1.getProjectName();			
						System.out.print(query+" ==== ");
						System.out.print("=="+strselect1);
						System.out.println(" ");
						if(query.equals(strselect1))
						{
							flag=true;
						}
						
						
					}
					
					return flag;
			
	}

	
	public ArrayList<ProjectMasterBean> dataSelectProjectMaster()
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		ProjectMasterBean bean=null;
		ArrayList< ProjectMasterBean> list=new ArrayList<ProjectMasterBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select p.proj_id,p.proj_name,p.proj_DESCRIPTION,to_char(p.PROJ_ESTIMATED_START_DATE)PROJ_ESTIMATED_START_DATE,to_char(p.PROJ_ACTUAL_START_DATE)PROJ_ACTUAL_START_DATE,to_char(p.PROJ_ESTIMATED_END_DATE)PROJ_ESTIMATED_END_DATE,to_char(p.PROJ_ACTUAL_END_DATE)PROJ_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJECT_CATEGARY from TBL_PROJECTMASTER p,tbl_PMT_PRIORITY p1,tbl_pmt_status p2,PROJECT_CATEGARY p3 where p.PMT_STATUS_ID=p2.PMT_STATUS_ID and p.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and p.CATEGARY_ID=p3.CATEGARY_ID";
				//* from TBL_PROJECTMASTER order by PROJ_ID";
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ProjectMasterBean();
					bean.setProjectId(rs.getInt("PROJ_ID"));
					bean.setProjectName(rs.getString("PROJ_NAME"));
					bean.setProjectdescription(rs.getString("PROJ_DESCRIPTION"));
					bean.setProj_estimated_start_date(rs.getString("PROJ_ESTIMATED_START_DATE"));
					bean.setProj_actual_start_date(rs.getString("PROJ_ACTUAL_START_DATE"));
					bean.setProj_estimated_end_date(rs.getString("PROJ_ESTIMATED_END_DATE"));
					bean.setProj_actual_end_date(rs.getString("PROJ_ACTUAL_END_DATE"));
					bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
					bean.setPmtStatus(rs.getString("PMT_STATUS"));
					bean.setProjCategary(rs.getString("PROJECT_CATEGARY"));					
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



public ArrayList<ProjectMasterBean> dataListProjectMaster(int id)
{
	//boolean flag=false;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	ProjectMasterBean bean=null;
	ArrayList< ProjectMasterBean> list=new ArrayList<ProjectMasterBean>();
	if(conn!=null)
	{
		
		try
		{
			String strselect="select p.proj_id,p.proj_name,p.proj_DESCRIPTION,to_char(p.PROJ_ESTIMATED_START_DATE)PROJ_ESTIMATED_START_DATE,to_char(p.PROJ_ACTUAL_START_DATE)PROJ_ACTUAL_START_DATE,to_char(p.PROJ_ESTIMATED_END_DATE)PROJ_ESTIMATED_END_DATE,to_char(p.PROJ_ACTUAL_END_DATE)PROJ_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJECT_CATEGARY from TBL_PROJECTMASTER p,tbl_PMT_PRIORITY p1,tbl_pmt_status p2,PROJECT_CATEGARY p3 where p.PMT_STATUS_ID=p2.PMT_STATUS_ID and p.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and p.CATEGARY_ID=p3.CATEGARY_ID and proj_id="+id;
			//* from TBL_PROJECTMASTER order by PROJ_ID";
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new ProjectMasterBean();
				bean.setProjectId(rs.getInt("PROJ_ID"));
				bean.setProjectName(rs.getString("PROJ_NAME"));
				bean.setProjectdescription(rs.getString("PROJ_DESCRIPTION"));
				bean.setProj_estimated_start_date(rs.getString("PROJ_ESTIMATED_START_DATE"));
				bean.setProj_actual_start_date(rs.getString("PROJ_ACTUAL_START_DATE"));
				bean.setProj_estimated_end_date(rs.getString("PROJ_ESTIMATED_END_DATE"));
				bean.setProj_actual_end_date(rs.getString("PROJ_ACTUAL_END_DATE"));
				bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
				bean.setPmtStatus(rs.getString("PMT_STATUS"));
				bean.setProjCategary(rs.getString("PROJECT_CATEGARY"));
				
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
}
