package dsynhub.its.controller.usertype;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserTypeBean;
import dsynhub.its.dao.UserTypeDao;
public class UserTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserTypeDao utdao=new UserTypeDao();
		 PrintWriter out=response.getWriter();
	ArrayList<UserTypeBean> list=utdao.selectData();
	if(list!=null)
	{
		request.setAttribute("list",list);
		request.getRequestDispatcher("UserTypeList.jsp").forward(request, response);
	}
	else
	{
		request.setAttribute("list",list);
		request.getRequestDispatcher("UserTypeList.jsp").forward(request, response);
	}
	}
}