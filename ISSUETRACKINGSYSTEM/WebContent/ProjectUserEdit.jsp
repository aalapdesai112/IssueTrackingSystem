<%@page import="dsynhub.its.dao.UserRegistrationDao"%>
<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.dao.UserRoleDao"%>
<%@page import="dsynhub.its.bean.UserRoleBean"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
<%@page import="dsynhub.its.dao.ProjectMasterDao"%>
<%@page import="dsynhub.its.dao.ProjectUserDao"%>
<%@page import="dsynhub.its.bean.ProjectUserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function edit(id)
{
	 var f=document.updatefrm;
	 f.did.value=id;
     var b=window.confirm("are you sure"+id);
     
     if(b)
         {
            f.action="ProjectUserUpdateServlet";
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
	<form action="" name="updatefrm">
		<input type="hidden" name="did" id="did">
		<table align="center">
			<%
			ArrayList list=(ArrayList)request.getAttribute("list");
			for(int i=0;i<list.size();i++)
			{
				ProjectUserBean bean=(ProjectUserBean)list.get(i);
				
				
				%>

			<tr>
				<td>Project Name::</td>
				<td><select name="proj_id" id="proj_id">
						<%ProjectMasterDao dao1=new ProjectMasterDao();
	
	ArrayList<ProjectMasterBean> list1=dao1.dataSelectProjectMaster();
	ProjectMasterBean bean1=null;
	for(int j=0;j<list1.size();j++)
	{
		
		bean1=new ProjectMasterBean();
		 bean1=(ProjectMasterBean)list1.get(j);
		%>
						<option value="<%=bean1.getProjectId() %>"><%=bean1.getProjectName() %></option>

						<%} %>
						<option value="<%= bean.getProjId()%>" selected="selected"><%=bean.getProjName() %></option>
				</select>
			</tr>




			<tr>
			<tr>
				<td>User Name::</td>
				<td><select name="user_id" id="user_id">
						<%
		UserRegistrationBean beanR=null;
		UserRegistrationDao daoR=new UserRegistrationDao();
			ArrayList<UserRegistrationBean> listR=daoR.dataSelectRegistration();
			
			for(int k=0;k<listR.size();k++)
			{
				beanR =new UserRegistrationBean();
				beanR=(UserRegistrationBean)listR.get(k);
				%>
						<option value="<%=beanR.getUserId()%>"><%=beanR.getUserFirstName() %></option>
						<%} %>

						<option value="<%= bean.getUserId()%>" selected="selected"><%=bean.getUserName() %></option>
				</select>
			</tr>

			<tr>
				<td>User Role::</td>
				<td><select name="role_id" id="role_id">
						<%
		UserRoleBean beanRole=null;
		UserRoleDao daorole=new UserRoleDao();
			ArrayList<UserRoleBean> listrole=daorole.dataSelect();
			
			for(int k=0;k<listrole.size();k++)
			{
				beanRole =new UserRoleBean();
				beanRole=(UserRoleBean)listrole.get(k);
				%>
						<option value="<%=beanRole.getRoleId()%>"><%=beanRole.getRoleName() %></option>
						<%} %>

						<option value="<%= bean.getRoleId()%>" selected="selected"><%=bean.getRoleName() %></option>
				</select>
			</tr>


			<tr>
				<td align="center"><a href="#"
					onclick="edit(<%=bean.getProjUserId()%>)">update</a></td>
			</tr>
			<%} %>
		</table>
	</form>
</body>
</html>