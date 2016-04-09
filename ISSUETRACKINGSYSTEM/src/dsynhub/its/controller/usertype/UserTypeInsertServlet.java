package dsynhub.its.controller.usertype;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserTypeBean;
import dsynhub.its.dao.UserTypeDao;
public class UserTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserTypeBean bean=new UserTypeBean();
		String userType=request.getParameter("userType");
		boolean isError=false;
		Pattern pattern=Pattern.compile(".*[A-z].*");
		int str=userType.length();
		if(userType=="")
		{
			isError=true;
			request.setAttribute("userType","<font color=red>fill up ");
		}
		else if(userType.trim().length()==0)
			 	{
					isError=true;
					request.setAttribute("userType","<font color=red>blank not allowed");
			 	}
		else if(userType.trim().length()>29)
					{
						isError=true;
						request.setAttribute("userType","<font color=red>size existed from 30");
					}			
		else if(pattern.matcher(userType).matches()==false)
					{
						isError=true;
						request.setAttribute("userType","<font color=red> only character enter</font>");
					}
		else
		{
			bean.setUserType(userType);
		}
		if(isError==true)
		{
			RequestDispatcher rd=request.getRequestDispatcher("UserTypeInsert.jsp");
			rd.forward(request, response);
		}
		else
		{
		UserTypeDao dao=new UserTypeDao();
	boolean	flag1=dao.duplicateUserType(userType);
		System.out.println("flag1"+flag1);
	
		UserTypeDao cdao=new UserTypeDao();
		 if(flag1==false)
		 {
	        boolean flag= cdao.insert(bean);
	        if(flag)
	        {
	        	request.setAttribute("insert",
						"<font color=red>1 record inserted  </font>");
	        	response.sendRedirect("UserTypeListServlet");
	    		
	        	
	        	out.write("<font size=6 color=green>inserted successfully</font>");
	        }
	        else
	        {
	        	
				
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        }
		 }
	        else
	        {
	        	request.setAttribute("duplicate","<font color=red>user type exists </font>");
					
	        	RequestDispatcher rd=request.getRequestDispatcher("UserTypeListServlet");
	    		rd.forward(request,response);
	        	out.write("<font size=6 color=green>not inserted  successfully because data already exit</font>");
	        }
	}
	}

}
