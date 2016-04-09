package dsynhub.its.controller.userregistration;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.UserRegistrationBean;
import dsynhub.its.dao.UserRegistrationDao;
public class UserRegistrationViewServlet extends HttpServlet{
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
	int sid=Integer.parseInt(request.getParameter("hid"));
	System.out.println("sid"+sid);
	UserRegistrationDao dao=new UserRegistrationDao();
	ArrayList<UserRegistrationBean> list=dao.dataSelect1Registration(sid);
	if(list!=null)
	{
		request.setAttribute("list", list);	
		request.getRequestDispatcher("UserRegistrationView.jsp").forward(request, response);
	}
	else
	{
		request.getRequestDispatcher("UserRegistrationView.jsp").forward(request, response);
	}
}
}