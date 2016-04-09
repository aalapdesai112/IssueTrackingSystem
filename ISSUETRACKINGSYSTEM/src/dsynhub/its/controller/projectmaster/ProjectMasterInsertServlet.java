package dsynhub.its.controller.projectmaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.dao.ProjectMasterDao;

public class ProjectMasterInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			System.out.println("..................................");
			ProjectMasterDao dao = new ProjectMasterDao();
			PrintWriter out = response.getWriter();
			String projectName = request.getParameter("projectname");
			System.out.println("projectname"+request.getParameter("projectname"));
			String projDiscription = request.getParameter("projectdescrption");
			String estimatedStartDate = request
					.getParameter("estimated_start_date");
			String estimatedEndDate = request
					.getParameter("estimated_end_date");
			String actualStartDate = request.getParameter("actual_start_date");
			String actualEndDate = request.getParameter("actual_end_date");
			System.out.println("...........actual"+request.getParameter("actual_end_date"));
			int statusId = Integer.parseInt(request.getParameter("Status_id"));
			System.out.println(".........."+request.getParameter("Status_id"));
			int prorityId = Integer.parseInt(request
					.getParameter("project_priority_id"));
			int projCategaryId = Integer.parseInt(request
					.getParameter("project_categary_id"));

			ProjectMasterBean bean = new ProjectMasterBean();
			boolean isError = false;
			Pattern pattern1 = Pattern.compile(".*[A-z].*");
			if (projectName.isEmpty() || projectName.trim().length() == 0) {
				isError = true;
				request.setAttribute("ProjectName",
						"<font color=red>Enter the ProjectName</font>");
			} else if (projectName.trim().length() > 50) {
				isError = true;
				request.setAttribute("ProjectName",
						"<font color=red>size exided from 50 in ProjectName</font>");

			} else if (pattern1.matcher(projectName).matches() == false) {
				isError = true;
				request.setAttribute("ProjectName",
						"<font color=red>only character enter in ProjectName</font>");
			} else {
				bean.setProjectName(projectName);
			}

			if (actualStartDate.isEmpty()
					|| actualStartDate.trim().length() == 0) {
				isError = true;
				request.setAttribute("actualStartDate",
						"<font color=red>Enter the actualStartDate</font>");
			} else if (actualStartDate.trim().length() > 50) {
				isError = true;
				request.setAttribute("actualStartDate",
						"<font color=red>size exided from 50 in ProjectName</font>");

			} else 
			{
				bean.setProj_actual_start_date(actualStartDate);
			}
			
			
			if (actualEndDate.isEmpty()
					|| actualEndDate.trim().length() == 0) {
				isError = true;
				request.setAttribute("actualEndDate",
						"<font color=red>Enter the actualEndDate</font>");
			} else if (actualEndDate.trim().length() > 50) {
				isError = true;
				request.setAttribute("actualEndDate","<font color=red>size exided from 50 in actualEndDate</font>");

			} else {
				bean.setProjectdescription(projDiscription);
				bean.setProj_estimated_start_date(estimatedStartDate);
				bean.setProj_estimated_end_date(estimatedEndDate);
				bean.setProj_actual_end_date(actualEndDate);
				bean.setStatusId(statusId);
				bean.setPriorityId(prorityId);
				bean.setCategaryId(projCategaryId);

			}
			if (isError == true) {
				RequestDispatcher rd = request
						.getRequestDispatcher("ProjectMasterInsert.jsp");
				rd.forward(request, response);
			} else {
				boolean flag1 = false;
				flag1 = dao.duplicateProjectMaster(projectName);
				System.out.println(flag1);
				if (flag1 == false) {
					boolean flag = dao.DataInsertProjectMaster(bean);
					if (flag) {
						response.sendRedirect("ProjectMasterViewServlet");
						out.println("inserted...");
					}
				} 
				else {
					 request.setAttribute("duplicate","<font color=red>project Name already exists </font>");
					 RequestDispatcher
					 rd=request.getRequestDispatcher("ProjectMasterViewServlet");
					 rd.forward(request, response);
					out.println("inserted...");

				}
			}

		}
	}
}
