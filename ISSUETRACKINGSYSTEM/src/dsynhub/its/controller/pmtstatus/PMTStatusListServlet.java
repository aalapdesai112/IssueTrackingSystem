package dsynhub.its.controller.pmtstatus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.PmtStatusDao;

public class PMTStatusListServlet extends HttpServlet{
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
		PmtStatusDao dao=new PmtStatusDao();
		ArrayList<PMTStatusBean> list=dao.select();
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("PMTStatusList.jsp").forward(request, response);
		}
	}
}
