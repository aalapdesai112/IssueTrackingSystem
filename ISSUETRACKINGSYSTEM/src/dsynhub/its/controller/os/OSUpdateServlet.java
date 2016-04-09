package dsynhub.its.controller.os;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.OSBean;
import dsynhub.its.dao.OSDao;

public class OSUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String os=request.getParameter("os");
		OSBean bean=new OSBean();
		bean.setOsid(id);
		bean.setOs(os);
		request.setAttribute("bean",bean);
		 OSDao dao=new OSDao();
	        boolean flag1=dao.duplicate(os);
	        if(flag1==false)
	        {
	        	 boolean flag= dao.update(bean);
	        	 if(flag==true)
	        	 {
	        		 System.out.println("updated");
	        		 RequestDispatcher rd=request.getRequestDispatcher("OSListServlet");
	        		 rd.forward(request,response);
	        	 }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
	        		 RequestDispatcher rd = request.getRequestDispatcher("OSListServlet");
	        		 rd.forward(request, response);
	        	 }
	        }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
						RequestDispatcher rd = request.getRequestDispatcher("OSListServlet");
						rd.forward(request, response);
	        	 }
	    }
}
