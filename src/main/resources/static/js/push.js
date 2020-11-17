var push = (function () {

var stompClient = null;
var module = "js/apiclient.js";

var connectAndSubscribe = function() {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/subasta.'+"101919191",function (message) {
                var theObject=JSON.parse(message.body);
                alert("subscribed");
                refresh();
            });
        });

    };
function refresh(){
    document.getElementById('relevantInfo').style.visibility = "hidden";
    $('#relevantInfo').empty();
    product = "<span class=\"reducedfrom\">$30.000</span>"+"<input type=\"text\" id=\"OfferSumited\" placeholder=\"OfferSumited\"><a href=\"#\"> </a>"
    stompClient.connect();
    stompClient.send('/topic/subasta.'+"101919191", {}, JSON.stringify(st));
    $('#relevantInfo').append(product);
    document.getElementById('relevantInfo').style.visibility = "visible";
}

return {
    connect: function(){
            connectAndSubscribe();
    },
    
    push: function(id, value){
        refresh
    }
};
})();