package dsynhub.its.controller.feedback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.FeedbackBean;
import dsynhub.its.dao.FeedbackDao;
public class FeedbackListServlet extends HttpServlet{
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
		FeedbackDao dao = new FeedbackDao();
		List<FeedbackBean> list =new ArrayList<FeedbackBean>();
		list=dao.selectDataFeedback();
		if(list!=null)
		{
			request.setAttribute("list",list);
			request.getRequestDispatcher("FeedbackList.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("FeedbackList.jsp").forward(request, response);
		}
	}
}