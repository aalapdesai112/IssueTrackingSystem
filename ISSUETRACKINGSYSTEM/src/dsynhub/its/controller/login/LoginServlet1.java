package dsynhub.its.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("username........"+userName);
		System.out.println("password...."+password);
		
		if(userName.equals("admin") && password.equals("admin"))
		{
			System.out.println("login suceessful");
		}
	}

}
