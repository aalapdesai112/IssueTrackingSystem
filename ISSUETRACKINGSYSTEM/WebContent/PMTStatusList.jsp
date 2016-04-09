<%@page import="dsynhub.its.bean.PMTStatusBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dsynhub.its.dao.PmtStatusDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/displaytag.css">
<script type="text/javascript">

function delete1(id)
{
	 var f=document.frm;
	 var msg=window.confirm("Are you Sure you want to delete?");
	 if(msg)
	 {
		 	f.hid.value=id;
		 	f.action = "PMTStatusDeleteServlet";
			alert(id);
			f.submit();
	 }
	
}
function update(id)
{
	var f=document.frm;
	f.hid.value=id;
	var a=window.confirm("are you sure you want to update");
	if(a)
	{
		f.action="PMTStatusEditServlet";
		f.submit();
	}
}
function Insert()
{
	var f=document.frm;
	f.action="PMTStatusInsert.jsp";
	f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" id="frm">

		<input type="hidden" name="hid"> ${duplicate} ${delete}

		<display:table name="list" requestURI="./PMTStatusListServlet"
			pagesize="5" export="true" form="frm" id="currentRowObject">


			<display:column property="pmtstatus" title="pmtstatus"></display:column>
			<display:column title="Action">

				<a href="#" title="Action"
					onclick="delete1('<% ((PMTStatusBean)currentRowObject).getPmtstatusid();%>')">Delete</a>
			</display:column>
		</display:table>
	</form>
</body>
</html>