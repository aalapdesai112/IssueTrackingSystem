package dsynhub.its.controller.userregistration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.dao.UserRegistrationDao;

public class UserRegistrationListServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRegistrationDao dao=new UserRegistrationDao();
		ArrayList<UserRegistrationBean> list=dao.dataSelectRegistration();
		if(list!=null)
		{
			request.setAttribute("Registrationlist", list);		
		}
		request.getRequestDispatcher("UserRegistrationList.jsp").forward(request, response);
	}
}