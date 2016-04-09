package dsynhub.its.controller.projectuser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.dao.ProjectUserDao;
public class ProjectUserInsertServlet extends HttpServlet {
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
		int projId=Integer.parseInt(request.getParameter("project_id"));
		int userId=Integer.parseInt(request.getParameter("user_id"));
		int roleId=Integer.parseInt(request.getParameter("role_id"));
		ProjectUserBean bean=new ProjectUserBean();
		ProjectUserDao dao=new ProjectUserDao();		
		bean.setProjId(projId);
		bean.setUserId(userId);
		bean.setRoleId(roleId);
		boolean flag=dao.dataInsertProjectUser(bean);
		if(flag==true)
		{
			response.sendRedirect("ProjectUserListServlet");
			System.out.println("Inserted........");
		}
		else
		{
			System.out.println("Data Not Inserted....");
		}
	}
}