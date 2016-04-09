package dsynhub.its.controller.projecttechnology;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.ProjectTechnologyBean;
import dsynhub.its.dao.ProjectTechnologyDao;
public class ProjectTechnologyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ProjectTechnology = request.getParameter("projectcategary");
		ProjectTechnologyDao dao = new ProjectTechnologyDao();
		ProjectTechnologyBean bean = new ProjectTechnologyBean();
		boolean flag = false;
		boolean isError = false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (ProjectTechnology.isEmpty() ||ProjectTechnology.trim().length()==0)
		{
			isError = true;
			request.setAttribute("ProjectTechnology","<font color=red>Enter the ProjectTechnology</font>");
		}	
		else if(ProjectTechnology.trim().length()>50)
		{
			isError = true;
			request.setAttribute("ProjectTechnology","<font color=red>size exided from 50 in ProjectTechnology</font>");			
		}
		else if(pattern1.matcher(ProjectTechnology).matches()==false)
		{
			isError = true;
			request.setAttribute("ProjectTechnology","<font color=red>only character enter in ProjectTechnology</font>");
		}
		else
		{
			bean.setProjectTechnology(ProjectTechnology);
		}
		if (isError == true)
		{
			request.getRequestDispatcher("ProjectTechnologyInsert.jsp").forward(request, response);
		} 
		else
		{
			boolean flag1 = dao.duplicate(ProjectTechnology);
			if (flag1 == false)
			{
				flag = dao.dataInsert(bean);
				if (flag == true) {
				System.out.println("Inserted........");
				request.getRequestDispatcher("ProjectTechnologyListServlet").forward(request, response);
			}
			else
			{
					System.out.println("not inserted,...");
			}
		}
		else
		{
			System.out.println("data is already in table......");
			request.getRequestDispatcher("ProjectTechnologyInsert.jsp").forward(request, response);
		}
	}
}
}