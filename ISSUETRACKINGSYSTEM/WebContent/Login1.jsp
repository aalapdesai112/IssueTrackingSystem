<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.UserTypeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen" title="default" />
<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>
<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>
<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
function Login() 
{
	alert("do want to countinu..");
			var f=document.loginfrm;
			f.action="LoginServlet1";
			f.submit();
}
</script>
</head>
<body id="login-bg">
	<form action="" name="loginfrm">
		<!-- Start: login-holder -->
		<div id="login-holder">

			<!-- start logo -->
			<div id="logo-login">
				<a href="index.html"><img src="images/shared/logo.png"
					width="156" height="40" alt="" /></a>
			</div>
			<!-- end logo -->

			<div class="clear"></div>

			<!--  start loginbox ...................................................... -->
			<div id="loginbox">

				<!--  start login-inner -->
				<div id="login-inner">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>UserType</th>
							<td><select name="usertype">
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

							</select>
						<tr>
							<th>Username</th>
							<td><input type="text" class="login-inp" name="username" /></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input type="password" value="************"
								name="password" class="login-inp" /></td>
						</tr>

						<tr>
							<th></th>
							<td><input type="button" class="submit-login"
								onclick="Login()" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>