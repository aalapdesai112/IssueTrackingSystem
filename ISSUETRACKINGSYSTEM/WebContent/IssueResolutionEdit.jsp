<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.dao.UserRegistrationDao"%>
<%@page import="dsynhub.its.bean.IssueDetailBean"%>
<%@page import="dsynhub.its.dao.IssueDetailDao"%>
<%@page import="dsynhub.its.bean.IssueResolutionBean"%>
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
<link rel="stylesheet" href="pagestyle.css" media="screen, projection" />
<link rel="stylesheet" href="slimpicker.css" media="screen, projection" />
<script src="mootools-1.2.4-core-yc.js"></script>
<script src="mootools-1.2.4.4-more-yc.js"></script>
<script src="slimpicker.js"></script>
<script type="text/javascript">
function updateData(id)
{
	 var f=document.editfrm;
	 f.did.value=id;
     var b=window.confirm("are you sure you want to update");
     
     if(b)
         {
            f.action="IssueResolutionUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 return false;
    	 }
}
function deleteData(id)
{
    var f=document.editfrm;
    f.did.value=id;
    var b=window.confirm("are you sure you want to delete?");
    if(b)
        {
           f.action="IssueResolutionDeleteServlet";
           f.submit();
        }
        else
            {
				return false;
            }
}
function viewData()
{
	var f=document.editfrm;
	f.action="IssueResolutionListServlet";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="editfrm" action="" method="post">
		<input type=hidden name="did" id="did">
		<!--  <input type="button" onClick="history.go(-1);" value="Back&lt;&lt;"></a>-->
		<input type="button" onClick="history.go(-1);" value="Back&lt;&lt;" />
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<table border="2">
					<% 
ArrayList list=(ArrayList)request.getAttribute("list");
IssueResolutionBean bean=null;
for(int i=0;i<list.size();i++)
{
	bean=new IssueResolutionBean();
	bean=(IssueResolutionBean)list.get(i);
	%>
					<tr>
						<td>Issue Name::</td>
						<td><select name="issuename">

								<%
IssueDetailDao dao=new IssueDetailDao();
ArrayList<IssueDetailBean> list1=dao.dataSelectIssueDetail();
IssueDetailBean bean1=null;

for(int j=0;j<list1.size();j++)
	{		
		bean1=new IssueDetailBean();
		bean1=(IssueDetailBean)list1.get(j);
		
		%>
								<option value="<%=bean1.getIssueId()%>"><%=bean1.getIssueName()%></option>
								<%} %>
								<option value="<%=bean.getIssueId()%>" selected="selected"><%=bean.getIssueName()%></option>
						</select>
					</tr>
					<tr>
						<td>Issue Action Type::</td>
						<td><input type="text" name="actiontype" id="actiontype"
							value="<%=bean.getIssueActionType() %>"></td>
					</tr>
					<tr>
						<td>Issue Action Description::</td>
						<td><textarea rows="3" cols="3" name="issueactiondes"><%=bean.getIssueActionDescription() %></textarea></td>
					</tr>
					<tr>
						<td>Issue Resolved By::</td>
						<td><select name="resolvedby">
								<option>--Select User--</option>
								<% 
UserRegistrationDao dao2=new UserRegistrationDao();
ArrayList<UserRegistrationBean> list3=dao2.dataSelectRegistration();
UserRegistrationBean bean3=null;
for(int l=0;l<list3.size();l++)
	{		
		bean3=new UserRegistrationBean();
		bean3=(UserRegistrationBean)list3.get(l);
%>
								<option value="<%=bean3.getUserId()%>"><%=bean3.getUserFirstName()%></option>

								<%} %>
								<option value="<%=bean.getIssueResolvedBy()%>"
									selected="selected"><%=bean.getUserFirstName()%></option>
						</select>
					</tr>
					<tr>
						<td>Issue Resolved date::</td>
						<td><input type="text" name="resolveddate" class="slimpicker"
							alt="{
			dayChars:3,
			dayNames:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
			daysInMonth:[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
			format:'dd-mm-yyyy',
			monthNames:['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			startDay:1,
			yearOrder:'desc',
			yearRange:90,
			yearStart:2014
		}"
							value="<%=bean.getIssueResolvedDate() %>" /></td>
						<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});

</script>
					</tr>
					<tr>
						<td colspan="3" align="center"><a href="#" name="edit"
							id="edit"
							onClick="javascript:updateData(<%=bean.getIssueResolutionId()%>)">Update</a></td>
						<%}%>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>