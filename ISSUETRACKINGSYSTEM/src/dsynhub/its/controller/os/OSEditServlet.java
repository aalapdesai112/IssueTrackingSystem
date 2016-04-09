package dsynhub.its.controller.os;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.OSBean;
import dsynhub.its.dao.CountryDao;
import dsynhub.its.dao.OSDao;

public class OSEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int osid=Integer.parseInt(request.getParameter("hid"));
		OSDao  dao=new OSDao();
		OSBean bean=new OSBean();
		bean.setOsid(osid);
		ArrayList<OSBean>list=dao.selectData(osid);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("OSEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}
}