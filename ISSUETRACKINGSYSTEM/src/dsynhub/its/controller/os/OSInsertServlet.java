package dsynhub.its.controller.os;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.its.bean.OSBean;
import dsynhub.its.dao.OSDao;
public class OSInsertServlet extends HttpServlet{
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
				PrintWriter out = response.getWriter();
				String OS = request.getParameter("os");
				boolean isError = false;
				OSBean bean = new OSBean();
				if (OS.isEmpty() ||OS.trim().length()==0)
				{
					isError = true;
					request.setAttribute("Os","<font color=red>Enter the Os</font>");
				}	
				else if(OS.trim().length()>50)
				{
					isError = true;
					request.setAttribute("Os","<font color=red>size exided from 50 in OS</font>");
					
				}
				else
				{
					bean.setOs(OS);
				}
				if (isError == true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("OSInsert.jsp");
					rd.forward(request, response);
				}
				else
				{
					OSDao dao = new OSDao();
					boolean flag1 = dao.duplicate(OS);
					System.out.println("flag1" + flag1);
					request.setAttribute("bean", bean);
					if (flag1 == false)
					{
						boolean flag = dao.insert(bean);
						if (flag == true)
						{
							RequestDispatcher rd = request.getRequestDispatcher("OSListServlet");
							rd.forward(request, response);
							out.write("<font size=6 color=green>inserted successfully</font>");
						}
						else
						{
							request.setAttribute("duplicate","<font color=red>OS exist </font>");
							RequestDispatcher rd = request.getRequestDispatcher("OSListServlet");
							rd.forward(request, response);
						}
					}
					else
					{
						request.setAttribute("duplicate","<font color=red>OS exist </font>");
						RequestDispatcher rd = request.getRequestDispatcher("OSListServlet");
						rd.forward(request, response);
						out.write("<font size=6 color=green>not inserted  successfully because data already exit</font>");
					}
				}
			}
}
