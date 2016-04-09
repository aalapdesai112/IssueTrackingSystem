package dsynhub.its.controller.issueassign;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueAssignBean;
import dsynhub.its.dao.IssueAssignDao;
public class IssueAssignListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
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
		
		IssueAssignDao dao=new IssueAssignDao();
		ArrayList<IssueAssignBean> list=dao.dataSelectIssueAssign();
		System.out.println("");
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueAssignList.jsp").forward(request, response);
		}
		else
		{
			System.out.println("list is null");
			request.getRequestDispatcher("IssueAssignList.jsp").forward(request, response);
		}	
	}
}
