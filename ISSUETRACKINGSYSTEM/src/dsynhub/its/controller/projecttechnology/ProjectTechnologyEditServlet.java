package dsynhub.its.controller.projecttechnology;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ProjectTechnologyBean;
import dsynhub.its.dao.ProjectTechnologyDao;
public class ProjectTechnologyEditServlet extends HttpServlet{
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
		int strCategaryId=Integer.parseInt(request.getParameter("did"));
		ProjectTechnologyDao dao=new ProjectTechnologyDao();
		ProjectTechnologyBean bean=new ProjectTechnologyBean();
		bean.setTechnologyId(strCategaryId);
		ArrayList<ProjectTechnologyBean> list=dao.dataSelect1(strCategaryId);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProjectTechnologyEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("list is null");
		}		
	}
}