package dsynhub.its.controller.securityquestion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.dao.SequrityQuestionDao;
public class SecurityQuestionDeleteServlet extends HttpServlet {
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
		int strQuestionId=Integer.parseInt(request.getParameter("did"));
		SequrityQuestionDao dao=new SequrityQuestionDao();
		boolean flag=false;
		flag=dao.dataDelete(strQuestionId);
		if(flag)
		{
			System.out.println("data Deleted.....");
			request.getRequestDispatcher("SecurityQuestionListServlet").forward(request, response);
		}
		else
		{
			System.out.println("not deleted....");
		}		
	}
}