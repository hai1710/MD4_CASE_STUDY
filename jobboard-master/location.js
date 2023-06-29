function postEdit() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    // Lấy thông tin hình ảnh sau khi chỉnh sửa
    let email = $('#Email-name').val();
    let name = $('#Name').val();
    let age = $('#Age').val();
    let gender = $('#Gender').val();
    let phone = $('#Phone').val();
    let img = $('#uploadedImage').attr("src");
    console.log(img);
    let locationId = $('#mySelect').val();
    let locationName =$("option:selected", $("#mySelect")).text();
    let id = currentUser.id;
    let updatedAccount = {
        id: id,
        email:email,
        name: name,
        age: age,
        gender: gender,
        phone: phone,
        image: img,
        location: {
            id : locationId,
            name: locationName,
        },
    };
    console.log(updatedAccount)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(updatedAccount),
        url: "http://localhost:8080/account/" + id,
        success: function ( ) {
            alert("Update success")
        }
    });
}
function postCompany() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    console.log(currentUser)

    // Lấy thông tin hình ảnh sau khi chỉnh sửa
    let email = $('#Email-name').val();
    let name =  $('#company-name').val();
    let link_company = $('#company-website').val();
    let link_facebook = $('#company-website-fb').val();
    let phone = $('#company-phone').val();
    let region = $('#company-region').val();
    let img = $('#uploadedImage1').attr("src");
    let id =  $('#accountId').val();
    let updatedAccount = {
        id: id,
        email:email,
        name: name,
        link_company: link_company,
        link_facebook: link_facebook,
        phone: phone,
        region:region,
        image: img,
        account: currentUser,
    };
    console.log(updatedAccount)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(updatedAccount),
        url: "http://localhost:8080/company/" + id,
        success: function ( ) {
            alert("Update success")
        }
    });
}

