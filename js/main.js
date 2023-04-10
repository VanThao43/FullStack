/*Các xử lý kịch bản cho index.html*/

//Khai báo biến: 2 cách

var def = "------------- từ khóa ---------------";
let emp = '';

function setFirstTime() { //làm việc thông qua form rồi đến đối tượng
    // window.document.forms[0].txtKeyword.value = def;
    window.document.frmSearch.txtKeyword.value = def; //có thể bỏ window 
}

function setFirstTimeV2(fn) {
    fn.txtKeyword.value = def;
}

function setFirstTimeV3() { //định danh từng đối tượng. cách viết này sử lý nhanh nhất, không cần dùng đến form
    let key = document.getElementById('txtKeyword');

    //gán giá trị
    key.value = def;
}

function setKeyword(fn, isClick) {
    //Lấy giá trị
    let value = fn.txtKeyword.value;

    //Xử lý khoảng trắng ở đầu và cuối của chuỗi ký tự
    value = value.trim();

    if (isClick) {
        if (value == def) {
            fn.txtKeyword.value = emp;
        }
    } else {
        if (value == emp) {
            fn.txtKeyword.value = def;
        }
    }

}

function checkValidKeyword(fn) {
    let value = fn.txtKeyword.value;

    var message = "Hãy nhập vào từ khóa để tìm kiếm.";

    if ((value.trim() == def) || (value.trim() == emp)) {
        window.alert(message);
        fn.txtKeyword.focus();
        fn.txtKeyword.select();
    } else {
        return true;
    }
}