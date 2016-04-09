<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
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
function view(id)
{
	 var f=document.list;
	 f.hid.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="UserRegistrationViewServlet";
			f.submit();
	 }
}

function del(id)
{
	 var f=document.list;
	 f.hid.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="UserRegistrationDeleteServlet";
			f.submit();
	 }
	
}

function edit(id)
{
	 var f=document.list;
	 f.hid.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="UserRegistrationEditServlet";
			f.submit();
	 }
	
}
function Ins() {
	var f=document.list;
	f.action="UserRegistrationInsert.jsp";
	f.submit();
}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form name="list">
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" name="hid" id="hid"> <a href="#"
					onclick="history.go(-1);">Back</a>

				<table border="2">
					<tr>
						<th>UserName</th>
						<th>UserCity</th>
						<th>Gender</th>
						<th>UserMobileNo</th>
						<th>EmailID</th>
						<th>Action</th>
					</tr>
					<% 
ArrayList list=(ArrayList)request.getAttribute("Registrationlist");
for(int i=0;i<list.size();i++)
{
	UserRegistrationBean bean=(UserRegistrationBean)list.get(i);
	%>
					<tr>
						<td><%=bean.getUserFirstName() %></td>
						<td><%=bean.getCityName() %></td>
						<td><%=bean.getUserGender() %></td>
						<td><%=bean.getUser_Mobile_No() %></td>
						<td><%=bean.getEmailId() %></td>
						<td><a href="#" name="update"
							onclick="edit(<%=bean.getUserId()%>)">Update</a> <a href="#"
							name="delete" onclick="del(<%=bean.getUserId()%>)">delete</a> <a
							href="#" name="viewrecord" onclick="view(<%=bean.getUserId()%>);">ViewRecord</a></td>
					</tr>
					<%}%><tr>
						<td colspan="6" align="center"><a href="#" name="insertData"
							onclick="Ins();">InsertData</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>