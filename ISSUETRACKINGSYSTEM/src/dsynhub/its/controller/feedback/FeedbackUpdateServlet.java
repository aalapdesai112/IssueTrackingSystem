package dsynhub.its.controller.feedback;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.FeedbackBean;
import dsynhub.its.dao.FeedbackDao;
public class FeedbackUpdateServlet extends HttpServlet{
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
				int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
				String feedbackName = request.getParameter("feedbackname");
				String feedbackDescription = request.getParameter("feedbackDescription");
				String feedbackDate = request.getParameter("feedbackDate");
				FeedbackBean bean = new FeedbackBean();
				bean.setFeedbackId(feedbackId);
				bean.setFeedbackName(feedbackName);
				bean.setFeedbackDescription(feedbackDescription);
				bean.setFeedbackDate(feedbackDate);
				FeedbackDao dao = new FeedbackDao();
				boolean flag = dao.updateDataFeedback(bean);
				if(flag)
				{
					request.getRequestDispatcher("FeedbackListServlet").forward(request, response);
					System.out.println("updated....??????...");
				}
				else
				{
					request.getRequestDispatcher("FeedbackListServlet").forward(request, response);
					System.out.println("Not Updated......");
				}
			}
	}