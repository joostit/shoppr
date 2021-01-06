$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var searchData = {}
    searchData["keywords"] = $("#keywords").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/getLists",
        data: JSON.stringify(searchData),
        dataType: 'json',
        cache: false,
        timeout: 6000,
        success: function (resultData) {

            var json = "<h4>Ajax Response</h4>"
                + JSON.stringify(resultData, null, 4);
            $('#feedback').html(json);

            console.log("POST: ", searchData);
            console.log("SUCCESS : ", resultData);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}