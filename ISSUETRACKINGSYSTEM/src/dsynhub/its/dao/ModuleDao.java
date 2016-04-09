package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.its.bean.ModuleBean;
import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.util.DBConnection;

public class ModuleDao {
	public Boolean DataInsertModule(ModuleBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into TBL_MODULE(module_id,module_name,module_description,module_estimate_start_date,module_actual_start_date,module_estimate_end_date,module_actual_end_date,PMT_PRIORITY_ID,pmt_status_id,proj_id) values(tbl_module_seq.nextval,?,?,to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),to_date(?,'dd-mm-yy'),?,?,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getModuleName());
				pstmt.setString(2, bean.getModuleDescription());
				pstmt.setString(3, bean.getModuleEstimateStartDate());
				pstmt.setString(4, bean.getModuleActualStartDate());
				pstmt.setString(5, bean.getModuleEstimateEndDate());
				pstmt.setString(6, bean.getModuleActualEndDate());
				pstmt.setInt(7, bean.getPmtPriorityId());
				pstmt.setInt(8, bean.getPmtStatusId());
				pstmt.setInt(9, bean.getProjectId());
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
	
	public boolean dataDeleteModule(ModuleBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		
		if(conn!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_MODULE where  MODULE_ID=?";
				pstmt=conn.prepareStatement(deleteQuery);
				pstmt.setInt(1,bean.getModuleId());
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
	public boolean dataUpdateModule(ModuleBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update tbl_module set MODULE_NAME=?,MODULE_DESCRIPTION=?,MODULE_ESTIMATE_START_DATE=to_date(?,'dd-mm-yy'),MODULE_ACTUAL_START_DATE=to_date(?,'dd-mm-yy'),MODULE_ESTIMATE_END_DATE=to_date(?,'dd-mm-yy'),MODULE_ACTUAL_END_DATE=to_date(?,'dd-mm-yy'),PMT_PRIORITY_ID=?,PMT_STATUS_ID=?,PROJ_ID=? where MODULE_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getModuleName());			
				pstmt.setString(2,bean.getModuleDescription());
				pstmt.setString(3, bean.getModuleEstimateStartDate());
				pstmt.setString(4, bean.getModuleActualStartDate());
				pstmt.setString(5, bean.getModuleEstimateEndDate());
				pstmt.setString(6, bean.getModuleActualEndDate());
				pstmt.setInt(7, bean.getPmtPriorityId());
				pstmt.setInt(8, bean.getPmtStatusId());
				pstmt.setInt(9, bean.getProjectId());
				pstmt.setInt(10, bean.getModuleId());
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
	public boolean duplicateModule(String strselect1)
	{
		Boolean flag = false;		
		ModuleBean bean1 = null;
		ArrayList<ModuleBean> list = dataSelectModule();
		String query="";
		for(int i=0;i<list.size();i++)
		{	
			bean1=(ModuleBean)list.get(i);
			query=bean1.getModuleName();			
			if(query.equals(strselect1))
			{
				flag=true;
			}
		}
		return flag;
	}
public ArrayList<ModuleBean> dataSelectModule()
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	ModuleBean bean=null;
	ArrayList< ModuleBean> list=new ArrayList<ModuleBean>();
	if(conn!=null)
	{
			try
			{
				//String strselect="select m.module_id,m.module_name,m.MODULE_DESCRIPTION,to_char(m.MODULE_ESTIMATE_START_DATE)MODULE_ESTIMATE_START_DATE,to_char(m.MODULE_ACTUAL_START_DATE)MODULE_ACTUAL_START_DATE,to_char(m.MODULE_ESTIMATE_END_DATE)MODULE_ESTIMATE_END_DATE,to_char(m.MODULE_ACTUAL_END_DATE)MODULE_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_MODULE m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.pmt_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.PMT_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID ";
				String strselect1="select module_id,module_name,to_char(MODULE_ACTUAL_START_DATE)MODULE_ACTUAL_START_DATE,to_char(MODULE_ACTUAL_END_DATE)MODULE_ACTUAL_END_DATE from TBL_MODULE";
				pstmt=conn.prepareStatement(strselect1);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ModuleBean();
					bean.setModuleId(rs.getInt("MODULE_ID"));
					bean.setModuleName(rs.getString("MODULE_NAME"));
					bean.setModuleActualStartDate(rs.getString("MODULE_ACTUAL_START_DATE"));
					bean.setModuleActualEndDate(rs.getString("MODULE_ACTUAL_END_DATE"));
					list.add(bean);
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
		return list;
	}
public ArrayList<ModuleBean> dataListModule(int id)
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	conn=DBConnection.getConnection();
	ModuleBean bean=null;
	ArrayList< ModuleBean> list=new ArrayList<ModuleBean>();
	if(conn!=null)
	{
		try
		{
			String strselect="select m.module_id,m.MODULE_NAME,m.MODULE_DESCRIPTION,to_char(m.MODULE_ESTIMATE_START_DATE)MODULE_ESTIMATE_START_DATE,to_char(m.MODULE_ACTUAL_START_DATE)MODULE_ACTUAL_START_DATE,to_char(m.MODULE_ESTIMATE_END_DATE)MODULE_ESTIMATE_END_DATE,to_char(m.MODULE_ACTUAL_END_DATE)MODULE_ACTUAL_END_DATE,p1.PMT_PRIORITY,p2.PMT_STATUS,p3.PROJ_NAME from TBL_MODULE m,tbl_pmt_priority p1,tbl_pmt_status p2,tbl_projectmaster p3 where m.PMT_STATUS_ID=p2.PMT_STATUS_ID and m.PMT_PRIORITY_ID=p1.pmt_PRIORITY_ID and m.PROJ_ID=p3.PROJ_ID and module_id="+id;
			pstmt=conn.prepareStatement(strselect);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new ModuleBean();
				bean.setModuleId(rs.getInt("MODULE_ID"));
				bean.setModuleName(rs.getString("MODULE_NAME"));
				bean.setModuleDescription(rs.getString("MODULE_DESCRIPTION"));
				System.out.println("Description"+rs.getString("MODULE_DESCRIPTION"));
				bean.setModuleEstimateStartDate(rs.getString("MODULE_ESTIMATE_START_DATE"));
				bean.setModuleActualStartDate(rs.getString("MODULE_ACTUAL_START_DATE"));
				bean.setModuleEstimateEndDate(rs.getString("MODULE_ESTIMATE_END_DATE"));
				bean.setModuleActualEndDate(rs.getString("MODULE_ACTUAL_END_DATE"));
				bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
				bean.setPmtStatus(rs.getString("PMT_STATUS"));
				bean.setProjectName(rs.getString("PROJ_NAME"));		
				list.add(bean);
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
	return list;
	}



public List<ModuleBean> srch(String n) {
	// TODO Auto-generated method stub

	ArrayList<ModuleBean> list = new ArrayList<ModuleBean>();
	DBConnection db = new  DBConnection();
	Connection conn = null;
	conn=DBConnection.getConnection();
	ResultSet rs = null;
	PreparedStatement pstmt =null;
	ModuleBean bean = null;
	try {
		
		String select = "select m.*,pmt.pmt_priority,ps.pmt_status,p.proj_name from tbl_module m,tbl_pmt_priority pmt,tbl_pmt_status ps,tbl_projectmaster p where m.pmt_priority_id=pmt.pmt_priority_id and m.pmt_status_Id=ps.pmt_status_Id and m.proj_Id=p.proj_id and m.module_name=?";
		pstmt=conn.prepareStatement(select);
		System.out.println("Query->"+select);
		pstmt.setString(1,n);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new ModuleBean();
			bean.setModuleId(rs.getInt("MODULE_ID"));
			bean.setModuleName(rs.getString("MODULE_NAME"));
			bean.setModuleDescription(rs.getString("MODULE_DESCRIPTION"));
			System.out.println("Description"+rs.getString("MODULE_DESCRIPTION"));
			bean.setModuleEstimateStartDate(rs.getString("MODULE_ESTIMATE_START_DATE"));
			bean.setModuleActualStartDate(rs.getString("MODULE_ACTUAL_START_DATE"));
			bean.setModuleEstimateEndDate(rs.getString("MODULE_ESTIMATE_END_DATE"));
			bean.setModuleActualEndDate(rs.getString("MODULE_ACTUAL_END_DATE"));
			bean.setPmtPriority(rs.getString("PMT_PRIORITY"));
			bean.setPmtStatus(rs.getString("PMT_STATUS"));
			bean.setProjectName(rs.getString("PROJ_NAME"));	
			
			list.add(bean);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}




}