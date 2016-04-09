package dsynhub.its.controller.issuepriority;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssuePriorityBean;
import dsynhub.its.dao.IssuePriorityDao;
public class IssuePriorityInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String strissueleval = request.getParameter("issuepriorityname");
		IssuePriorityDao dao = new IssuePriorityDao();
		IssuePriorityBean bean = new IssuePriorityBean();

		boolean flag = false;
		boolean isError = false;
		

		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (strissueleval.isEmpty() ||strissueleval.trim().length()==0)
		{
			isError = true;
			request.setAttribute("seq","<font color=red>Enter the issuepriority</font>");
		}	
		else if(strissueleval.trim().length()>50)
		{
			isError = true;
			request.setAttribute("seq","<font color=red>size exided from 50 in issuepriority</font>");
			
		}
		else if(pattern1.matcher(strissueleval).matches()==false)
		{
			isError = true;
			request.setAttribute("seq","<font color=red>only character enter in issuepriority</font>");
		}
		else
		{
			bean.setIssuePrioritylevel(strissueleval);
		}
		if (isError == true)
		{
			request.getRequestDispatcher("IssuePriorityInsert.jsp").forward(request, response);
		} else {
			boolean flag1 = dao.duplicate(strissueleval);
			System.out.println("flag1..................."+flag1);
			if (flag1 == false) {
				flag = dao.dataInsert(bean);
				if (flag == true)
				{
					System.out.println("Inserted........");
					request.getRequestDispatcher("IssuePriorityListServlet").forward(request, response);
				}
				else
				{
					System.out.println("not inserted,...");
				}
			}
			else
			{
				System.out.println("data is already in table......");
				request.getRequestDispatcher("IssuePriorityListServlet").forward(request, response);
			}
		}
	}
}
