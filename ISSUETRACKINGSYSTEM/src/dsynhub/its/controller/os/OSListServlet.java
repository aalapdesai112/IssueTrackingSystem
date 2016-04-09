package dsynhub.its.controller.os;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.OSBean;
import dsynhub.its.dao.OSDao;

public class OSListServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		OSDao dao=new OSDao();
		ArrayList<OSBean> list=dao.select();
		if(list!=null)
		{
			req.setAttribute("list", list);
			req.getRequestDispatcher("OSList.jsp").forward(req, resp);
		}
	}
}
