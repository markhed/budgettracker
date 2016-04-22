<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/jsp/include.jsp" %>

<html>
<head>
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
<title><fmt:message key="title"/></title></head>
<body>
	<div id="main_head" class="head">
		<h1><fmt:message key="heading"/></h1>
	</div>
	<div id="main_body" class="body">
		<div id="menu_area">
			<input id="login_button" form="login_form" type="submit" value="Login"/>
			<input id="signup_button" type="button" value="Sign Up" onclick="direct('signup.htm')"/>
		</div>
		
		<div class="main_area">
			<form:form id="login_form" method="POST" modelAttribute="loginForm">
			<input name="userName" placeholder="username"/>
			<br/>
			<input name="password" type="password" placeholder="password"/>
		</form:form>
		</div>
	</div>
</body>
  
</html>