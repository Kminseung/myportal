function checkForm(frm) {
	console.log(frm);
	
	var name = frm.name.value.trim();
	var password = frm.password.value.trim();
	var email = frm.email.value.trim();
	var gender = frm.gender.value;
	var check = frm.check.value;		// 이메일 중복 체크 여부
	
	if(name.length < 2) {
		alert("이름은 2자리 이상의 문자입니다.");
		frm.name.focus();
	} else if(password.length < 8) {
		alert("비밀번호는 8자리 이상이여야 합니다.");
		frm.password.focus();
	} else if(email.length < 10) {
		alert("이메일은 10자리 이상으로 입력해 주세요.");
		frm.email.focus();
	} else if(check != "t") {		// 중복 체크 안함
		alert("이메일 중복 체크를 해 주세요.");
	} else if(gender!='M' && gender!='F') {
		alert("성별을 선택해주세요.");
	} else {	// 검증 통과
		return true;	// 폼 전송
	}
	
	return false;		// onsubmit 이벤트에서 true여야 전송
}

function checkemail(emailField, url) {
	console.log("email field: ", emailField.value);
	
	// Ajax 호출
	if(emailField.value.trim().length == 0) {
		alert("이메일을 입력핼 주세요.");
		return ;
	}
	
	$.ajax({ 
		url: url,
		type: "GET",
		dataType: "json",
		data: {email: emailField.value.trim()},
		success: function(result) {
			console.log("Result: ", result);
			// hidden field: check 값을 변경
			if(result.data == true) {		// 이메일 중복 발생
				emailField.form.check.value = "f";
				alert("이미 가입 된 이메일입니다.");
			} else {
				emailField.form.check.value = "t";
				alert("가입할 수 있는 이메일입니다.");
			}
		},
		error: function(xhr, status, error) {
			console.error("Status: ", status);
			console.error("Response: ", xhr);
			console.error("Error: ", error);
			
			emailField.form.check.value = "f";
		}
	});
}