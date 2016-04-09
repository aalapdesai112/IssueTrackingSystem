<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.StateDao"%>
<%@page import="dsynhub.its.bean.StateBean"%>
<%@page import="dsynhub.its.dao.CityDao"%>
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
	function ins() {
		var f = document.frm;
		f.action = "CityInsertServlet";
		f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" method="post" action="">
		<jsp:include page="Header.jsp"></jsp:include>

		<!-- <div class="main-content">
			<div class="column1-unit"> -->
		<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />

		<table>
			<tr>
				<td>StateName::</td>
				<td><select name="statename">
						<%
									StateDao dao = new StateDao();
									StateBean bean = null;
									ArrayList<StateBean> list = dao.selectData();

									for (int i = 0; i < list.size(); i++) {
										bean = new StateBean();
										bean = (StateBean) list.get(i);
								%>
						<option value="<%=bean.getStateId()%>"><%=bean.getStateName()%></option>
						<%
									}
								%>
				</select>
			<tr>
				<td>City Name:</td>
				<td><input type="text" name="cityname">${CityName}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="#" name="insert"
					onclick="ins()">Insert</a></td>
			</tr>
		</table>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>