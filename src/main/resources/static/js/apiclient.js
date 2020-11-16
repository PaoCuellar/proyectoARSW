api = (function () {

    return {
         postSubastaPush: function(cinema_name, callback) {
            $.ajax({
                			type: "POST",
                			//url: "https://subastasdinipa.herokuapp.com/subastas/subasta/push",
                                        
                			data: JSON.stringify({
                				"subasta_id": $("#productname").val(),
                				"user_id": $("#productprice").val(),
                				"push": $("#productprice").val()
                			}),
                			dataType: "json",
                			contentType: "application/json;charset=UTF-8",
                			success: function (res) {
                				//window.location.href="/index.html"
                			}});
        }
    };
})();