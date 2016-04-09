package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dsynhub.its.bean.IssueBean;
import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.util.DBConnection;

public class IssueDao {
	public Boolean DataInsertIssueDetail(IssueBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{
			String strInsert="insert into issuedetail values (issuedetailid.nextval,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getIssueDetail());
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


}
