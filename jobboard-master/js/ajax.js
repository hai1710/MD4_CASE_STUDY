$(document).ready(function () {
    showListJob();
    showListLocation()
});

function showListJob() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/job",
        success: function (data) {
            console.log(data);
            let jobList = "";
            for (let i = 0; i < data.length; i++) {
                jobList += `<li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
            <a href="job-single.html"></a>
            <div class="job-listing-logo">
              <img src="${data[i].image}" alt="Free Website Template by Free-Template.co" class="img-fluid">
            </div>

            <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
              <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                <h2>${data[i].title}</h2>
                <strong>${data[i].company.name}</strong>
              </div>
              <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25">
                <span class="icon-room"></span> ${data[i].jobLocation.name}, ${data[i].job_region}
              </div>
              <div class="job-listing-meta">
                <span class="badge badge-danger">${data[i].jobType}</span>
              </div>
            </div>
          </li>`
            }
            document.getElementById("job-listing").innerHTML = jobList;
        }
    })
}


function showListLocation() {
   let listLocation = ``;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/location",
        success: function (data) {
            console.log(data);
            for (let i = 0; i < data.length; i++){
                listLocation += `<option value="${data[i].id}">${data[i].name}</option>`;
            }
            listLocation += `</select>`
            console.log(listLocation);
            document.getElementById("test").innerHTML = listLocation
        }
    })
}