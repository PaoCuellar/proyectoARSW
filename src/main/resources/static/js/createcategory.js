$(document).ready(function() {
	$("#createCategoryButton").click(function(){
        console.log({
			"category": $("#namecategory").val(),
			"description":$("#categorydescription").val(),
			})
		$.ajax({
		  type: "POST",
		  url: "https://subastasdinipa.herokuapp.com/subastas/createCategory",
		  data: JSON.stringify({
			"category": $("#namecategory").val(),
			"description":$("#categorydescription").val(),
			}),
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
		  success: function(res) {
                window.location.href="/administrator.html"
			},
			error: function(xhr, status, error) {
              alert(xhr.responseText);
            }
		});
	});
}) 