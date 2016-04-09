package dsynhub.its.controller.country;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CountryDao;

public class CountryDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int countryid=Integer.parseInt(request.getParameter("hid"));
		CountryBean bean=new CountryBean();
		bean.setCountryID(countryid);
		PrintWriter out=response.getWriter();
		request.setAttribute("bean",bean);
		CountryDao pstd=new CountryDao();
		boolean flag1=pstd.checkReference(countryid);
		
		if(flag1==false)
		{
	        boolean flag= pstd.delete(bean);
	        if(flag)
	        {
	        	RequestDispatcher rd=request.getRequestDispatcher("CountryListServlet");
	    		rd.forward(request,response);
	        	out.write("<font size=4 color=red>deleted successfully</font>");
	        }
	        else
	        {
	        	request.setAttribute("delete", "<font color=red>Chiled Record Not Deleted</font>");
	        	RequestDispatcher rd=request.getRequestDispatcher("CountryListServlet");
	    		rd.forward(request,response);
	        }
	    }
	    else
	    {
	    	request.setAttribute("delete", "<font color=red>Chiled Record Not Deleted</font>");
	    	RequestDispatcher rd=request.getRequestDispatcher("CountryListServlet");
    		rd.forward(request,response);
	        out.write("<font size=4 color=red> not deleted successfully</font>");
	    }
	}
}