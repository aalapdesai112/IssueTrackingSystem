package dsynhub.its.controller.usertype;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.UserTypeBean;

import dsynhub.its.dao.CountryDao;
import dsynhub.its.dao.UserTypeDao;
import dsynhub.its.util.DBConnection;


public class UserTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id1"));
		String userType=request.getParameter("userType");
		
		
		UserTypeBean bean=new UserTypeBean();
		bean.setUserTypeId(id);
		bean.setUserType(userType);
		
		request.setAttribute("bena",bean);
		UserTypeDao udo=new UserTypeDao();
	        boolean flag= udo.update(bean);
	        PrintWriter out=response.getWriter();
	        System.out.println(flag);
	        
	        UserTypeDao dao=new UserTypeDao();
	    	boolean	flag1=dao.duplicateUserType(userType);
	    	if(flag1==false)
	    	{
	        if(flag)
	        {
	        	
	        	request.setAttribute("update",
						"<font color=red>1 record updated  </font>");
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        	
	        	out.write("<font size=6 color=green>updated successfully</font>");
	        }
	        else
	        {
	        	out.write("<font size=6 color=green>not updated successfully</font>");
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        }
	    	}
	    	else
	    	{
	    		request.setAttribute("duplicate","<font color=red>user type exists </font>");
	    		RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	    	}
	}
}