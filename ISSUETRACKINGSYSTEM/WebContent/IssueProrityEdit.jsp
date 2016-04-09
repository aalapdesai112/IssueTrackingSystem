<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.IssuePriorityBean"%>
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
		var f=document.updatepage;
		f.id.value=id;
		var msg="are you sure for update";
		if(msg)
			{
				f.action="IssuePriorityUpdateServlet";
				f.submit();
			}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="updatepage" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<input type="hidden" name="id" value="id">
				<table border="2">
					<%
ArrayList list=(ArrayList)request.getAttribute("list");
IssuePriorityBean bean;
for(int i=0;i<list.size();i++)
	{
		bean=new IssuePriorityBean();
		bean=(IssuePriorityBean)list.get(i);
%>
					<tr>
						<td>IssuePriorityName::</td>
						<td><input type="text" name="priorityname" id="priorityname"
							value=<%=bean.getIssuePrioritylevel()%>></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#" name="Update"
							onclick="update(<%=bean.getIssuePriorityId()%>)">Update</a></td>
					</tr>
					<%}%>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>