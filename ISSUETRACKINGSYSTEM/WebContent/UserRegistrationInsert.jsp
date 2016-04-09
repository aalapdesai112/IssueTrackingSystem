<!--<%@page import="dsynhub.its.bean.SequrityQuestionBean"%>-->
<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="dsynhub.its.dao.UserTypeDao"%>
<%@page import="dsynhub.its.bean.SequrityQuestionBean"%>
<%@page import="dsynhub.its.bean.UserRoleBean"%>
<%@page import="dsynhub.its.dao.UserRoleDao"%>
<%@page import="dsynhub.its.dao.SequrityQuestionDao"%>
<%@page import="dsynhub.its.bean.CountryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="slimpicker.css" media="screen, projection" />

<script src="mootools-1.2.4-core-yc.js"></script>
<script src="mootools-1.2.4.4-more-yc.js"></script>
<script src="slimpicker.js"></script>
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/engine.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxStateDao.js'></script>
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/util.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxCityDao.js'></script>
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href="./css/layout4_setup.css" />
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href="./css/layout4_text.css" />
<script type="text/javascript">
function list()
{
	
	var f=document.Registerform;
	f.action="UserRegistrationListServlet";
	f.submit();
}
function ins()
{
	
	var f=document.Registerform;
	f.action="UserRegistrationInsertServlet";
	f.submit();
}
function getReply(countryId){
	dwr.util.removeAllOptions("state");
	document.getElementById('stateLoader').style.visibility = 'hidden';
	if(countryId=='')
	{
		var data=[{stateName:'-- Select --' ,stateId:''}];
		dwr.util.addOptions("state",data,"stateId","stateName");
	}else{
	   document.getElementById('stateLoader').style.visibility = 'visible';
	    AjaxStateDao.selectState(countryId,function(data){
		dwr.util.addOptions("state",data,"stateId","stateName");
		document.getElementById('stateLoader').style.visibility = 'hidden';
		});
	}
}	
function getReplyCity(cityId){
	dwr.util.removeAllOptions("city");
	document.getElementById('cityLoader').style.visibility = 'visible';
	if(cityId=='')
	{
		var data=[{cityName:'-- Select --' ,cityId:''}];	
		dwr.util.addOptions("city",data,"cityId","cityName");
	}else{	
	  document.getElementById('cityLoader').style.visibility = 'visible';
	    AjaxCityDao.selectCity(cityId,function(data){
		dwr.util.addOptions("city",data,"cityId","cityName");
		 document.getElementById('cityLoader').style.visibility = 'hidden';
		});
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<form action="" name="Registerform">
		<%@include file="Header.jsp"%>
		<div class="main-content">
			<div class="column1-unit">
				<a href="#" onClick="history.go(-1);">Back</a>
				<h1 align="center">UserRegistration Form</h1>
				<table align="center" border="2">
					<tr>
						<td width="247">firstName:</td>
						<td width="585"><input type="text" name="firstname"
							id="firstname">${FirstName}</td>
					</tr>

					<tr>
						<td>MiddleName::</td>
						<td><input type="text" name="middlename" /></td>
					</tr>

					<tr>
						<td>LastName::</td>
						<td><input type="text" name="lastname" />${lastName}</td>
					</tr>

					<tr>
						<td>Current Address::</td>
						<td><textarea name="currentaddress" row="2" coloumns="5" /></textarea></td>
					</tr>

					<tr>
						<td>Parmenant Address::</td>
						<td><textarea name="parmentaddress" row="2" coloumns="5" /></textarea>${permenentAddress}</td>
					</tr>
					<tr>
						<td>CountryName</td>
						<td><select name="country" id="country"
							onchange="getReply(this.value)">
								<option>---Select Country---</option>
								<%
							ArrayList list = (ArrayList) application.getAttribute("list");
							for (int i = 0; i < list.size(); i++) {
								CountryBean bean = (CountryBean) list.get(i);
								if (list != null) {
						%>
								<option value="<%=bean.getCountryID()%>"><%=bean.getCountryName()%></option>
								<%
							}
							}
						%>
						</select></td>
					</tr>
					<tr>
						<td>State Name</td>
						<td><select name="state" id="state"
							onChange="getReplyCity(this.value)">
								<option value="">---Select State---</option>
						</select><span id="stateLoader" style="visibility: hidden"> <img
								src="loading (5).gif" height="30" width="25">
						</span></td>

					</tr>
					<tr>
						<td>City</td>
						<td><select name="city" id="city">
								<option value="">---Select City---</option>
						</select>${cityId } <span id="cityLoader" style="visibility: hidden">
								<img src="loading (5).gif" height="30" width="25">
						</span></td>
					<tr>
						<td>Gender</td>
						<td><input type="radio" name="gender" value="male">Male
							<input type="radio" name="gender" value="Female">Female</td>
					</tr>
					<tr>
						<td>BirthDate::</td>
						<td><input type="text" name="birthdate" class="slimpicker"
							alt="{
			dayChars:3,
			dayNames:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
			daysInMonth:[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
			format:'dd-mm-yyyy',
			monthNames:['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			startDay:1,
			yearOrder:'desc',
			yearRange:90,
			yearStart:2012
		}"
							value="" />${userBirthDate}</td>
					</tr>

					<tr>
						<td>Phone_no::</td>
						<td><input type="text" name="phonenumber" /></td>
					</tr>

					<tr>
						<td>Mobile_no::</td>
						<td><input type="text" name="Mobilenumber" />${Mobile_no}</td>
					</tr>

					<tr>
						<td>Email Id::</td>
						<td><input type="text" name="emailid" />${emailId}</td>
					</tr>

					<tr>
						<td>Password::</td>
						<td><input type="password" name="password" /></td>

					</tr>


					<tr>
						<td>User Type::</td>
						<td><select name="type_id">
								<%
							UserTypeDao dao = new UserTypeDao();
						
						
							UserTypeBean bean = null;
							ArrayList<UserTypeBean> list3 = dao.selectData();

							for (int i = 0; i < list3.size(); i++) {
								bean = new UserTypeBean();
								bean = (UserTypeBean) list3.get(i);
						%>
								<option value="<%=bean.getUserTypeId()%>"><%=bean.getUserType()%></option>
								<%
							}
						%>
						</select></td>
					</tr>


					<tr>
						<td>Security QueStion::</td>
						<td><select name="securityqueid">
								<option>---------Select Question---------</option>
								<%
							SequrityQuestionDao dao1 = new SequrityQuestionDao();
							SequrityQuestionBean bean3 = null;
							ArrayList<SequrityQuestionBean> list1 = dao1.dataSelect();

							for (int i = 0; i < list1.size(); i++) {
								bean3 = new SequrityQuestionBean();
								bean3 = (SequrityQuestionBean) list1.get(i);
						%>
								<option value="<%=bean3.getQuestionId()%>"><%=bean3.getQuestionName()%></option>
								<%}%>
						</select></td>
					</tr>
					<tr>
						<td>Security QuestionAnswer::</td>
						<td><textarea name="securityans" row=2></textarea>${securityQuesAns}</td>
					</tr>

					<tr>
						<td>UserStatus::</td>
						<td><input type="radio" name="userstatus" value="T">Avaiable<input
							type="radio" name="userstatus" value="F">NotAvaible</td>
					</tr>
					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});
</script>
					<tr>

						<td><a href="#" onClick="ins();">Register User</a></td>
						<td><a href="#" onClick="list();">ListData</a>
					</tr>
				</table>
			</div>
		</div>
		<%@include file="Footer.jsp"%>

	</form>
</body>
</html>