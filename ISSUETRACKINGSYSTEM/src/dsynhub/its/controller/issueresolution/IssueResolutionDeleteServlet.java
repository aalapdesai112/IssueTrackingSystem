package dsynhub.its.controller.issueresolution;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueResolutionBean;
import dsynhub.its.dao.IssueResolutionDao;

public class IssueResolutionDeleteServlet extends HttpServlet{
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
		IssueResolutionBean bean=new IssueResolutionBean();
		bean.setIssueResolutionId(deleteId);
		IssueResolutionDao dao=new IssueResolutionDao();
		boolean flag=dao.dataDeleteIssueResolution(bean);
		if(flag)
		{
			response.sendRedirect("IssueResolutionListServlet");
		}
		else
		{
			response.sendRedirect("IssueResolutionListServlet");
		}
	}
}