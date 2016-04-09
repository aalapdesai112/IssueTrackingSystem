<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.dao.UserRegistrationDao"%>
<%@page import="dsynhub.its.bean.IssueStatusBean"%>
<%@page import="dsynhub.its.dao.IssueStatusDao"%>
<%@page import="dsynhub.its.bean.IssuePriorityBean"%>
<%@page import="dsynhub.its.dao.IssuePriorityDao"%>
<%@page import="dsynhub.its.bean.OSBean"%>
<%@page import="dsynhub.its.dao.OSDao"%>
<%@page import="dsynhub.its.bean.IssueTypeBean"%>
<%@page import="dsynhub.its.dao.IssueTypeDao"%>
<%@page import="dsynhub.its.dao.ProjectMasterDao"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
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
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/engine.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxModuleDao.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxTaskDao.js'></script>
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/util.js'></script>
<script type="text/javascript">
function getReply(projId){
	
	//alert(countryId);
	dwr.util.removeAllOptions("moduleid");
	//document.getElementById('stateLoader').style.visibility = 'visible';
	
	if(projId=='')
	{
		//alert(countryId);
		var data=[{moduleName:'-- Select --' ,moduleId:''}];
	
		dwr.util.addOptions("moduleid",data,"moduleId","moduleName");
	}else{
		//alert(countryId);
	  // document.getElementById('stateLoader').style.visibility = 'visible';
	 
	    AjaxModuleDao.selectModule(projId,function(data){
		dwr.util.addOptions("moduleid",data,"moduleId","moduleName");
		//document.getElementById('stateLoader').style.visibility = 'hidden';
		});
	}
}	


