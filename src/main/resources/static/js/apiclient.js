api = (function () {

    return {
         getSubastaById: function(subasta_id, callback){
             $.getJSON("http://localhost:8080/subastas/subasta/" + subasta_id, function (data) {//$.getJSON("https://subastasdinipa.herokuapp.com/subastas/subasta/" + subasta_id, function (data) {
                callback(data);
            });
         },

         postSubastaPush: function(subasta_id,user_id,push) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/subastas/subasta/push",//url: "https://subastasdinipa.herokuapp.com/subastas/subasta/push",
                data: JSON.stringify({
                    "subasta_id": subasta_id,
                    "user_id": user_id,
                    "push": push
                }),
                dataType: "json",
                contentType: "application/json;charset=UTF-8"
                });
        }
    };
})();