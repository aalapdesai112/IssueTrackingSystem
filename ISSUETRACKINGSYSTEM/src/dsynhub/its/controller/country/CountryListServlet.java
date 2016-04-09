package dsynhub.its.controller.country;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CountryDao;

public class CountryListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5529305582961502104L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CountryDao dao=new CountryDao();
		ArrayList<CountryBean> list=dao.select();
		if(list!=null)
		{
			req.setAttribute("list", list);
			req.getRequestDispatcher("CountryList.jsp").forward(req, resp);
		}
	}
}
