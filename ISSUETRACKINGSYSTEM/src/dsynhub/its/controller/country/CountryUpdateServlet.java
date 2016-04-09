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
public class CountryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String country=request.getParameter("country");
		CountryBean bean=new CountryBean();
		bean.setCountryID(id);
		bean.setCountryName(country);
		System.out.println("COUNTRY"+country);
		request.setAttribute("bean",bean);
		 CountryDao dao=new CountryDao();
	       
	        boolean flag1=dao.duplicate(country);
	        PrintWriter out=response.getWriter();
	        if(flag1==false)
	        {
	        	 boolean flag= dao.update(bean);
	        	 if(flag==true)
	        	 {
	        		 System.out.println("updated");
	        		 RequestDispatcher rd=request.getRequestDispatcher("CountryListServlet");
	        		 rd.forward(request,response);
	        	 }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
	        		 RequestDispatcher rd = request.getRequestDispatcher("CountryListServlet");
	        		 rd.forward(request, response);
	        	 }
	        }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
						RequestDispatcher rd = request.getRequestDispatcher("CountryListServlet");
						rd.forward(request, response);
	        	 }
	    }
}