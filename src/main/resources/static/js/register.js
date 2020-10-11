$(document).ready(function() {
	$("#registerbutton").click(function(){
        console.log({
			"userName": $("#usuarioreg").val(),
			"password":$("#passwdreg").val(),
            "name": $("#nombrereg").val(),
			"phone":$("#celreg").val(),
            "Email": $("#correoreg").val(),
			"ciudad":$("#ciudadreg").val(),
            "id":$("#identificacionreg").val()
			})
		$.ajax({
		  type: "POST",
		  url: "https://subastasdinipa.herokuapp.com/subastas/register",
		  data: JSON.stringify({
			"userName": $("#usuarioreg").val(),
			"password":$("#passwdreg").val(),
            "name": $("#nombrereg").val(),
			"phone":$("#celreg").val(),
            "email": $("#correoreg").val(),
			"ciudad":$("#ciudadreg").val(),
            "id":$("#identificacionreg").val()
			}),
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
		  success: function(res) {
                window.location.href="/login.html"
			},
			error: function(xhr, status, error) {
              alert(xhr.responseText);
            }
		});
	});
})