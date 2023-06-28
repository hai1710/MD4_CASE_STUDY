window.onload = function() {
    checkUser();
};
function checkUser(){
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));

    if (currentUser == null || currentUser == undefined) {
        console.log('1')
        // Hiển thị form đăng nhập
        $("#login").removeClass("d-none");
        $("#user").addClass("d-none");
        $("#logout").addClass("d-none");
    } else {
        // Hiển thị thông tin tài khoản của người dùng
        console.log('2')
        $("#login").addClass("d-none");
        $("#user").removeClass("d-none");
        $("#user").text(currentUser.email) ;
        $("#logout").removeClass("d-none");
    }
}
function logout(){
    localStorage.removeItem("currentUser");
    window.location.href = "index.html";
}