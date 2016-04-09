package dsynhub.its.controller.state;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.StateDao;
public class StateListServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StateDao psex=new StateDao();
		ArrayList<StateBean> list=psex.selectData();
		if(list!=null)
		{
			req.setAttribute("list", list);
			req.getRequestDispatcher("StateList.jsp").forward(req, resp);
		}
	}
}