<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SlimPicker Demo Page</title>
<link rel="stylesheet" href="pagestyle.css" media="screen, projection" />
<link rel="stylesheet" href="slimpicker.css" media="screen, projection" />
<script src="mootools-1.2.4-core-yc.js"></script>
<script src="mootools-1.2.4.4-more-yc.js"></script>
<script src="slimpicker.js"></script>
<title>Issue Tracking System</title>
</head>
<body>
	<%!int i=0;%>
	<form name="Feedback" action="FeedbackInsertServlet">
		<center>
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="feedbackName"></td>
				</tr>
				<tr>
					<td>Feedback</td>
					<td><textarea rows="3" cols="18 " name="feedbackDescription"></textarea>
					</td>
				</tr>
				<tr>
					<td>date</td>
					<td><input id="date" name="feedbackDate" type="text"
						class="slimpicker"
						alt="{
			dayChars:3,
			dayNames:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thrusday', 'Friday', 'Saturday'],
			daysInMonth:[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
			format:'dd-MM-yyyy',
			monthNames:['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			startDay:1,
			yearOrder:'desc',
			yearRange:100,
			yearStart:2014
		}" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="insert" values="Insert"></td>
				</tr>
			</table>
		</center>
		<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});
</script>
	</form>
</body>
</html>