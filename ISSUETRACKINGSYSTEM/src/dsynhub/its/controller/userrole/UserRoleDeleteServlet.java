package dsynhub.its.controller.userrole;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.dao.UserRoleDao;
public class UserRoleDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int strQuestionId=Integer.parseInt(request.getParameter("did"));
		UserRoleDao dao=new UserRoleDao();
		boolean flag=false;
		flag=dao.dataDelete(strQuestionId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("UserRoleListServlet").forward(request, response);
			
		}
		else
		{
			System.out.println("not deleted....");
		}
		
		
		
	}
		
	}
