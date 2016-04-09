<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="dsynhub.its.dao.UserTypeDao"%>
<%@page import="dsynhub.its.bean.UserRoleBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.UserRoleDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="Loginform" action="LoginServlet">
		<h1>Login</h1>
		<table border="2" align="center">
			<tr>
				<td>User Type::</td>
				<td><select name="userId">
						<%
				UserTypeDao daoR = new UserTypeDao();
				ArrayList<UserTypeBean> listR = daoR.selectData();
				UserTypeBean beanR = null;
				for (int i = 0; i < listR.size(); i++) {
					beanR = new UserTypeBean();
					beanR = (UserTypeBean) listR.get(i);
			%>
						<option value="<%=beanR.getUserTypeId()%>"><%=beanR.getUserType()%></option>
						<%} %>
				</select></td>
			</tr>
			<tr>
				<td>UserName::</td>
				<td><input type="text" name="username"></td>
			<tr>
				<td>Password::</td>
				<td><input type="password" name="password" /></td>
			</tr>


			<tr>
				<td align="center" colspan="2"><a href="LoginServlet">Submit</a></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="reset"
					value="Reset" name="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>