package dsynhub.its.controller.module;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ModuleBean;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.ModuleDao;
import dsynhub.its.dao.PmtStatusDao;
public class ModuleEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int moduleId=Integer.parseInt(request.getParameter("did"));
		ModuleDao  dao=new ModuleDao();
		ModuleBean bean=new ModuleBean();
		bean.setModuleId(moduleId);
		ArrayList<ModuleBean>list=dao.dataListModule(moduleId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ModuleEdit.jsp").forward(request, response);
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
//			//request.getRequestDispatcher("ModuleEdit.jsp").forward(request, response);
//		}
//		else
//		{
//			System.out.println("List is null");
//		}
}
	
	
	
}
