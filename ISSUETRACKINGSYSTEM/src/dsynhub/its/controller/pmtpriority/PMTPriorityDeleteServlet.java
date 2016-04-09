package dsynhub.its.controller.pmtpriority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.dao.PMTPriorityDao;
import dsynhub.its.dao.SequrityQuestionDao;

public class PMTPriorityDeleteServlet extends HttpServlet {
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
		
		int strPriorityId=Integer.parseInt(request.getParameter("did"));
		PMTPriorityDao dao=new PMTPriorityDao();
		boolean flag=false;
		flag=dao.dataDelete(strPriorityId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
			
		}
		else
		{
			request.setAttribute("delete","<font color=red>child record already exist so,cant deleted</font>");
			System.out.println("not deleted....");
			request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
		}
		
		
		
	}


}
