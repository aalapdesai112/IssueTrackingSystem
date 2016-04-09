package dsynhub.its.controller.task;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.TaskBean;
import dsynhub.its.dao.TaskDao;

public class TaskEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int TaskId=Integer.parseInt(request.getParameter("did"));
		TaskDao  dao=new TaskDao();
		TaskBean bean=new TaskBean();
		bean.setTaskId(TaskId);
		ArrayList<TaskBean>list=dao.dataListTask(TaskId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("TaskEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}
		
//		PmtStatusDao sdao=new  PmtStatusDao();
//		ArrayList<PMTStatusBean> list1=sdao.select();
//		System.out.println(list1);
//		if(list1!=null)
//		{
//			request.setAttribute("list1", list1);
//			//request.getRequestDispatcher("TaskEdit.jsp").forward(request, response);
//		}
//		else
//		{
//			System.out.println("List is null");
//		}
}
}
