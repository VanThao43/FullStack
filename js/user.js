//Các xử lý cho kịch bản user.html

//Sinh giao diện quyền thực thi
function generatePermit() {
	//Khai báo mảng, tên các quyền thực thi
	let permit = new Array();
	permit[0] = '------chọn-----';
	permit[1] = 'Thành viên';
	permit[2] = 'Tác giả';
	permit[3] = 'Quản lý';
	permit[4] = 'Quản lý cấp cao';
	permit[5] = 'Quản trị';

	//Khai báo biến cấu tạo nên cấu trúc html
	var opt = '';
	opt += '<select class="form-control" id="UPermit" onchange="refreshPermit()">';
	for (var i = 0; i < permit.length; i++) {
		opt += '<option value=" ' + i + ' ">' + permit[i] + '</option>';
	}
	opt += '</select>';

	//in giá trị ra màn hình
	document.write(opt);
}


//Sinh giao diện các vai trò
function generateRoles() {
	//Khai báo danh sách các roles
	let roles = new Array();
	roles[0] = 'Người sử dụng';
	roles[1] = 'Chuyên mục';
	roles[2] = 'Thể loại';
	roles[3] = 'Bài viêt & Tin tức';
	roles[4] = 'Hệ sản phẩm';
	roles[5] = 'Nhóm sản phẩm';
	roles[6] = 'Loại sản phẩm';
	roles[7] = 'Sản phẩm';
	roles[8] = 'Hoá đơn';
	roles[9] = 'Khách hàng';


	let role = '';
	for (var i = 0; i < roles.length; i++) {

		//Mở dòng mới
		if (i % 3 == 0) {
			role += '<div class="row">';
		}

		role += '<div class="col-md-4">';
		role += '<div class="form-check">';
		role += '<input class="form-check-input" type="checkbox" id="chk' + i + '"     disabled  name="chks" onclick="checkPermit()">';
		role += '<label class="form-check-label" for="chk' + i + '">';
		role += 'Quản lý ' + roles[i];
		role += '</label>';
		role += '</div>';
		role += '</div>';

		//Đóng dòng
		if ((i % 3 == 2) || (i == roles.length - 1)) {
			role += '</div>'
		}
	}

	//In ra tài liệu
	document.write(role);
}


//Thiết lập trạng thái của Roles
function setCheckRoles(dis, check) {
	//Tham chiếu đối tượng form
	let fn = document.getElementById('frmUser');

	//Duyệt các phần tử của Form
	for (var i = 0; i < fn.elements.length; i++) {
		if ((fn.elements[i].type == 'checkbox') && (fn.elements[i].name == 'chks')) {
			fn.elements[i].disabled = dis;
			fn.elements[i].checked = check;
		}
	}
}


//Thay đổi lựa chọn quyền thực thi
function refreshPermit() {
	//lấy quyền thực thi
	let permit = parseInt(document.getElementById('UPermit').value);
	if ((permit == 4) || (permit == 5)) {
		this.setCheckRoles(true, true);
	}
	else if (permit == 3) {
		this.setCheckRoles(false, true);
	}
	else if (permit == 2) {
		this.setCheckRoles(false, false);
	}
	else {
		this.setCheckRoles(true, false);
	}
}

var messages = new Array();
function checkCharacter(messages) {
	
}



