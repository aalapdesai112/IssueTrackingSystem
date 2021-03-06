package dsynhub.its.controller.securityquestion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.SequrityQuestionBean;
import dsynhub.its.dao.SequrityQuestionDao;
public class SecurityQuestionEditServlet extends HttpServlet{
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
			SequrityQuestionBean bean=new SequrityQuestionBean();
			bean.setQuestionId(strQuestionId);
			ArrayList< SequrityQuestionBean> list=dao.dataSelect1(strQuestionId);
			if(list!=null)
			{
				request.setAttribute("list", list);
				request.getRequestDispatcher("SequrityQuestionEdit.jsp").forward(request, response);
			}
			else
			{
				System.out.println("list is null");
			}
			
		}
}