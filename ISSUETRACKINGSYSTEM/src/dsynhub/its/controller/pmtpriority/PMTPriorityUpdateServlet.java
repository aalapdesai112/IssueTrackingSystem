package dsynhub.its.controller.pmtpriority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.PMTPriorityBean;

import dsynhub.its.dao.PMTPriorityDao;


public class PMTPriorityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int strid=Integer.parseInt(request.getParameter("id"));
		System.out.println(strid);
		String strPriorityName=request.getParameter("priorityname");
		PMTPriorityBean bean=new PMTPriorityBean();
		bean.setPMTPriorityId(strid);
		bean.setPMTPriorityName(strPriorityName);
		PMTPriorityDao dao=new PMTPriorityDao();
		boolean flag1=dao.duplicate(strPriorityName);
		if(flag1==false)
		{
		boolean flag=dao.dataUpdate(bean);
		System.out.println(flag);
		if(flag)
		{
			request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			System.out.println("Not Updated......");
		}
		}
		else
		{
			request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
		}
	}
}
