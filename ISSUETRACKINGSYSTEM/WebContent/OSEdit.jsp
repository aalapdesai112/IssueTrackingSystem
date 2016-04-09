<%@page import="dsynhub.its.bean.OSBean"%>
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
function updateData(id)
{
	 var f=document.frm;
	 f.hid.value=id;
     var b=window.confirm("are you sure you want to update?");
     
     if(b)
         {
            f.action="OSUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 return false;
    	 }
}
function deleteData(id)
{
    var f=document.frm;
    f.hid.value=id;
    var b=window.confirm("are you sure you want to delete?");
    if(b)
        {
           f.action="OSDeleteServlet";
           f.submit();
        }
        else
            {
				return false;
            }
}
function viewData()
{
	var f=document.frm;
	f.action="OSListServlet";
	f.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form name="frm" action="" method="post">
		<jsp:include page="Header.jsp"></jsp:include>
		<div class="main-content">
			<div class="column1-unit">
				<input type=hidden name="hid" id="hid"> <input type="button"
					onClick="history.go(-1);" value="Back&lt;&lt;" />
				<table border="2">
					<% 
ArrayList list=(ArrayList)request.getAttribute("list");
for(int i=0;i<list.size();i++)
{
	OSBean bean=(OSBean)list.get(i);
	%>
					<tr>
						<td>OS</td>
						<td><input type="text" name="os" id="os"
							value="<%=bean.getOs()%>"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#"
							onClick="javascript:updateData(<%=bean.getOsid()%>)">Update</a> <%} %>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>