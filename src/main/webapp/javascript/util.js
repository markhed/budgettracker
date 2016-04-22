function direct(argLocation) {
	location.href = argLocation;
}

function isArray(o) {
	  return Object.prototype.toString.call(o) === '[object Array]';
}

function mergeString(arrayString, prefix, separator) {
	var output = "";
	
	for (var i = 0; i < arrayString.length; i++) {
		output += prefix + arrayString[i];
		
		if(i != arrayString.length - 1) {
			output += separator;
		}
	}
	
	return output;
}