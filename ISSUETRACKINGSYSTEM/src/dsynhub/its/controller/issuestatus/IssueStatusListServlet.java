package dsynhub.its.controller.issuestatus;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.IssueStatusBean;
import dsynhub.its.dao.IssueStatusDao;

public class IssueStatusListServlet extends HttpServlet{
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
		IssueStatusDao dao=new IssueStatusDao();
		ArrayList<IssueStatusBean> list=dao.select();
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("IssueStatusList.jsp").forward(request, response);
		}
	}
}
