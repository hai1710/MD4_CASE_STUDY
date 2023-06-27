function addAccount() {
    //lay du lieu
    let email = $('#signup-email').val();
    let phone = $('#signup-phone').val();
    let password = $('#signup-password').val();
    let newAccount = {
        email: email,
        phone: phone,
        password: password
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newAccount),
        //tên API
        url: "http://localhost:8080/account",
        //xử lý khi thành công
        success: function(result) {
            console.log(result.message)
            document.getElementById("checkSignupabc").innerHTML = result.message
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
function checkSignup(){
    let email = $('#signup-email').val();
    let phone = $('#signup-phone').val();
    let password = $('#signup-password').val();
    let rePassword =$('#signup-confirm-password').val();
    let isValid=true;
    // Kiểm tra định dạng email
    let emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!emailRegex.test(email)) {
        mess1 = "Vui lòng nhập địa chỉ email hợp lệ.";
        document.getElementById('checkEmail').innerHTML = mess1;
        isValid=false;
    }

    // Kiểm tra định dạng số điện thoại
    let phoneRegex = /(84|0[3|5|7|8|9])+([0-9]{8})\b/;
    if (!phoneRegex.test(phone)) {
        mess2 = "Vui lòng nhập số điện thoại hợp lệ.";
        document.getElementById('checkPhone').innerHTML = mess2;
        isValid=false;
    }

    // Kiểm tra độ dài và định dạng mật khẩu
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!passwordRegex.test(password)) {
        mess3 = "Mật khẩu phải chứa ít nhất 8 ký tự, trong đó có ít nhất một chữ cái viết hoa, một chữ cái thường và một số.";
        document.getElementById('checkPassword').innerHTML = mess3;
        isValid=false;
    }

    // Kiểm tra xem mật khẩu được nhập lại có khớp với mật khẩu ban đầu không
    if (password != rePassword) {
        mess4 = "Mật khẩu không khớp. Vui lòng nhập lại.";
        document.getElementById('checkRePassword').innerHTML = mess4;
        isValid=false;
    }

    // Nếu tất cả các kiểm tra đều đúng thì cho phép gửi form
    if (isValid) {
        console.log(isValid)
        mess = "Đăng kí thành công";
        document.getElementById('checkSignup').innerHTML = mess;
        addAccount();
    }
}