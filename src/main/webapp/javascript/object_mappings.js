//temporary values
var budgetTypeList = {"btype 1":"btype 1", "btype 2":"btype 2"};
var flowTypeList= {"type 1":"type 1", "type 2":"type 2"};
var ownerList= {"owner 1":"owner 1", "owner 2":"owner 2"};
var statusList= {"status 1":"status 1", "status 2":"status 2"};
//

var FIELDS = {
	"id":{			type:'input', 
					attributes: {'class':"id", 'name':"id",
								'type':"hidden"}
	},
	
	"accountNumber":{type:'input', 
					attributes: {'class':"accountNumber", 'name':"accountNumber",
								'placeholder':"account number"}
	},
	
	"add_inflow":{	type:'input', 
					attributes: {'class':"add add_inflow",
								'type':"button", 'value':"new inflow", 
								'onclick':"addNew(this, 'inflow')"}
	},
	
	"add_outflow":{	type:'input', 
					attributes: {'class':"add add_outflow", 
								'type':"button", 'value':"new outflow", 
								'onclick':"addNew(this, 'outflow')"}
	},
	
	"bankName":{	type:'input', 
					attributes: {'class':"bankName", 'name':"bankName",
								'placeholder':"bank name"}
	},
	
	"budgetType":{	type:'select', 
					attributes: {'class':"budgetType", 'name':"cashFlowDetails.budgetType"}, 
					additionalData: {'optionsList':budgetTypeList, 'placeholder':"budget type"}
	},
	
	"comment":{		type:'input', 
					attributes: {'class':"comment", 'name':"cashFlowDetails.comment", 
								'placeholder':"comment"}
	},
	
	"creditLimit":{		type:'input', 
					attributes: {'class':"amount creditLimit", 'name':"creditLimit", 
								'placeholder':"creditLimit"}
	},
	
	"currentAmount": {type:'input',
					attributes: {'class':"amount currentAmount move_to_head", 
								'type':'text', 'name':"amount currentAmount move_to_head", 
								'placeholder':"current amount"}
	},
	
	"cutoffDate":{	type:'input', 
					attributes: {'class':"date cutoffDate",
					'name':"cutoffDate", 'placeholder':"cutoff date"}
	},
	
	"dueDate":{		type:'input', 
					attributes: {'class':"date dueDate",
								'name':"dueDate", 'placeholder':"due date"}
	},
	
	"endDate":{		type:'input', 
					attributes: {'class':"date endDate",
								'name':"endDate", 'placeholder':"end date"}
	},
	
	"firstName":{	type:'input', 
					attributes: {'class':"firstName", 'name':"firstName", 
								'placeholder':"first name"}
	},
	
	"flowType":{	type:'select', 
					attributes: {'class':"flowType", 'name':"flowType"},
					additionalData: {'optionsList':flowTypeList, 'placeholder':"type"}
	},
	
	"lastName":{	type:'input', 
					attributes: {'class':"lastName", 'name':"lastName", 
								'placeholder':"last name"}
	},
	
	"outstAmount":{	type:'input', 
					attributes: {'class':"amount outstAmount", 'name':"cashFlowDetails.outstAmount", 
								'placeholder':"outstanding amount"}
	},
	
	"outstUnits":{	type:'input', 
					attributes: {'class':"outstUnits", 'name':"outgoingDetails.outstUnits", 
								'placeholder':"outstanding units"}
	},
	
	"owner":{		type:'select', 
					attributes: {'class':"owner", 'name':"cashFlowDetails.owner"},
					additionalData: {'optionsList':ownerList, 'placeholder':"from"}
	},
	

	"period":{		type:'input', 
					attributes: {'class':"period", 'name':"period", 
					'placeholder':"period"}
	},
	
	"receivedAmount":{type:'input', 
					attributes: {'class':"amount receivedAmount", 'name':"incomingDetails.receivedAmount", 
								'placeholder':"received amount"}
	},
	
	"startDate":{	type:'input', 
					attributes: {'class':"date startDate", 'name':"startDate", 
								'placeholder':"start date"}
	},
	
	"status":{		type:'select', 
					attributes: {'class':"status", 'name':"status"},
					additionalData: {'optionsList':statusList, 'placeholder':"status"}
	},

	"specificDate":{		type:'input', 
		attributes: {'class':"specificDate", 'name':"specificDate",
					'type':'text', 'placeholder':"specificDate"}
	},
	
	"specificDay":{		type:'input', 
		attributes: {'class':"specificDay", 'name':"specificDay",
					'type':'text', 'placeholder':"specificDay"}
	},
	
	"targetAmount":{type:'input', 
					attributes: {'class':"amount targetAmount", 'name':"targetAmount",
								'placeholder':"target amount"}
	},
	
	"targetDate":{	type:'input', 
					attributes: {'class':"date targetDate", 'name':"targetDate",
								'placeholder':"target date"}
	},
	
	"title":{		type:'input', 
					attributes: {'class':"title", 'name':"title",
								'type':'text', 'placeholder':"title"}
	},
	
	"totalUnits":{	type:'input', 
					attributes: {'class':"totalUnits", 'name':"outgoingDetails.totalUnits",
								'placeholder':"total units"}
	},
	
	"unitAmount":{	type:'input', 
					attributes: {'class':"amount unitAmount", 'name':"outgoingDetails.unitAmount", 
								'placeholder':"unit amount"}
	}
};
	
