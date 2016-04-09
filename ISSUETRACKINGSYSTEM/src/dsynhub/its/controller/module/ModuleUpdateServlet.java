package dsynhub.its.controller.module;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ModuleBean;
import dsynhub.its.dao.ModuleDao;
public class ModuleUpdateServlet extends HttpServlet{
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
		ModuleDao cdao=new ModuleDao();
		int id=Integer.parseInt(request.getParameter("did"));
		System.out.println("id..............."+id);
		String moduleName = request.getParameter("moduleName");
		String moduleDescription = request.getParameter("moduledescription");
		String estimatedStartDate = request.getParameter("moduleEstimatedStartDate");
		String actualStartDate = request.getParameter("moduleActualStartDate");
		String estimatedEndDate = request.getParameter("moduleEstimatedEndDate");
		String actualEndDate=request.getParameter("moduleActualEndDate");
		int pmtProirityId=Integer.parseInt(request.getParameter("pmtPrority"));
		int pmtStatusId=Integer.parseInt(request.getParameter("pmtStatus"));
		int projectId=Integer.parseInt(request.getParameter("projectName"));
		
		ModuleBean bean = new ModuleBean();
		bean.setModuleId(id);
		bean.setModuleName(moduleName);
		System.out.println(estimatedStartDate);
		System.out.println(actualStartDate);
		System.out.println(estimatedEndDate);
		System.out.println(actualEndDate);
		System.out.println("priority id...."+pmtProirityId);
		System.out.println("status id...."+pmtStatusId);
		System.out.println("project id..."+projectId);
		
		bean.setModuleDescription(moduleDescription);
		bean.setModuleEstimateStartDate(estimatedStartDate);
		bean.setModuleActualStartDate(actualStartDate);
		bean.setModuleEstimateEndDate(estimatedEndDate);
		bean.setModuleActualEndDate(actualEndDate);
		bean.setPmtPriorityId(pmtProirityId);
		
		bean.setPmtStatusId(pmtStatusId);
		bean.setProjectId(projectId);
		System.out.println("..............."+bean.getModuleActualEndDate());
		System.out.println(bean.getModuleId());
		System.out.println("priority===="+bean.getPmtPriorityId());
		PrintWriter out = response.getWriter();
		ModuleDao mdao = new ModuleDao();
		//boolean flag1=false;
//		flag1 = mdao.duplicateModule(moduleName);
//		if (flag1 ==false) 
//		{
			boolean flag = mdao.dataUpdateModule(bean);
			//System.out.println(flag);
			if (flag==true)
			{
				System.out.println(flag+"jhj");
				request.setAttribute("update","<font color=red>1 record updated  </font>");
				RequestDispatcher rd = request.getRequestDispatcher("ModuleViewServlet");
				rd.forward(request, response);
				out.write("<font size=6 color=green>updated successfully</font>");
			}
			else
			{
				out.write("<font size=6 color=green>not updated successfully</font>");
				RequestDispatcher rd = request.getRequestDispatcher("ModuleViewServlet");
				rd.forward(request, response);
			}
		}
//else 
//{
//	request.setAttribute("duplicate","<font color=red>State Name exist </font>");
//	RequestDispatcher rd = request.getRequestDispatcher("ModuleViewServlet");
//	rd.forward(request, response);
//}	
}
