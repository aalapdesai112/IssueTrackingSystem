package dsynhub.its.controller.state;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.CountryDao;
import dsynhub.its.dao.StateDao;
public class StateUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String stateName=request.getParameter("stateName");
		StateBean bean=new StateBean();
		bean.setStateId(id);
		bean.setStateName(stateName);
		request.setAttribute("bean",bean);
		 StateDao dao=new StateDao();
	      boolean flag1=dao.duplicateState(stateName);
	        //PrintWriter out=response.getWriter();
	        if(flag1==false)
	        {
	        	 boolean flag= dao.update(bean);
	        	 if(flag==true)
	        	 {
	        		 System.out.println("updated");
	        		 RequestDispatcher rd=request.getRequestDispatcher("StateListServlet");
	        		 rd.forward(request,response);
	        	 }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
	        		 RequestDispatcher rd = request.getRequestDispatcher("StateListServlet");
	        		 rd.forward(request, response);
	        	 }
	        }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
						RequestDispatcher rd = request.getRequestDispatcher("StateListServlet");
						rd.forward(request, response);
	        	 }
	    }
}
