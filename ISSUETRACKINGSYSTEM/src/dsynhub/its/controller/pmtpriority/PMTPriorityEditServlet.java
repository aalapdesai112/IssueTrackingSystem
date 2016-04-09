package dsynhub.its.controller.pmtpriority;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.PMTPriorityBean;
import dsynhub.its.dao.PMTPriorityDao;
public class PMTPriorityEditServlet extends HttpServlet{
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
	
		int strPriorityId=Integer.parseInt(request.getParameter("did"));
		
		PMTPriorityDao dao=new PMTPriorityDao();
		PMTPriorityBean bean=new PMTPriorityBean();
		bean.setPMTPriorityId(strPriorityId);
		
		ArrayList<PMTPriorityBean> list=dao.dataSelect1(strPriorityId);
		
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("PMTPriorityEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("list is null");
		}
		
	}
}
