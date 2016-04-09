package dsynhub.its.controller.task;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.TaskBean;
import dsynhub.its.dao.TaskDao;
public class TaskListServlet extends HttpServlet{
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
		int listId=Integer.parseInt(request.getParameter("did"));
		TaskDao dao=new TaskDao();
		TaskBean bean=null;
		ArrayList<TaskBean> list=dao.dataListTask(listId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("TaskList.jsp").forward(request, response);
		}	
	}
}
