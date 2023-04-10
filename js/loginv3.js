function checkValidLogin() {
    // tham chiếu lấy giá trị
    let name = document.getElementById('name').value;
    let pass = document.getElementById('pass').value;

    //Tham chiếu đối tượng hiển thị lỗi
    let viewErrName = document.getElementById('errName');
    let viewErrPass = document.getElementById('errPass');

    // Khai báo biến xác nhận hợp lệ
    var validName = true;
    var validPass = true;

    //Khai báo biến ghi nhận thông báo
    var message = "";

    // Kiểm tra Name
    name = name.trim();
    if (name == "") {
        validName = false;
        message = "Thiếu tên / hộp thư đăng nhập cho tài khoản."
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
                    var mark = false;
                    if (name.indexOf(item) != -1)
                        mark = true;
                    return mark;
                }
                let tests = charcs.map(test).join(' ');

                let check = false;
                for (var i = 0; i < len; i++) {
                    if (tests.indexOf(true) != -1) {
                        check = true;
                    }
                }
                if (!check) {
                    validName = false;
                    message = "Tên đăng nhập phải chứa chữ số!";
                }
                else {
                    if (name.indexOf('@') == -1) {
                        validName = false;
                        message = "Tên đăng nhập không đúng cấu trúc!";
                    }
                    else {
                        var parttern = /\w+@\w+[.]\w/;
                        if (!name.match(parttern)) {
                            validName = false;
                            message = "Tên đăng nhập chưa hợp lệ!";
                        }
                    }
                }
            }
        }
    }

    //thông báo lỗi name
    viewErrName.style.padding = "8px";
    viewErrName.style.marginTop = "5px";

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


    //Kiểm tra pass
    pass = pass.trim();
    if (pass == "") {
        validPass = false;
        message = "Thiếu mật khẩu để đăng nhập!";
    }
    else {
        if (pass.length < 6) {
            validPass = false;
            message = "Mật khẩu quá ngắn!";
        }
        else {
            if (pass.indexOf(" ") != -1) {
                validPass = false;
                message = "Mật khẩu không chưa dấu cách!";
            }
            else {
                const charcs = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
                let len = charcs.length;
                function test(item) {
                    var mark = false;
                    if (pass.indexOf(item) != -1)
                        mark = true;
                    return mark;
                }
                let tests = charcs.map(test).join(' ');

                let check = false;
                for (var i = 0; i < len; i++) {
                    if (tests.indexOf(true) != -1) {
                        check = true;
                    }
                }
                if (!check) {
                    validPass = false;
                    message = "Mật khẩu phải chứa chữ số!";
                }
                else {
                    const charcs = ['@', '!', '#', '$', '%', '^', '&', '*', '+', '-'];
                    let len = charcs.length;
                    function test(item) {
                        var mark = false;
                        if (pass.indexOf(item) != -1)
                            mark = true;
                        return mark;
                    }
                    let tests = charcs.map(test).join(' ');

                    let check = false;
                    for (var i = 0; i < len; i++) {
                        if (tests.indexOf(true) != -1) {
                            check = true;
                        }
                    }
                    if (!check) {
                        validPass = false;
                        message = "Mật khẩu phải chứa ít nhất 1 kí tự đặc biệt \"!@#$%^&*+-\"";
                    }
                }
            }
        }
    }


    //Thông báo lỗi pass

    viewErrPass.style.padding = "8px";
    viewErrPass.style.marginTop = "5px";

    if (validPass) {
        viewErrPass.innerHTML = '<i class="fa-solid fa-check"></i>';
        viewErrPass.style.backgroundColor = "transparent";
        viewErrPass.style.color = "blue";
    }
    else {
        viewErrPass.innerHTML = message;
        viewErrPass.style.backgroundColor = "yellow";
        viewErrPass.style.color = "black";
    }



	var btnReg = document.getElementById('btnReg');
	var check = document.getElementById('chkSave').checked;

	if (validName && validPass && check){
		btnReg.disabled = false;
	}
	else{
		btnReg.disabled = true;
	}
}





var show = true;
function showPassword() {
    if (show) {
        document.getElementById('pass').type = "text";
        show = false;
    }
    else {
        document.getElementById('pass').type = "password";
        show = true;
    }
}


