<%@page import="dsynhub.its.bean.StateBean"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.*"%>
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
function deleteData(id)
{
    var f=document.frm;
    if(confirm("are you sure you want to delete?"))
    {	
    f.id1.value=id;
           f.action="StateDeleteServlet";
          f.submit();
	   }       
}
function editData(id)
{
	var f=document.frm;
	if(confirm("are you sure you want to edit?"))
    {	
    f.id1.value=id;
	f.action="StateEditServlet";
	f.submit();
	}
}
function Insert()
{
	var f=document.frm;
	f.action="StateInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" action="" method="post">
		${reference} ${duplicate} ${delete}
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type=hidden name=id1 id=id1> <input type="button"
					onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<tr>
						<th>State Name</th>
						<th>Country Name</th>
						<th colspan="3">Action</th>
					</tr>
					<%
ArrayList list=(ArrayList)request.getAttribute("list");
System.out.println("size is"+list.size());
for(int i=0;i<list.size();i++)
{
	StateBean bean=(StateBean)list.get(i);
	%>
					<tr>
						<td><%=bean.getStateName() %></td>
						<td><%=bean.getCountryName() %></td>
						<td><a href="#" name="delete"
							onclick="javascript:deleteData(<%=bean.getStateId()%>);">Delete</a></td>
						<td><a href="#" name="edit"
							onclick="javascript:editData(<%=bean.getStateId()%>);">Update</a></td>
					</tr>
					<% }%>
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