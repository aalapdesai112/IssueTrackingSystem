package dsynhub.its.controller.userrole;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserRoleBean;
import dsynhub.its.dao.UserRoleDao;
public class UserRoleUpdateServlet extends HttpServlet{
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
		
		
		int strid=Integer.parseInt(request.getParameter("id"));
		System.out.println("strid"+strid);
		String strrolename=request.getParameter("rolename");
		UserRoleBean bean=new UserRoleBean();
		bean.setRoleId(strid);
		bean.setRoleName(strrolename);
		UserRoleDao dao=new UserRoleDao();
		boolean flag=dao.dataUpdate(bean);
		System.out.println(flag);
		if(flag)
		{
			request.getRequestDispatcher("UserRoleListServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			System.out.println("Not Updated......");
		}
		
	}
	}


