$(document).ready(function() {
	$("#loginButton").click(function(){
		console.log( {
			"usuario": $("#idUsuario").val(),
			"passwd":$("#passwd").val()
			})
		$.ajax({
		  type: "POST",
		  url: "localhost:8080/subastas/login",
		  data: JSON.stringify({
			"usuario": $("#idUsuario").val(),
			"passwd":$("#passwd").val()
			}),
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
		  success: function(res) {
				alert("Login")
			},
			error: function(err){
				alert("Error login")
			}
		});
	});

})