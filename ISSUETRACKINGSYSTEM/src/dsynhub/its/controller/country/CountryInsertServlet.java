package dsynhub.its.controller.country;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.CountryBean;
import dsynhub.its.dao.CountryDao;

public class CountryInsertServlet extends HttpServlet
{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
			{
				String CountryName = request.getParameter("country");
				boolean isError = false;
				CountryBean bean = new CountryBean();
				Pattern pattern1=Pattern.compile(".*[A-z].*");
				if (CountryName.isEmpty() ||CountryName.trim().length()==0)
				{
					isError = true;
					request.setAttribute("CountryName","<font color=red>Enter the CountryName</font>");
				}	
				else if(CountryName.trim().length()>30)
				{
					isError = true;
					request.setAttribute("CountryName","<font color=red>size exided from 30 in CountryName</font>");
					
				}
				else if(pattern1.matcher(CountryName).matches()==false)
				{
					isError = true;
					request.setAttribute("CountryName","<font color=red>only character enter in CountryName</font>");
				}
				else
				{
					bean.setCountryName(CountryName);
				}
				if (isError == true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("CountryInsert.jsp");
					rd.forward(request, response);
				}
				else
				{
					CountryDao dao = new CountryDao();
					boolean flag1 = dao.duplicate(CountryName);
					System.out.println("flag1" + flag1);
					request.setAttribute("bean", bean);
					if (flag1 == false)
					{
						boolean flag = dao.insert(bean);
						if (flag == true)
						{
							RequestDispatcher rd = request.getRequestDispatcher("CountryListServlet");
							rd.forward(request, response);
						}
						else
						{
							request.setAttribute("duplicate","<font color=red>Country Name exist </font>");
							RequestDispatcher rd = request.getRequestDispatcher("CountryListServlet");
							rd.forward(request, response);
						}
					}
					else
					{
						request.setAttribute("duplicate","<font color=red>Country Name exist </font>");
						RequestDispatcher rd = request.getRequestDispatcher("CountryListServlet");
						rd.forward(request, response);
					}
				}
		}
	}