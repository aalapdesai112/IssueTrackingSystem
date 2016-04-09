<%@page import="dsynhub.its.bean.PMTStatusBean"%>
<%@page import="dsynhub.its.dao.PmtStatusDao"%>
<%@page import="dsynhub.its.bean.PMTPriorityBean"%>
<%@page import="dsynhub.its.dao.PMTPriorityDao"%>
<%@page import="dsynhub.its.dao.ProjectTechnologyDao"%>
<%@page import="dsynhub.its.bean.ProjectTechnologyBean"%>
<%@page import="dsynhub.its.bean.IssuePriorityBean"%>

<%@page import="dsynhub.its.dao.ProjectMasterDao"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.IssueStatusBean"%>
<%@page import="dsynhub.its.dao.IssueStatusDao"%>
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
	
	 function ins1()
	 {
	 alert('insert');
	 var f=document.projectMaster;
	 if(window.confirm("are you sure,,,,,,,,,"))
	 {
	 f.action="ProjectMasterInsertServlet";
	 f.submit();
	 }
	
	 }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="main-content">
		<div class="column1-unit">

			<form name="projectMaster" action="ProjectMasterInsertServlet">
				<h1>Project Detail</h1>
				<table border="2" align="center">
					<tr>
						<td>Project Name::</td>
						<td><input type="text" name="projectname" />${ProjectName}</td>
					</tr>
					<tr>
						<td>Project Descrption::</td>
						<td><textarea name="projectdescrption" row=3 /></textarea></td>
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
			yearStart:2007
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
			yearStart:2010
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
			yearStart:2010
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
			yearStart:2010
		}"
							value="" />${actualEndDate}</td>
					</tr>
					<tr>
						<td>Project Status Id::</td>
						<td><select name="Status_id">
								<%
				PmtStatusDao dao = new PmtStatusDao();
				ArrayList<PMTStatusBean> list = dao.select();
				PMTStatusBean bean = null;
				for (int i = 0; i < list.size(); i++) {
					bean = new PMTStatusBean();
					bean = (PMTStatusBean) list.get(i);
			%>
								<option value="<%=bean.getPmtstatusid()%>"><%=bean.getPmtstatus()%></option>
								<%
				}
			%>
						</select>
					</tr>

					<tr>
						<td>Project Priority Id::</td>
						<td><select name="project_priority_id">
								<%
				PMTPriorityDao dao1 = new PMTPriorityDao();
				ArrayList<PMTPriorityBean> list1 = dao1.dataSelect();
				PMTPriorityBean bean1 = null;
				for (int i = 0; i < list1.size(); i++) {
					bean1 = new PMTPriorityBean();
					bean1 = (PMTPriorityBean) list1.get(i);
			%>
								<option value="<%=bean1.getPMTPriorityId()%>"><%=bean1.getPMTPriorityName()%></option>
								<%
				}
			%>
						</select>
					</tr>
					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});

</script>
					<tr>
						<td>Project category Id::</td>
						<td><select name="project_categary_id">
								<%
				ProjectTechnologyDao dao2 = new ProjectTechnologyDao();
				ArrayList<ProjectTechnologyBean> list2 = dao2.dataSelect();
				ProjectTechnologyBean bean2 = null;
				for (int i = 0; i < list2.size(); i++) {
					bean2 = new ProjectTechnologyBean();
					bean2 = (ProjectTechnologyBean) list2.get(i);
			%>
								<option value="<%=bean2.getTechnologyId()%>"><%=bean2.getProjectTechnology()%></option>
								<%
				}
			%>
						</select>
					</tr>
					<tr>
						<td align="center" colspan="2"><a href="#" name="submit"
							onclick="ins1()">Insert</a></td>
					</tr>
				</table>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>