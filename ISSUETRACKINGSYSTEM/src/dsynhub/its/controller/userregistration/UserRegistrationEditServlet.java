package dsynhub.its.controller.userregistration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.UserRegistrationDao;

public class UserRegistrationEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserRegistrationDao  dao=new UserRegistrationDao();
		UserRegistrationBean bean=new UserRegistrationBean();
		
		
		int userId=Integer.parseInt(request.getParameter("hid"));
		bean.setUserId(userId);
		
		ArrayList<UserRegistrationBean>list=dao.dataSelect1Registration(userId);

		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("UserRegistrationEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}

}
