package dsynhub.its.controller.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.TaskBean;
import dsynhub.its.dao.TaskDao;

public class TaskInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		{
			TaskDao dao = new TaskDao();
			TaskBean bean = new TaskBean();
			PrintWriter out = response.getWriter();
			String taskName = request.getParameter("taskName");
			String taskDiscription = request.getParameter("taskDescription");
			String estimatedStartDate = request.getParameter("estimated_start_date");
			String actualStartDate = request.getParameter("actual_start_date");
			String estimatedEndDate = request.getParameter("estimated_end_date");
			String actualEndDate = request.getParameter("actual_end_date");
			int prorityId = Integer.parseInt(request.getParameter("priorityid"));
			int statusId = Integer.parseInt(request.getParameter("statusid"));
			int moduleId = Integer.parseInt(request.getParameter("moduleid"));
			boolean isError = false;
			Pattern pattern1 = Pattern.compile(".*[A-z].*");
			if (taskName.isEmpty() || taskName.trim().length() == 0) 
			{
				isError = true;
				request.setAttribute("taskName","<font color=red>Enter the ModuleName</font>");
			}
			else if (taskName.trim().length() > 50)
			{
				isError = true;
				request.setAttribute("taskName","<font color=red>size exided from 50 in ModuleName</font>");
			}
			else if (pattern1.matcher(taskName).matches() == false)
			{
				isError = true;
				request.setAttribute("taskName","<font color=red>only character enter in ModuleName</font>");
			}
			else
			{
				bean.setTaskName(taskName);
			}

			if (actualStartDate.isEmpty()|| actualStartDate.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("actualStartDate","<font color=red>Enter the actualStartDate</font>");
			}
			else if (actualStartDate.trim().length() > 50)
			{
				isError = true;
				request.setAttribute("actualStartDate","<font color=red>size exided from 50 in ProjectName</font>");
			}
			else 
			{
				bean.setTaskActualStartDate(actualStartDate);
			}
			if (actualEndDate.isEmpty()|| actualEndDate.trim().length() == 0)
			{
				isError = true;
				request.setAttribute("actualEndDate","<font color=red>Enter the actualEndDate</font>");
			}
			else if (actualEndDate.trim().length() > 50)
			{
				isError = true;
				request.setAttribute("actualEndDate","<font color=red>size exided from 50 in actualEndDate</font>");
			}
			else
			{
				bean.setTaskDescription(taskDiscription);
				bean.setTaskEstimateStartDate(estimatedStartDate);
				bean.setTaskActualStartDate(actualStartDate);
				bean.setTaskEstimateEndDate(estimatedEndDate);
				bean.setTaskActualEndDate(actualEndDate);
				bean.setPmtPriorityId(prorityId);
				bean.setPmtStatusId(statusId);
				bean.setModuleId(moduleId);
			}
			if (isError == true)
			{
				RequestDispatcher rd = request.getRequestDispatcher("ModuleInsert.jsp");
				rd.forward(request, response);
			}
			else
			{
				boolean flag1 = false;
				flag1 = dao.duplicateTask(taskName);
				System.out.println(flag1);
				if (flag1 == false)
				{
					boolean flag = dao.DataInsertTask(bean);
					if (flag)
					{
						response.sendRedirect("TaskViewServlet");
						out.println("inserted...");
					}
				}
				else
				{
					 request.setAttribute("duplicate","<font color=red>Task Name exist </font>");
					 RequestDispatcher
					 rd=request.getRequestDispatcher("TaskViewServlet");
					 rd.forward(request, response);
					out.println("inserted...");
				}
			}
		}
	}
}