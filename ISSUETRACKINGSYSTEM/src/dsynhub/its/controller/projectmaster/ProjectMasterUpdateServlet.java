package dsynhub.its.controller.projectmaster;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dsynhub.its.bean.ProjectMasterBean;

import dsynhub.its.dao.ProjectMasterDao;

public class ProjectMasterUpdateServlet extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(request,response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	int strid=Integer.parseInt(request.getParameter("hid"));
	System.out.println("Update Id======="+strid);
	String projectName=request.getParameter("projectname");
	String projDescription=request.getParameter("projectdescrption");
	String estimatedStartDate=request.getParameter("estimated_start_date");
	String actualStartDate=request.getParameter("actual_start_date");
	String estimatedEndDate=request.getParameter("estimated_end_date");
	String actualEndDate=request.getParameter("actual_end_date");
	int statusId=Integer.parseInt(request.getParameter("Status_id"));
	int priorityId=Integer.parseInt(request.getParameter("project_priority_id"));
	int categoryId=Integer.parseInt(request.getParameter("project_categary_id"));
	
	ProjectMasterBean bean=new ProjectMasterBean();
	bean.setProjectId(strid);
	bean.setProjectName(projectName);
	System.out.println("project Name::::"+projectName);
	bean.setProjectdescription(projDescription);
	bean.setProj_estimated_start_date(estimatedStartDate);	
	bean.setProj_actual_start_date(actualStartDate);
	bean.setProj_estimated_end_date(estimatedEndDate);
	bean.setProj_actual_end_date(actualEndDate);
	bean.setStatusId(statusId);
	System.out.println("StatuId in servlet......."+statusId);
	System.out.println("Status Id in servlet.........(GetId)"+bean.getPmtStatus());
	bean.setPriorityId(priorityId);
	System.out.println("priority in servlet......."+priorityId);
	bean.setCategaryId(categoryId);
	System.out.println("Project CategaryId=="+categoryId);
	ProjectMasterDao dao=new ProjectMasterDao();
	
	boolean flag=dao.dataUpdateProjectMaster(bean);
	
	if(flag)
	{
		request.getRequestDispatcher("ProjectMasterViewServlet").forward(request, response);
		System.out.println("updated....??????...");
	}
	else
	{
		System.out.println("Not Updated......");
	}
	}
	
	}


