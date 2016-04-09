<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.StateBean"%>
<%@page import="dsynhub.its.bean.CityBean"%>
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
	 var f=document.citylist;
	 f.hid.value=id;
	 var msg=window.confirm("Are you Sure you want to delete?");
	 if(msg)
	 {
			f.action="CityDeleteServlet";
			f.submit();
	 }
}
function update(id)
{
	var f=document.citylist;
	f.hid.value=id;
	var a=window.confirm("are you sure you want to update");
	if(a)
	{
		f.action="CityEditServlet";
		f.submit();
	}
}
function Insert()
{
	var f=document.citylist;
	f.action="CityInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="citylist">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<!--<a href="#" onClick="history.go(-1);" value="Back&lt;&lt;">Back<<</a>  -->
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				${duplicate} ${reference} <input type="hidden" id="hid" name="hid">
				<table border="2">
					<%ArrayList list=(ArrayList)request.getAttribute("list");%>
					<tr>
						<th>CityName</th>
						<th>StateName</th>
						<th colspan="2">Action</th>
					</tr>
					<%
CityBean bean;
for(int i=0;i<list.size();i++)
{
		bean=new CityBean();
		bean=(CityBean)list.get(i);
		%>
					<tr>
						<td><%=bean.getCityName()%></td>
						<td><%=bean.getStateName() %>
						<td><a href="#" name="delete"
							onclick="delete1(<%=bean.getCityId()%>)">Delete</a></td>
						<td><a href="#" name="Edit"
							onclick="update(<%=bean.getCityId()%>)">Update</a> <%} %>
					<tr>
						<td colspan="4" align="center"><a href="#" name="insertdata"
							onclick="Insert()">Insertdata</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>