var CONTAINERS = {
	"types":{					
			"account":{ attributes: {'class':"module_item account"},
						customData: {'objectType':"account", 'arrayName':"itemList", 
									'headList':["id", "title"],
									'bodyList':["accountNumber", "status", "currentAmount"]},
						appendTarget: "#accounts_form"
			},
			
			"allotment":{ attributes: {'class':"module_item allotment"},
						customData: {'objectType':"allotment", 'arrayName':"itemList", 
										'headList':["id", "title"],
										'bodyList':["comment", "targetDate", "targetAmount", "currentAmount"]},
						appendTarget: "#allotments_form"
			},
			
			"budgetCycle":{	attributes: {'class':"cycle"},
						customData: {'objectType':"budgetCycle", 'arrayName':"itemList", 
									'headList':["id", "startDate", "endDate", "add_inflow", "add_outflow", "status"],
									'bodyList':{'summary':[], //temp values - "dispensableAmount", "totalDailyInflows"
												'cashflows':["inflows", "outflows"]
												}},
						appendTarget: ".body .append_target"
			},
			
			"creditCard":{ attributes: {'class':"module_item creditCard"},
						customData: {'objectType':"creditCard", 'arrayName':"itemList", 
										'headList':["id", "bankName", "title"],
										'bodyList':["accountNumber", "creditLimit", "cutoffDate", "dueDate", "comment"]},
						appendTarget: "#creditCards_form"
			},
			
			"dailyOutflow":{ attributes: {'class':"module_item dailyOutflow"},
						customData: {'objectType':"dailyOutflow", 'arrayName':"itemList", 
									'headList':["id", "title"],
									'bodyList':["unitAmount", "totalUnits", "comment"]},
						appendTarget: "#dailyOutflows_form"
			},
			

			
			"inflow":{	attributes: {'class':"cashflow inflow"},
						customData: {'objectType':"inflow", 'arrayName':"inflowList", 
									'headList':["id", "title", "status"],
									'bodyList':["owner", "outstAmount", "receivedAmount", 
									             "comment", "budgetType", "flowType"]},
						appendTarget: ".inflows.append_target"
			},
			
			"outflow":{	attributes: {'class':"cashflow outflow"},
						customData: {'objectType':"outflow", 'arrayName':"outflowList", 
									'headList':["id", "title", "status"],
									'bodyList':["owner", "outstAmount", "unitAmount", 
						            			 "totalUnits", "outstUnits", "comment", 
						            			 "budgetType", "flowType"]},
						appendTarget: ".outflows.append_target"
			},
			
			"party":{ attributes: {'class':"module_item party"},
						customData: {'objectType':"party", 'arrayName':"itemList", 
									'headList':["id", "title"],
									'bodyList':["firstName", "lastName", "comment"]},
						appendTarget: "#parties_form"
			},
			
			"periodicInflow":{ attributes: {'class':"module_item periodicInflow"},
				customData: {'objectType':"periodicInflow", 'arrayName':"periodicInflowList", 
							'headList':["id", "title"],
							'bodyList':["startDate", "specificDate", "specificDay", "period",
							            "outstAmount", "receivedAmount", "comment", "budgetType",
							            "owner"]},
				appendTarget: "#periodicInflows_form"
			},
	},
			
	"classNames":[
			"module_item", 
			"module",
			"cycle", 
			"cashflow"
	]
};

var WRAPPERS = {
	"types":{
			"bar":{ attributes: {'class':"window_bar"}},
			"head":{ attributes: {'class':"head"}},	
			"body":{ attributes: {'class':"body"}},	
			"summary":{ attributes: {'class':"summary"}},
			"cashflows":{ attributes: {'class':"cashflows"},
						wrappers:["inflows", "outflows"]},
			"inflows":{ attributes: {'class':"inflows append_target"}},	
			"outflows":{ attributes: {'class':"outflows append_target"}}
			}
	};

var CONTAINER_CLASSES = mergeString(CONTAINERS.classNames, '.', ', ');