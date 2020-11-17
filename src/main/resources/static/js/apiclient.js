api = (function () {

    return {
         getSubastaById: function(subasta_id, callback){
             $.getJSON("https://subastasdinipa.herokuapp.com/subastas/subasta/" + subasta_id, function (data) {
                callback(data);
            });
         },

         postSubastaPush: function(subasta_id,user_id,push, callback) {
            $.ajax({
                type: "POST",
                url: "https://subastasdinipa.herokuapp.com/subastas/subasta/push",
                data: JSON.stringify({
                    "subasta_id": subasta_id,
                    "user_id": user_id,
                    "push": push
                }),
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (res) {
                    window.location.href="/product.html";
                }});
        }
    };
})();