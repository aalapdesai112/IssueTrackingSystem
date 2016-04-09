package dsynhub.its.controller.task;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.TaskBean;
import dsynhub.its.dao.TaskDao;
public class TaskDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		int deleteId=Integer.parseInt(request.getParameter("did"));
		TaskBean bean=new TaskBean();
		bean.setTaskId(deleteId);
		TaskDao dao=new TaskDao();
		boolean flag=dao.dataDeleteTask(bean);
		if(flag)
		{
			response.sendRedirect("TaskViewServlet");
		}
		else
		{
			response.sendRedirect("TaskViewServlet");
		}
	
	}
}