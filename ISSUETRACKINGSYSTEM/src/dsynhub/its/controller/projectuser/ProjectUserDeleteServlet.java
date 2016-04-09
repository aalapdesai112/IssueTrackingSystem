package dsynhub.its.controller.projectuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.dao.ProjectUserDao;
import dsynhub.its.dao.SequrityQuestionDao;

public class ProjectUserDeleteServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int strUserProjId=Integer.parseInt(request.getParameter("did"));
		ProjectUserDao dao=new ProjectUserDao();
		boolean flag=false;
		flag=dao.dataDeleteProjectUser(strUserProjId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("ProjectUserListServlet").forward(request, response);
			
		}
		else
		{
			System.out.println("not deleted....");
		}
		
		
		
	}
}
