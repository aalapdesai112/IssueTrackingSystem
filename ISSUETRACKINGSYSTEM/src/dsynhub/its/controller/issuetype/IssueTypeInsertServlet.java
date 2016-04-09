package dsynhub.its.controller.issuetype;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueTypeBean;
import dsynhub.its.dao.IssueTypeDao;
public class IssueTypeInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				PrintWriter out=response.getWriter();
				String issuetype=request.getParameter("issuetype");
				boolean isError=false;
				IssueTypeBean bean=new IssueTypeBean();
				Pattern pattern1=Pattern.compile(".*[A-z].*");
				if (issuetype.isEmpty() ||issuetype.trim().length()==0)
				{
					isError = true;
					request.setAttribute("IssueType","<font color=red>Enter the IssueType</font>");
				}	
				else if(issuetype.trim().length()>50)
				{
					isError = true;
					request.setAttribute("IssueType","<font color=red>size exided from 50 in IssueType</font>");
					
				}
				else if(pattern1.matcher(issuetype).matches()==false)
				{
					isError = true;
					request.setAttribute("IssueType","<font color=red>only character enter in IssueType</font>");
				}
				else
				{
					bean.setIssuetype(issuetype);
				}
				if(isError==true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("IssueTypeinsert.jsp");
					rd.forward(request, response);
				}
		else
		{
		IssueTypeDao dao=new IssueTypeDao();
		boolean	flag1=dao.duplicate(issuetype);
		System.out.println("flag1"+flag1);
		request.setAttribute("bean",bean);
		if(flag1==false)
		{
			boolean flag= dao.insert(bean);
			if(flag==true)
	        {
	           	RequestDispatcher rd=request.getRequestDispatcher("IssueTypeListServlet");
	        	rd.forward(request,response);
	    		out.write("<font size=6 color=green>inserted successfully</font>");
	        }
	        else
	        {
	        	request.setAttribute("duplicate","<font color=red>Issue Type exist </font>");
				RequestDispatcher rd=request.getRequestDispatcher("IssueTypeListServlet");
	    		rd.forward(request,response);
	        }
		 }
		else
		{
			request.setAttribute("duplicate","<font color=red>Issue Type exist </font>");
			RequestDispatcher rd=request.getRequestDispatcher("IssueTypeListServlet");
    		rd.forward(request,response);
		}
	 }
}
}