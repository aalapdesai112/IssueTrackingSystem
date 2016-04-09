package dsynhub.its.controller.issueresolution;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.bean.IssueResolutionBean;
import dsynhub.its.dao.IssueAssignDao;
import dsynhub.its.dao.IssueResolutionDao;

public class IssueResolutionUpdateServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("did"));
		String issueId=request.getParameter("issuename");
		String issueactiontype = request.getParameter("actiontype");
		String actionDescription=request.getParameter("issueactiondes");
		int issueresolvedby = Integer.parseInt(request.getParameter("resolvedby"));
		String resolvedDate=request.getParameter("resolveddate");
		IssueResolutionBean bean=new IssueResolutionBean();
		
		bean.setIssueResolutionId(id);
		bean.setIssueId(Integer.parseInt(issueId));
		bean.setIssueActionType(issueactiontype);
		bean.setIssueActionDescription(actionDescription);
		bean.setIssueResolvedBy(issueresolvedby);
		System.out.println("resolved by............"+issueresolvedby);
		bean.setIssueResolvedDate(resolvedDate);
		request.setAttribute("bean",bean);
		 IssueResolutionDao dao=new IssueResolutionDao();
//		 boolean flag1=dao.duplicate(pmtStatus);
//		 if(flag1==false)
//		 {
	        boolean flag= dao.dataUpdateIssueResolution(bean);
	        if(flag==true)
	        {
	        	System.out.println("updated");
	        	RequestDispatcher rd=request.getRequestDispatcher("IssueResolutionListServlet");
	    		rd.forward(request,response);
	        }
	        else
	    	 {
	    		 RequestDispatcher rd = request.getRequestDispatcher("IssueResolutionListServlet");
	    		 rd.forward(request, response);
	    	 }
	  	}
}
