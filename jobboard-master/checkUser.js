window.onload = function() {
    checkUser();
    editInfo();
    editCompany();
};
function checkUser(){
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if (currentUser == null || currentUser == undefined) {
        // Hiển thị form đăng nhập
        $("#login").removeClass("d-none");
        $("#user").addClass("d-none");
        $("#logout").addClass("d-none");
    } else {
        // Hiển thị thông tin tài khoản của người dùng
        $("#login").addClass("d-none");
        $("#user").removeClass("d-none");
        $("#user").text(currentUser.email) ;
        $("#logout").removeClass("d-none");
    }
}
function editInfo() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    let idUser = currentUser.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/account/" + idUser,
        success: function (account) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/location",
                success: function (data) {
                    let listLocation = '<select id="mySelect">';
                    for (let i = 0; i < data.length; i++) {
                        let selected = '';
                        if (account.location!=null){
                        if (  data[i].name == account.location.name) {
                            selected = 'selected';
                        }}
                        listLocation += '<option value="' + data[i].id + '" ' + selected + '>' + data[i].name + '</option>';
                    }
                    listLocation += '</select>';
                    // Đổ thông tin vào các trường input
                    $('#Email-name').val(account.email);
                    $('#Name').val(account.name);
                    $('#Age').val(account.age);
                    $('#Gender').val(account.gender);
                    $('#Phone').val(account.phone);
                    $('#mySelect').html(listLocation);
                    $('#mySelect option:selected').text();
                    document.getElementById("selectedImage").src=account.image;

                }
            });
        }
    });
}
function editCompany() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    let idUser = currentUser.id;

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/company/account/" + idUser,
        success: function (account) {
            $('#accountId').val(account.id)
            $('#company-name').val(account.name);
            $('#company-email').val(account.email);
            $('#company-phone').val(account.phone);
            $('#company-website').val(account.link_company);
            $('#company-website-fb').val(account.link_facebook);
            $('#company-region').val(account.region);
            console.log(account.image);
            document.getElementById("selectedImage1").src=account.image;

        }
    });
}
function logout(){
    localStorage.removeItem("currentUser");
    window.location.href = "index.html";
}