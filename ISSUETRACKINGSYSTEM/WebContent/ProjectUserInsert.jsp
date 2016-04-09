<%@page import="dsynhub.its.bean.UserRoleBean"%>
<%@page import="dsynhub.its.dao.UserRoleDao"%>
<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.dao.UserRegistrationDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
<%@page import="dsynhub.its.dao.ProjectMasterDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function ins()
{
	
	var f=document.projectUser;
	f.action="ProjectUserInsertServlet";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="projectUser">
		<table border="2">
			<tr>
				<td>Project NAme::</td>
				<td><select name="project_id" id="project_id">
						<%
ProjectMasterDao dao2=new ProjectMasterDao();
ArrayList<ProjectMasterBean> list2=dao2.dataSelectProjectMaster();
ProjectMasterBean bean2=null;
for(int i=0;i<list2.size();i++)
	{		
		bean2=new ProjectMasterBean();
		bean2=(ProjectMasterBean)list2.get(i);
%>
						<option value="<%=bean2.getProjectId()%>"><%=bean2.getProjectName()%></option>
						<% }%>
				</select></td>
			</tr>


			<tr>
				<td>User NAme::</td>
				<td><select name="user_id" id="user_id">
						<%
UserRegistrationDao daoR=new UserRegistrationDao();
ArrayList<UserRegistrationBean> listR=daoR.dataSelectRegistration();
UserRegistrationBean beanR=null;
for(int i=0;i<listR.size();i++)
	{		
	beanR=new UserRegistrationBean();
	beanR=(UserRegistrationBean)listR.get(i);
%>
						<option value="<%=beanR.getUserId()%>"><%=beanR.getUserFirstName()%></option>
						<% }%>
				</select></td>
			</tr>


			<tr>
				<td>User Role::</td>
				<td><select name="role_id" id="role_id">
						<%
							UserRoleDao dao = new UserRoleDao();
							UserRoleBean bean = null;
							ArrayList<UserRoleBean> list3 = dao.dataSelect();

							for (int i = 0; i < list3.size(); i++) {
								bean = new UserRoleBean();
								bean = (UserRoleBean) list3.get(i);
						%>
						<option value="<%=bean.getRoleId()%>"><%=bean.getRoleName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td align="center"><a href="#" onclick="ins();">Insert</a></td>
			</tr>
		</table>
	</form>
</body>
</html>