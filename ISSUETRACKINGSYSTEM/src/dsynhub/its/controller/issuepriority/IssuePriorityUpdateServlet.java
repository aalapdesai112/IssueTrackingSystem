package dsynhub.its.controller.issuepriority;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssuePriorityBean;
import dsynhub.its.dao.IssuePriorityDao;
public class IssuePriorityUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int strid=Integer.parseInt(request.getParameter("id"));
		System.out.println(strid);
		String strPriorityName=request.getParameter("priorityname");
		IssuePriorityBean bean=new IssuePriorityBean();
		bean.setIssuePriorityId(strid);
		bean.setIssuePrioritylevel(strPriorityName);
		IssuePriorityDao dao=new IssuePriorityDao();
		boolean flag1=dao.duplicate(strPriorityName);
		if(flag1==false)
		{
		boolean flag=dao.dataUpdate(bean);
		System.out.println(flag);
		if(flag)
		{
			request.getRequestDispatcher("IssuePriorityListServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			System.out.println("Not Updated......");
		}
		}
		else
		{
			request.getRequestDispatcher("IssuePriorityListServlet").forward(request, response);
		}
	}

}
