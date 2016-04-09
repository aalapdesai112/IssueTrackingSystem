package dsynhub.its.controller.projectmaster;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.dao.ProjectMasterDao;

public class ProjectMasterDeleteServlet extends HttpServlet
{

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
		// TODO Auto-generated method stub
		
			int deleteId=Integer.parseInt(request.getParameter("did"));
			System.out.println("............."+deleteId);
			
			ProjectMasterBean bean=new ProjectMasterBean();
			bean.setProjectId(deleteId);
			ProjectMasterDao dao=new ProjectMasterDao();
			boolean flag=dao.dataDeleteProjectMaster(bean);
			if(flag)
			{
				response.sendRedirect("ProjectMasterViewServlet");
			}
			else
			{
				response.sendRedirect("ProjectMasterViewServlet");
			}
		
		}
}
