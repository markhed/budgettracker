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
		<form:form method="POST" commandName="UserForm">
			<label>First name: </label>
			<form:input path="firstName"/>
			<br/>
			<label>Last name: </label>
			<form:input path="lastName"/>
			<br/>
			<label>Account: </label>
			<form:input path="userName"/>
			<br/>
			<label>Password: </label>
			<form:password path="password"/>
			<br/>
			<br>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
  
</html>