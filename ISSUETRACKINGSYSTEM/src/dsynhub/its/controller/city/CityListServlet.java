package dsynhub.its.controller.city;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CityBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.StateDao;


public class CityListServlet extends HttpServlet{
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
		CityDao dao=new CityDao();
		ArrayList<CityBean> list=dao.dataSelectCity();
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("CityList.jsp").forward(request, response);
		}
		
		
	}
}
