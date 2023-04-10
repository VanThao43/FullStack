var check1 = true, check2 = true;
function checkValidLogin() {
    let name = document.getElementById('uName').value;
    let pass = document.getElementById('uPass').value;

    let errName = document.getElementById('errName');
    let errPass = document.getElementById('errPass');

    let validName = true;
    let validPass = true;

    var message = "";
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

    errName.style.padding = "8px";
    errName.style.marginTop = "5px";

    if (validName) {
        errName.innerHTML = '<i class="fa-solid fa-check"></i>';
        errName.style.backgroundColor = "transparent";
        errName.style.color = "blue";
    }
    else {
        errName.innerHTML = message;
        errName.style.backgroundColor = "yellow";
        errName.style.color = "black";
    }


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

    errPass.style.padding = "8px";
    errPass.style.marginTop = "5px";

    if (validPass) {
        errPass.innerHTML = '<i class="fa-solid fa-check"></i>';
        errPass.style.backgroundColor = "transparent";
        errPass.style.color = "blue";
    }
    else {
        errPass.innerHTML = message;
        errPass.style.backgroundColor = "yellow";
        errPass.style.color = "black";
    }


    // var changeBtn = document.querySelector('.btn');
    // var changeIcon = document.getElementById('change-icon');
    // if (validName && validPass) {
    //     changeBtn.style.backgroundColor = "greenyellow";
    //     changeBtn.style.color = "black";
    //     changeIcon.style.color = "#000";
    //     changeBtn.style.fontWeight = "650";
    // }
    // if (!(validName && validPass)) {
    //     changeBtn.style.backgroundColor = "#0d6efd";
    //     changeBtn.style.color = "#fff";
    //     changeIcon.style.color = "#fff";
    //     changeBtn.style.fontWeight = "normal";
    // }


    let check = document.getElementById('chkSave').checked;
    let btnReg = document.getElementById('btnReg');

    if (validName && validPass && check) {
        btnReg.disabled = false;
    }
    else {
        btnReg.disabled = true;
    }
}



var show = true;
function showPassword() {
    if (show) {
        document.getElementById('uPass').type = "text";
        show = false;
    }
    else {
        document.getElementById('uPass').type = "password";
        show = true;
    }
}