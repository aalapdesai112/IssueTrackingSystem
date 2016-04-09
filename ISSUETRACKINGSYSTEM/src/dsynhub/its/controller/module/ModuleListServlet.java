package dsynhub.its.controller.module;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ModuleBean;
import dsynhub.its.dao.ModuleDao;
public class ModuleListServlet extends HttpServlet{
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
		int listId=Integer.parseInt(request.getParameter("did"));
		ModuleDao dao=new ModuleDao();
		ModuleBean bean=null;
		ArrayList<ModuleBean> list=dao.dataListModule(listId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ModuleList.jsp").forward(request, response);
		}	
	}
}