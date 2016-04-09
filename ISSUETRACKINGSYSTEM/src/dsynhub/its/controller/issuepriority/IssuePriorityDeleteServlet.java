package dsynhub.its.controller.issuepriority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.dao.IssuePriorityDao;


public class IssuePriorityDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int strPriorityId=Integer.parseInt(request.getParameter("did"));
		IssuePriorityDao dao=new IssuePriorityDao();
		boolean flag=false;
		flag=dao.dataDelete(strPriorityId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("IssuePriorityListServlet").forward(request, response);
			
		}
		else
		{
			System.out.println("not deleted....");
		}
		
		
		
	}


}
