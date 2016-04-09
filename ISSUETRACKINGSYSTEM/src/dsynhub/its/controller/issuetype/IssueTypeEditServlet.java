package dsynhub.its.controller.issuetype;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.IssueTypeBean;
import dsynhub.its.dao.IssueTypeDao;
public class IssueTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int issuetypeid=Integer.parseInt(request.getParameter("hid"));
	IssueTypeDao  dao=new IssueTypeDao();
	IssueTypeBean bean=new IssueTypeBean();
	bean.setIssuetypeid(issuetypeid);
	ArrayList<IssueTypeBean> list=dao.selectData(issuetypeid);
	if(list!=null)
	{
		request.setAttribute("list", list);
		request.getRequestDispatcher("IssueTypeEdit.jsp").forward(request, response);
	}
	else
	{
		System.out.println("List is null");
	}

}
}
