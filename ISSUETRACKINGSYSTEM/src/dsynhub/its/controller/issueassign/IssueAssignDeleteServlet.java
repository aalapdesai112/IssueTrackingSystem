package dsynhub.its.controller.issueassign;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.dao.IssueAssignDao;
public class IssueAssignDeleteServlet extends HttpServlet{
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
		int deleteId=Integer.parseInt(request.getParameter("did"));
		System.out.println("............."+deleteId);
		IssueAssignBean bean=new IssueAssignBean();
		bean.setIssueAssignId(deleteId);
		IssueAssignDao dao=new IssueAssignDao();
		boolean flag=dao.dataDeleteIssueAssign(bean);
		if(flag)
		{
			response.sendRedirect("IssueAssignListServlet");
		}
		else
		{
			response.sendRedirect("IssueAssignListServlet");
		}
	}
}