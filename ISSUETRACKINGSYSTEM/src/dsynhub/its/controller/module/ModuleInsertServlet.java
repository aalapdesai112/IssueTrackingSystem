package dsynhub.its.controller.module;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ModuleBean;
import dsynhub.its.dao.ModuleDao;
public class ModuleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		{
			ModuleDao dao = new ModuleDao();
			ModuleBean bean = new ModuleBean();
			PrintWriter out = response.getWriter();
			String moduleName = request.getParameter("moduleName");
			String moduleDiscription = request.getParameter("moduleDescription");
			String estimatedStartDate = request.getParameter("estimated_start_date");
			String actualStartDate = request.getParameter("actual_start_date");
			String estimatedEndDate = request.getParameter("estimated_end_date");
			String actualEndDate = request.getParameter("actual_end_date");
			int statusId = Integer.parseInt(request.getParameter("Status_id"));
			int prorityId = Integer.parseInt(request.getParameter("priority_id"));
			int projectId = Integer.parseInt(request.getParameter("project_id"));
			
			boolean isError = false;
			Pattern pattern1 = Pattern.compile(".*[A-z].*");
			if (moduleName.isEmpty() || moduleName.trim().length() == 0) 
			{
				isError = true;
				request.setAttribute("moduleName","<font color=red>Enter the ModuleName</font>");
			}
			else if (moduleName.trim().length() > 50)
			{
				isError = true;
				request.setAttribute("moduleName","<font color=red>size exided from 50 in ModuleName</font>");
			}
			else if (pattern1.matcher(moduleName).matches() == false)
			{
				isError = true;
				request.setAttribute("moduleName","<font color=red>only character enter in ModuleName</font>");
			}
			else
			{
				bean.setModuleName(moduleName);
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
				bean.setModuleActualStartDate(actualStartDate);
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
				bean.setModuleDescription(moduleDiscription);
				bean.setModuleEstimateStartDate(estimatedStartDate);
				bean.setModuleEstimateEndDate(estimatedEndDate);
				bean.setModuleActualStartDate(actualStartDate);
				bean.setModuleActualEndDate(actualEndDate);
				bean.setPmtStatusId(statusId);
				bean.setPmtPriorityId(prorityId);
				bean.setProjectId(projectId);
			}
			if (isError == true)
			{
				RequestDispatcher rd = request.getRequestDispatcher("ModuleInsert.jsp");
				rd.forward(request, response);
			}
			else
			{
				boolean flag1 = false;
				flag1 = dao.duplicateModule(moduleName);
				System.out.println(flag1);
				if (flag1 == false)
				{
					boolean flag = dao.DataInsertModule(bean);
					if (flag)
					{
						response.sendRedirect("ModuleViewServlet");
						out.println("inserted...");
					}
				}
				else
				{
					 request.setAttribute("duplicate","<font color=red>State Name exist </font>");
					 RequestDispatcher
					 rd=request.getRequestDispatcher("ModuleViewServlet");
					 rd.forward(request, response);
					out.println("inserted...");
				}
			}
		}
	}
}