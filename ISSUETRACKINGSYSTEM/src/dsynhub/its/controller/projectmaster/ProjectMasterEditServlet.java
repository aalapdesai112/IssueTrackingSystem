package dsynhub.its.controller.projectmaster;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.dao.IssueStatusDao;
import dsynhub.its.dao.PmtStatusDao;
import dsynhub.its.dao.ProjectMasterDao;

public class ProjectMasterEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId=Integer.parseInt(request.getParameter("did"));
		ProjectMasterDao  dao=new ProjectMasterDao();
		ProjectMasterBean bean=new ProjectMasterBean();
		bean.setProjectId(projectId);
		
		System.out.println("ProjectId"+projectId);
		ArrayList<ProjectMasterBean>list=dao.dataListProjectMaster(projectId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			
		}
		else
		{
			System.out.println("List is null");
		}
		
		PmtStatusDao sdao=new  PmtStatusDao();
		ArrayList<PMTStatusBean> list1=sdao.select();
		if(list1!=null)
		{
			request.setAttribute("list1", list1);
		
		}
		else
		{
			System.out.println("List is null");
		}
		request.getRequestDispatcher("ProjectMasterEdit.jsp").forward(request, response);
		}
	}
