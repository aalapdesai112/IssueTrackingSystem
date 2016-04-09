package dsynhub.its.controller.projectuser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.dao.ProjectUserDao;

public class ProjectUserSearchServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str=request.getParameter("Search1");
		System.out.println("str,,,.............,,,,,,,,,,,,,,,,,,,,............"+str);
		ProjectUserDao dao=new ProjectUserDao();
		
		ArrayList<ProjectUserBean> list=dao.search(str);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectUserList.jsp").forward(request, response);
		}
	}
}