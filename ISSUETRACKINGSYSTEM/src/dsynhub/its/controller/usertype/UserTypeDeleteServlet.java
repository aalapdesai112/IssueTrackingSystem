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

public class UserTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userTypeId=Integer.parseInt(request.getParameter("id1"));
		
		
		UserTypeBean bean=new UserTypeBean();
		bean.setUserTypeId(userTypeId);
		
		PrintWriter out=response.getWriter();
		request.setAttribute("bena",bean);
		 UserTypeDao cdo=new UserTypeDao();
	        boolean flag= cdo.delete(bean);
	        System.out.println(flag);
	        if(flag)
	        {
	        	request.setAttribute("delete","<font color=red>1  record deleted</font>");
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        	
	        	out.write("<font size=6 color=green>deleted successfully</font>");
	        }
	        
	        else
	        {	
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        }
	       
	        
	}
	}


