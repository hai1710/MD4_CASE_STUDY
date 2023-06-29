function addAccount() {
    //lay du lieu
    let email = $('#signup-email').val();
    let phone = $('#signup-phone').val();
    let password = $('#signup-password').val();
    let role =  {
        "id": 1,
            "name_role": "user"
    };
    let newAccount = {
        email: email,
        phone: phone,
        password: password,
        role: role
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newAccount),
        url: "http://localhost:8080/account",
        success: function(result) {
            document.getElementById("checkSignup").innerHTML = result.message
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
        mess1 = "Please enter a valid email address.";
        document.getElementById('checkEmail').innerHTML = mess1;
        isValid=false;
    }
    if (emailRegex.test(email)) {
        mess1 = "";
        document.getElementById('checkEmail').innerHTML = mess1;
    }

    // Kiểm tra định dạng số điện thoại
    let phoneRegex = /(84|0[3|5|7|8|9])+([0-9]{8})\b/;
    if (!phoneRegex.test(phone)) {
        mess2 = "Please enter valid phone number.";
        document.getElementById('checkPhone').innerHTML = mess2;
        isValid=false;
    }
    if (phoneRegex.test(phone)) {
        mess2 = "";
        document.getElementById('checkPhone').innerHTML = mess2;
    }

    // Kiểm tra độ dài và định dạng mật khẩu
    let passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!passwordRegex.test(password)) {
        mess3 = "Passwords must contain at least 8 characters, including at least one capital letters, a regular letter and some.";
        document.getElementById('checkPassword').innerHTML = mess3;
        isValid=false;
    }
    if (passwordRegex.test(password)) {
        mess3 = "";
        document.getElementById('checkPassword').innerHTML = mess3;
    }

    // Kiểm tra xem mật khẩu được nhập lại có khớp với mật khẩu ban đầu không
    if (password != rePassword) {
        mess4 = "Password incorrect. Please enter again.";
        document.getElementById('checkRePassword').innerHTML = mess4;
        isValid=false;
    }
    if (password == rePassword) {
        mess4 = "";
        document.getElementById('checkRePassword').innerHTML = mess4;
    }

    // Nếu tất cả các kiểm tra đều đúng thì cho phép gửi form
    if (isValid) {
        addAccount();
    }
}
function checkLogin() {
    let email1 = $('#login-email').val();
    console.log(email1)
    let password1 = $('#login-password').val();
    console.log(password1)

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/account",
        success: function(data) {
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                if (data[i].email==email1&&data[i].password==password1){
                    localStorage.setItem("currentUser", JSON.stringify(data[i]));
                   window.location.href = "index.html";
               }
            }
            document.getElementById("checkLogin").innerHTML="Accounts or passwords incorrectly."
        }

    });
}