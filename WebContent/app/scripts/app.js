function validateName(name) {
	var regExpression = /^([A-Za-z])/;
	if (regExpression.test(name) == false) {

		return false;
	} else {

		return true;
	}

}

function validateEmail(email) {
	var regExpression = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

	if (regExpression.test(email) == false) {

		return false;
	} else {

		return true;
	}

};

function validateAddress(addressString) {
	var regexpression = /^([a-z0-9.|(|)|:|#|/|-])/;
	if (!(regexpression.test(addressString.value))) {

		return false;
	} else {

		return true;
	}
};

function validateformsubmit() {

	var vemail = document.getElementById('email').value;
	var vaddress = document.getElementById('saddr').value;
	var vfname = document.getElementById('fname').value;
	var vtelnumber = document.getElementById('telid').value;
	var studentInfo = {
		"firstName" : vfname,
		"email" : vemail,
		"streetAddress" : vaddress,
		"telphoneNumber" : vtelnumber
	};
	var postData = JSON.stringify(studentInfo);
	var url = "./resources/studentSurveyService/save";
	$.ajax({
		'type' : 'POST',
		'headers' : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		'url' : url,
		'data' : postData,
		'dataType' : 'json',
		'success' : function(data) {
			console.log("SUCCESS");
		}
	});
	/*var stringbuild = "";

	if (!validateName(vfname)) {

		stringbuild += "First Name text box should contain only Alphabets \n"

	}

	if (!validateEmail(vemail)) {
		stringbuild += "Email ID should be in proper format Example: example@abc.com \n"

	}
	if (!validateAddress(vaddress)) {
		stringbuild += "The Address text boxes should contain only appropriate numeric, alphabet or alphanumeric characters\n"
	}

	if (!stringbuild == "") {
		alert(stringbuild);
	}*/

}

function logomouseover() {
	document.getElementById('logomessage2').style.visibility = "visible";
	document.getElementById('logo2').style.visibility = "hidden";

};
$("#logo2").tooltip();

console.log("ready!");