<%@page import="dsynhub.its.bean.ModuleBean"%>
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
function search()
{
	alert("search called..");
	var name = document.viewpage.Search.value;
	var f=document.viewpage;
	alert(name);
	f.modulename.value=name;
	f.action="ModuleSearchServlet";
	alert("--"+name);
	f.submit();
}

function del(id)
{
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="ModuleDeleteServlet";
			f.submit();
	 }
}

function view(id)
{
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="ModuleListServlet";
			f.submit();
	 }
}
function edit(id)
{
	var f=document.viewpage;
	f.did.value=id;
	var msg="you want to edit::"+id;
	if(window.confirm(msg))
		{
			f.action="ModuleEditServlet";
			f.submit();
			
		}
	}
function Insert()
{
	var f=document.viewpage;
	f.action="ModuleInsert.jsp";
	f.submit();
}	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="viewpage">
		<input type="hidden" name="modulename"> <input type="text"
			name="Search"> <input type="button" value="Search"
			onclick="search()">


		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" id="did" name="did"> ${delete} <input
					type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<H1 align="center" style="color: green"></H1>
				<table border="2">
					<tr>
						<th>Module Name</th>
						<th>ActualStartDate</th>
						<th>ActualEndDate</th>
						<th colspan="3">Action</th>
					</tr>
					<%		ArrayList list=(ArrayList)request.getAttribute("list");
		for(int i=0;i<list.size();i++)
		{
			ModuleBean bean=(ModuleBean)list.get(i);
			%><tr>
						<td><%=bean.getModuleName()%></td>
						<td><%=bean.getModuleActualStartDate()%></td>
						<td><%=bean.getModuleActualEndDate() %></td>
						<td><a href="#" onclick="del(<%= bean.getModuleId()%>)">Delete</a></td>
						<td><a href="#" onclick="view(<%= bean.getModuleId()%>)">List</a></td>
						<td><a href="#" name="Update"
							onclick="edit(<%=bean.getModuleId()%>)">Update</a></td>
						<%}%>
					
					<tr>
						<td colspan="6" align="center"><a href="#" onclick="Insert()">Insertdata</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>