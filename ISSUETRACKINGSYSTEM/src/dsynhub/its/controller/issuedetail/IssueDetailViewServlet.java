package dsynhub.its.controller.issuedetail;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.dao.IssueDetailDao;
public class IssueDetailViewServlet extends HttpServlet{
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
		// TODO Auto-generated method stub
		
		IssueDetailDao dao=new IssueDetailDao();
		IssueDetailBean bean=null;
		ArrayList< IssueDetailBean> list=dao.dataSelectIssueDetail();
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueDetailView.jsp").forward(request, response);
		}
	}
}