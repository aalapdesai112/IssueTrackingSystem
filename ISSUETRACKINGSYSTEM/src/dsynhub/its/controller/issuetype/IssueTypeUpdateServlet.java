package dsynhub.its.controller.issuetype;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueTypeBean;
import dsynhub.its.dao.*;
public class IssueTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("hid"));
	String issuetype=request.getParameter("issuetype");
	IssueTypeBean bean=new IssueTypeBean();
	bean.setIssuetypeid(id);
	bean.setIssuetype(issuetype);
	request.setAttribute("bean",bean);
	 IssueTypeDao dao=new IssueTypeDao();
	 boolean flag1=dao.duplicate(issuetype);
	 if(flag1==false)
	 {
		 boolean flag= dao.update(bean);
		 if(flag==true)
		 {
			 System.out.println("updated");
			 RequestDispatcher rd=request.getRequestDispatcher("IssueTypeListServlet");
			 rd.forward(request,response);
		 }
		 else
    	 {
    		 request.setAttribute("duplicate","");
    		 RequestDispatcher rd = request.getRequestDispatcher("IssueTypeListServlet");
    		 rd.forward(request, response);
    	 }
    }
    	 else
    	 {
    		 request.setAttribute("duplicate","");
				RequestDispatcher rd = request.getRequestDispatcher("IssueTypeListServlet");
				rd.forward(request, response);
    	 }
			 
		 }
  }