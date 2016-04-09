package dsynhub.its.controller.issuedetail;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.dao.IssueDetailDao;

public class IssueDetailEditServlet extends HttpServlet{
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
		
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println("ID on servlet............."+id);
			ArrayList<IssueDetailBean> list=new ArrayList<IssueDetailBean>();
			IssueDetailBean bean=new IssueDetailBean();
			bean.setIssueId(id);
			IssueDetailDao dao=new IssueDetailDao();
			list=dao.dataSelectIssueDetail1(id);
			if(list!=null)
			{
				request.setAttribute("list2", list);	
				request.getRequestDispatcher("IssueDetailEdit.jsp").forward(request, response);
				System.out.println("Selected.....");
			}
			else
			{
				System.out.println("list is null...");
			}

			
			
		}
}
