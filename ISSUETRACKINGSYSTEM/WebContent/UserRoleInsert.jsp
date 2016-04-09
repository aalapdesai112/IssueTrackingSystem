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
function ins()
{
	var f=document.userrole;
	f.action="UserRoleInsertServlet";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="userrole">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">

				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				${duplicate}
				<h1>User Role</h1>
				<table border="2">
					<tr>
						<td>RoleName::</td>
						<td><input type="text" name="rolename">${strroleName}</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><a href="#" name="add"
							onclick="ins()">Insert</a></td>
					</tr>

				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>

	</form>
</body>
</html>