package dsynhub.its.controller.issueassign;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.dao.IssueAssignDao;
public class IssueAssignInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String issueassign = request.getParameter("issueassign");
		String issueId=request.getParameter("issuename");
		String issueReported=request.getParameter("issuereported");
		String assignDate=request.getParameter("issueassigndate");
		IssueAssignDao dao = new IssueAssignDao();
		IssueAssignBean bean = new IssueAssignBean();
		boolean flag = false;
//		boolean isError = false;
//		Pattern pattern1=Pattern.compile(".*[A-z].*");
//		if (issuename.isEmpty() ||issuename.trim().length()==0)
//		{
//			isError = true;
//			request.setAttribute("seq","<font color=red>Enter the issuename</font>");
//		}	
//		else if(issuename.trim().length()>50)
//		{
//			isError = true;
//			request.setAttribute("seq","<font color=red>size exided from 50 in issuename</font>");
//			
//		}
//		else if(pattern1.matcher(issuename).matches()==false)
//		{
//			isError = true;
//			request.setAttribute("seq","<font color=red>only character enter in issuename</font>");
//		}
//		else
//		{
		
			bean.setIssueId(Integer.parseInt(issueId));
			bean.setIssueAssignTo(Integer.parseInt(issueassign));
			bean.setIssueReportedBy(issueReported);
			
			bean.setAssignDate(assignDate);
//		}
//		if (isError == true)
//		{
//			request.getRequestDispatcher("IssueAssignInsert.jsp").forward(request, response);
//		} else {
			
				flag = dao.insertIssueAssign(bean);
				if (flag == true)
				{
					System.out.println("Inserted........");
					request.getRequestDispatcher("IssueAssignListServlet").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("IssueAssignListServlet").forward(request, response);
					System.out.println("not inserted,...");
				}
			}
	
		}
	
//}