//Kiểm tra tên tài khoản
function checkName() {
	//Lấy thông tin
	let name = document.getElementById('UName').value;

	//Tham chiếu đối tượng hiển thị lỗi
	let viewErrName = document.getElementById('errName');

	//biến xác nhận giá trị hợp lệ
	var validName = true;

	//Biến ghi nhận thông báo
	var message = "";

	//Tham chiếu và hiện ô nhập email
	//Tham chiếu và ẩn ô nhập email
	document.getElementById('UEmail').disabled = false;

	//Thực hiện kiểm tra
	name = name.trim();
	if (name == "") {
		validName = false;
		message = "Thiếu tên đăng nhập / hộp thư đăng nhập cho tài khoản."
	}
	else {
		if ((name.length < 5) || (name.length > 50)) {
			validName = false;
			message = "Tên đăng nhập / hộp thư quá ngắn hoặc quá dài!";
		}
		else {
			if (name.indexOf(" ") != -1) {
				validName = false;
				message = "Tên đăng nhập / hộp thư không có giấu cách!";
			}
			else {
				const charcs = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
				let len = charcs.length;
				function test(item) {
					let mark = false;
					if (name.indexOf(item) != -1)
						mark = true;
					return mark;
				}
				let tests = charcs.map(test).join(' ');

				let check = false;
				for (var i = 0; i < len; i++) {
					if (tests.indexOf("true") != -1) {
						check = true;
					}
				}
				if (!check) {
					validName = false;
					message = "Tên đăng nhập / hộp thư phải chứa chữ số!";
				}
				else {

					document.getElementById('UEmail').disabled = true;
				}
			}
		}
	}

	//Thông báo
	viewErrName.style.padding = "5px";
	viewErrName.style.marginTop = "2px";
	if (validName) {
		viewErrName.innerHTML = '<i class="fa-solid fa-check"></i>';
		viewErrName.style.backgroundColor = "transparent";
		viewErrName.style.color = "blue";
	}
	else {
		viewErrName.innerHTML = message;
		viewErrName.style.backgroundColor = "red";
		viewErrName.style.color = "yellow";
	}

	return validName;
}


/* Kiểm tra pass */
function checkPass() {
	let pass = document.getElementById('UPass').value;

	let viewErrPass = document.getElementById('errPass');
	let viewErrPass2 = document.getElementById('errPass2');

	var validPass = false;
	var message = "";


	/* Tham chiếu ô xác nhận mật khẩu */
	let passConfirm = document.getElementById('UConfirm');

	pass = pass.trim();
	if (this.checkName()) {
		if (pass == "") {
			passConfirm.disabled = true;
			message = "Thiếu mật khẩu để đăng nhập!";
		}
		else {
			if (pass.length < 6) {
				passConfirm.disabled = true;
				message = "Mật khẩu quá ngắn!";
			}
			else {
				let name = document.getElementById('UName').value;
				if (pass.indexOf(name) != -1) {
					passConfirm.disabled = true;
					message = "Mật khẩu không chứa tên đăng nhập";
				}
				else {
					if (pass.indexOf(" ") != -1) {
						passConfirm.disabled = true;
						message = "Mật khẩu không chưa dấu cách!";
					}
					else {
						const charcs = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
						let len = charcs.length;
						function test(item) {
							let mark = false;
							if (pass.indexOf(item) != -1)
								mark = true;
							return mark;
						}
						let tests = charcs.map(test).join(' ');

						let check = false;
						for (var i = 0; i < len; i++) {
							if (tests.indexOf("true") != -1) {
								check = true;
							}
						}
						if (!check) {
							passConfirm.disabled = true;
							message = "Mật khẩu phải chứa chữ số!";
						}
						else {
							const charcs = ['@', '!', '#', '$', '%', '^', '&', '*', '+', '-'];
							let len = charcs.length;
							function test(item) {
								let mark = false;
								if (pass.indexOf(item) != -1)
									mark = true;
								return mark;
							}
							let tests = charcs.map(test).join(' ');

							let check = false;
							for (var i = 0; i < len; i++) {
								if (tests.indexOf("true") != -1) {
									check = true;
								}
							}
							if (!check) {
								passConfirm.disabled = true;
								message = "Mật khẩu phải chứa ít nhất 1 kí tự đặc biệt \"!@#$%^&*+-\"";
							}
							else {
								// document.getElementById('UConfirm').disabled = false;
								passConfirm.disabled = false;
								let pass2 = document.getElementById('UConfirm').value;

								if (pass2.trim() == "") {
									message = "Xác nhận lại mật khẩu.";
								}
								else {
									if (pass != pass2) {
										message = "Mật khẩu xác nhận lại không khớp";
									}
									else {
										validPass = true;
									}
								}
							}
						}
					}
				}
			}
		}



		viewErrPass.style.padding = "8px";
		viewErrPass.style.marginTop = "5px";
		viewErrPass2.style.padding = "8px";
		viewErrPass2.style.marginTop = "5px";

		if (validPass) {
			viewErrPass.innerHTML = '<i class="fa-solid fa-check"></i>';
			viewErrPass.style.backgroundColor = "transparent";
			viewErrPass.style.color = "blue";


			viewErrPass2.innerHTML = '<i class="fa-solid fa-check"></i>';
			viewErrPass2.style.backgroundColor = "transparent";
			viewErrPass2.style.color = "blue";

		}
		else {
			if (passConfirm.disabled == true) {
				viewErrPass.innerHTML = message;
				viewErrPass.style.backgroundColor = "yellow";
				viewErrPass.style.color = "black";

				viewErrPass2.innerHTML = '';
				viewErrPass2.style.backgroundColor = "transparent";

			}
			else {
				viewErrPass2.innerHTML = message;
				viewErrPass2.style.backgroundColor = "yellow";
				viewErrPass2.style.color = "black";

				viewErrPass.innerHTML = '';
				viewErrPass.style.backgroundColor = "transparent";
			}
		}


	}
	else {
		document.getElementById('UName').focus();
		document.getElementById('UName').selected();
	}


	return validPass;
}



