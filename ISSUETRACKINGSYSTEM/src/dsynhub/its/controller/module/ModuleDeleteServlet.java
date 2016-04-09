package dsynhub.its.controller.module;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ModuleBean;
import dsynhub.its.dao.ModuleDao;
public class ModuleDeleteServlet extends HttpServlet{
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
	
		int deleteId=Integer.parseInt(request.getParameter("did"));
		System.out.println("............."+deleteId);
		
		ModuleBean bean=new ModuleBean();
		bean.setModuleId(deleteId);
		ModuleDao dao=new ModuleDao();
		boolean flag=dao.dataDeleteModule(bean);
		if(flag)
		{
			response.sendRedirect("ModuleViewServlet");
		}
		else
		{
			request.setAttribute("delete","<font color=red>child record already exist so,cant deleted</font>");
			System.out.println("not deleted....");
			request.getRequestDispatcher("ModuleViewServlet").forward(request, response);
		}
	
	}
}