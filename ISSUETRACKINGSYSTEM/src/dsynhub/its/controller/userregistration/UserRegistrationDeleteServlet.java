package dsynhub.its.controller.userregistration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.dao.UserRegistrationDao;

public class UserRegistrationDeleteServlet extends HttpServlet{	
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int strdeleteId=Integer.parseInt(request.getParameter("hid"));
		UserRegistrationDao dao=new UserRegistrationDao();
		boolean flag=false;
		flag=dao.dataDeleteUserRegistration(strdeleteId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("UserRegistrationListServlet").forward(request, response);
			
		}
		else
		{
			System.out.println("not deleted....");
		}
		
		
		
	}


}
