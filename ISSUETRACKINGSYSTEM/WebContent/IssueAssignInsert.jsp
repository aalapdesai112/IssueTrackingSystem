<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.dao.UserRegistrationDao"%>
<%@page import="dsynhub.its.dao.IssueDetailDao"%>
<%@page import="dsynhub.its.bean.IssueDetailBean"%>
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

<link rel="stylesheet" href="pagestyle.css" media="screen, projection" />
<link rel="stylesheet" href="slimpicker.css" media="screen, projection" />
<script src="mootools-1.2.4-core-yc.js"></script>
<script src="mootools-1.2.4.4-more-yc.js"></script>
<script src="slimpicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
<script type="text/javascript">
function ins()
{
var f=document.frm;
f.action="IssueAssignInsertServlet";
f.submit();
}
</script>
</head>
<body>
	<form name="frm" method="post" action="">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<tr>
						<td>Issue Name::</td>
						<td><select name="issuename">
								<option>--Select IssueName--</option>
								<%
IssueDetailDao dao=new IssueDetailDao();
ArrayList<IssueDetailBean> list=dao.dataSelectIssueDetail();
IssueDetailBean bean=null;
for(int i=0;i<list.size();i++)
	{		
		bean=new IssueDetailBean();
		bean=(IssueDetailBean)list.get(i);
%>
								<option value="<%=bean.getIssueId()%>"><%=bean.getIssueName()%></option>
								<% }%>
						</select>
					</tr>
					<tr>
						<td>Issue Assign To::</td>
						<td><select name="issueassign">
								<option>--Select User--</option>
								<%

UserRegistrationDao dao1=new UserRegistrationDao();
ArrayList<UserRegistrationBean> list1=dao1.dataSelectRegistration();
UserRegistrationBean bean1=null;
for(int i=0;i<list1.size();i++)
	{		
		bean1=new UserRegistrationBean();
		bean1=(UserRegistrationBean)list1.get(i);
	
%>

								<option value="<%=bean1.getUserId()%>"><%=bean1.getUserFirstName()%></option>
								<%} %>
						</select>
					</tr>
					<tr>
						<td>Issue Reported By::</td>
						<td><select name="issuereported">
								<option>--Select User--</option>
								<% 
UserRegistrationDao dao2=new UserRegistrationDao();
ArrayList<UserRegistrationBean> list2=dao1.dataSelectRegistration();
UserRegistrationBean bean2=null;
for(int i=0;i<list2.size();i++)
	{		
		bean2=new UserRegistrationBean();
		bean2=(UserRegistrationBean)list2.get(i);
%>
								<option value="<%=bean2.getUserFirstName()%>"><%=bean2.getUserFirstName()%></option>

								<%} %>
						</select>
					</tr>
					<tr>
						<td>Issue Assign date::</td>
						<td><input type="text" name="issueassigndate"
							class="slimpicker"
							alt="{
			dayChars:3,
			dayNames:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
			daysInMonth:[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
			format:'dd-mm-yyyy',
			monthNames:['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			startDay:1,
			yearOrder:'desc',
			yearRange:90,
			yearStart:2014
		}"
							value="" /></td>
						<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});

</script>
					</tr>
					<tr>
						<td><a href="#" name="Insert" onclick="ins()">Insert</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>