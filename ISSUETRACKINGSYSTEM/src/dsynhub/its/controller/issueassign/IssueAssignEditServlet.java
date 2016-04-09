package dsynhub.its.controller.issueassign;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.dao.IssueAssignDao;
import dsynhub.its.dao.PmtStatusDao;
import dsynhub.its.dao.ProjectMasterDao;

public class IssueAssignEditServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int assignId=Integer.parseInt(request.getParameter("did"));
		IssueAssignDao  dao=new IssueAssignDao();
		IssueAssignBean bean=new IssueAssignBean();
		bean.setIssueAssignId(assignId);
		
		System.out.println("assignid"+assignId);
		ArrayList<IssueAssignBean>list=dao.dataListIssueAssign(assignId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueAssignEdit.jsp").forward(request, response);
		}
		else
		{
			
			System.out.println("List is null");
		}
		
		
		
		}
}
