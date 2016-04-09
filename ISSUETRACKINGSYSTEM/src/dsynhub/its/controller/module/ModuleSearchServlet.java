package dsynhub.its.controller.module;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ModuleBean;
import dsynhub.its.dao.ModuleDao;

public class ModuleSearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String moduleName = req.getParameter("modulename");
		
		System.out.println("===========ProjectName Called==============="+moduleName);
		
		ModuleDao dao = new ModuleDao();
		List<ModuleBean> list= dao.srch(moduleName);
		if(list != null)
		{
			System.out.println("----------------success");
			req.setAttribute("list",list);
			RequestDispatcher rd = req.getRequestDispatcher("ModuleView.jsp");
			rd.forward(req, resp);
		}
		else
		{
			System.out.println("-------fail");
		}
	}
}