/* Kiểm tra confirmPass */
// function checkConfirmPass() {
// 	if(this.checkPass){

// 	}
// 	let pass2 = document.getElementById('UConfirm').value;
// 	let viewErrPass2 = document.getElementById('errPass2');

// 	var message2 = "";
// 	var validPass2 = true;



// 	pass2 = pass2.trim();

// 	viewErrPass2.style.padding = "8px";
// 	viewErrPass2.style.marginTop = "5px";
// 	if (pass2 == validPass) {
// 		viewErrPass2.innerHTML = '<i class="fa-solid fa-check"></i>';
// 		viewErrPass2.style.backgroundColor = "transparent";
// 		viewErrPass2.style.color = "blue";
// 	}
// 	else {
// 		viewErrPass2.innerHTML = "Mật khẩu nhập lại không đúng!";
// 		viewErrPass2.style.backgroundColor = "yellow";
// 		viewErrPass2.style.color = "black";
// 	}
// }


/* Check Email */
function checkEmail() {

	//Lấy thông tin	
	let email = document.getElementById('UEmail');
	if (email.disabled == true) {
		return true;
	}
	else {
		//Tham chiếu đối tượng hiển thị lỗi
		let viewErrEmail = document.getElementById('errEmail');

		//biến xác nhận giá trị hợp lệ
		var validEmail = true;

		//Biến ghi nhận thông báo
		var message = "";

		let value = email.value;

		//Thực hiện kiểm tra
		value = value.trim();
		if (value == "") {
			validEmail = false;
			message = "Thiếu hộp thư cho tài khoản."
		}
		else {
			let at = value.indexOf('@');
			if (value.substring(at).length < 5) {
				validEmail = false;
				message = 'Tên hộp thư quá ngắn. (<b style="font-size: 20px;">' + value.substring(at) + '</b>@gmail.com)';
			}
			else {
				if (value.substring(at).length > 50) {
					validEmail = false;
					message = "Hộp thư quá dài!";
				}
				else {
					if (value.indexOf(" ") != -1) {
						validEmail = false;
						message = "Hộp thư không có giấu cách!";
					}
					else {
						const charcs = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
						let len = charcs.length;
						function test(item) {
							let mark = false;
							if (value.indexOf(item) != -1)
								mark = true;
							return mark;
						}
						let tests = charcs.map(test).join(' ');

						let check = false;
						for (var i = 0; i < len; i++) {
							if (tests.indexOf("true") != -1) {
								check = true;
							}
						}
						if (!check) {
							validEmail = false;
							message = "Hộp thư phải chứa chữ số!";
						}
						else {
							if (value.indexOf('@') == -1) {
								validEmail = false;
								message = "Hộpthư không đúng cấu trúc!";
							}
							else {
								var parttern = /\w+@\w+[.]\w/;
								if (!value.match(parttern)) {
									validEmail = false;
									message = "Hộp thư chưa hợp lệ!";
								}
							}
						}
					}
				}
			}

		}

		//Thông báo
		viewErrEmail.style.padding = "5px";
		viewErrEmail.style.marginTop = "2px";
		if (validEmail) {
			viewErrEmail.innerHTML = '<i class="fa-solid fa-check"></i>';
			viewErrEmail.style.backgroundColor = "transparent";
			viewErrEmail.style.color = "blue";
		}
		else {
			viewErrEmail.innerHTML = message;
			viewErrEmail.style.backgroundColor = "yellow";
			viewErrEmail.style.color = "black";
		}
	}


	return validEmail;
}




