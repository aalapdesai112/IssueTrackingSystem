package dsynhub.its.controller.projectmaster;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.ProjectMasterBean;
import dsynhub.its.dao.ProjectMasterDao;

public class ProjectMasterViewServlet extends HttpServlet {
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
		ProjectMasterDao dao=new ProjectMasterDao();
		ProjectMasterBean bean=null;
		ArrayList< ProjectMasterBean> list=dao.dataSelectProjectMaster();
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectMasterView.jsp").forward(request, response);
		}	
	}
}