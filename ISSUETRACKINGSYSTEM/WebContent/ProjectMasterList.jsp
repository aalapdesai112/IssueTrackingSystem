<%@page import="dsynhub.its.bean.*"%>
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


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="viewpage">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">

				<input type="hidden" id="did" name="did">
				<H1 align="center" style="color: green">Project Master</H1>
				<table border="2">
					<tr>
						<th>Project Name</th>
						<th>Project Description</th>
						<th>EstimatedStartDate</th>
						<th>ActualStartDate</th>
						<th>EstimatedEndDate</th>
						<th>ActualEndDate</th>
						<th>PriorityName</th>
						<th>PMTStatus</th>
						<th>PrjectCategory</th>
						<th>Action</th>
					</tr>

					<%
		ArrayList list=(ArrayList)request.getAttribute("list");
		for(int i=0;i<list.size();i++)
		{
			ProjectMasterBean bean=(ProjectMasterBean)list.get(i);
			%><tr>
						<td><%=bean.getProjectName()%></td>
						<td><%=bean.getProjectdescription() %>
						<td><%=bean.getProj_estimated_start_date() %></td>
						<td><%=bean.getProj_actual_start_date()%></td>
						<td><%=bean.getProj_estimated_end_date()%></td>
						<td><%=bean.getProj_actual_end_date() %></td>
						<td><%=bean.getPmtPriority() %></td>
						<td><%=bean.getPmtStatus() %></td>
						<td><%=bean.getProjCategary()%></td>

						<%} %>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>