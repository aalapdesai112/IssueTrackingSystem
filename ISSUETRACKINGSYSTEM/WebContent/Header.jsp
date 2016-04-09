<%@page import="dsynhub.its.bean.UserRegistrationBean"%>
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
<div class="page-container">
	<div class="header">

		<!-- A.1 HEADER TOP -->
		<div class="header-top">

			<!-- Sitelogo and sitename -->
			<a class="sitelogo" href="#" title="Go to Start page"></a>
			<div class="sitename">
				<h1>
					<a href="index.html" title="Go to Start page">ISSUE TRACKING
						SYSTEM<span style="font-weight: normal; font-size: 50%;">&nbsp;</span>
					</a>
				</h1>

			</div>

			<!-- Navigation Level 0 -->
			<div class="nav0">
				<ul>
					<li><a href="#" title="Pagina home in Italiano"><img
							src="./img/flag_italy.gif" alt="Image description" /></a></li>
					<li><a href="#" title="Homepage auf Deutsch"><img
							src="./img/flag_germany.gif" alt="Image description" /></a></li>
					<li><a href="#" title="Hemsidan p&aring; svenska"><img
							src="./img/flag_sweden.gif" alt="Image description" /></a></li>
				</ul>
			</div>

			<!-- Navigation Level 1 -->
			<div class="nav1">
				<ul>
					<li><a href="#" title="Go to Start page">Home</a></li>
					<li><a href="#" title="Get to know who we are">About</a></li>
					<li><a href="#" title="Get in touch with us">Contact</a></li>
					<li><a href="#" title="Get an overview of website">Sitemap</a></li>
				</ul>
			</div>
		</div>

		<!-- A.2 HEADER MIDDLE -->
		<div class="header-middle">

			<!-- Site message -->
			<div class="sitemessage"></div>
		</div>

		<!-- A.3 HEADER BOTTOM -->
		<div class="header-bottom">

			<!-- Navigation Level 2 (Drop-down menus) -->
			<div class="nav2">

				<!-- Navigation item -->
				<ul>
					<li><a href="index.html">Overview</a></li>
				</ul>

				<!-- Navigation item -->
				<ul>
					<li><a href="#"> User<!--[if IE 7]><!--></a>
					<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="UserRegistrationListServlet">User
									Registration</a></li>
							<li><a href="UserRoleListServlet">User Role</a></li>
							<li><a href="UserTypeListServlet">User Type</a></li>
							<li><a href="SecurityQuestionListServlet">Security
									Question</a></li>

						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
				</ul>

				<!-- Project item -->
				<ul>
					<li><a href="#">Project<!--[if IE 7]><!--></a>
					<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="ProjectMasterViewServlet">Project Master</a></li>
							<li><a href="ProjectTechnologyListServlet">ProjectTechnology</a></li>
							<li><a href="PMTStatusListServlet">View PMT Status</a></li>
							<li><a href="PMTPriorityListServlet">View PMT Priority</a></li>
							<li><a href="ModuleViewServlet ">View Module detail</a></li>
							<li><a href="TaskViewServlet">View Task detail</a></li>
						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
				</ul>

				<!-- Issue Detail -->
				<ul>
					<li><a href="#">Issue <!--[if IE 7]><!--></a>
					<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>

							<li><a href="IssuePriorityListServlet">Issue Priority</a></li>
							<li><a href="IssueStatusListServlet">Issue Status</a></li>
							<li><a href="IssueTypeListServlet">Issue Type</a></li>
							<li><a href="IssueResolutionListServlet">Issue Resolved</a></li>
							<li><a href="IssueAssignListServlet">Issue Assign</a></li>
							<li><a href="IssueDetailListServlet">Issue Detail</a></li>
						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
				</ul>
				<!-- Country item -->
				<ul>
					<li><a href="#">Country<!--[if IE 7]><!--></a>
					<!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul>
							<li><a href="CountryListServlet">View Country </a></li>
							<li><a href="StateListServlet">View State</a></li>
							<li><a href="CityListServlet">View City</a></li>


						</ul> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
				</ul>
			</div>
		</div>

		<!-- A.4 HEADER BREADCRUMBS -->


	</div>
</div>

</head>
<link rel="stylesheet" href="mm_restaurant1.css" type="text/css" />

</html>