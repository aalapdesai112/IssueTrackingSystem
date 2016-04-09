<%@page import="dsynhub.its.bean.FeedbackBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript">
function del(feedbackId)
{
	if(confirm("Are U Sure to want to delete this"))
	{
		var f=document.feedbackList;
		f.feedbackId.value=feedbackId;
		f.action="FeedbackDeleteServlet";
		f.submit();
	}
	else
	{
		var f=document.feedbackList;
		f.action="FeedbackListServlet";
		f.submit();
	}
}
function ed(feedbackId)
{
		var f=document.feedbackList;
		f.feedbackId.value=feedbackId;
		f.action="FeedbackEditServlet";
		f.submit();
}
function Ins() 
{
	var f=document.feedbackList;
	f.action="FeedbackInsert.jsp";
	f.submit();
}
</script>
<body>
	<form name="feedbackList" action="" id="feedbackList" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<center>
					<input type="hidden" name="feedbackId" id="feedbackId">
					<table>
						<tr>
							<th>NAME</th>
							<th>FEEDBACK</th>
							<th>DATE</th>
							<th>ACTION</th>
						</tr>
						<%
	System.out.println("List Jsp:");
	List list = (ArrayList)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++) 
	{
		FeedbackBean bean = (FeedbackBean)list.get(i);
		%>
						<tr>
							<td><%=bean.getFeedbackName() %> &nbsp; &nbsp;</td>
							<td><%=bean.getFeedbackDescription() %></td>
							<td><%=bean.getFeedbackDate() %></td>
							<td><a href="#" onclick="ed(<%=bean.getFeedbackId()%>)">Edit</a>&nbsp;<a
								href="#" onclick="del(<%=bean.getFeedbackId()%>)">Delete</a></td>
						</tr>
						<%} %>
						<tr>
							<td><a href="#" onclick="Ins()" name="insertData">InsertData</a></td>
						</tr>
					</table>
				</center>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>