package dsynhub.its.controller.issuepriority;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssuePriorityBean;
import dsynhub.its.dao.IssuePriorityDao;


public class IssuePriorityListServlet extends HttpServlet{
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
		
		IssuePriorityDao dao=new IssuePriorityDao();
		ArrayList<IssuePriorityBean> list=dao.dataSelect();
		System.out.println("");
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssuePriorityList.jsp").forward(request, response);
		}
		else
		{
			System.out.println("list is null");
		}
		
		
	}

}
