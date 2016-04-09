package dsynhub.its.controller.city;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.CountryDao;

public class CityEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cityId=Integer.parseInt(request.getParameter("hid"));
		CityDao  dao=new CityDao();
		CountryBean bean=new CountryBean();
		bean.setCountryID(cityId);
		ArrayList<CityBean>list=dao.dataSelectCity1(cityId);
//		ArrayList<CountryBean> list=dao.selectData(countryid);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("CityEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}
	}
}
