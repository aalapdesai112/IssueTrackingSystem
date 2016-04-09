package dsynhub.its.controller.projecttechnology;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ProjectTechnologyBean;
import dsynhub.its.dao.ProjectTechnologyDao;
public class ProjectTechnologyUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int strid=Integer.parseInt(request.getParameter("id"));
		System.out.println(strid);
		String strcategary=request.getParameter("ProjectTechnology");
		ProjectTechnologyBean bean=new ProjectTechnologyBean();
		bean.setTechnologyId(strid);
		bean.setProjectTechnology(strcategary);
		ProjectTechnologyDao dao=new ProjectTechnologyDao();
		boolean flag1=dao.duplicate(strcategary);
		if(flag1==false)
		{
		boolean flag=dao.dataUpdate(bean);
		System.out.println(flag);
		if(flag)
		{
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);
			System.out.println("Not Updated......");
		}
	}
	else
	{	
       	request.setAttribute("duplicate","");
	   	RequestDispatcher rd = request.getRequestDispatcher("ProjectTechnologyListServlet");
		rd.forward(request, response);
    }
}
}