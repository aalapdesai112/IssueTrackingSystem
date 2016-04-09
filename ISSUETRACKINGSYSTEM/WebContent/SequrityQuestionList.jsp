<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="dsynhub.its.bean.SequrityQuestionBean"%>
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
	
	var f=document.listpage;
	f.did.value=id;
	var msg="you want to delete";
	if(confirm(msg))
		{
		f.action="SecurityQuestionDeleteServlet";
		f.submit();
		}
}
function edit(id)
{
	var f=document.listpage;
	f.did.value=id;
	var msg="you want to edit";
	if(msg)
		{
			f.action="SecurityQuestionEditServlet";
			f.submit();
			
		}
}
function Insert()
{
	var f=document.listpage;
	f.action="SequrityQuestionInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="listpage">
		${duplicate}
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" name="did" id="id"> <input
					type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<%
ArrayList list=(ArrayList)request.getAttribute("list");
%>
					<tr>
						<th>SecurityQuestion</th>
						<th colspan="2">Action</th>
						<%
SequrityQuestionBean bean;
for(int i=0;i<list.size();i++)
	{
		bean=new SequrityQuestionBean();
		bean=(SequrityQuestionBean)list.get(i);
%>
					
					<tr>
						<td><%=bean.getQuestionName()%></td>
						<td><a href="#" name="delete"
							onclick="del(<%=bean.getQuestionId()%>)">Delete</a></td>
						<td><a href="#" name="Edit"
							onclick="edit(<%=bean.getQuestionId()%>)">Update</a></td>
					</tr>
					<%
} 
%>
					<tr>
						<td colspan="4" align="center"><a href="#" name="insertdata"
							onclick="Insert()">Insert</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>