
function getParameterByName(name) {
    var url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

var jobId = getParameterByName('id');
console.log(jobId);

showJob(jobId);

function showJob(jobId) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/job/' + jobId,
        success: function (data) {
            console.log(data);
            $('#job-title').append(data.title);
            $('#job-company').append(data.company.name);
            $('#job-published').append(data.published_on);
            $('#job-deadline').append(data.application_deadline);
            $('#job-vacancy').append(data.vacancy);
            $('#job-type').append(data.jobLocation.name);
            $('#job-experience').append(data.experience);
            $('#job-location').append(data.jobLocation.name);
            $('#job-salary').append(data.salary);
            $('#job-gender').append(data.gender);
            $('.title').append(data.title);
            $('#companyName').append(data.company.name);
            $('#location').append(data.jobLocation.name);
            $('#jobtype').append(data.jobType);

            $('#image').attr('src', data.image);
            $('#image2').attr('src', data.image);

        }
    });
}
