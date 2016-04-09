<%@page import="dsynhub.its.dao.IssueDetailDao"%>
<%@page import="dsynhub.its.bean.IssueDetailBean"%>
<%@page import="java.util.ArrayList"%>
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
<script type="text/javascript">
function delete1(id)
{
	var f=document.listpage;
	f.id.value=id;
	var msg="are u sure"+id;
	if(confirm(msg))
		{
			f.action="IssueDetailDeleteServlet";
			f.submit();
		}
	else
		{
		return false;
		}
	
}

function Insert()
{
	var f=document.listpage;
	
			f.action="IssueDetailInsert.jsp";
			f.submit();
	
}
function edit1(id)
{
	var f=document.listpage;
	f.id.value=id;
	var msg="are u sure"+id;
	if(confirm(msg))
		{
		
			f.action="IssueDetailEditServlet";
			f.submit();
		}
	else
		{
		return false;
		}
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="IssueDetailUpdateServlet" name="listpage" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" name="id" id="id">
				<table border="2">
					<tr>
						<td>Issue Name</td>
						<td>Issue description</td>
						<td>ISSUE_CREATION_DATE</td>
						<td>ISSUE_TYPE</td>
						<td>Operting System</td>
						<td>Task Name</td>
						<td>ISSUE_Priority</td>
						<td>ISSUE_STATUS</td>
						<td>ISSUE_status_DATE</td>
						<td>ISSUE_SANP_SHORT</td>
						<td>USER NAME</td>
						<%
	IssueDetailDao dao=new IssueDetailDao();
	ArrayList<IssueDetailBean> list=dao.dataSelectIssueDetail();
	IssueDetailBean bean=null;
	for(int i=0;i<list.size();i++)
	{
		bean=new IssueDetailBean();
		bean = (IssueDetailBean) list.get(i);
	
%>
					
					<tr>
						<td><%=bean.getIssueName() %></td>
						<td><%=bean.getIssueDescription() %></td>
						<td><%=bean.getIssueCreationDate() %></td>
						<td><%=bean.getIssueType() %></td>
						<td><%=bean.getTaskName() %></td>
						<td><%=bean.getOs() %></td>
						<td><%=bean.getIssueLevel() %></td>
						<td><%=bean.getIssueStatus() %></td>
						<td><%=bean.getIssueStatusDate() %></td>
						<td><img src="image1\<%=bean.getIssueSnapShot()%>"
							alt="image" width="100" height="80" /></td>
						<%
System.out.println("path set...."+bean.getIssueSnapShot());
%>
						<td><%=bean.getUserName()%></td>


						<td><a href="#" onclick="delete1(<%=bean.getIssueId()%>)">Delete</a></td>
						<td><a href="#" onclick="edit1(<%=bean.getIssueId()%>)">Edit</a></td>
						<%} %>
						<td><a href="#" onclick="Insert()">Insert Data</a></td>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>