function getTask(moduleId){
	
	alert(moduleId);
	dwr.util.removeAllOptions("taskid");
	//document.getElementById('stateLoader').style.visibility = 'visible';
	
	if(moduleId=='')
	{
		//alert(countryId);
		var data=[{taskName:'-- Select --' ,taskId:''}];
	
		dwr.util.addOptions("taskid",data,"taskId","taskName");
	}else{
		alert(moduleId);
	  // document.getElementById('stateLoader').style.visibility = 'visible';
	 
	    AjaxTaskDao.selectTask(moduleId,function(data){
		dwr.util.addOptions("taskid",data,"taskId","taskName");
		//document.getElementById('stateLoader').style.visibility = 'hidden';
		});
	}
}
function update(id)
{
		var f=document.editpage;
		f.id.value=id;
		var msg="are you sure for update";
		if(msg)
			{
				f.action="IssueDetailUpdateServlet";
				f.submit();
			}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" name="editpage" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="id" name="id">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<table border="2">
					<%
ArrayList list=(ArrayList)request.getAttribute("list2");
IssueDetailBean bean=null;
for(int j=0;j<list.size();j++)
	{
		bean=new IssueDetailBean();
		bean=(IssueDetailBean)list.get(j);
		
		System.out.println(".....NAME.........."+bean.getIssueName());
		
%>

					<tr>
						<td>Issue Title::</td>
						<td><input type="text" name="issuetitle" id="issuetitle"
							value="<%=bean.getIssueName()%>"></td>
					<tr>
						<td>ISSUE DESCRIPTION</td>
						<td><input type="text" name="issuedescription"
							id="issuedescription" value="<%=bean.getIssueDescription()%>"></td>
					</tr>


					<tr>

						<td>ISSUE_CREATION_DATE</td>
						<td><input type="text" name="issueCreationData"
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
							value="<%=bean.getIssueCreationDate() %>" />${issueCreationDate}</td>

					</tr>
					<tr>
						<td>Project::</td>
						<td><select name="project_id" onchange="getReply(this.value)">
								<%
ProjectMasterDao daoP=new ProjectMasterDao();
ArrayList<ProjectMasterBean> listP=daoP.dataSelectProjectMaster();
ProjectMasterBean beanP=null;
for(int i=0;i<listP.size();i++)
	{		
		beanP=new ProjectMasterBean();
		beanP=(ProjectMasterBean)listP.get(i);
%>
								<option value="<%=beanP.getProjectId()%>"><%=beanP.getProjectName()%></option>
								<% }%>
						</select>
					</tr>
					<tr>
						<td>Module Id</td>
						<td><select name="moduleid" id="moduleid"
							onchange="getTask(this.value)">
						</select>
					</tr>
					<tr>
						<td>Task Id::</td>
						<td><select name="taskid" id="taskid">
								<option value="<%=bean.getTaskId()%>"><%=bean.getTaskName()%></option>
						</select>${taskId }</td>
					</tr>
					<tr>
						<td>Issue Type Id::</td>
						<td><select name="issue_type_id">
								<%
				IssueTypeDao daoI = new IssueTypeDao();
				ArrayList<IssueTypeBean> listI = daoI.select();
				IssueTypeBean beanI = null;
				for (int i = 0; i < listI.size(); i++) {
					beanI = new IssueTypeBean();
					beanI = (IssueTypeBean) listI.get(i);
			%>
								<option value="<%=beanI.getIssuetypeid()%>"><%=beanI.getIssuetype()%></option>
								<%
				}
			%>
								<option value="<%=bean.getIssueTypeId()%>" selected="selected"><%=bean.getIssueType() %></option>
						</select>${issueTypeId}</td>
					</tr>



					<tr>
						<td>Operating System::</td>
						<td><select name="os_id">
								<%
				OSDao daoO = new OSDao();
				ArrayList<OSBean> listO = daoO.select();
				OSBean beanO = null;
				for (int i = 0; i < listO.size(); i++) {
					beanO = new OSBean();
					beanO = (OSBean) listO.get(i);
			%>
								<option value="<%=beanO.getOsid()%>"><%=beanO.getOs()%></option>
								<%
			}
			%>
								<option value="<%=bean.getOsId()%>"><%=bean.getOs()%></option>
						</select></td>
					</tr>
					<tr>
						<td>Issue Priority Id::</td>
						<td><select name="issue_priority_id">
								<%
				IssuePriorityDao dao2 = new IssuePriorityDao();
				ArrayList<IssuePriorityBean> list2 = dao2.dataSelect();
				IssuePriorityBean bean2 = null;
				for (int i = 0; i < list2.size(); i++) {
					bean2 = new IssuePriorityBean();
					bean2 = (IssuePriorityBean) list2.get(i);
			%>
								<option value="<%=bean2.getIssuePriorityId()%>"><%=bean2.getIssuePrioritylevel()%></option>
								<%
				}
			%>
								<option value="<%=bean.getIssuePriorityId()%>"
									selected="selected"><%=bean.getIssueLevel() %></option>
						</select>${issuePriorityId }</td>
					</tr>

					<tr>
						<td>Issue Status Id::</td>
						<td><select name="issue_status_id">
								<%
				IssueStatusDao dao3 = new IssueStatusDao();
				ArrayList<IssueStatusBean> list3 = dao3.select();
				IssueStatusBean bean3 = null;
				for (int i = 0; i < list3.size(); i++) {
					bean3 = new IssueStatusBean();
					bean3 = (IssueStatusBean) list3.get(i);
			%>
								<option value="<%=bean3.getIssuestatusid()%>"><%=bean3.getIssuestatus()%></option>
								<%} %>
								<option value="<%=bean.getIssueStatusId()%>" selected="selected"><%=bean.getIssueStatus() %></option>

						</select>${issueStatusId }</td>
					</tr>


					<tr>
						<td>ISSUE_STATUS_DATE</td>
						<td><input type="text" name="issue_status_date"
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
							value="<%=bean.getIssueStatusDate() %>" />${issueStatusDate }</td>
					</tr>
					<tr>
						<td>User Name::</td>
						<td><select name="userId">
								<%
				UserRegistrationDao daoU = new UserRegistrationDao();
				ArrayList<UserRegistrationBean> listU = daoU.dataSelectRegistration();
				UserRegistrationBean beanU = null;
				for (int i = 0; i < listU.size(); i++) {
					beanU = new UserRegistrationBean();
					beanU = (UserRegistrationBean) listU.get(i);
			%>
								<option value="<%=beanU.getUserId()%>"><%=beanU.getUserFirstName()%></option>
								<%} %>
								<option value="<%=bean.getUserId()%>" selected="selected"><%=bean.getUserName() %></option>
						</select></td>
					</tr>

					<tr>
						<td>Snap Shot</td>
						<td><img src="image1\<%=bean.getIssueSnapShot()%>"
							width="100" height="80" /> <input type="file" name="issueimage"
							id="issueimage"></td>

					</tr>
					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});
</script>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							name="valUpdate" id="valUpdate" value="Update"
							onclick="update(<%=bean.getIssueId()%>)"></td>
					</tr>
					<%} %>

				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>