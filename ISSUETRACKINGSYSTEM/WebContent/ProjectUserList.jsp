<%@page import="dsynhub.its.bean.ProjectUserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function del(id)
{
	var f=document.myform;
	f.did.value=id;
	var msg="are you sure you want to delete.."+id;
	if(confirm(msg))
		{
		f.action="ProjectUserDeleteServlet";
		f.submit();
		}
	
}
function search()
{
	var f=document.myform;
	f.action="ProjectUserSearchServlet";
	f.submit();
}
function edit(id)
{
	
	alert("edit");
	var f=document.myform;
	f.did.value=id;
	var msg="you want to edit::"+id;
	if(msg)
		{
			f.action="ProjectUserEditServlet";
			f.submit();
			
		}
	}
	function Ins()
	{
		var f=document.myform;
		f.action="ProjectUserInsert.jsp";
		f.submit();
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="myform">
		<input type="hidden" name="did" id="did"> <input type="hidden"
			name="sname" id="sname"> <input type="text" name="Search1"
			id="Search1"> <input type="button" value="Search"
			onclick="search()">
		<table>
			<tr>
				<th>ProjectName</th>
				<th>UserName</th>
				<th>Role NAme</th>
				<th colspan="4">Action</th>
			</tr>
			<%
		ArrayList list = (ArrayList) request.getAttribute("list");
	for (int i = 0; i < list.size(); i++) {
		
 ProjectUserBean bean = (ProjectUserBean) list.get(i);
	%>

			<tr>
				<td><%=bean.getProjName() %></td>
				<td><%=bean.getUserName() %></td>
				<td><%=bean.getRoleName() %></td>
				<td colspan="2" align="center"><a href="#" name="delete"
					onclick="del(<%=bean.getProjUserId()%>)">Delete</a></td>
				<td colspan="2" align="center"><a href="#" name="Edit"
					onclick="edit(<%=bean.getProjUserId()%>)">Update</a></td>
			</tr>

			<%} %>
			<tr>
				<td colspan="7" align="center"><a href="#" name="insertData"
					onclick="Ins()">InsertData</a></td>
			</tr>
		</table>
	</form>
</body>
</html>