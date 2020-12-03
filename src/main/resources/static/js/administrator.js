$(document).ready(function() {
        $.get("https://subastasdinipa.herokuapp.com/subastas/items", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
})