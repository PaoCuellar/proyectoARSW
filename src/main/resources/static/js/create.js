$(document).ready(function() {
	$("#publicproduc").click(function(){
        console.log({
			"name": $("#productname").val(),
			"priceSold":$("#productprice").val(),
            "date": $("#limitdate").val(),
			"categoria":$("#productcategory").val(),
            "description": $("#productdescription").val(),
			})
		$.ajax({
		  type: "POST",
		  url: "https://subastasdinipa.herokuapp.com/subastas/createItem",
		  data: JSON.stringify({
			"name": $("#productname").val(),
			"priceSold":$("#productprice").val(),
            "date": $("#limitdate").val(),
            "categoria":{"categoria":$("#productcategory").val(),"descripcion":""},
            "description": $("#productdescription").val(),
			}),
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
		  success: function(res) {
                //window.location.href="/index.html"
			},
			error: function(xhr, status, error) {
              alert(xhr.responseText);
            }
		});
	});
}) 