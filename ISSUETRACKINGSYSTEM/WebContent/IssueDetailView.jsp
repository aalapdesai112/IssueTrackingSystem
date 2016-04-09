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
function del(id)
{
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="IssueDetailDeleteServlet";
			f.submit();
	 }
}

function view(id)
{
	 var f=document.viewpage;
	 f.did.value=id;
	 var msg=window.confirm("Are you Sure....");
	 if(msg)
	 {
			f.action="IssueDetailListServlet";
			f.submit();
	 }
}
function edit(id)
{
	var f=document.viewpage;
	f.did.value=id;
	var msg="you want to edit::"+id;
	if(window.confirm(msg))
		{
			f.action="MIssueDetailEditServlet";
			f.submit();
			
		}
	}
function Insert()
{
	var f=document.viewpage;
	f.action="IssueDetailInsert.jsp";
	f.submit();
}	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>

</body>
</html>