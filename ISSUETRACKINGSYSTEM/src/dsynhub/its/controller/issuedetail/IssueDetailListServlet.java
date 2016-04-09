package dsynhub.its.controller.issuedetail;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.dao.IssueDetailDao;

public class IssueDetailListServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doPost(request, response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
			ArrayList<IssueDetailBean> list=new ArrayList<IssueDetailBean>();
			IssueDetailBean bean=null;
			IssueDetailDao dao=new IssueDetailDao();
			
			list=dao.dataSelectIssueDetail();
			if(list!=null)
			{
				request.setAttribute("issuedetaillist", list);
				
				
			}
			else
			{
				System.out.println("list is empty......");
			}
			
			response.sendRedirect("IssueDetailList.jsp");
	}
}
