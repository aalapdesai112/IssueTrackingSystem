package dsynhub.its.controller.pmtstatus;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.PmtStatusDao;

public class PMTStatusDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
			int id=Integer.parseInt(request.getParameter("hid"));
			PMTStatusBean bean=new PMTStatusBean();
			bean.setPmtstatusid(id);
			PmtStatusDao pstmtD=new PmtStatusDao();
			//boolean flag=pstmtD.insertData(bean);
			boolean flag=pstmtD.delete(bean);
			if(flag==true)
			{
					RequestDispatcher rd=request.getRequestDispatcher("PMTStatusListServlet");
					rd.forward(request, response);
			}
			else
			{
				request.setAttribute("delete","<font color=red>child record already exist so,cant deleted</font>" );
				RequestDispatcher rd=request.getRequestDispatcher("PMTStatusListServlet");
				rd.forward(request, response);
			}
	}
}