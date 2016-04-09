package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dsynhub.its.bean.FeedbackBean;
import dsynhub.its.util.DBConnection;
public class FeedbackDao {
		public boolean insertDataFeedback(FeedbackBean bean)
		{
		Connection con = null;
		con =DBConnection.getConnection();
		PreparedStatement pstmt = null;
		boolean flag = false;
		if(con!=null)
		{
			try
			{
				String insertSQL = "INSERT INTO tbl_feedback VALUES(tbl_feedback_seq.NEXTVAL,?,?,to_date(?,'dd-MM-yy'))";		
				pstmt =con.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getFeedbackName() );
				pstmt.setString(2, bean.getFeedbackDescription());
				pstmt.setString(3, bean.getFeedbackDate());
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
public List<FeedbackBean> selectDataFeedback()
	{
		List<FeedbackBean> list=new ArrayList<FeedbackBean>();
		{
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			conn=DBConnection.getConnection();
			String selectSQL="select feedback_Id,feedback_Name,feedback_Description,to_char(feedback_Date)feedback_Date from tbl_feedback";
			try {
						pstmt=conn.prepareStatement(selectSQL);
						rs=pstmt.executeQuery();
				
				        FeedbackBean bean=null;
				
					while (rs.next())
					{
						bean=new FeedbackBean();
						bean.setFeedbackId(rs.getInt("feedback_Id"));
						bean.setFeedbackName(rs.getString("feedback_Name"));
						bean.setFeedbackDescription(rs.getString("feedback_Description"));
						bean.setFeedbackDate(rs.getString("feedback_Date"));
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
	
	public boolean deleteDataFeedback(int id)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=DBConnection.getConnection();
		String deleteSQL="delete  from  tbl_feedback where feedback_Id=?";
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1,id);
			int result=pstmt.executeUpdate();
			if (result>0)
				{
					System.out.println("Deleted The Data...");
					flag=true;
				}
			else
				{
					System.out.println("Not Deleted The Data...");
					flag=false;
				}
			
			} 
		catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return flag;
	}
	
	public FeedbackBean selectFeedback(int feedbackId)
	{
		FeedbackBean bean=null;
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		  
		conn = DBConnection.getConnection();
		String sql="select feedback_Id,feedback_Name,feedback_Description,to_char(feedback_Date)feedback_Date from tbl_feedback where feedback_Id =(?)";  
		try 
		{ 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, feedbackId);
			rs = pstmt.executeQuery();
			bean =new FeedbackBean();
			while(rs.next())
			{ 
				bean.setFeedbackId(rs.getInt("feedback_Id"));
				bean.setFeedbackName(rs.getString("feedback_Name"));
				bean.setFeedbackDescription(rs.getString("feedback_Description"));
				bean.setFeedbackDate(rs.getString("feedback_Date"));
			}
		  
		 }
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		}
		return bean;
	}
	public boolean updateDataFeedback(FeedbackBean bean) {
		Connection con=null;
		PreparedStatement pstmt =null;
		con=DBConnection.getConnection();
		boolean flag = false;
		try {
			String updateSQL = "UPDATE TBL_FEEDBACK	 SET FEEDBACK_NAME = ? , FEEDBACK_DESCRIPTION= ?, FEEDBACK_DATE = to_date(?,'dd-MM-yy')  WHERE FEEDBACK_ID = ?";
			pstmt = con.prepareStatement(updateSQL);
			pstmt.setString(1, bean.getFeedbackName());
			System.out.println("name"+bean.getFeedbackName());
			pstmt.setString(2,bean.getFeedbackDescription());
			System.out.println("description"+bean.getFeedbackDescription());
			pstmt.setString(3,bean.getFeedbackDate());
			System.out.println("date"+bean.getFeedbackDate());
			pstmt.setInt(4,bean.getFeedbackId());
			System.out.println("id"+bean.getFeedbackId());
			int result = pstmt.executeUpdate();
			if (result > 0)
			{
				flag=true;
				System.out.println("***updated Successfully***");
			}else{
				System.out.println("***updated not Successfully***");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return flag;
	}
}