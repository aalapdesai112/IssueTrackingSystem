package dsynhub.its.controller.issueresolution;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueResolutionBean;
import dsynhub.its.dao.IssueResolutionDao;
public class IssueResolutionEditServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int resolutionId=Integer.parseInt(request.getParameter("did"));
		IssueResolutionDao  dao=new IssueResolutionDao();
		IssueResolutionBean bean=new IssueResolutionBean();
		bean.setIssueResolutionId(resolutionId);	
		System.out.println("resolutionId"+resolutionId);
		ArrayList<IssueResolutionBean>list=dao.dataListIssueResolution(resolutionId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueResolutionEdit.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("IssueResolutionEdit.jsp").forward(request, response);
			System.out.println("List is null");
		}
	}
}