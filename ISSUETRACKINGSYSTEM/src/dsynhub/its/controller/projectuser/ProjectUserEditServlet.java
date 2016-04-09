package dsynhub.its.controller.projectuser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.dao.PmtStatusDao;
import dsynhub.its.dao.ProjectUserDao;

public class ProjectUserEditServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("did"));
		ProjectUserDao  dao=new ProjectUserDao();
		ProjectUserBean bean=new ProjectUserBean();
		
		bean.setProjUserId(id);
		ArrayList<ProjectUserBean>list=dao.selectDataProjectUser1(id);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectUserEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}
}
