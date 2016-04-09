package dsynhub.its.controller.state;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dsynhub.its.bean.StateBean;
import dsynhub.its.dao.StateDao;
public class StateInsertServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StateDao udo=new StateDao();
		String stateName=request.getParameter("stateName");
		int countryId=Integer.parseInt(request.getParameter("countryId"));
		StateBean bean=new StateBean();
		boolean isError=false;
		Pattern pattern1=Pattern.compile(".*[A-z].*");
		if (stateName.isEmpty() ||stateName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("stateName","<font color=red>Enter the stateName</font>");
		}	
		else if(stateName.trim().length()>50)
		{
			isError = true;
			request.setAttribute("stateName","<font color=red>size exided from 50 in stateName</font>");
			
		}
		else if(pattern1.matcher(stateName).matches()==false)
		{
			isError = true;
			request.setAttribute("stateName","<font color=red>only character enter in stateName</font>");
		}
		else
		{
			bean.setStateName(stateName);
			bean.setCountryId(countryId);
		}
		if (isError == true)
		{
			request.getRequestDispatcher("StateInsert.jsp").forward(request, response);
		}
		else 
		{
			boolean	flag1=false;
			flag1=udo.duplicateState(stateName);
			if(flag1==false)
			{
				boolean flag= udo.insert(bean);
				if(flag)
				{
					response.sendRedirect("StateListServlet");
				}
				else
				{
					request.setAttribute("duplicate","<font color=red>State Name exist </font>");
					RequestDispatcher rd=request.getRequestDispatcher("StateListServlet");
					rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("duplicate","<font color=red>State Name exist </font>");
				RequestDispatcher rd=request.getRequestDispatcher("StateListServlet");
				rd.forward(request, response);	
			}
		}
	}
}