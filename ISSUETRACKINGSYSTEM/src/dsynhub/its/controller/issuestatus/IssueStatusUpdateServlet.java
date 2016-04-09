package dsynhub.its.controller.issuestatus;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.dao.IssueStatusDao;
public class IssueStatusUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String IssueStatus=request.getParameter("issuestatus");
		IssueStatusBean bean=new IssueStatusBean();
		bean.setIssuestatusid(id);
		bean.setIssuestatus(IssueStatus);
		System.out.println("IssueStatus"+IssueStatus);
		request.setAttribute("bean",bean);
		 IssueStatusDao dao=new IssueStatusDao();
		 boolean flag1=dao.duplicate(IssueStatus);
		 if(flag1==false)
		 {
	        boolean flag= dao.update(bean);
	        if(flag==true)
	        {
	        	System.out.println("updated");
	        	RequestDispatcher rd=request.getRequestDispatcher("IssueStatusListServlet");
	    		rd.forward(request,response);
	        }
	        else
	        {
	        	request.setAttribute("duplicate","");
	        	RequestDispatcher rd=request.getRequestDispatcher("IssueStatusListServlet");
	    		rd.forward(request,response);
	        }
	  }
		 else
		 {
			 request.setAttribute("duplicate","");
	        	RequestDispatcher rd=request.getRequestDispatcher("IssueStatusListServlet");
	    		rd.forward(request,response);
		 }
}
}