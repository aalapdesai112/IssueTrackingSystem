package dsynhub.its.controller.country;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CountryDao;

public class CountryEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int countryid=Integer.parseInt(request.getParameter("hid"));
		CountryDao  dao=new CountryDao();
		CountryBean bean=new CountryBean();
		bean.setCountryID(countryid);
		ArrayList<CountryBean>list=dao.selectData(countryid);
//		ArrayList<CountryBean> list=dao.selectData(countryid);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("CountryEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}
}
