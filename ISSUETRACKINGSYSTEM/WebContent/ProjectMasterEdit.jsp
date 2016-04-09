<%@page import="dsynhub.its.bean.PMTStatusBean"%>
<%@page import="dsynhub.its.dao.PmtStatusDao"%>
<%@page import="dsynhub.its.bean.ProjectTechnologyBean"%>
<%@page import="dsynhub.its.dao.ProjectTechnologyDao"%>
<%@page import="dsynhub.its.bean.PMTPriorityBean"%>
<%@page import="dsynhub.its.dao.PMTPriorityDao"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
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
function updateData(id)
{
	 var f=document.editfrm;
	 f.hid.value=id;
     var b=window.confirm("are you sure you want to update");
     
     if(b)
         {
            f.action="ProjectMasterUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 return false;
    	 }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>

	<form name="editfrm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type=hidden name="hid" id="hid">
				<table>
					<% 
ArrayList list=(ArrayList)request.getAttribute("list");
for(int i=0;i<list.size();i++)
{
	ProjectMasterBean bean=(ProjectMasterBean)list.get(i);
	//ProjectMasterBean bean=null;
		//bean=new ProjectMasterBean();
		//bean=(ProjectMasterBean)list.get(i);

	%>
					<tr>
						<td>Project Name::</td>
						<%System.out.println("projectname:::"+bean.getProjectName());%>
						<td><input type="text" name="projectname"
							value="<%=bean.getProjectName() %>" size="30">${ProjectName}</td>
					</tr>
					<tr>
						<td>Project Descrption::</td>
						<td><textarea name="projectdescrption" row=3 /><%=bean.getProjectdescription() %></textarea></td>
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
							value=<%=bean.getProj_estimated_start_date() %> /></td>
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
							value=<%=bean.getProj_actual_start_date() %> />${actualStartDate}</td>
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
							value=<%=bean.getProj_estimated_end_date() %> /></td>
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
							value=<%=bean.getProj_actual_end_date() %> />${actualEndDate}</td>
					</tr>
					<script>

$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});

</script>
					<tr>
						<td>Priority</td>
						<td><select name="project_priority_id">
								<%
				PMTPriorityDao dao1 = new PMTPriorityDao();
				ArrayList<PMTPriorityBean> list1 = dao1.dataSelect();
				PMTPriorityBean bean1 = null;
				for (int j = 0; j < list1.size(); j++) {
					bean1 = new PMTPriorityBean();
					bean1 = (PMTPriorityBean) list1.get(j);
					%>
								<option value="<%=bean1.getPMTPriorityId()%>"><%=bean1.getPMTPriorityName()%></option>
								<%}%>
								<option value="<%=bean.getPriorityId()%>" selected="selected"><%=bean.getPmtPriority()%></option>

						</select>
					</tr>
					<tr>
						<td>Status</td>

						<td><select name="Status_id">
								<%
				PmtStatusDao dao = new PmtStatusDao();
				ArrayList<PMTStatusBean> liststatus = dao.select();
				PMTStatusBean beanstatus = null;
				for (int j = 0; j < liststatus.size(); j++) {
					beanstatus = new PMTStatusBean();
					beanstatus = (PMTStatusBean) liststatus.get(j);
			%>
								<option value="<%=beanstatus.getPmtstatusid()%>"><%=beanstatus.getPmtstatus()%></option>
								<%}%>
								<option value="<%=bean.getStatusId()%>" selected="selected"><%=bean.getPmtStatus()%></option>
						</select>
					</tr>
					<tr>
						<td>Category Name</td>
						<td><select name="project_categary_id">
								<%
				ProjectTechnologyDao dao2 = new ProjectTechnologyDao();
				ArrayList<ProjectTechnologyBean> list2 = dao2.dataSelect();
				ProjectTechnologyBean bean2 = null;
				for (int j = 0; j < list2.size(); j++) {
					bean2 = new ProjectTechnologyBean();
					bean2 = (ProjectTechnologyBean) list2.get(j);
			%>
								<option value="<%=bean2.getTechnologyId()%>"><%=bean2.getProjectTechnology()%></option>
								<%}%>
								<option value="<%=bean.getCategaryId()%>" selected="selected"><%=bean.getProjCategary()%></option>
						</select>
					</tr>
					<td><a href="#" name="edit" id="edit"
						onClick="javascript:updateData(<%=bean.getProjectId()%>)">Update</a></td>
					<%} %>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>