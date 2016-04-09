package dsynhub.its.controller.projectuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.dao.ProjectUserDao;

public class ProjectUserUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		int id=Integer.parseInt(request.getParameter("did"));
		
		ProjectUserDao dao=new ProjectUserDao();
		ProjectUserBean bean=new ProjectUserBean();
		
		bean.setProjUserId(id);
		int roleId=Integer.parseInt(request.getParameter("role_id"));;
		int projId=Integer.parseInt(request.getParameter("proj_id"));;
		int userId=Integer.parseInt(request.getParameter("user_id"));;
		
		
		bean.setProjId(projId);
		bean.setUserId(userId);
		bean.setRoleId(roleId);
		
		boolean flag=dao.dataUpdateProjectUser(bean);
		if(flag)
		{
			
			request.getRequestDispatcher("ProjectUserListServlet").forward(request, response);
			System.out.println("updated...");
		}
		else
		{
			request.getRequestDispatcher("ProjectUserListServlet").forward(request, response);
			System.out.println("not updated........");
		}
		
		
	}
	
}
