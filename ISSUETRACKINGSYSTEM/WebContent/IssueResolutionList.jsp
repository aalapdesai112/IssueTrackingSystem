<%@page import="dsynhub.its.bean.IssueResolutionBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.IssueAssignBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href="./css/layout4_setup.css" />
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href="./css/layout4_text.css" />
<link rel="icon" type="image/x-icon" href="./img/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
<script type="text/javascript">
function Ins()
{
 	var f=document.viewpage;
 	f.action="IssueResolutionInsert.jsp";
 	f.submit();
}
function del(id)
{
	var f=document.viewpage;
	f.did.value=id;
	var msg="are you sure..."+id;
	if(confirm(msg))
		{
			f.action="IssueResolutionDeleteServlet";
			f.submit();
		}
	else
		{
		return false;
		}
}
function ed(id)
{
		var f=document.viewpage;
		f.did.value=id;
		f.action="IssueResolutionEditServlet";
		f.submit();
}
</script>
</head>
<body>
	<form action="" name="viewpage">
		<input type="hidden" id="did" name="did">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">

				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<H1 align="center" style="color: green"></H1>
				<table border="2">
					<tr>
						<th>Issue Name</th>
						<th>Issue Action Type</th>
						<th>Issue Action Discription</th>
						<th>Issue Resolved By</th>
						<th>Issue Resolved Date</th>
						<th colspan="2">Action</th>
					</tr>
					<%
		ArrayList list=(ArrayList)request.getAttribute("list");
		for(int i=0;i<list.size();i++)
		{
			IssueResolutionBean bean=(IssueResolutionBean)list.get(i);
			%><tr>
						<td><%=bean.getIssueName() %></td>
						<td><%=bean.getIssueActionType() %></td>
						<td><%=bean.getIssueActionDescription() %></td>
						<td><%=bean.getUserFirstName()%></td>
						<td><%=bean.getIssueResolvedDate() %></td>
						<td><a href="#" name="delete"
							onclick="del(<%=bean.getIssueResolutionId()%>)">Delete</a></td>
						<td><a href="#" name="edit"
							onclick="ed(<%=bean.getIssueResolutionId()%>)">Update</a></td>
						<%}%>
					</tr>
					<tr>
						<td colspan="5" align="center"><a href="#" name="insertdata"
							onclick="Ins()">InsertData</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>