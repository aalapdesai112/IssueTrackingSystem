package dsynhub.its.controller.feedback;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.FeedbackBean;
import dsynhub.its.dao.FeedbackDao;
public class FeedbackEditServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
		{
			int feedbackId=Integer.parseInt(request.getParameter("feedbackId"));
			System.out.println(feedbackId);
			FeedbackDao dao = new FeedbackDao();
			FeedbackBean bean = dao.selectFeedback(feedbackId);
			if(bean!=null)
			{	
				request.setAttribute("feedbackId",bean);
				request.getRequestDispatcher("FeedbackEdit.jsp").forward(request, response);
			}
			else
			{		
		}
	}
}