var pushS = (function () {
    
    var stompClient = null;
    var module = "js/apiclient.js";
    var product = "";
    var subastaSelected;
    
    
    class subasta{
        constructor(subast){
            this.userId = subast.user.id;
            this.id = subast.id;
            this.userWinning = subast.userWinning.id;
            this.highestPush = subast.highestPush;
            this.description = subast.item.description;
            this.name = subast.item.name;
        }
    }
    
    var connectAndSubscribe = function(subastaId) {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/subasta.'+subastaId,function (message) {
                alert("subscribed");
                var theObject=JSON.parse(message.body);
                reload(theObject.id);
            });
        });
        
    };
    
    function reload (subastaId){
        stompClient.send('/topic/subasta.'+subasta.id, {}, JSON.stringify(this.subastaSelected));
        $.getScript(module, function(){
            api.getSubastaById(subastaId, refresh);
        });
    }
    
    function setSubasta(subast){
        this.subastaSelected = new subasta(subast); 
    }
    
    function refresh(subasta){
        setSubasta(subasta);
        document.getElementById('relevantInfo').style.visibility = "hidden";
        $('#relevantInfo').empty();
        htmlProduct(subasta);
        $('#relevantInfo').append(product);
        document.getElementById('relevantInfo').style.visibility = "visible";
    }
    
    function htmlProduct(subastaSelected){
        console.log("Subasta ID : "+ this.subastaSelected.id);
        product = "<div class=\"grid images_3_of_2\">"
                +"<ul id=\"etalage\">"
                +"<li>"
                +"<a href=\"optionallink.html\">"
                +"<img class=\"etalage_thumb_image\" src=\"images/p1.jpg\" class=\"img-responsive\" />"
                +"<img class=\"etalage_source_image\" src=\"images/p1.jpg\" class=\"img-responsive\" title=\"\" />"
                +"</a>"
                +"</li>"
                +"</ul>"
                +"<div class=\"clearfix\"></div>"
                +"</div>"
                +"<div class=\"desc1 span_3_of_2\">"
                +"<h1>"+"$"+this.subastaSelected.name+"</h1>"
                +"<div  class=\"price_single\">"  
                +"<span class=\"reducedfrom\">"+"$"+this.subastaSelected.highestPush+"</span>"
                +"<input type=\"text\" id=\"offerSumited\" placeholder=\"OfferSumited\"><a href=\"#\"> </a>"
                +"</div>"
                +"<h2 class=\"quick\">Descripción:</h2>"
                +"<p class=\"quick_desc\">"+this.subastaSelected.description+"</p>"
                
                +"<button class=\"btn btn-outline-primary\" onclick=\"pushS.pushSubasta("+this.subastaSelected.id+",20191919,"+"offerSumited.value)\">Ofertar</button>"
                +"</div>"
                +"<div class=\"clearfix\"> </div>";
    }

return {
    
    
    pushSubasta: function(subastaId,userId,push ){
        console.log(subastaId+" "+userId+"" +push);
        $.getScript(module, function(){
            api.postSubastaPush(subastaId,userId,push, refresh);
        });
        
    },

    load: function(subastaId){
        connectAndSubscribe(subastaId);
        $.getScript(module, function(){
            api.getSubastaById(subastaId, refresh);
        });
    }
};
})();