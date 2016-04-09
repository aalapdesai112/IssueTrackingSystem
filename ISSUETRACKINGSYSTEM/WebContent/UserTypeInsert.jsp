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
function insertData()
{
	var f=document.frm;
	f.action="UserTypeInsertServlet";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<a href="#" onclick="history.go(-1);">&lt;-- Back</a>
	<form name="frm" action="" method="post">
		${duplicate}
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<table>
					<tr>
						<td>User Type</td>
						<td><input type="text" name="userType" id="userType" />${userType}</td>
					</tr>
					<tr>
						<td><a href="#" onClick="insertData();">Insert</a></td>
						<td><input type="reset" name="reset" value="reset" /></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>