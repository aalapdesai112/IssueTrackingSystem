package dsynhub.its.controller.projectuser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.ProjectUserBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.ProjectUserDao;

public class ProjectUserListServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectUserDao dao=new ProjectUserDao();
		
		ArrayList<ProjectUserBean> list=dao.selectDataProjectUser();
		//StateDao dao1=new StateDao();
		
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectUserList.jsp").forward(request, response);
		}
		
		
	}
		
	}

