package dsynhub.its.controller.pmtpriority;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.PMTPriorityBean;

import dsynhub.its.dao.PMTPriorityDao;


public class PMTPriorityInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Priorityname = request.getParameter("pmtpriorityname");
		PMTPriorityDao dao = new PMTPriorityDao();
		PMTPriorityBean bean = new PMTPriorityBean();
		boolean flag = false;
		boolean isError = false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (Priorityname.isEmpty() ||Priorityname.trim().length()==0)
		{
			isError = true;
			request.setAttribute("pmtPriority","<font color=red>Enter the PriorityName</font>");
		}	
		else if(Priorityname.trim().length()>50)
		{
			isError = true;
			request.setAttribute("pmtPriority","<font color=red>size exided from 50 in PriorityName</font>");
			
		}
		else if(pattern1.matcher(Priorityname).matches()==false)
		{
			isError = true;
			request.setAttribute("pmtPriority","<font color=red>only character enter in PriorityName</font>");
		}
		else
		{
			bean.setPMTPriorityName(Priorityname);
		}
		if (isError == true) {
			request.getRequestDispatcher("PMTPriorityInsert.jsp").forward(request, response);
		} 
		else
		{
			boolean flag1 = dao.duplicate(Priorityname);
			if (flag1 == false)
			{
				flag = dao.dataInsert(bean);
				if (flag == true) {
				System.out.println("Inserted........");
				request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
			}
			else
			{
					System.out.println("not inserted,...");
			}
		} 
		else
		{
				request.setAttribute("duplicate", "<font color=red> could not enter duplicate value....</font>");
				request.getRequestDispatcher("PMTPriorityListServlet").forward(request, response);
				System.out.println("data is already in table......");
		}
	}
}
}