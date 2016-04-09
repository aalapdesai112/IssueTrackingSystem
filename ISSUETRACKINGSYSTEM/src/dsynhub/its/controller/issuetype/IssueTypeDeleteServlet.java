package dsynhub.its.controller.issuetype;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueTypeBean;

import dsynhub.its.dao.IssueTypeDao;

public class IssueTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	IssueTypeBean bean=new IssueTypeBean();
	IssueTypeDao dao=new IssueTypeDao();
	int id=Integer.parseInt(request.getParameter("hid"));
	System.out.println("ID"+id);
	bean.setIssuetypeid(id);
	boolean flag=dao.delete(bean);
	if(flag==true)
	{
			RequestDispatcher rd=request.getRequestDispatcher("IssueTypeListServlet");
			rd.forward(request, response);
	}
}
}

