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
			<input id="cycles_button" class="common" type="button" value="Cycles" onclick="direct('cycles.htm')"/>
			<input id="accounts_button" class="common" type="button" value="Accounts" onclick="direct('accounts.htm')"/>
			<input id="allotments_button" class="common" type="button" value="Allotments" onclick="direct('allotments.htm')"/>
			<input id="creditcards_button" class="common" type="button" value="Credit Cards" onclick="direct('creditcards.htm')"/>
			<input id="parties_button" class="common" type="button" value="Parties" onclick="direct('parties.htm')"/>
			<input id="dailyexpenses_button" class="common" type="button" value="Daily Expenses" onclick="direct('dailyexpenses.htm')"/>
			<input id="periodicInflows_button" class="common" type="button" value="Periodic Inflows" onclick="direct('periodic.htm')"/>
			<input id="periodicOutflows_button" class="common" type="button" value="Periodic Outflows" onclick="direct('')"/>
			<input id="logout_button" class="common bottom" type="button" value="Log Out" onclick="direct('logout.htm')"/>
		</div>
		
		<div class="main_area">
			<h2><fmt:message key="greeting"/> <c:out value="${currentUser.firstName}"/></h2> 
		</div>
</body>
  
</html>