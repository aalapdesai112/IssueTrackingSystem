package dsynhub.its.controller.city;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.CityBean;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.CityDao;
import dsynhub.its.dao.StateDao;
public class CityInsertServlet extends HttpServlet
{
	private static final long serialVersionUID = 5529305582961502104L;
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
		CityDao dao=new CityDao();
		PrintWriter out=response.getWriter();		
		String cityName=request.getParameter("cityname");
		int cityId=Integer.parseInt(request.getParameter("statename"));
		CityBean bean=new CityBean();
		boolean isError=false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (cityName.isEmpty() ||cityName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("CityName","<font color=red>Enter the CityName</font>");
		}	
		else if(cityName.trim().length()>50)
		{
			isError = true;
			request.setAttribute("CityName","<font color=red>size exided from 50 in CityName</font>");			
		}
		else if(pattern1.matcher(cityName).matches()==false)
		{
			isError = true;
			request.setAttribute("CityName","<font color=red>only character enter in CityName</font>");
		}
		else
		{
			bean.setCityName(cityName);
			bean.setStateId(cityId);
		}
		if(isError==true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("CityInsert.jsp");
			rd.forward(request, response);
		}
		else
		{
			boolean	flag1=false;
			flag1=dao.duplicate(cityName);
			if(flag1==false)
			{
				boolean flag= dao.dataInsertCity(bean);
				if(flag)
				{
					response.sendRedirect("CityListServlet");
				}
			}
			else
			{
				request.setAttribute("duplicate","<font color=red>City Name exist </font>");
				RequestDispatcher rd=request.getRequestDispatcher("CityListServlet");
				rd.forward(request, response);	
		
			}
		}
	}
}