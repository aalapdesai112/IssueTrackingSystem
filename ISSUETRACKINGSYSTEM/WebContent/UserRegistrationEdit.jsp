<%@page import="dsynhub.its.bean.UserTypeBean"%>
<%@page import="dsynhub.its.dao.UserTypeDao"%>
<%@page import="dsynhub.its.bean.CountryBean"%>
<%@page import="dsynhub.its.bean.SequrityQuestionBean"%>
<%@page import="dsynhub.its.dao.SequrityQuestionDao"%>
<%@page import="dsynhub.its.bean.UserRoleBean"%>
<%@page import="dsynhub.its.dao.UserRoleDao"%>
<%@page import="dsynhub.its.bean.CityBean"%>
<%@page import="dsynhub.its.dao.CityDao"%>
<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
<%@page import="dsynhub.its.bean.PMTStatusBean"%>
<%@page import="dsynhub.its.dao.PmtStatusDao"%>
<%@page import="dsynhub.its.bean.ProjectTechnologyBean"%>
<%@page import="dsynhub.its.dao.ProjectTechnologyDao"%>
<%@page import="dsynhub.its.bean.PMTPriorityBean"%>
<%@page import="dsynhub.its.dao.PMTPriorityDao"%>
<%@page import="dsynhub.its.bean.ProjectMasterBean"%>
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
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/engine.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxStateDao.js'></script>
<script type='text/javascript'
	src='/ISSUETRACKINGSYSTEM/dwr/interface/AjaxCityDao.js'></script>
<script type='text/javascript' src='/ISSUETRACKINGSYSTEM/dwr/util.js'></script>


