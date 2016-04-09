<%@page import="dsynhub.its.bean.PMTPriorityBean"%>
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
	var f=document.userrolelist;
	f.did.value=id;
	var msg="are you sure you want to deleteSSS";
	if(confirm(msg))
		{
		f.action="PMTPriorityDeleteServlet";
		f.submit();
		}
	
}
function edit(id)
{
	var f=document.userrolelist;
	f.did.value=id;
	var msg="you want to edit";
	if(msg)
		{
			f.action="PMTPriorityEditServlet";
			f.submit();
		}
	}
function Insert()
{
	var f=document.userrolelist;
	f.action="PMTPriorityInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="userrolelist">
		${duplicate} ${delete}<br> <input type="hidden" name="did"
			id="id">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<%
	ArrayList list=(ArrayList)request.getAttribute("list");
%>
					<tr>
						<th>PMTPriorityName</th>
						<th colspan="3">Action</th>
					</tr>
					<%
PMTPriorityBean bean;
for(int i=0;i<list.size();i++)
	{
		bean=new PMTPriorityBean();
		bean=(PMTPriorityBean)list.get(i);
%>
					<tr>
						<td><%=bean.getPMTPriorityName()%></td>
						<td colspan="2" align="center"><a href="#" name="delete"
							onclick="del(<%=bean.getPMTPriorityId()%>)">Delete</a></td>
						<td><a href="#" name="Edit"
							onclick="edit(<%=bean.getPMTPriorityId()%>)">Update</a></td>
					</tr>
					<%
} 
%>
					<tr>
						<td colspan="4" align="center"><a href="#" name="insertdata"
							onclick="Insert()">InsertData</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>