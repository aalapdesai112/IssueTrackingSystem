package dsynhub.its.controller.task;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.TaskBean;
import dsynhub.its.dao.TaskDao;
public class TaskUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskDao cdao=new TaskDao();
		int id=Integer.parseInt(request.getParameter("did"));
		System.out.println("id..............."+id);
		String TaskName = request.getParameter("TaskName");
		String TaskDescription = request.getParameter("description");
		String estimatedStartDate = request.getParameter("TaskEstimatedStartDate");
		String actualStartDate = request.getParameter("TaskActualStartDate");
		String estimatedEndDate = request.getParameter("TaskEstimatedEndDate");
		String actualEndDate=request.getParameter("TaskActualEndDate");
		int pmtProirityId=Integer.parseInt(request.getParameter("pmtPrority"));
		int pmtStatusId=Integer.parseInt(request.getParameter("pmtStatus"));
		int moduleId=Integer.parseInt(request.getParameter("moduleName"));
		
		TaskBean bean = new TaskBean();
		bean.setTaskId(id);
		bean.setTaskName(TaskName);
//		System.out.println(estimatedStartDate);
//		System.out.println(actualStartDate);
//		System.out.println(estimatedEndDate);
//		System.out.println(actualEndDate);
//		System.out.println("priority id...."+pmtProirityId);
//		System.out.println("status id...."+pmtStatusId);
//		System.out.println("module id..."+moduleId);
		
		bean.setTaskDescription(TaskDescription);
		bean.setTaskEstimateStartDate(estimatedStartDate);
		bean.setTaskActualStartDate(actualStartDate);
		bean.setTaskEstimateEndDate(estimatedEndDate);
		bean.setTaskActualEndDate(actualEndDate);
		bean.setPmtPriorityId(pmtProirityId);
		
		bean.setPmtStatusId(pmtStatusId);
		bean.setModuleId(moduleId);
//		System.out.println("..............."+bean.getTaskActualEndDate());
//		System.out.println(bean.getTaskId());
//		System.out.println("priority===="+bean.getPmtPriorityId());
		PrintWriter out = response.getWriter();
		TaskDao mdao = new TaskDao();
		//boolean flag1=false;
//		flag1 = mdao.duplicateTask(TaskName);
//		if (flag1 ==false) 
//		{
			boolean flag = mdao.dataUpdateTask(bean);
			//System.out.println(flag);
			if (flag==true)
			{
				System.out.println(flag+"jhj");
				request.setAttribute("update","<font color=red>1 record updated  </font>");
				RequestDispatcher rd = request.getRequestDispatcher("TaskViewServlet");
				rd.forward(request, response);
				out.write("<font size=6 color=green>updated successfully</font>");
			}
			else
			{
				out.write("<font size=6 color=green>not updated successfully</font>");
				RequestDispatcher rd = request.getRequestDispatcher("TaskViewServlet");
				rd.forward(request, response);
			}
		}
//else 
//{
//	request.setAttribute("duplicate","<font color=red>State Name exist </font>");
//	RequestDispatcher rd = request.getRequestDispatcher("TaskViewServlet");
//	rd.forward(request, response);
//}	
}
