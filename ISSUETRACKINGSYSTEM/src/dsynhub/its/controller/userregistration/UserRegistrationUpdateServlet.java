package dsynhub.its.controller.userregistration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.dao.UserRegistrationDao;

public class UserRegistrationUpdateServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		int strid=Integer.parseInt(request.getParameter("hid"));
		System.out.println("Update Id======="+strid);
		String firstName=request.getParameter("firstname");
		String middleName=request.getParameter("middlename");
		
		String lastName=request.getParameter("lastname");
		String currentAddress=request.getParameter("currentaddress");
		
		
		String pAddress=request.getParameter("permentaddress");
		int cityId=Integer.parseInt(request.getParameter("city"));
		
		String birthDate=request.getParameter("birthDate");
		String gender=request.getParameter("gender");
		
		
		String phNum=request.getParameter("phonenum");
		String mobileNum=request.getParameter("mobilenum");
		
		String emailId=request.getParameter("emailid");
		int typeId=Integer.parseInt(request.getParameter("type_id"));
		
		int questionId=Integer.parseInt(request.getParameter("question_id"));
		String sequrityQuestionAns=request.getParameter("sequrityQuestion");
		
		String userStatus=request.getParameter("userstatus");
		
		UserRegistrationBean bean=new UserRegistrationBean();
		bean.setUserId(strid);
		bean.setUserFirstName(firstName);
		bean.setUserMiddleName(middleName);
		bean.setUserLastName(lastName);
		bean.setUser_Res_Address(currentAddress);
		bean.setUser_Per_Address(pAddress);	
		bean.setCityId(cityId);
		bean.setUserGender(gender);
		bean.setBirthDate(birthDate);
		bean.setEmailId(emailId);
		bean.setUser_Phone_No(phNum);
		bean.setUserStatus(userStatus);
		bean.setUser_Mobile_No(mobileNum);
		bean.setTypeId(typeId);
		bean.setSequrityQuestionId(questionId);
		bean.setSequrityQuestionAns(sequrityQuestionAns);
		UserRegistrationDao dao=new UserRegistrationDao();
		boolean flag=dao.dataUpdateUserRegistration(bean);	
		if(flag)
		{
			request.getRequestDispatcher("UserRegistrationViewServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			System.out.println("Not Updated......");
		}
	}
}