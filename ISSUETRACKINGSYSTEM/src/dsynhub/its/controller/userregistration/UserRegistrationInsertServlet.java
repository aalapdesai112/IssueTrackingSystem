package dsynhub.its.controller.userregistration;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.dao.UserRegistrationDao;

public class UserRegistrationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String firstName = request.getParameter("firstname");
		String middleName = request.getParameter("middlename");
		
		String lastName = request.getParameter("lastname");
		String currentAddress = request.getParameter("currentaddress");
		
		String permenentAddress = request.getParameter("parmentaddress");
		String cityId = request.getParameter("city");
		
		String gender = request.getParameter("gender");
		String userBirthDate = request.getParameter("birthdate");
		
		String Ph_no = request.getParameter("phonenumber");
		String Mobile_no = request.getParameter("Mobilenumber");
		
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		int type_id = Integer.parseInt(request.getParameter("type_id"));
		int securityQuestionId = Integer.parseInt(request.getParameter("securityqueid"));
		
		String securityQuesAns = request.getParameter("securityans");
		String UserloginDate = request.getParameter("UserloginDate");		
		String UserStatus = request.getParameter("userstatus");
		
		
		
		boolean isError = false;
		UserRegistrationBean bean=new UserRegistrationBean();
		
		
		Pattern pattern1 = Pattern.compile(".*[A-z].*");
		Pattern pattern2=Pattern.compile(".*[0-9].*");
		
		if (firstName.isEmpty())
		{
			isError = true;
			request.setAttribute("FirstName","<font color=red>Enter the FirstName</font>");
		}
		else if(firstName.trim().length() == 0)
			{
			isError = true;
			request.setAttribute("FirstName","<font color=red>Enter the FirstName</font>");
			
			}
		else if (firstName.trim().length() > 50) {
			
			isError = true;
			request.setAttribute("FirstName",
					"<font color=red>size exided from 50 in FirstName</font>");

		} else if (pattern1.matcher(firstName).matches() == false) {
			isError = true;
			request.setAttribute("FirstName",
					"<font color=red>only character enter in FirstName</font>");
		}
		else
		{
			bean.setUserFirstName(firstName);
			bean.setUserMiddleName(middleName);
		}
			
		

		//lastname
		if (lastName.isEmpty() || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastName",
					"<font color=red>Enter the lastName</font>");
		} else if (lastName.trim().length() > 50) {
			isError = true;
			request.setAttribute("FirstName",
					"<font color=red>size exided from 50 in FirstName</font>");

		} else if (pattern1.matcher(lastName).matches() == false) {
			isError = true;
			request.setAttribute("lastName",
					"<font color=red>only character enter in lastName</font>");
		}
		else
		{
			
						bean.setUserLastName(lastName);
		}
		
		//city ID
		if(cityId=="")
		{
			isError = true;
			request.setAttribute("cityId","<font color=red>not null city name</font>");
		}
		
		else
		{
			bean.setCityId(Integer.parseInt(cityId));
		}
	
		//perment address
		if (permenentAddress.isEmpty() || permenentAddress.trim().length() == 0) {
			isError = true;
			request.setAttribute("permenentAddress",
					"<font color=red>Enter the permenentAddress</font>");
		} else if (permenentAddress.trim().length() > 50) {
			isError = true;
			request.setAttribute("permenentAddress",
					"<font color=red>size exided from 200 in permenentAddress</font>");
		}
		else
		{
			bean.setUserGender(gender);
			bean.setUser_Per_Address(permenentAddress);
			bean.setUser_Res_Address(currentAddress);
		}

		
		
		//BirthDate.........
		if (userBirthDate.isEmpty()
				|| userBirthDate.trim().length() == 0) {
			isError = true;
			request.setAttribute("userBirthDate",
					"<font color=red>Enter the userBirthDate</font>");
		} else if (userBirthDate.trim().length() > 50) {
			isError = true;
			request.setAttribute("userBirthDate",
					"<font color=red>size exided from 50 in ProjectName</font>");

		} else 
		{
			bean.setBirthDate(userBirthDate);
		}
		
		
		
		
		//Mobile_no
		
		if (Mobile_no.isEmpty() || Mobile_no.trim().length() == 0) {
			isError = true;
			request.setAttribute("Mobile_no",
					"<font color=red>Enter the Mobile_no</font>");
		} else if (Mobile_no.trim().length() > 50) {
			isError = true;
			request.setAttribute("Mobile_no",
					"<font color=red>size exided from 50 in Mobile_no</font>");

		} else if (pattern2.matcher(Mobile_no).matches() == false) {
			isError = true;
			request.setAttribute("Mobile_no",
					"<font color=red>Only Number</font>");
		}
		else
		{
			
			bean.setUser_Phone_No(Ph_no);
			bean.setUser_Mobile_No(Mobile_no);
		}
				
		//EmailId.........
				if (emailId.isEmpty()
						|| emailId.trim().length() == 0) {
					isError = true;
					request.setAttribute("emailId",
							"<font color=red>Enter the emailId</font>");
				} else if (emailId.trim().length() > 100) {
					isError = true;
					request.setAttribute("emailId",
							"<font color=red>size exided from 100 in emailId</font>");

				} else 
				{
					bean.setEmailId(emailId);
					bean.setPassWord(password);
					bean.setTypeId(type_id);
					bean.setSequrityQuestionId(securityQuestionId);
				}
		
//		
//				//SecurityQuestion Answer.........
				if (securityQuesAns.isEmpty()
						|| securityQuesAns.trim().length() == 0) {
					isError = true;
					request.setAttribute("securityQuesAns",
							"<font color=red>Enter the securityQuesAns</font>");
				} else if (securityQuesAns.trim().length() > 150) {
					isError = true;
					request.setAttribute("securityQuesAns",
							"<font color=red>size exided from 150 in securityQuesAns</font>");

				} else 
				{
					bean.setSequrityQuestionAns(securityQuesAns);
					bean.setLoginDate(UserloginDate);
					bean.setUserStatus(UserStatus);
				}
		
		
//		bean.setUserMiddleName(middleName);
//		bean.setUserLastName(lastName);
//		bean.setCityId(cityId);
//		bean.setUserGender(gender);
//		bean.setUser_Per_Address(permenentAddress);
//		bean.setUser_Res_Address(currentAddress);
//		bean.setBirthDate(userBirthDate);
//		bean.setUser_Phone_No(Ph_no);
//		bean.setUser_Mobile_No(Mobile_no);
//		bean.setEmailId(emailId);
//		bean.setPassWord(password);
//		bean.setRoleId(role_id);
//		bean.setSequrityQuestionId(securityQuestionId);
//		bean.setSequrityQuestionAns(securityQuesAns);
//		bean.setLoginDate(UserloginDate);
//		bean.setUserStatus(UserStatus);
		
			if (isError == true) 
			{
					RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationInsert.jsp");
					rd.forward(request, response);
			} 
				else
				{		
						UserRegistrationDao dao=new UserRegistrationDao();
						boolean flag=dao.dataInsertRegistertion(bean);
						if(flag==true)
						{
								response.sendRedirect("UserRegistrationListServlet");
								System.out.println("data inserted........");
						}
						else
						{
							System.out.println("data not inserted..........");
						}
				}
		}
}
