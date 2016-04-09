package dsynhub.its.controller.usertype;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.UserTypeBean;
import dsynhub.its.dao.CountryDao;
import dsynhub.its.dao.UserTypeDao;

public class UserTypeEditServlet  extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserTypeDao cdao=new UserTypeDao();
		int id=Integer.parseInt(request.getParameter("id1"));
		ArrayList<UserTypeBean> list=cdao.select(id);
		if(list!=null)
		{
			request.setAttribute("list",list);
			request.getRequestDispatcher("UserTypeEdit.jsp").forward(request, response);
		}
	}

}