function checkPermit() {
	//Lấy giá trị
	let permit = parseInt(document.getElementById('UPermit').value);

	// tham chiếu báo lỗi
	let viewErrPermit = document.getElementById('errPermit');

	let validPermit = true;

	var message = "";

	if ((permit == 2) || (permit == 3)) {
		var fn = document.getElementById('frmUser');
		//Duyệt các phần tử
		for (var i = 0; i < fn.elements.length; i++) {
			if ((fn.elements[i].type == 'checkbox') && (fn.elements[i].name == 'chks')) {
				if (fn.elements[i].checked) {
					validPermit = true;
					break;
				}
				else {
					validPermit = false;
				}
			}
		}
	}

	// Thông báo
	viewErrPermit.style.padding = '5px';
	viewErrPermit.style.paddingTop = '8px';
	if (validPermit) {
		if ((permit == 0) || (permit == 1)) {
			viewErrPermit.innerHTML = '';
		}
		else {
			viewErrPermit.innerHTML = '<i class="fa-solid fa-check"></i>';
			viewErrPermit.style.backgroundColor = "transparent";
			viewErrPermit.style.color = "blue";
		}
	}
	else {
		viewErrPermit.innerHTML = 'Cần có <b style="font-size: 20px;">ít nhất</b> một vai trò cho quyền thực thi.';
		viewErrPermit.style.backgroundColor = "yellow";
		viewErrPermit.style.color = "black";
	}

	return validPermit;
}


function checkValidUser() {
	let check_name = checkName();
	let check_pass = checkPass();
	let check_email = checkEmail();
	let check_permit = checkPermit();

	return check_name && check_pass && check_email && check_permit;
}


function checkFullName() {
	let fullName = document.getElementById('UFullName').value;
	let viewErrFullName = document.getElementById('errFullName');

	var validFullName = true;
	var message = "";

	fullName = fullName.trim();
	if (fullName == "") {
		validFullName = false;
		message = "Thiếu họ tên đầy đủ.";
	}
	else {
		if (fullName.length < 6) {
			validFullName = false;
			message = "Tên đầy đủ quá ngắn.";
		}
		else {
			const charcs = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
			let len = charcs.length;
			function test(item) {
				let mark = false;
				if (fullName.indexOf(item) != -1)
					mark = true;
				return mark;
			}
			let tests = charcs.map(test).join(' ');

			let check = false;
			for (var i = 0; i < len; i++) {
				if (tests.indexOf("true") != -1) {
					check = true;
				}
			}
			if (check) {
				validFullName = false;
				message = "Tên đầy đủ không chứa chữ số!";
			}
			else {
				const charcs = ['@', '!', '#', '$', '%', '^', '&', '*', '+', '-'];
				let len = charcs.length;
				function test(item) {
					let mark = false;
					if (fullName.indexOf(item) != -1)
						mark = true;
					return mark;
				}
				let tests = charcs.map(test).join(' ');

				let check = false;
				for (var i = 0; i < len; i++) {
					if (tests.indexOf("true") != -1) {
						check = true;
					}
				}
				if (check) {
					validFullName = false;
					message = "Tên đầy đủ không chứa kí tự đặc biệt.";
				}
			}
		}
	}


	//Thông báo
	viewErrFullName.style.padding = "5px";
	viewErrFullName.style.marginTop = "8px";
	if (validFullName) {
		viewErrFullName.innerHTML = '<i class="fa-solid fa-check"></i>';
		viewErrFullName.style.backgroundColor = "transparent";
		viewErrFullName.style.color = "blue";
	}
	else {
		viewErrFullName.innerHTML = message;
		viewErrFullName.style.backgroundColor = "yellow";
		viewErrFullName.style.color = "black";
	}

	return fullName;
}



/* Check LastName */
// function checkLastName{}
