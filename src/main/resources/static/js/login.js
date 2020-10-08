$(document).ready(function() {
	$("#loginButton").click(function(){
		console.log( {
			"usuario": $("#idUsuario").val(),
			"passwd":$("#passwd").val()
			})
		$.ajax({
		  type: "POST",
		  url: "https://subastasdinipa.herokuapp.com/subastas/login",
		  data: JSON.stringify({
			"usuario": $("#idUsuario").val(),
			"passwd":$("#passwd").val()
			}),
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
		  success: function(res) {
                localStorage.setItem("login",true)
                window.location.href="/index.html"
			},
			error: function(xhr, status, error) {
              alert(xhr.responseText);
            }
		});
	});

})