/*Các xử lý kịch bản dành cho provider*/

function checkValidProvider(){
	//Khai báo biến xác nhận hợp lệ
	var validName = true;
	var validCheck = true;
		
	//Khai báo biến ghi nhận thông báo
	var message = "";
	
	//Tham chiếu lấy giá trị
	let name = document.getElementById('PName').value;
	let check = document.getElementById('action').checked;
	
	//tham chiếu nút bấm
	let btnReg = document.getElementById('btnReg');

	//Kiểm tra
	if (name.trim() != "" && check){
		btnReg.disabled = false;
	}
	else{
		btnReg.disabled = true;
	}

}
// 	//Kiểm tra tên
// 	name = name.trim();
// 	if(name == ""){
// 		validName = false;
// 		message = "Bạn cần nhập tên nhà cung cấp";
// 	}else{
// 		if((name.length<5) || (name.length>50)){
// 			validName = false;
// 			message = "Tên nhà cung cấp quá dài hoặc quá ngắn";
		
// 	}
// 	//Thông báo lỗi name
// 	viewErrName.style.paddingTop = "5px";
// 	if(validName){
// 		viewErrName.innerHTML = '<i class="fa-solid fa-check"></i>';
// 		viewErrName.style.backgroundColor = "transparent";
// 		viewErrName.style.color = "blue";
// 	}else{
// 		viewErrName.innerHTML = message;
// 		viewErrName.style.backgroundColor = "red";
// 		viewErrName.style.color = "yellow";
// 	}
	
// 	//Kiểm tra checkbox
// 	if (document.getElementById('action').onclick){
// 		if(document.getElementById('action').checked){
// 			validCheck = true;
// 		}else{
// 			validCheck = false;
// 			message = "Bạn cần chấp nhận các quy định";
// 		}
// 	}
	
	
// 	//Thông báo lỗi checkbox
// 	if(validCheck){
// 		viewErrCheck.innerHTML = '<i class="fa-solid fa-check"></i>';
// 		viewErrCheck.style.backgroundColor = "transparent";
// 		viewErrCheck.style.color = "blue";
// 	}else{
// 		viewErrCheck.innerHTML = message;
// 		viewErrCheck.style.backgroundColor = "red";
// 		viewErrCheck.style.color = "yellow";
// 	}
	
// 	//Hiện thị nút đăng nhập
// 	if((validCheck==false) || (validName==false)){
// 		//errButton.style = "disabled";
		
// 	}
// 	return validName && validCheck;
// 	}
// }


