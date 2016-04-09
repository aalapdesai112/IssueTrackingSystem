package dsynhub.its.controller.pmtstatus;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.PmtStatusDao;
public class PMTStatusEditServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		PmtStatusDao  dao=new PmtStatusDao();
		PMTStatusBean bean=new PMTStatusBean();
		bean.setPmtstatusid(id);
		ArrayList<PMTStatusBean>list=dao.selectData(id);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("PMTStatusEdit.jsp").forward(request, response);
		}
		else
		{
			System.out.println("List is null");
		}

	}
}
