$(document).ready(function() {
	$("#loginButton").click(function(){
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
			   if ($("#idUsuario").val()==="admin"){
			   		localStorage.setItem("admin",true)
			   }
                window.location.href="/index.html"
			},
			error: function(xhr, status, error) {
              alert(xhr.responseText);
            }
		});
	});
})