
/* global connectAndSubscribe */

var pushS = (function () {
    
    var stompClient = null;
    var module = "js/apiclient.js";
    var product = "";
    var subastaSelected;
    var connected = false;
    var subastaIdSelected;
    
    
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
    
    function setconnected(){
        connected = true;
    }
    
    function setsubastaID(id){
        subastaIdSelected = id;
    }
    
    var connectAndSubscribe = function() {
        console.log("ID SuBASTA "+subastaIdSelected);
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        console.log("connected");
        stompClient.connect({}, function (frame) {
            console.log("ID SuBASTA "+subastaIdSelected);
            console.log("ID SuBASTA "+subastaIdSelected);
            console.log('Connected: ' + frame);
            setconnected();
            stompClient.subscribe("/topic/subasta."+subastaIdSelected,function (Subasta) {
                alert("¡Nueva oferta detectada!");
                var theObject=JSON.parse(Subasta.body);
                console.log(Subasta);
                reload(theObject);
            });
        });
        
    };
    
    function reload (subastaId){  
        console.log("RELOAD----- "+subastaId);
        $.getScript(module, function(){
            api.getSubastaById(subastaId, refresh);
        });
    }
    
    function setSubasta(subast){
        this.subastaSelected = new subasta(subast); 
    }
    
    function refresh(subasta){
        if (!connected){
            connectAndSubscribe();
        }
        setSubasta(subasta);
        document.getElementById('relevantInfo').style.visibility = "hidden";
        $('#relevantInfo').empty();
        htmlProduct(subasta);
        $('#relevantInfo').append(product);
        document.getElementById('relevantInfo').style.visibility = "visible";
    }
    
    function postedPush(subastaId){
        console.log("POSTED");
        console.log('/app/subasta.'+subastaId);
        console.log(subastaSelected);
        if (connected){
            stompClient.send("/app/subasta."+subastaId, {}, JSON.stringify(this.subastaSelected));
        }
        
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
    connect: function(){
            connectAndSubscribe();
            
    },
    
    pushSubasta: function(subastaId,userId,push ){
        $.getScript(module, function(){
            api.postSubastaPush(subastaId,userId,push);
        });
        postedPush(subastaId);
        $.getScript(module, function(){
            api.getSubastaById(subastaId, refresh);
        });
        
    },

    load: function(subastaId){
        setsubastaID(subastaId);
        $.getScript(module, function(){
            api.getSubastaById(subastaId, refresh);
        });
        
    }
};
})();
