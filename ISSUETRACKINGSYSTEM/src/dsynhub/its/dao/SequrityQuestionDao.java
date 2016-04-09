package dsynhub.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import dsynhub.its.bean.SequrityQuestionBean;
import dsynhub.its.util.DBConnection;

public class SequrityQuestionDao {
	
	public Boolean DataInsert(SequrityQuestionBean bean)
	{
		Boolean flag=false;		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		//SequrityQuestionBean bean= new SequrityQuestionBean();
		
		if(conn!=null)
		{
			String strInsert="insert into SEQURITY_QUESTION values(SEQURITYQUESTIONSEQ.nextval,?)";
			try {
				pstmt=conn.prepareStatement(strInsert);
				pstmt.setString(1,bean.getQuestionName());
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
					String strDelete="delete from SEQURITY_QUESTION where QUESTION_ID=?";
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
	public boolean dataUpdate(SequrityQuestionBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update SEQURITY_QUESTION set QUESTION_NAME=? where QUESTION_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getQuestionName());
				pstmt.setInt(2,bean.getQuestionId());
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
	public ArrayList<SequrityQuestionBean> dataSelect()
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		SequrityQuestionBean bean=null;
		ArrayList< SequrityQuestionBean> list=new ArrayList<SequrityQuestionBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from SEQURITY_QUESTION";
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new SequrityQuestionBean();
					bean.setQuestionId(rs.getInt(1));
					bean.setQuestionName(rs.getString(2));
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
	public boolean duplicate(String strselect1)
	{
		Boolean flag = false;		
		SequrityQuestionBean bean = null;
		ArrayList<SequrityQuestionBean> list = dataSelect();
		String query="";
		for(int i=0;i<list.size();i++)
					{
						bean=(SequrityQuestionBean)list.get(i)	;
						String str2=bean.getQuestionName();
						query=str2.toLowerCase().trim();
						if(strselect1.toLowerCase().trim().equals(query))
						{
							flag=true;
						}
					}
					return flag;
			}
public ArrayList<SequrityQuestionBean> dataSelect1(int id)
	{
		//boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		SequrityQuestionBean bean=null;
		ArrayList< SequrityQuestionBean> list=new ArrayList<SequrityQuestionBean>();
		if(conn!=null)
		{
			
			try
			{
				String strselect="select * from SEQURITY_QUESTION where QUESTION_ID="+id;
				pstmt=conn.prepareStatement(strselect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new SequrityQuestionBean();
					bean.setQuestionId(rs.getInt("QUESTION_ID"));
					System.out.println("id::"+rs.getInt("QUESTION_ID"));
					bean.setQuestionName(rs.getString("QUESTION_NAME"));
					System.out.println("name;;;;;"+rs.getString("QUESTION_NAME"));
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
