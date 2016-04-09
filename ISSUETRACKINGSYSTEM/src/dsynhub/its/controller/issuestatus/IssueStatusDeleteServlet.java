package dsynhub.its.controller.issuestatus;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.dao.IssueStatusDao;
public class IssueStatusDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
			int id=Integer.parseInt(request.getParameter("hid"));
			IssueStatusBean bean=new IssueStatusBean();
			bean.setIssuestatusid(id);
			IssueStatusDao pstmtD=new IssueStatusDao();
			boolean flag=pstmtD.delete(bean);
			if(flag==true)
			{
					RequestDispatcher rd=request.getRequestDispatcher("IssueStatusListServlet");
					rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("IssueStatusListServlet");
				rd.forward(request, response);
			}
	}
}
