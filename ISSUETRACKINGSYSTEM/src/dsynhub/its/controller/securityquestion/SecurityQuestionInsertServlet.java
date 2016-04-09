package dsynhub.its.controller.securityquestion;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.SequrityQuestionBean;
import dsynhub.its.dao.SequrityQuestionDao;

public class SecurityQuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String SequrityQue = request.getParameter("SequrityQuestionName");
		SequrityQuestionDao dao = new SequrityQuestionDao();
		SequrityQuestionBean bean = new SequrityQuestionBean();
		boolean flag = false;
		boolean isError = false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (SequrityQue.isEmpty() ||SequrityQue.trim().length()==0)
		{
			isError = true;
			request.setAttribute("SequrityQue","<font color=red>Enter the SequrityQue</font>");
		}	
		else if(SequrityQue.trim().length()>50)
		{
			isError = true;
			request.setAttribute("SequrityQue","<font color=red>size exided from 50 in SequrityQue</font>");
			
		}
		else if(pattern1.matcher(SequrityQue).matches()==false)
		{
			isError = true;
			request.setAttribute("SequrityQue","<font color=red>only character enter in SequrityQue</font>");
		}
		else
		{
			bean.setQuestionName(SequrityQue);
		}
		if (isError == true)
		{
			request.getRequestDispatcher("SequrityQuestionInsert.jsp").forward(request, response);
		}
		else 
		{
			boolean flag1 = dao.duplicate(SequrityQue);
			if (flag1 == false) 
			{
				flag = dao.DataInsert(bean);
				if (flag == true) 
				{
					System.out.println("Inserted........");
					request.getRequestDispatcher("SecurityQuestionListServlet").forward(request, response);
				}
				else
				{
					System.out.println("not inserted,...");
				}
			}
			else
			{
				request.setAttribute("duplicate","<font color=red>State Name exist </font>");
				RequestDispatcher rd = request.getRequestDispatcher("SecurityQuestionListServlet");
				rd.forward(request, response);
				System.out.println("data is already in table......");
			}
		}
	}
}