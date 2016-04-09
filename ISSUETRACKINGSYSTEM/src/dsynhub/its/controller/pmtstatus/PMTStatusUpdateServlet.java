package dsynhub.its.controller.pmtstatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.PmtStatusDao;
public class PMTStatusUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String pmtStatus=request.getParameter("pmtStatus");
		PMTStatusBean bean=new PMTStatusBean();
		bean.setPmtstatusid(id);
		bean.setPmtstatus(pmtStatus);
		//System.out.println("COUNTRY"+country);
		request.setAttribute("bean",bean);
		 PmtStatusDao dao=new PmtStatusDao();
		 boolean flag1=dao.duplicate(pmtStatus);
		 if(flag1==false)
		 {
	        boolean flag= dao.update(bean);
	        if(flag==true)
	        {
	        	System.out.println("updated");
	        	RequestDispatcher rd=request.getRequestDispatcher("PMTStatusListServlet");
	    		rd.forward(request,response);
	        }
	        else
	    	 {
	    		 request.setAttribute("duplicate","");
	    		 RequestDispatcher rd = request.getRequestDispatcher("PMTStatusListServlet");
	    		 rd.forward(request, response);
	    	 }
	    }
	    	 else
	    	 {
	    		 request.setAttribute("duplicate","");
					RequestDispatcher rd = request.getRequestDispatcher("PMTStatusListServlet");
					rd.forward(request, response);
	    	 }
	  }
}