<%@page import="dsynhub.its.dao.*"%>
<%@page import="dsynhub.its.bean.*"%>
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
function updateData(id)
{
	alert('.............Update..............');
	 var f=document.frm;
	 f.did.value=id;
   
     if(window.confirm("are you sure  to update this record"+id))
         {
    		 alert('');
            f.action="ModuleUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 alert('.m;lmgh;jkju');
    	 return false;
    	 }
}

</script>
<link rel="stylesheet" href="pagestyle.css" media="screen, projection" />
<link rel="stylesheet" href="slimpicker.css" media="screen, projection" />
<script src="mootools-1.2.4-core-yc.js"></script>
<script src="mootools-1.2.4.4-more-yc.js"></script>
<script src="slimpicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type=hidden name="did" id="did"> <input type="button"
					onClick="history.go(-1);" value="Back&lt;&lt;" />
				<%
					ArrayList<ModuleBean> list=(ArrayList)request.getAttribute("list");
						ModuleBean bean=null;
						for(int i=0;i<list.size();i++)
						{
							bean=new ModuleBean();
							bean=(ModuleBean)list.get(i);
						}
				%>
				<br /> <br />
				<table align="center" border="2">
					<tr>
						<td>Module name</td>
						<td><input type="text" name="moduleName" id="moduleName"
							value="<%=bean.getModuleName()%>" />${moduleName}</td>
					</tr>
					<tr>
						<td>Module Description</td>
						<td><textarea rows="5" cols="10" name="description"><%=bean.getModuleDescription()%></textarea>
							${moduleDescription}</td>

					</tr>
					<tr>
						<td>Module Estimated Start Date</td>
						<td><input type="text" name="moduleEstimatedStartDate"
							id="moduleEstimatedStartDate" class="slimpicker"
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
							value="<%=bean.getModuleEstimateStartDate()%>" />${estimatedStartDate}</td>

					</tr>

					<tr>
						<td>Module actual Start Date</td>
						<td><input type="text" name="moduleActualStartDate"
							id="moduleActualStartDate" class="slimpicker"
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
							value="<%=bean.getModuleActualStartDate()%>" />${actualStartDate}</td>
					</tr>
					<tr>
						<td>Module Estimated End Date</td>
						<td><input type="text" name="moduleEstimatedEndDate"
							id="moduleEstimatedEndDate" class="slimpicker"
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
							value="<%=bean.getModuleEstimateEndDate()%>" />${estimatedEndDate}</td>
					</tr>
					<tr>
						<td>Module actual End Date</td>
						<td><input type="text" name="moduleActualEndDate"
							id="moduleActualEndDate" class="slimpicker"
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
							value="<%=bean.getModuleActualEndDate()%>" />${actualEndDate}</td>
					</tr>
					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});
</script>
					<tr>
					<tr>
						<td>priority</td>
						<td><select name="pmtPrority">
								<%
									PMTPriorityDao psex = new PMTPriorityDao();
									ArrayList<PMTPriorityBean> plist = psex.dataSelect();
									PMTPriorityBean pbean = null;
									if (plist != null) {
										for (int i = 0; i < plist.size(); i++) {
											pbean = new PMTPriorityBean();
											pbean = (PMTPriorityBean) plist.get(i);
											if (bean.getPmtPriorityId() == pbean.getPMTPriorityId()) {
								%>
								<option value="<%=pbean.getPMTPriorityId()%>"
									selected="selected"><%=pbean.getPMTPriorityName()%></option>
								<%}
								else {
								%>
								<option value="<%=pbean.getPMTPriorityId()%>"><%=pbean.getPMTPriorityName()%></option>
								<%
									}
										}
									}
								%>
						</select>${priorityID}</td>
					</tr>
					<tr>
						<td>Status</td>
						<td><select name="pmtStatus">
								<%
									PmtStatusDao sdao = new PmtStatusDao();
									ArrayList<PMTStatusBean> slist = sdao.select();
									PMTStatusBean sbean = null;
									if (slist != null) {
										for (int i = 0; i < slist.size(); i++) {
											sbean = new PMTStatusBean();
											sbean = (PMTStatusBean) slist.get(i);
											if (bean.getPmtStatusId() == sbean.getPmtstatusid()) {
								%>
								<option value="<%=sbean.getPmtstatusid()%>" selected="selected"><%=sbean.getPmtstatus()%></option>
								<%
									} else {
								%>
								<option value="<%=sbean.getPmtstatusid()%>"><%=sbean.getPmtstatus()%></option>
								<%
									}
										}
									}
								%>
						</select>${statusId}</td>
					</tr>
					<tr>
						<td>Project Name</td>
						<td><select name="projectName">
								<%
									ProjectMasterDao pmdao = new ProjectMasterDao();
									ArrayList<ProjectMasterBean> pmlist = pmdao
											.dataSelectProjectMaster();
									ProjectMasterBean pmbean = null;
									if (pmlist != null) {
										for (int j = 0; j < pmlist.size(); j++) {
											pmbean = new ProjectMasterBean();
											pmbean = (ProjectMasterBean) pmlist.get(j);
											//System.out.println(bean.getPmtStatusId());
											if (bean.getProjectId() == pmbean.getProjectId()) {
								%>
								<option value="<%=pmbean.getProjectId()%>" selected="selected"><%=pmbean.getProjectName()%></option>
								<%
									}
								%>
								<option value="<%=pmbean.getProjectId()%>"><%=pmbean.getProjectName()%></option>
								<%
									}
									}
								%>
						</select>${projectId}</td>
					</tr>
					<tr>
						<td><a href="#" name="update"
							onclick="javascript:updateData(<%=bean.getModuleId()%>)">Update</a>
							<a href="reset" name="reset">Reset</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>