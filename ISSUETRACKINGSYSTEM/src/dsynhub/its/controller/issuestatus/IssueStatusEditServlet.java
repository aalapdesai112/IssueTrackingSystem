package dsynhub.its.controller.issuestatus;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.dao.IssueStatusDao;
public class IssueStatusEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int issuestatusid=Integer.parseInt(request.getParameter("hid"));
		IssueStatusDao  dao=new IssueStatusDao();
		IssueStatusBean bean=new IssueStatusBean();
		bean.setIssuestatusid(issuestatusid);
		System.out.println("ISSuestatusid"+issuestatusid);
		ArrayList<IssueStatusBean>list=dao.selectData(issuestatusid);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueStatusEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}
	}
}
