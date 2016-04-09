package dsynhub.its.controller.issueresolution;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.bean.IssueResolutionBean;
import dsynhub.its.dao.IssueAssignDao;
import dsynhub.its.dao.IssueResolutionDao;
public class IssueResolutionInsertServlet extends HttpServlet{
private static final long serialVersionUID=1L;
@Override
protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
}
@Override
protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	String issueId=request.getParameter("issuename");
	String issueactiontype=request.getParameter("actionType");
	String issueactionDiscription=request.getParameter("actionDescription");
	int issueresolvedBy=Integer.parseInt(request.getParameter("issueresolvedBy"));
	String issueresolvedDate=request.getParameter("issueResolvedDate");
	IssueResolutionDao dao = new IssueResolutionDao();
	IssueResolutionBean bean = new IssueResolutionBean();
	boolean flag = false;
//	boolean isError = false;
//	Pattern pattern1=Pattern.compile(".*[A-z].*");
//	if (issuename.isEmpty() ||issuename.trim().length()==0)
//	{
//		isError = true;
//		request.setAttribute("seq","<font color=red>Enter the issuename</font>");
//	}	
//	else if(issuename.trim().length()>50)
//	{
//		isError = true;
//		request.setAttribute("seq","<font color=red>size exided from 50 in issuename</font>");
//		
//	}
//	else if(pattern1.matcher(issuename).matches()==false)
//	{
//		isError = true;
//		request.setAttribute("seq","<font color=red>only character enter in issuename</font>");
//	}
//	else
//	{
	
		bean.setIssueId(Integer.parseInt(issueId));
		bean.setIssueActionType(issueactiontype);
		bean.setIssueActionDescription(issueactionDiscription);
		bean.setIssueResolvedBy(issueresolvedBy);
		bean.setIssueResolvedDate(issueresolvedDate);
//	}
//	if (isError == true)
//	{
//		request.getRequestDispatcher("IssueAssignInsert.jsp").forward(request, response);
//	} else {
		
			flag = dao.insertIssueResolution(bean);
			if (flag == true)
			{
				System.out.println("Inserted........");
				request.getRequestDispatcher("IssueResolutionListServlet").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("IssueResolutionListServlet").forward(request, response);
				System.out.println("not inserted,...");
			}
		}

	}

//}


