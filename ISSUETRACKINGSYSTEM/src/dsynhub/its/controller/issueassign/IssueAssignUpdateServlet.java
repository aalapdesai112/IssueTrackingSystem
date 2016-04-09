package dsynhub.its.controller.issueassign;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.dao.IssueAssignDao;
public class IssueAssignUpdateServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("did"));
		String issueId=request.getParameter("issuename");
		int issueassign = Integer.parseInt(request.getParameter("issueassign"));
		String issueReported=request.getParameter("issuereported");
		String assignDate=request.getParameter("issueassigndate");
		IssueAssignBean bean=new IssueAssignBean();
		
		bean.setIssueAssignId(id);
		bean.setIssueId(Integer.parseInt(issueId));
		bean.setIssueAssignTo(issueassign);
		bean.setIssueReportedBy(issueReported);
		bean.setAssignDate(assignDate);
		request.setAttribute("bean",bean);
		 IssueAssignDao dao=new IssueAssignDao();
//		 boolean flag1=dao.duplicate(pmtStatus);
//		 if(flag1==false)
//		 {
	        boolean flag= dao.dataUpdateIssueAssign(bean);
	        if(flag==true)
	        {
	        	System.out.println("updated");
	        	RequestDispatcher rd=request.getRequestDispatcher("IssueAssignListServlet");
	    		rd.forward(request,response);
	        }
	        else
	    	 {
	    		 RequestDispatcher rd = request.getRequestDispatcher("IssueAssignListServlet");
	    		 rd.forward(request, response);
	    	 }
	  	}
	}