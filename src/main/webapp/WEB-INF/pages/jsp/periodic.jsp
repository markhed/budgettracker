<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/jsp/include.jsp" %>
<html>
<head>
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
<script type="text/javascript">
//initialize from model attributes
var ownerList = {<c:forEach items="${ownerList}" var="item"> 
					${item.id}:'${item.title}',
                </c:forEach>};

var budgetTypeList = {<c:forEach items="${budgetTypeList}" var="item"> 
						${item}:'${item}',
					</c:forEach>};
					
periodicInflowList = {
<c:forEach items="${periodicInflowForm.periodicInflowList}" var="periodicInflow" varStatus="itr"> 
${itr.index}:{
	'id':"${periodicInflow.id}",
	'title':"${periodicInflow.cashFlowDetails.title}",
	'startDate':"${periodicInflow.periodicDetails.startDate}",
	'specificDay':"${periodicInflow.periodicDetails.specificDay}",
	'specificDate':"${periodicInflow.periodicDetails.specificDate}",
	'period':"${periodicInflow.periodicDetails.period}",
	'outstAmount':"${periodicInflow.cashFlowDetails.outstAmount}",
	'receivedAmount':"${periodicInflow.incomingDetails.receivedAmount}",
	'comment':"${periodicInflow.cashFlowDetails.comment}",
	'budgetType':"${periodicInflow.cashFlowDetails.budgetType}",
	'owner':"${periodicInflow.cashFlowDetails.owner.id}"
},
</c:forEach>
};


$(function (){
	initialize('periodicInflow', periodicInflowList);
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
			<div id="periodicInflows" class="module" >
				<div class="window_bar"> 
					<input class="minimize" type="button"/>	
				</div>
				<div class="head">
					<h2>Periodic Inflows</h2> 
					<input class="add" type="button" value="new" onclick="addNew(this, 'periodicInflow')"/>
				</div>
				<div class="body">
					<form:form id="periodicInflows_form" class="append_target" method="POST" modelAttribute="periodicForm">
					</form:form>
				</div>
			</div>
			</div>
	</div>
</body>
</html>
