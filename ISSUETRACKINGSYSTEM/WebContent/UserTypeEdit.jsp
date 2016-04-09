<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.CountryDao"%>
<%@page import="dsynhub.its.bean.CountryBean"%>
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
function updateData(id)
{
	 var f=document.frm;
	 f.id1.value=id;
     
     var b=window.confirm("are you sure  to update this record");
     if(b)
         {
            f.action="UserTypeUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 return false;
    	 }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<a href="#" onclick="history.go(-1);">&lt;-- Back</a>
	<form name="frm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<table>
					<%
ArrayList<UserTypeBean> list=(ArrayList)request.getAttribute("list");
UserTypeBean bean=null;
for(int i=0;i<list.size();i++)
{
	bean=new UserTypeBean();
	bean=(UserTypeBean)list.get(i);
	
}
%>
					<tr>
						<td>User Type</td>
						<td><input type="text" name="userType" id="userType"
							value="<%=bean.getUserType()%>"></td>
					</tr>
					<tr>
						<td><a href="#"
							onClick="updateData(<%=bean.getUserTypeId()%>);">Update</a> <input
							type=hidden name=id1 id=id1> <input type="reset"
							name="reset" value="reset" /></td>
					</tr>
					<% %>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>