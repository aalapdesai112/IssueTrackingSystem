package dsynhub.its.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.util.DBConnection;
public class UserRegistrationDao {
	public boolean dataInsertRegistertion(UserRegistrationBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				String strInsert = "insert into TBL_USER_REGISTRATION values(TBL_USER_REGISTRATION_SEQ.nextval,?,?,?,?,?,?,?,to_date(?,'dd-mm-yy'),?,?,?,?,?,?,?,sysdate,?)";
				pstmt = conn.prepareStatement(strInsert);
				pstmt.setString(1, bean.getUserFirstName());
				pstmt.setString(2, bean.getUserMiddleName());
				pstmt.setString(3, bean.getUserLastName());
				pstmt.setString(4, bean.getUser_Res_Address());
				pstmt.setString(5, bean.getUser_Per_Address());
				pstmt.setInt(6, bean.getCityId());
				pstmt.setString(7, bean.getUserGender());
				pstmt.setString(8, bean.getBirthDate());
				pstmt.setString(9, bean.getUser_Phone_No());
				pstmt.setString(10, bean.getUser_Mobile_No());
				pstmt.setString(11, bean.getEmailId());
				pstmt.setString(12, bean.getPassWord());
				pstmt.setInt(13, bean.getTypeId());
				pstmt.setInt(14, bean.getSequrityQuestionId());
				pstmt.setString(15, bean.getSequrityQuestionAns());
				pstmt.setString(16, bean.getUserStatus());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag=true;
					System.out.println("data Inseted.......");
				} else {
					System.out.println("Data Not Inserted........");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	public ArrayList<UserRegistrationBean> dataSelectRegistration()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		UserRegistrationBean bean=null;
		ArrayList< UserRegistrationBean> list=new ArrayList<UserRegistrationBean>();
		if(conn!=null)
		{		
			try
			{
				String strSelect="select r.USER_ID,r.USER_FIRSTNAME,r.USER_MIDDLENAME,r.USER_LASTNAME,r.USER_ADDRESS_R,r.USER_ADDRESS_P,r.USER_GENDER,r.city_id,to_char(r.DATE_OF_BIRTH)DATE_OF_BIRTH,r.USER_PHONE_NO,r.USER_MOBILE_NO,r.USER_EMAIL_ID,to_char(r.USER_LOGIN_DATE)USER_LOGIN_DATE,r.QUESTION_ANS,r.user_status,u.User_Type,c.city_name,s.QUESTION_NAME from TBL_USER_REGISTRATION r,TBL_CITY c,tbl_user_type u,SEQURITY_QUESTION s where r.city_id=c.city_id and r.user_type_id=u.user_type_id and r.QUESTION_ID=s.QUESTION_ID";				
				pstmt=conn.prepareStatement(strSelect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new UserRegistrationBean();
					bean.setUserId(rs.getInt("USER_ID"));
					bean.setUserFirstName(rs.getString("USER_FIRSTNAME"));
					bean.setUserMiddleName(rs.getString("USER_MIDDLENAME"));
					bean.setUserLastName(rs.getString("USER_LASTNAME"));
					bean.setUser_Res_Address(rs.getString("USER_ADDRESS_R"));
					bean.setUser_Per_Address(rs.getString("USER_ADDRESS_P"));
					bean.setCityId(rs.getInt("CITY_ID"));
					bean.setCityName(rs.getString("city_name"));			
					bean.setUserGender(rs.getString("USER_GENDER"));
					bean.setBirthDate(rs.getString("DATE_OF_BIRTH"));
					bean.setUser_Phone_No(rs.getString("USER_PHONE_NO"));
					bean.setUser_Mobile_No(rs.getString("USER_MOBILE_NO"));
					bean.setEmailId(rs.getString("USER_EMAIL_ID"));
					bean.setUserType(rs.getString("USER_TYPE"));
					bean.setSecurity_Question(rs.getString("QUESTION_NAME"));
					bean.setSequrityQuestionAns(rs.getString("QUESTION_ANS"));
					bean.setLoginDate(rs.getString("USER_LOGIN_DATE"));
					bean.setUserStatus(rs.getString("user_status"));
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
	public ArrayList<UserRegistrationBean> dataSelect1Registration(int id)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DBConnection.getConnection();
		UserRegistrationBean bean=null;
		ArrayList< UserRegistrationBean> list=new ArrayList<UserRegistrationBean>();
		if(conn!=null)
		{
			try
			{
				String strSelect="select r.USER_ID,r.USER_FIRSTNAME,r.USER_MIDDLENAME,r.USER_LASTNAME,r.USER_ADDRESS_R,r.USER_ADDRESS_P,r.city_id,r.USER_GENDER,to_char(r.DATE_OF_BIRTH)DATE_OF_BIRTH,r.USER_PHONE_NO,r.USER_MOBILE_NO,r.USER_EMAIL_ID,to_char(r.USER_LOGIN_DATE)USER_LOGIN_DATE,r.user_status,u.USER_TYPE,c.city_name,s1.state_name,c1.country_name,s.QUESTION_NAME,r.QUESTION_ANS from TBL_USER_REGISTRATION r,TBL_CITY c,TBL_USER_TYPE u,SEQURITY_QUESTION s,tbl_state s1,tbl_country c1 where r.city_id=c.city_id and r.user_type_id=u.user_type_id and r.QUESTION_ID=s.QUESTION_ID and c.state_id=s1.state_id and s1.country_id=c1.country_id and r.user_id="+id;
				pstmt=conn.prepareStatement(strSelect);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new UserRegistrationBean();
					bean.setUserId(rs.getInt("USER_ID"));
					bean.setUserFirstName(rs.getString("USER_FIRSTNAME"));
					bean.setUserMiddleName(rs.getString("USER_MIDDLENAME"));
					bean.setUserLastName(rs.getString("USER_LASTNAME"));
					bean.setUser_Res_Address(rs.getString("USER_ADDRESS_R"));
					bean.setUser_Per_Address(rs.getString("USER_ADDRESS_P"));
					bean.setCityId(rs.getInt("CITY_ID"));
					bean.setCityName(rs.getString("city_name"));
					bean.setStateName(rs.getString("STATE_NAME"));
					bean.setCountryName(rs.getString("COUNTRY_NAME"));
					bean.setUserGender(rs.getString("USER_GENDER"));
					bean.setBirthDate(rs.getString("DATE_OF_BIRTH"));
					bean.setUser_Phone_No(rs.getString("USER_PHONE_NO"));
					bean.setUser_Mobile_No(rs.getString("USER_MOBILE_NO"));
					bean.setEmailId(rs.getString("USER_EMAIL_ID"));
					bean.setUserType(rs.getString("USER_TYPE"));
					bean.setSecurity_Question(rs.getString("QUESTION_NAME"));
					bean.setSequrityQuestionAns(rs.getString("QUESTION_ANS"));
					bean.setLoginDate(rs.getString("USER_LOGIN_DATE"));
					bean.setUserStatus(rs.getString("user_status"));
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
public boolean dataDeleteUserRegistration(int id)
{
		boolean flag=false;
		Connection con=null;
		con=DBConnection.getConnection();
		PreparedStatement pstmt=null;		
		if(con!=null)
		{
			try
			{
				String deleteQuery="delete from TBL_USER_REGISTRATION where  USER_id="+id;
				pstmt=con.prepareStatement(deleteQuery);
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
	public boolean dataUpdateUserRegistration(UserRegistrationBean bean)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection.getConnection();
		if(conn!=null)
		{			
			String strUpdate="update TBL_USER_REGISTRATION set USER_FIRSTNAME=?,USER_MIDDLENAME=?,USER_LASTNAME=?,USER_ADDRESS_R=?,USER_ADDRESS_P=?,CITY_ID=?,USER_GENDER=?,DATE_OF_BIRTH=to_date(?,'dd-mm-yy'),USER_PHONE_NO=?,USER_MOBILE_NO=?,USER_EMAIL_ID=?,USER_TYPE_ID=?,QUESTION_ID=?,QUESTION_ANS=?,USER_STATUS=? where USER_ID=?";
			try 
			{
				pstmt=conn.prepareStatement(strUpdate);
				pstmt.setString(1, bean.getUserFirstName());
				pstmt.setString(2,bean.getUserMiddleName());
				pstmt.setString(3, bean.getUserLastName());
				pstmt.setString(4, bean.getUser_Res_Address());
				pstmt.setString(5, bean.getUser_Per_Address());
				pstmt.setInt(6, bean.getCityId());
				pstmt.setString(7, bean.getUserGender());
				pstmt.setString(8, bean.getBirthDate());
				pstmt.setString(9,bean.getUser_Phone_No());
				pstmt.setString(10,bean.getUser_Mobile_No());
				pstmt.setString(11,bean.getEmailId());
				pstmt.setInt(12,bean.getTypeId());
				pstmt.setInt(13, bean.getSequrityQuestionId());
				pstmt.setString(14,bean.getSequrityQuestionAns());
				pstmt.setString(15, bean.getUserStatus());
				pstmt.setInt(16, bean.getUserId());
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
}