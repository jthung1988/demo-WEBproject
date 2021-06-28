// JavaScript source code
$(document).ready(function () {
    $("#login").hide();
    $("#login_btn").on("click", function () {
        $("#login").show();
        $("#login").on("click", function () {
            $("#login").hide();
        })
        $("#login_content").on("mouseenter", function () {
            $("#login").off("click");
        })
        $("#login_content").on("mouseleave", function () {
            $("#login").on("click", function () {
            	$("#login").hide();
        	})
        })
    })

});