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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>

	<form name="listpage">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="hidden" name="hid" id="hid"> <a href="#"
					onclick="history.go(-1);">Back</a>

				<table align="center">
					<% 
ArrayList list=(ArrayList)request.getAttribute("list");
for(int i=0;i<list.size();i++)
{
	UserRegistrationBean bean=(UserRegistrationBean)list.get(i);
	%>
					<tr></tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><font size="6"> User
								Detail</font></td>
					</tr>

					<tr>
						<td><b>UserFirstName::</b></td>
						<td><%=bean.getUserFirstName()%></td>
					<tr>
						<td><b>UserMiddleName::</b></td>
						<td><%=bean.getUserMiddleName()%></td>
					<tr>
						<td><b>UserLastName::</b></td>
						<td><%=bean.getUserLastName()%></td>
					<tr>
						<td><b>Current Address::</b></td>
						<td><%=bean.getUser_Res_Address() %>
					<tr>
						<td><b>PerMenent Address::</b></td>
						<td><%=bean.getUser_Per_Address() %>
					<tr>
						<td><b>CityName::</b></td>
						<td><%=bean.getCityName() %></td>
					<tr>
						<td><b>Gender::</b></td>
						<td><%=bean.getUserGender() %></td>
					<tr>
						<td colspan="2"><B><font size="5">--Personal
									Detail----------</font></B></td>
					</tr>

					<tr>
						<td><b>Birth Date::</b>
						<td><%=bean.getBirthDate() %></td>
					<tr>
						<td><b>User Phone No::</b></td>
						<td><%=bean.getUser_Phone_No() %></td>
					<tr>
						<td><b>User Mobile No::</b></td>
						<td><%=bean.getUser_Mobile_No() %></td>
					<tr>
						<td><b>EmailId</b></td>
						<td><%=bean.getEmailId() %></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><B><font size="5">--Login Detail------------</font></B></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><b>Login Date</b></td>
						<td><%=bean.getLoginDate()%></td>
					<tr>
						<td><b>User Status</b></td>
						<td><%=bean.getUserStatus()%></td>
					</tr>
					<%}%>

				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>