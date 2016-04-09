package dsynhub.its.controller.login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsynhub.its.bean.UserRegistrationBean;
public class LoginServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(request, response);
}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
				System.out.println("username"+username);
				System.out.println("password"+password);
//		UserRegistrationBean bean=new UserRegistrationBean();
//		HttpSession session=request.getSession();
//		bean.setUserFirstName("priya");
//		bean.setUserMiddleName("shah");
//		bean.setUserLastName("shah");
//		bean.setCityName("Nadiad");
//		bean.setUserGender("female");
//		bean.setUser_Per_Address("abc");
//		bean.setUser_Res_Address("abc");
//		bean.setBirthDate("19-apr-1991");
//		bean.setUser_Phone_No("02682558236");
//		bean.setUser_Mobile_No("9428436239");
//		bean.setEmailId("shahpri19491@yahoo.com");	
//		bean.setPassWord("priya");
//		bean.setUserType("admin");
//		bean.setSequrityQuestionAns("what is yor nick name");
//		//bean.setSequrityQuestionAns(securityQuesAns);
//		bean.setLoginDate("08-05-2013");
//		bean.setUserStatus(UserStatus);
				
		if(username.equals("admin") && password.equals("admin"))
		{
			//session.setAttribute("LoginBean", bean);
//			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationListServlet");
//			rd.forward(request, response);
			response.sendRedirect("UserRegistrationListServlet");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}
}