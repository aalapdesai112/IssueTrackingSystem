package dsynhub.its.controller.city;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.CountryDao;

public class CityUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("hid"));
		String cityName=request.getParameter("cityname");
		CityBean bean=new CityBean();
		bean.setCityId(id);
		bean.setCityName(cityName);
		//System.out.println("city"+cityName);
		request.setAttribute("bean",bean);
		 CityDao dao=new CityDao();
	       
	        boolean flag1=dao.duplicate(cityName);
	        //PrintWriter out=response.getWriter();
	        if(flag1==false)
	        {
	        	 boolean flag= dao.dataUpdateCity(bean);
	        	 if(flag==true)
	        	 {
	        		 System.out.println("updated");
	        		 RequestDispatcher rd=request.getRequestDispatcher("CityListServlet");
	        		 rd.forward(request,response);
	        	 }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
	        		 RequestDispatcher rd = request.getRequestDispatcher("CityListServlet");
	        		 rd.forward(request, response);
	        	 }
	        }
	        	 else
	        	 {
	        		 request.setAttribute("duplicate","");
						RequestDispatcher rd = request.getRequestDispatcher("CityListServlet");
						rd.forward(request, response);
	        	 }
	    }
	
}
