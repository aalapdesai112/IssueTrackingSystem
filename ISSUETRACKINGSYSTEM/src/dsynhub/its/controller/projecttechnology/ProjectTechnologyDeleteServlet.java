package dsynhub.its.controller.projecttechnology;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.dao.ProjectTechnologyDao;
public class ProjectTechnologyDeleteServlet extends HttpServlet{
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
		boolean flag=false;
		flag=dao.dataDelete(strCategaryId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);			
		}
		else
		{
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);
			System.out.println("not deleted....");
		}
	}
}