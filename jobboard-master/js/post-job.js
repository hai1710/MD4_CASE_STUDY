let currentUser = JSON.parse(localStorage.getItem("currentUser"));
console.log(currentUser);
showLocationList();
function postJob() {
    let title = $('#job-title').val();
    let type = $('#job-type').val();
    let published = $('#job-published').val();
    let deadline = $('#job-deadline').val();
    let vacancy = $('#job-vacancy').val();
    let experience = $('#job-experience').val();
    let salary = $('#job-salary').val();
    let gender = $('#job-gender').val();
    let image = $('#uploadedImage').attr("src");
    let locationId = parseInt($('#mySelect').val());
    let locationName =$("option:selected", $("#mySelect")).text();
    let job = {
        title: title,
        jobType: type,
        published_on: published,
        application_deadline: deadline,
        vacancy: vacancy,
        experience: experience,
        salary: salary,
        gender: gender,
        image: image,
        company:{
            id: 1,
        },
        jobLocation: {
            id : locationId,
            name: locationName,
        },
    };

    console.log(job)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(job),
        url: "http://localhost:8080/job",
        success: function ( ) {
            alert("Success")
            window.location.href = "index.html";
        }
    });
}

function showLocationList() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/location",
        success: function (data) {
            let listLocation = '<select id="mySelect">';
            for (let i = 0; i < data.length; i++) {
                let selected = '';
                if (currentUser.location!=null){
                    if (data[i].location == currentUser.location) {
                        selected = 'selected';
                    }}
                listLocation += '<option value="' + data[i].id + '" ' + selected + '>' + data[i].name + '</option>';
            }
            listLocation += '</select>';
            $('#mySelect').html(listLocation);

        }
    });
}
