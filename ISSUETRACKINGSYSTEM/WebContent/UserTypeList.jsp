<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="dsynhub.its.bean.CountryBean"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="dsynhub.its.dao.CountryDao"%>
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
function insertData()
{
	 var f=document.frm;
	 f.action = "UserTypeInsert.jsp";
	    f.submit();
	}
function deleteData(id)
{  
    var f=document.frm;
    f.id1.value=id;
    if(confirm("are you sure  to delete this record"))
    {	
    f.action = "UserTypeDeleteServlet";
    f.submit();
    }
}
function editData(id)
{
	var f=document.frm;
	 f.id1.value=id;
    if(confirm("are you sure  to edit this record"))
    {	  
    f.action = "UserTypeEditServlet";
    f.submit();
    }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<a href="#" onclick="history.go(-1);">&lt;-- Back</a>
	<form name="frm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" name="id1" id="id1"> ${duplicate}
				<table border="1">
					<!--  ${delete}
${update}
${insert}-->
					<%
ArrayList<UserTypeBean> list=(ArrayList)request.getAttribute("list");
UserTypeBean bean=null;
if(list!=null)
{
%>
					<tr>
						<th>User Type</th>
						<th colspan="2">Action</th>
					</tr>
					<% 
for(int i=0;i<list.size();i++)
{
	bean=new UserTypeBean();
	bean=(UserTypeBean)list.get(i);
	%>
					<tr>
						<td><%=bean.getUserType()%></td>
						<td><a href="#"
							onclick="javascript:editData(<%=bean.getUserTypeId()%>);">Edit</a></td>
						<td><a href="#"
							onclick="javascript:deleteData(<%=bean.getUserTypeId()%>);">Delete</a></td>
						<%}}%>
					
					<tr>
						<td colspan="4" align="center"><a href="#"
							onclick="javascript:insertData();">Insert</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>