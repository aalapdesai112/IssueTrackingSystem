package dsynhub.its.controller.issuedetail;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.dao.IssueDetailDao;

public class IssueDetailDeleteServlet extends HttpServlet{
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		IssueDetailDao dao=new IssueDetailDao();
		IssueDetailBean bean=new IssueDetailBean();
		bean.setIssueId(id);
		boolean flag=dao.dataDeleteIssueDetail(bean);
		if(flag)
		{
			System.out.println("deleted.....");
			response.sendRedirect("IssueDetailList.jsp");
		}
		else
		{
			System.out.println("not deleted.........");
		}
	}

}
