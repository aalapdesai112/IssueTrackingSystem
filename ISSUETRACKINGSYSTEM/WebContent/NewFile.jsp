s<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
</script>

<body>

	<h3 align="center">Add Browser</h3>
	<br />

	<form class="contact_form" action="CountryInsertServlet" id="frmAdd"
		method="post" onsubmit="return Browser_validate()">
		<table border="1" align="center">
			<tr>
				<th>Country :</th>
				<td><input type="text" name="browser" id="browser" size="38"
					required> <%= request.getAttribute("Duplicate") !=null? request.getAttribute("Duplicate"):""%>
				</td>
				<td><div id="BrowserError"
						style="color: red; font-size: 13[px];"></div></td>
			</tr>

			<tr>
				<th><input type="submit" value="Add"></th>
				<th><input type="reset" value="Cancel" onclick="cancel()"></th>
			</tr>
		</table>

	</form>
</body>
