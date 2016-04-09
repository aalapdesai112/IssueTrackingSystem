package dsynhub.its.controller.state;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.StateDao;

public class StateEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id1"));
		StateDao  dao=new StateDao();
		StateBean bean=new StateBean();
		bean.setStateId(id);
		ArrayList<StateBean>list=dao.select(id);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("StateEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}
}
