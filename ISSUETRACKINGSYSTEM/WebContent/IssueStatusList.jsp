<%@page import="dsynhub.its.bean.IssueStatusBean"%>
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
	 var f=document.frm;
	 f.hid.value=id;
	 var msg=window.confirm("Are you Sure you want to delete");
	 if(msg)
	 {
			f.action="IssueStatusDeleteServlet";
			f.submit();
	 }
}
function update(id)
{
	var f=document.frm;
	f.hid.value=id;
	var a=window.confirm("are you sure you want to update");
	if(a)
	{
		f.action="IssueStatusEditServlet";
		f.submit();
	}
}
function Insert()
{
	var f=document.frm;
	f.action="IssueStatusInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<input type="hidden" name="hid" id="hid"> ${duplicate}
				${IssueStatus}
				<table border="2">
					<tr>
						<th>Issue Status</th>
						<th colspan="2">Action</th>
					</tr>
					<% 
ArrayList list=(ArrayList)request.getAttribute("list");
for(int i=0;i<list.size();i++)
{
	IssueStatusBean bean=(IssueStatusBean)list.get(i);
	%>
					<tr>
						<td><%=bean.getIssuestatus() %></td>

						<td><a href="#" name="delete"
							onclick="javascript:delete1(<%=bean.getIssuestatusid()%>)">Delete</a></td>
						<td><a href="#" name="edit" id="edit"
							onClick="javascript:update(<%=bean.getIssuestatusid()%>)">Update</a></td>
					</tr>
					<%}%>
					<tr>
						<td colspan="3" align="center"><a href="#" name="insertdata"
							onclick="Insert()">InsertData</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>