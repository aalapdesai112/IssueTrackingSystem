<%@page import="dsynhub.its.bean.ProjectUserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<table>
		<%
ArrayList list=(ArrayList)request.getAttribute("search");
for(int i=0;i<list.size();i++)
{
	ProjectUserBean bean=(ProjectUserBean)list.get(i);
	//ProjectUserBean bean=(ProjectUserBean)list.get(i);
%>
		<tr>
			<td><%=bean.getProjName() %></td>
			<td><%=bean.getUserName() %></td>ss
			<td><%=bean.getRoleName() %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>