package dsynhub.its.controller.pmtstatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.PMTStatusBean;
import dsynhub.its.dao.PmtStatusDao;

public class PMTStatusInsertServlet extends HttpServlet{
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
				String pmtStatus = request.getParameter("pmtStatus");
				System.out.println("PMTSTATUS"+pmtStatus);
				boolean isError = false;
				PMTStatusBean bean = new PMTStatusBean();
				
				Pattern pattern1=Pattern.compile(".*[A-z].*");
				if (pmtStatus.isEmpty() ||pmtStatus.trim().length()==0)
				{
					isError = true;
					request.setAttribute("pmtStatus","<font color=red>Enter the PriorityName</font>");
				}	
				else if(pmtStatus.trim().length()>50)
				{
					isError = true;
					request.setAttribute("pmtStatus","<font color=red>size exided from 50 in PriorityName</font>");
					
				}
				else if(pattern1.matcher(pmtStatus).matches()==false)
				{
					isError = true;
					request.setAttribute("pmtStatus","<font color=red>only character enter in PriorityName</font>");
				}
				else
				{
					bean.setPmtstatus(pmtStatus);
				}
				if (isError == true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("PMTStatusInsert.jsp");
					rd.forward(request, response);
				}
				else
				{
					PmtStatusDao dao = new PmtStatusDao();
					boolean flag1 = dao.duplicate(pmtStatus);
					request.setAttribute("bean", bean);
					if (flag1 == false)
					{
						boolean flag = dao.insert(bean);
						if (flag == true)
						{
							RequestDispatcher rd = request.getRequestDispatcher("PMTStatusListServlet");
							rd.forward(request, response);
							out.write("<font size=6 color=green>inserted successfully</font>");
						}
						else
						{
							request.setAttribute("duplicate","<font color=red>PMT Status exist </font>");
							RequestDispatcher rd = request.getRequestDispatcher("PMTStatusListServlet");
							rd.forward(request, response);
						}
					}
					else
					{
						request.setAttribute("duplicate","<font color=red>PMT Status exist </font>");
						RequestDispatcher rd = request.getRequestDispatcher("PMTStatusListServlet");
						rd.forward(request, response);
						out.write("<font size=6 color=green>not inserted  successfully because data already exit</font>");
					}
				}
	}
}
