function changeLang() {
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace('movies?lang=' + selectedOption);
            }
        });
    });
}

function getMovie() {
    $.getJSON('http://localhost:7000/getAllMovie', function(res) {
        console.log(res);
        insertJson(res);
    })
}

function searchMovie(year, title) {
    $.getJSON('http://localhost:7000/searchMovies?year=' + year + '&title=' + title, function(res) {
        console.log(res);
        insertJson(res);
    })
}

function insertJson(data) {
    document.getElementById("json").innerHTML = JSON.stringify(data, undefined, 3);
}


