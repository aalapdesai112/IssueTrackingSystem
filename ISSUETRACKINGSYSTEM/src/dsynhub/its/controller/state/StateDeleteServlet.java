package dsynhub.its.controller.state;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.StateDao;
import dsynhub.its.util.DBConnection;
public class StateDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
			int stateId=Integer.parseInt(request.getParameter("id1"));
			StateBean bean=new StateBean();
			bean.setStateId(stateId);
			//PrintWriter out=response.getWriter();
			request.setAttribute("bean",bean);
			StateDao udo=new StateDao();
			//DBConnection util=new DBConnection();
			boolean flag= udo.delete(bean);
	        if(flag)
	        {
	        	response.sendRedirect("StateListServlet");
	        }
	        else
	        {
	        	request.setAttribute("delete", "<font color=red>Chiled Record Not Deleted</font>");
		    	RequestDispatcher rd=request.getRequestDispatcher("StateListServlet");
	    		rd.forward(request,response);
	        }
	  }
}