<%@page import="dsynhub.its.dao.CountryDao"%>
<%@page import="dsynhub.its.bean.CountryBean"%>
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
function insertData()
{
	var f=document.frm;
	f.action="StateInsertServlet";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" action="" method="post">
		${duplicate}
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
				<input type=hidden id=id1 name=id1 />
				<table border="2">

					<tr>
						<td>Country Name</td>
						<td><select name="countryId">
								<%
CountryDao dao=new CountryDao();
ArrayList<CountryBean> list=dao.select();
CountryBean bean=null;
for(int i=0;i<list.size();i++)
{
	bean=new CountryBean();
	bean=(CountryBean)list.get(i);
	%>
								<option value="<%=bean.getCountryID()%>"><%=bean.getCountryName()%></option>
								<% }%>
						</select></td>
					</tr>
					<tr>
						<td>State name</td>
						<td><input type="text" name="stateName" id="stateName" />${stateName}</td>
						<% //=request.getAttribute("stateName")!=null?request.getAttribute("stateName"):"" %>
					</tr>
					<tr>
						<td><a href="#" name="insert" id="insert"
							onClick="insertData()">Insert</a></td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>