package dsynhub.its.controller.feedback;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.FeedbackBean;
import dsynhub.its.dao.FeedbackDao;
public class FeedbackInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		String feedbackName = req.getParameter("feedbackName");
		String feedbackDescription = req.getParameter("feedbackDescription");
		String feedbackDate= req.getParameter("feedbackDate");
		FeedbackBean bean = new FeedbackBean();
		bean.setFeedbackName(feedbackName);
		bean.setFeedbackDescription(feedbackDescription);
		bean.setFeedbackDate(feedbackDate);
		FeedbackDao dao = new FeedbackDao();
		boolean flag = dao.insertDataFeedback(bean);
		if(flag){
			resp.sendRedirect("FeedbackListServlet");
		}
	}
}