function addNew(source, objectType) {
	var object = new CustomEntity(CONTAINERS.types[objectType].customData);
	var container = $(source).closest(CONTAINER_CLASSES);
	
	$(container).find(CONTAINERS.types[objectType].appendTarget)
				.first()
				.append(object.self);
}

function assignListeners(selector) {
	if (selector == ".minimize") {
		$(selector)
		.each(function(){
			$(this).val('-');
			$(this).click(function(){minimizeContainer(this)});
		});
	} else if (selector == ".delete") {
		$(selector)
		.each(function(){
			$(this).val('x');
			$(this).click(function(){deleteContainer(this)});
		});
	};
}

function createWrapper(wrapperType) {
	var typeObject = CONTAINERS.types[wrapperType];
	
	if (typeObject == null) { //if not a container
		typeObject = WRAPPERS.types[wrapperType];
	}
	
	if (typeObject != null) { //if a specific wrapper
		typeAttributes = typeObject.attributes;
	} else { //if neither
		typeAttributes = {'class':"wrapper"};
	}
	
	return createElement('div', typeAttributes);
}

function createElement(elementType, attributeList) {
	elementObject = document.createElement(elementType);
	
	for(attribute in attributeList) {
		elementObject.setAttribute(attribute, attributeList[attribute]);
	}
	
	return elementObject;
}

function deleteContainer(objectButton) {
	$(objectButton).closest(CONTAINER_CLASSES).remove(); 
}

function initialize(objectType, objectList) {
	for (index in objectList) {
		var objectValues = objectList[index];
		var object = new CustomEntity(CONTAINERS.types[objectType].customData);
		
		for (attribute in objectValues) {
			$(object.self).find('.' + attribute).first().attr('value', objectValues[attribute]);
		}
		
		$(CONTAINERS.types[objectType].appendTarget)
					.append(object.self);
	}
}

function minimizeAll(containerType) {
	$("." + containerType + " .window_bar .minimize").each(function () {
		minimizeContainer(this);
	});
}

function minimizeContainer(objectButton) {
	var container = $(objectButton).closest(CONTAINER_CLASSES);
	
	container.find(".head *, .body .move_to_head")
	  .each(function() {
		  toggleDisable(this);
	});
	
	container.find(".head .add").toggle('fast', 'linear');
	
	if (container.hasClass("module_item")) {
		if ($(objectButton).hasClass("minimize")) {
			moveItems({container:container, sourceName:"body", destinationName:"head"});
		} else if ($(objectButton).hasClass("maximize")) {
			moveItems({container:container, sourceName:"head", destinationName:"body"});
		}
	} 
	
	$(container).toggleClass("minimized");
	toggleBarButton({button:objectButton, 
					initialValue:"-", reverseValue:"+",
					initialClass:"minimize", reverseClass:"maximize"});
	container.find(".body").slideToggle({duration:'fast', easing:'linear'});
}

function moveItems(moveData) {
	var source = moveData.container.find('.' + moveData.sourceName);
	var destination = moveData.container.find('.' + moveData.destinationName);
	
	source.find(".move_to_" + moveData.destinationName)
		  .each(function () {
				if ($(this).val() != "") {
					$(this).toggleClass("move_to_" + moveData.sourceName + " " +
										"move_to_" + moveData.destinationName);
					$(destination).append(this);
				}
	});
}

function submitMultipleForms() {
    $('form').each(function() {
        $.post($(this).action, $(this).serialize());
    });
}

function toggleDisable(object) {
	$(object).prop('disabled',!$(object).prop('disabled'))
}

function toggleBarButton(barButtonData) {
	if ($(barButtonData.button).val() == barButtonData.initialValue) {
		$(barButtonData.button).val(barButtonData.reverseValue);
	} else if ($(barButtonData.button).val() == barButtonData.reverseValue) {
		$(barButtonData.button).val(barButtonData.initialValue);
	}
	$(barButtonData.button).toggleClass(barButtonData.initialClass + " "
					+ barButtonData.reverseClass);

}