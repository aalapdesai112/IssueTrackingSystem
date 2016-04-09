package dsynhub.its.controller.userregistration;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CountryDao;



public class CountryPreLoadedServlet extends HttpServlet {
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	public void init() throws ServletException {
		
			
			ServletContext appliction=getServletContext();	
			CountryDao dao=new CountryDao();
			ArrayList<CountryBean> list=dao.select();
				
			
			System.out.println("abc.................................................................");
			
			
			if(list!=null)
			{
				appliction.setAttribute("list", list);
				System.out.println("list,*************************************");
				
			}
	
	}	
}
