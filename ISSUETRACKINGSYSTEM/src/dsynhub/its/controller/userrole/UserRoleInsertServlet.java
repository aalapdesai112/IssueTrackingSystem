package dsynhub.its.controller.userrole;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.UserRoleBean;
import dsynhub.its.dao.UserRoleDao;

public class UserRoleInsertServlet extends HttpServlet{
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
	
		UserRoleBean bean=new UserRoleBean();
		String strroleName=request.getParameter("rolename");
		boolean isError = false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (strroleName.isEmpty() ||strroleName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("strroleName","<font color=red>Enter the RoleName</font>");
		}	
		else if(strroleName.trim().length()>50)
		{
			isError = true;
			request.setAttribute("strroleName","<font color=red>size exided from 50 in RoleName</font>");
			
		}
		else if(pattern1.matcher(strroleName).matches()==false)
		{
			isError = true;
			request.setAttribute("strroleName","<font color=red>only character enter in stateName</font>");
		}
		else
		{
			bean.setRoleName(strroleName);
		}
		if (isError == true)
		{
			request.getRequestDispatcher("UserRoleInsert.jsp").forward(request, response);
		}
		else
		{
			UserRoleDao dao=new UserRoleDao();
			boolean flag1 = dao.duplicate(strroleName);
			if (flag1 == false) {
			boolean	flag = dao.dataInsert(bean);		
			if(flag)
			{
				request.getRequestDispatcher("UserRoleListServlet").forward(request, response);
				System.out.println("data Inserted....");
			}
			else
			{
				System.out.println(("dATA NOT iNSERTED...."));
			}
		
			}
			else
			{
				request.setAttribute("duplicate", "<font color=red> could not enter duplicate value....</font>");
				request.getRequestDispatcher("UserRoleListServlet")
				.forward(request, response);
			}
	}
	}
}