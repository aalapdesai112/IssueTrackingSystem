package dsynhub.its.controller.feedback;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.dao.FeedbackDao;
public class FeedbackDeleteServlet extends HttpServlet{
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
			FeedbackDao dao = new FeedbackDao();
			boolean result=dao.deleteDataFeedback(feedbackId);
			if(result)
			{
				System.out.println("deleted"+result);
				response.sendRedirect("FeedbackListServlet");
			}
			else
			{
				System.out.println("not deleted"+result);
				response.sendRedirect("FeedbackListServlet");
			}
		}
	}