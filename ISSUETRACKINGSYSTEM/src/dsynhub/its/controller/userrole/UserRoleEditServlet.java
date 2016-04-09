package dsynhub.its.controller.userrole;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserRoleBean;
import dsynhub.its.dao.UserRoleDao;
public class UserRoleEditServlet extends HttpServlet{
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
		int strroleId=Integer.parseInt(request.getParameter("did"));
		UserRoleDao dao=new UserRoleDao();
		UserRoleBean bean=new UserRoleBean();
		bean.setRoleId(strroleId);
		ArrayList< UserRoleBean> list=dao.dataSelect1(strroleId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("UserRoleEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("list is null");
		}
	}
}