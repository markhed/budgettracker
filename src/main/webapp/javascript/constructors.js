function Container(containerType) {
	this.self = createWrapper(containerType);
	this.bar = new WindowBar();
	this.head = createWrapper("head");
	this.body = createWrapper("body");
	
	$(this.self).append(this.bar.self, this.head, this.body);
	
	this.reinitialize = function () { //invoke this if at least one of the attributes is replaced
		$(this.self).empty();
		$(this.self).append(this.bar.self, this.head, this.body);
	}
	
	console.log("Container:" + containerType + " created");
}

function CustomEntity(customData) {
	
	console.log("[start] CustomEntity:" + customData.objectType + " being created...");
	
	var container = new Container(customData.objectType);
	var cf = new CustomFieldFactory({'arrayName':customData.arrayName, 
									'index':$('div.' + customData.objectType).size()});
	
	if (isArray(customData.headList)) {
		console.log("[" + customData.objectType + "] -composing head...");
		
		for (var i = 0; i < customData.headList.length; i++) {
			$(container.head).append(cf.createField(customData.headList[i]));
		}
		
		console.log("[" + customData.objectType + "] -composed head");
	}
		
	if (isArray(customData.bodyList)) {
		console.log("[" + customData.objectType + "] -composing body...");
		
		for (var i = 0; i < customData.bodyList.length; i++) {
			$(container.body).append(cf.createField(customData.bodyList[i]));
		}
		
		console.log("[" + customData.objectType + "] -composed body");
		
	} else { //for custom entities containing custom entities
		var wrapper;
		var wrapperBodyList;
		
		console.log("[" + customData.objectType + "] -composing multi-nested body...");
		
		for(wrapperType in customData.bodyList) {
			wrapper = createWrapper(wrapperType);
			wrapperBodyList = customData.bodyList[wrapperType]; //gets body values
			
			$(container.body).append(wrapper);
					
			if (wrapperType == "summary") {
				var cf2 = new CustomFieldFactory({'arrayName':customData.arrayName, 
													'index':$('div.' + customData.objectType).size()});	//correct this later
													
				console.log("[" + customData.objectType + "] --composing body summary...");
													
				if (isArray(wrapperBodyList)) {
					for (var i = 0; i < wrapperBodyList.length; i++) {
						$(wrapper).append(cf2.createField(wrapperBodyList[i]));
					}
				}
				
				console.log("[" + customData.objectType + "] --composed body summary");
				
			} else if (wrapperType == "cashflows") {
				console.log("[" + customData.objectType + "] --composing body cashflows");
				
				for (var i = 0; i < wrapperBodyList.length; i++) {
					$(wrapper).append(createWrapper(wrapperBodyList[i]));
				}
				
				console.log("[" + customData.objectType + "] --composed body cashflows");
			}
		}
		
		console.log("[" + customData.objectType + "] -composed multi-nested body");
	}
				  
	this.self = container.self;
	
	console.log("[end] CustomEntity:" + customData.objectType);
}

function CustomFieldFactory(namingData) {
	this.namingData = namingData;
	
	this.createField = function (fieldName) {
		console.log("CustomField:" + fieldName + "...");
		
		var elementType = FIELDS[fieldName].type;
		var attributeList = FIELDS[fieldName].attributes;
		var additionalData = FIELDS[fieldName].additionalData;

		var elementObject = document.createElement(elementType);
			
		for(attribute in attributeList) {
			if (attribute == 'name') {
				elementObject.setAttribute(attribute, 
								this.namingData['arrayName'] + "[" + this.namingData['index'] + "]." + 
								attributeList[attribute]);
			} else {
				elementObject.setAttribute(attribute, attributeList[attribute]);
			}
		}
		
		console.log("-attributes set");

		if (additionalData != null) { //has additionalData
			console.log("-setting additional data...");
		
			if (elementType == 'select') {
				var placeholder = additionalData['placeholder'];
				var optionsList = additionalData['optionsList'];
				var option;
				
				if (placeholder != null && placeholder != "") {
					option = createElement('option', {'disabled':'true'});
					option.innerHTML = placeholder;
					elementObject.appendChild(option);
				}
				
				if (optionsList != null) {
					for(var key in optionsList) {
						option = createElement('option', {'value':key});
						option.innerHTML = optionsList[key];
						elementObject.appendChild(option);
					}
				}
				
				console.log("-'select' additional data set");
			}
		}
		
		console.log("CustomField done");
		
		return elementObject;
	};
}

function WindowBar() {
	this.self = createWrapper('bar');
	var minimizeButton = createElement('input', {'class':"minimize", 'type':'button', 'value':"-"});
	var deleteButton = createElement('input', {'class':"delete", 'type':'button', 'value':"x"});
	
	$(minimizeButton).click(function(){minimizeContainer(this);});
	$(deleteButton).click(function(){deleteContainer(this);});
	
	$(this.self).append(minimizeButton, deleteButton);
}