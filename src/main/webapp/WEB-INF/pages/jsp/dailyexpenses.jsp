<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/jsp/include.jsp" %>
<html>
<head>
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
<script type="text/javascript">
//initialize from model attributes
dailyOutflowList = {
<c:forEach items="${dailyOutflowForm.itemList}" var="dailyOutflow" varStatus="itr"> 
${itr.index}:{
	'id':"${dailyOutflow.id}",
	'title':"${dailyOutflow.title}",
	'comment':"${dailyOutflow.comment}",
	'unitAmount':"${dailyOutflow.unitAmount}",
	'totalUnits':"${dailyOutflow.totalUnits}"
},
</c:forEach>
};

$(function (){
	initialize('dailyOutflow', dailyOutflowList);
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
			<div id="dailyOutflows" class="module" >
				<div class="window_bar"> 
					<input class="minimize" type="button"/>	
				</div>
				<div class="head">
					<h2>Daily Expenses</h2> 
					<input class="add" type="button" value="new" onclick="addNew(this, 'dailyOutflow')"/>
				</div>
				<div class="body">
					<form:form id="dailyOutflows_form" class="append_target" method="POST" modelAttribute="dailyOutflowForm">
					</form:form>
				</div>
			</div>
			</div>
	</div>
</body>
