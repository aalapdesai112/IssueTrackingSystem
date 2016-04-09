<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
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
function del(id)
{
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure...."+id);
	 if(msg)
	 {
			f.action="ProjectMasterDeleteServlet";
			f.submit();
	 }
}
function updateData(id)
{
	var f=document.viewpage;
	f.did.value=id;
	var msg="you want to edit";
	if(msg)
		{
			f.action="ProjectMasterEditServlet";
			f.submit();
		}
}
function view(id)
{
	alert(',,,,,,,,,,');
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure...."+id);
	 if(msg)
	 {
			f.action="ProjectMasterListServlet";
			f.submit();
	 }
}
function Ins()
{
	var f=document.viewpage;
	f.action="ProjectMasterInsert.jsp";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="viewpage">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" id="did" name="did">
				<H1 align="center" style="color: green">Project Master</H1>
				<table border="2">
					<tr>
						<td>Project Name</td>
						<td>ActualStartDate</td>
						<td>ActualEndDate</td>
						<td>Action</td>
					</tr>

					<%
		ArrayList list=(ArrayList)request.getAttribute("list");
		for(int i=0;i<list.size();i++)
		{
			ProjectMasterBean bean=(ProjectMasterBean)list.get(i);
			%><tr>
						<td><%=bean.getProjectName()%></td>
						<td><%=bean.getProj_actual_start_date()%></td>
						<td><%=bean.getProj_actual_end_date() %></td>
						<td><a href="#" name="delete"
							onclick="del(<%= bean.getProjectId()%>)">Delete</a></td>
						<td><a href="#" name="Update"
							onclick="updateData(<%=bean.getProjectId()%>)">Update</a></td>
						<td><a href="#" name="View"
							onclick="view(<%= bean.getProjectId()%>)">View</a></td>
						<%} %>
					</tr>
					<tr>
						<td colspan="6" align="center"><a href="#" name="insert"
							onclick="Ins();">InsertData</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>