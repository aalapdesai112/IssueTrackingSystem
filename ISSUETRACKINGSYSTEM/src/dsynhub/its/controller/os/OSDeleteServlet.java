package dsynhub.its.controller.os;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.OSBean;
import dsynhub.its.dao.OSDao;
public class OSDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
			int id=Integer.parseInt(request.getParameter("hid"));
			OSBean bean=new OSBean();
			bean.setOsid(id);
			OSDao pstmtD=new OSDao();
			boolean flag=pstmtD.delete(bean);
			if(flag==true)
			{
					RequestDispatcher rd=request.getRequestDispatcher("OSListServlet");
					rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("OSListServlet");
				rd.forward(request, response);
			}
	}
}
