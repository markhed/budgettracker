<!DOCTYPE html>
<%@ include file="/WEB-INF/pages/jsp/include.jsp" %>
<html>
<head>
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen" />
</head>

<body>
	<div id="main_head" class="head">
		<h1>Budget Tracker</h1>
	</div>
	<div id="main_body" class="body">
		<div id="menu_area">
			<input id="home_button" class="common top" type="button" value="Main" onclick="direct('main.htm')"/>
			<input id="static_data_button" class="common" type="button" value="Static Data" onclick="direct('staticdata.htm')"/>
			<input id="save_button" class="common bottom" type="button" value="Save" onclick="submitMultipleForms()"/>
		</div>
		
		<div id="cycles_area" class="main_area module">
			<div class="window_bar"> 
				<input class="minimize" type="button"/>	
			</div>
			<div class="head">
				<h2>Budget Cycles</h2>
				<input class="add" type="button" value="new" onclick="addNew(this, 'budgetCycle')"/>
			</div>
			<div class="body">
				<form:form id="cycles_form" class="append_target" method="POST" onSubmit="budgetcycles.htm" modelAttribute="budgetCycleForm">
				<div id="active-cycles" class="wrapper">
				<c:forEach items="${budgetCycleForm.budgetCycleList}" var="budgetCycle" varStatus="itr">
					<div class="cycle">
						<div class="window_bar">
							<input class="minimize" type="button"/>	
							<input class="delete" type="button"/>
						</div>
						<div class="head">
							<form:input class="id" path="budgetCycleList[${itr.index}].id" hidden="true"/>
							<form:input class="date startDate" path="budgetCycleList[${itr.index}].startDate" placeholder="start date"/>
							<form:input class="date endDate" path="budgetCycleList[${itr.index}].endDate" placeholder="end date"/>
							<form:select class="status" path="budgetCycleList[${itr.index}].status">
							    <form:option value="" label="status" disabled="true"/>
							    <form:options items="${statusList}"/>
							</form:select>
							<input class="add add_inflow" type="button" value="new inflow" onclick="addNew(this, 'inflow')"/>
							<input class="add add_outflow" type="button" value="new outflow" onclick="addNew(this, 'outflow')"/>
						</div>
						<div class="body">
							<div class="summary">
								This is for the summary
							</div>
							<div class="cashflows">
								<div class="inflows append_target">
									<c:forEach items="${budgetCycle.inflowList}" var="inflowList" varStatus="itr2">
									<div class="cashflow inflow">
										<div class="window_bar">
											<input class="minimize" type="button"/>	
											<input class="delete" type="button"/>
										</div>
										<div class="head">
											<form:input type="hidden" class="id" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].id"/>
											<form:input class="title" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].cashFlowDetails.title" 
												placeholder="title"/>
											<form:select class="status" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].status">
											    <form:option value="" label="status" disabled="true"/>
											    <form:options items="${inflowStatusList}"/>
											</form:select>
										</div>
										<div class="body">
											<form:select class="owner" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].cashFlowDetails.owner">
											    <form:option value="" label="from" disabled="true"/>
											    <form:options items="${ownerList}" itemLabel="title" itemValue="id"/>
											</form:select>
											<form:input class="amount outstAmount" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].cashFlowDetails.outstAmount" 
												placeholder="outstanding amount"/>
											<form:input class="amount receivedAmount" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].incomingDetails.receivedAmount" 
												placeholder="received amount"/>
											<form:input class="comment" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].cashFlowDetails.comment" 
												placeholder="comment"/>
											<form:select class="budgetType" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].cashFlowDetails.budgetType">
											    <form:option value="" label="budget type" disabled="true"/>
											    <form:options items="${budgetTypeList}" />
											</form:select>
											<form:select class="flowType" 
												path="budgetCycleList[${itr.index}].inflowList[${itr2.index}].flowType">
											    <form:option value="" label="type" disabled="true"/>
											    <form:options items="${flowTypeList}" />
											</form:select>											
										</div>
									</div>
									</c:forEach>
								</div>
								<div class="outflows append_target">
									<c:forEach items="${budgetCycle.outflowList}" var="outflow" varStatus="itr2">
									<div class="cashflow outflow">
										<div class="window_bar">
											<input class="minimize" type="button"/>	
											<input class="delete" type="button"/>
										</div>
										<div class="head">
											<form:input class="id" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].id" hidden="true"/>
											<form:input class="title" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].cashFlowDetails.title" placeholder="title"/>
											<form:select class="status" 
													path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].status">
												    <form:option value="" label="status" disabled="true"/>
												    <form:options items="${outflowStatusList}"/>
											</form:select>
										</div>
										<div class="body">
											<form:select class="owner" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].cashFlowDetails.owner">
											    <form:option value="" label="for" disabled="true"/>
											    <form:options items="${ownerList}" itemLabel="title" itemValue="id"/>
											</form:select>
											<form:input class="amount outstAmount" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].cashFlowDetails.outstAmount" 
												placeholder="outstanding amount"/>
											<form:input class="amount unitAmount" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].outgoingDetails.unitAmount" 
												placeholder="unit amount"/>
											<form:input class="number totalUnits" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].outgoingDetails.totalUnits" 
												placeholder="total units"/>
											<form:input class="number outstUnits" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].outgoingDetails.outstUnits" 
												placeholder="outstanding units"/>		
											<form:input class="comment" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].cashFlowDetails.comment" 
												placeholder="comment"/>	
											<form:select class="budgetType" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].cashFlowDetails.budgetType">
											    <form:option value="" label="budget type" disabled="true"/>
											    <form:options items="${budgetTypeList}" />
											</form:select>
											<form:select class="flowType" 
												path="budgetCycleList[${itr.index}].outflowList[${itr2.index}].flowType">
											    <form:option value="" label="type" disabled="true"/>
											    <form:options items="${flowTypeList}" />
											</form:select>											
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
				</form:form>
			</div>
		</div>

<script>
var statusList = {<c:forEach items="${statusList}" var="item"> ${item}:'${item}',</c:forEach>};

$(function (){
	minimizeAll('cycle');
});


</script>
</body>
