<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/jsp/include.jsp" %>
<html>
<head>
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
<script type="text/javascript">
//initialize from model attributes
statusList = {<c:forEach items="${statusList}" var="item"> ${item}:'${item}',</c:forEach>};

creditCardList = {
<c:forEach items="${creditCardForm.itemList}" var="creditCard" varStatus="itr"> 
${itr.index}:{
	'id':"${creditCard.id}",
	'title':"${creditCard.title}",
	'bankName':"${creditCard.bankName}",
	'accountNumber':"${creditCard.accountNumber}",
	'creditLimit':"${creditCard.creditLimit}",
	'cutoffDate':"${creditCard.cutoffDate}",
	'dueDate':"${creditCard.dueDate}",
	'comment':"${creditCard.comment}"
},
</c:forEach>
};

$(function (){
	initialize('creditCard', creditCardList);
	minimizeAll('module');
});
</script>
</head>

<body>
	<div id="main_head" class="head">
		<h1>Budget Tracker</h1>
	</div>
	<div id="main_body" class="body">
		<div id="menu_area">
			<input id="home_button" class="common top" type="button" value="Main" onclick="direct('main.htm')"/>
			<input id="budget_cycles_button" class="common" type="button" value="Cycles" onclick="direct('cycles.htm')"/>
			<input id="save_button" class="common bottom" type="button" value="Save" onclick="submitMultipleForms()"/>
		</div>
		
		<div id="modules_area" class="main_area">
			<div id="creditCards" class="module" >
				<div class="window_bar"> 
					<input class="minimize" type="button"/>	
				</div>
				<div class="head">
					<h2>Credit Cards</h2> 
					<input class="add" type="button" value="new" onclick="addNew(this, 'creditCard')"/>
				</div>
				<div class="body">
					<form:form id="creditCards_form" class="append_target" method="POST" modelAttribute="creditCardForm">
					</form:form>
				</div>
			</div>
			</div>
	</div>
</body>
