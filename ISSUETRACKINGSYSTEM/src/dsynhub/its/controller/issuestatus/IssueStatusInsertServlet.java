package dsynhub.its.controller.issuestatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.dao.IssueStatusDao;

public class IssueStatusInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
			{
				PrintWriter out = response.getWriter();
				String IssueStatus = request.getParameter("issuestatus");
				boolean isError = false;
				IssueStatusBean bean = new IssueStatusBean();
				Pattern pattern1=Pattern.compile(".*[A-z].*");
				if (IssueStatus.isEmpty() ||IssueStatus.trim().length()==0)
				{
					isError = true;
					request.setAttribute("IssueStatus","<font color=red>Enter the IssueStatus</font>");
				}	
				else if(IssueStatus.trim().length()>50)
				{
					isError = true;
					request.setAttribute("IssueStatus","<font color=red>size exided from 50 in IssueStatus</font>");
					
				}
				else if(pattern1.matcher(IssueStatus).matches()==false)
				{
					isError = true;
					request.setAttribute("IssueStatus","<font color=red>only character enter in IssueStatus</font>");
				}
				else
				{
					bean.setIssuestatus(IssueStatus);
				}
				if (isError == true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("IssueStatusInsert.jsp");
					rd.forward(request, response);
				}
				else
				{
					IssueStatusDao dao = new IssueStatusDao();
					boolean flag1 = dao.duplicate(IssueStatus);
					System.out.println("flag1" + flag1);
					request.setAttribute("bean", bean);
					if (flag1 == false)
					{
						boolean flag = dao.insert(bean);
						if (flag == true)
						{
							RequestDispatcher rd = request.getRequestDispatcher("IssueStatusListServlet");
							rd.forward(request, response);
							out.write("<font size=6 color=green>inserted successfully</font>");
						}
						else
						{
							request.setAttribute("duplicate","<font color=red>Issue Status exist </font>");
							RequestDispatcher rd = request.getRequestDispatcher("IssueStatusListServlet");
							rd.forward(request, response);
						}
					}
					else
					{
						request.setAttribute("duplicate","<font color=red>Issue Status exist </font>");
						RequestDispatcher rd = request.getRequestDispatcher("IssueStatusListServlet");
						rd.forward(request, response);
						out.write("<font size=6 color=green>not inserted  successfully because data already exit</font>");
					}
				}
			}
}
