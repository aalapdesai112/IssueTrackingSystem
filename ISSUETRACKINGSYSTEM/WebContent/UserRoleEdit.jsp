<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.UserRoleBean"%>
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
function update(id)
{
		var f=document.roleupdate;
		f.id.value=id;
		var msg="are you sure for update";
		if(msg)
			{
				f.action="UserRoleUpdateServlet";
				f.submit();
			}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="roleupdate">
		<input type="hidden" name="id" value="id">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<%
ArrayList list=(ArrayList)request.getAttribute("list");
UserRoleBean bean;
for(int i=0;i<list.size();i++)
	{
		bean=new UserRoleBean();
		bean=(UserRoleBean)list.get(i);
	
%>
					<tr>
						<td>RoleName::</td>
						<td><input type="text" name="rolename" id="rolename"
							value=<%=bean.getRoleName()%>></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#" name="Update"
							onclick="update(<%=bean.getRoleId()%>)">Update</a></td>
					</tr>
					<%}%>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>