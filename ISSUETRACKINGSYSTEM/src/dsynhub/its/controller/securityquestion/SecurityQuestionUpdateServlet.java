package dsynhub.its.controller.securityquestion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.SequrityQuestionBean;
import dsynhub.its.dao.SequrityQuestionDao;
public class SecurityQuestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int strid=Integer.parseInt(request.getParameter("id"));
		System.out.println(strid);
		String strquestion=request.getParameter("questionname");
		SequrityQuestionBean bean=new SequrityQuestionBean();
		bean.setQuestionId(strid);
		bean.setQuestionName(strquestion);
		SequrityQuestionDao dao=new SequrityQuestionDao();
		boolean flag=dao.dataUpdate(bean);
		System.out.println(flag);
		if(flag)
		{
			request.getRequestDispatcher("SecurityQuestionListServlet").forward(request, response);
			System.out.println("updated....??????...");
		}
		else
		{
			System.out.println("Not Updated......");
		}	
	}
}