<script type="text/javascript">
function updateData(id)
{
	 var f=document.editfrm;
	 f.hid.value=id;
     var b=window.confirm("are you sure you want to update");
     
     if(b)
         {
            f.action="UserRegistrationUpdateServlet";
            f.submit();
         }
     else
    	 {
    	 return false;
    	 }
     
}   
   
     function getReply(countryId){
    		
    		//alert(countryId);
    		dwr.util.removeAllOptions("state");
    		document.getElementById('loading (5)').style.visibility = 'visible';
    		
    		if(countryId=='')
    		{
    			//alert(countryId);
    			var data=[{stateName:'-- Select --',stateId:''}];
    		
    			dwr.util.addOptions("state",data,"stateId","stateName");
    		}else{
    			//alert(countryId);
    		  document.getElementById('loading (5)').style.visibility = 'visible';
    		 
    		    AjaxStateDao.selectState(countryId,function(data){
    			dwr.util.addOptions("state",data,"stateId","stateName");
    			document.getElementById('loading (5)').style.visibility = 'hidden';
    			});
    		}
    	}	


    	function getReplyCity(cityId){
    		
    		alert('list');
    		dwr.util.removeAllOptions("city");
    		document.getElementById('loading (5)').style.visibility = 'visible';
    		
    		if(cityId=='')
    		{
    			
    			var data=[{cityName:'-- Select --' ,cityId:''}];	
    			dwr.util.addOptions("city",data,"cityId","cityName");
    		}else{
    			
    		   document.getElementById('loading (5)').style.visibility = 'visible';
    		 
    		    AjaxCityDao.selectCity(cityId,function(data){
    			dwr.util.addOptions("city",data,"cityId","cityName");
    			 document.getElementById('loading (5)').style.visibility = 'hidden';
    			});
    		}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Tracking System</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="main-content">
		<div class="column1-unit">
			<a href="#" onclick="history.go(-1);">Back</a>
			<form name="editfrm" action="" method="post">
				<input type=hidden name="hid" id="hid">
				<table>
					<%
				ArrayList list=(ArrayList)request.getAttribute("list");
			for(int i=0;i<list.size();i++)
			{
				UserRegistrationBean bean=(UserRegistrationBean)list.get(i);
				
			%>
					<tr>
						<td>First Name::</td>
						<td><input type="text" name="firstname"
							value=<%=bean.getUserFirstName()%> />${ProjectName}</td>
					</tr>
					<tr>
						<td>Middle Name::</td>
						<td><input type="text" name="middlename"
							value=<%=bean.getUserMiddleName()%> /></td>
					</tr>
					<tr>
						<td>Last Name::</td>
						<td><input type="text" name="lastname"
							value=<%=bean.getUserLastName()%> /></td>
					</tr>

					<tr>
						<td>Current Address::</td>
						<td><textarea name="currentaddress" row=3><%=bean.getUser_Res_Address()%></textarea></td>
					</tr>
					<tr>
						<td>Permenant Address::</td>
						<td><textarea name="permentaddress" row=3><%=bean.getUser_Per_Address()%></textarea></td>
					</tr>
					<tr>
						<td>CountryNAme</td>
						<td><select name="country" id="country"
							onchange="getReply(this.value)">

								<option>---Select Country---</option>
								<%
							ArrayList list1 = (ArrayList) application.getAttribute("list");
							for (int j = 0; j < list1.size(); j++) {
								CountryBean bean1 = (CountryBean) list1.get(j);
								if (list1 != null) {
						%>
								<option value="<%=bean1.getCountryID()%>"><%=bean1.getCountryName()%></option>
								<%
							}
							}
						%>
								<option value="<%=bean.getCountryId()%>" selected="selected"><%=bean.getCountryName()%></option>
						</select></td>
					</tr>
					<tr>
						<td>State Name</td>
						<td><select name="state" id="state"
							onchange="getReplyCity(this.value)">
								<option value="">---Select State---</option>
								<option value="<%=bean.getStateId()%>" selected="selected"><%=bean.getStateName()%></option>
						</select></td>
					<tr>
						<td>City Name::</td>
						<td><select name="city" id="city">
								<option value="<%=bean.getCityId()%>" selected="selected"><%=bean.getCityName()%></option>
						</select></td>
					</tr>

					<tr>
						<td>Gender</td>
						<td>
							<%if(bean.getUserGender().equals("male"))
				{
				%> <input type="radio" name="gender" value="male" checked="checked">Male
							<input type="radio" name="gender" value="Female">Female <%
				}
				else
				{
				%> <input type="radio" name="gender" value="male">Male <input
							type="radio" name="gender" value="Female" checked="checked">Female
							<%
					}
				%>
						</td>
					</tr>
					<tr>
						<td>Birth Date::</td>
						<td><input type="text" name="birthDate" class="slimpicker"
							alt="{
			dayChars:3,
			dayNames:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
			daysInMonth:[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
			format:'dd-mm-yyyy',
			monthNames:['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
			startDay:1,
			yearOrder:'desc',
			yearRange:90,
			yearStart:2013
		}"
							value=<%=bean.getBirthDate()%> /></td>
					</tr>
					<script>
$$('input.slimpicker').each( function(el){
	var picker = new SlimPicker(el);
});

</script>

					<tr>
						<td>Phone No::</td>
						<td><input type="text" name="phonenum"
							value=<%=bean.getUser_Phone_No()%> /></td>
					</tr>
					<tr>
						<td>Mobile No::</td>
						<td><input type="text" name="mobilenum"
							value=<%=bean.getUser_Mobile_No()%> /></td>
					</tr>
					<tr>
						<td>Email Id::</td>
						<td><input type="text" name="emailid"
							value=<%=bean.getEmailId()%> /></td>
					</tr>
					<tr>
						<td>User Type</td>
						<td><select name="role_id">
								<%
							UserTypeDao dao1 = new UserTypeDao();
							UserTypeBean bean2 = null;
							ArrayList<UserTypeBean> list3 = dao1.selectData();

							for (int k = 0; k < list3.size(); k++) {
								bean2 = new UserTypeBean();
								bean2 = (UserTypeBean) list3.get(k);
						%>
								<option value="<%=bean2.getUserTypeId()%>"><%=bean2.getUserType()%></option>
								<%
							}
						%>
						</select></td>
					</tr>
					<tr>
						<td>Status</td>

						<td><select name="question_id">
								<%
							SequrityQuestionDao dao2 = new SequrityQuestionDao();
								ArrayList<SequrityQuestionBean> listQ = dao2.dataSelect();
								SequrityQuestionBean beanQ = null;
								for (int j = 0; j < listQ.size(); j++) {
									beanQ = new SequrityQuestionBean();
									beanQ = (SequrityQuestionBean) listQ.get(j);
						%>
								<option value="<%=beanQ.getQuestionId()%>"><%=beanQ.getQuestionName()%></option>

								<%
							}
								//System.out.println("beanstatus.getPmtstatusid()======"
									//	+ request.getParameter("Status_id"));
						%>
						</select>
					</tr>
					<tr>
						<td>SecurityQuestion Answer::</td>
						<td><input type="text" name="sequrityQuestion"
							value=<%=bean.getSequrityQuestionAns()%> /></td>
					</tr>

					<tr>
						<td>userStatus</td>
						<%if(bean.getUserStatus().equals("T")){ %>
						<td><input type="radio" name="userstatus" value="T"
							checked="checked">Avaible <input type="radio"
							name="userstatus" value="F">NotAvaible<%}else{ %> <input
							type="radio" name="userstatus" value="T">Avaible <input
							type="radio" name="userstatus" value="F" checked="checked">NotAvaible
							<%} %></td>

					</tr>
					<tr>
						<td><input type="submit" name="edit" id="edit" value="update"
							onClick="javascript:updateData(<%=bean.getUserId()%>)" /></td>
						<%
				}
			%>
					
				</table>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>