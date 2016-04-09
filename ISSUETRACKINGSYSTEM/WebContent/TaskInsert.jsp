<%@page import="dsynhub.its.bean.PMTStatusBean"%>
<%@page import="dsynhub.its.dao.PmtStatusDao"%>
<%@page import="dsynhub.its.bean.PMTPriorityBean"%>
<%@page import="dsynhub.its.dao.PMTPriorityDao"%>
<%@page import="dsynhub.its.bean.ModuleBean"%>
<%@page import="dsynhub.its.dao.ModuleDao"%>
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
<script type="text/javascript">
function Ins()
{
	var f=document.frm;
	f.action="TaskInsertServlet";
	f.submit();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" method="post" action="">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table align="center" border="2">
					<tr>
						<td>Task Name</td>
						<td><input type="text" name="taskName" id="taskName"></td>
					</tr>
					<tr>
						<td>Task Description</td>
						<td><textArea name="taskDescription" cols="10" rows="3"></textArea></td>
					</tr>
					<tr>
						<td>Estimated Start date::</td>
						<td><input type="text" name="estimated_start_date"
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
			yearStart:2013
		}"
							value="" /></td>
					</tr>
					<tr>
						<td>Actual Start date::</td>
						<td><input type="text" name="actual_start_date"
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
			yearStart:2013
		}"
							value="" />${actualStartDate}</td>
					</tr>
					<tr>
						<td>Estimated End date::</td>
						<td><input type="text" name="estimated_end_date"
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
			yearStart:2013
		}"
							value="" /></td>
					</tr>
					<tr>
						<td>Actual End date::</td>
						<td><input type="text" name="actual_end_date"
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
			yearStart:2013
		}"
							value="" />${actualEndDate}</td>
					</tr>

					<tr>
						<td>PMT Priority::</td>
						<td><select name="priorityid">
								<%
PMTPriorityDao dao1=new PMTPriorityDao();
ArrayList<PMTPriorityBean> list1=dao1.dataSelect();
PMTPriorityBean bean1=null;
for(int i=0;i<list1.size();i++)
	{		
		bean1=new PMTPriorityBean();
		bean1=(PMTPriorityBean)list1.get(i);
%>
								<option value="<%=bean1.getPMTPriorityId()%>"><%=bean1.getPMTPriorityName()%></option>
								<% }%>
						</select>
					</tr>

					<tr>
						<td>PMT Status::</td>
						<td><select name="statusid">
								<%
PmtStatusDao dao=new PmtStatusDao();
ArrayList<PMTStatusBean> list=dao.select();
PMTStatusBean bean=null;
for(int i=0;i<list.size();i++)
	{		
		bean=new PMTStatusBean();
		bean=(PMTStatusBean)list.get(i);
%>
								<option value="<%=bean.getPmtstatusid()%>"><%=bean.getPmtstatus()%></option>
								<% }%>
						</select>
					</tr>

					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});
</script>

					<tr>
						<td>Module::</td>
						<td><select name="moduleid">
								<%
ModuleDao dao2=new ModuleDao();
ArrayList<ModuleBean> list2=dao2.dataSelectModule();
ModuleBean bean2=null;
for(int i=0;i<list2.size();i++)
	{		
		bean2=new ModuleBean();
		bean2=(ModuleBean)list2.get(i);
%>
								<option value="<%=bean2.getModuleId()%>"><%=bean2.getModuleName()%></option>
								<% }%>
						</select>
					</tr>
					<tr>
						<td align="center" colspan="2"><a href="#" name="submit"
							onclick="Ins()">Insert</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>