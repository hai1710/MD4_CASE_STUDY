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
