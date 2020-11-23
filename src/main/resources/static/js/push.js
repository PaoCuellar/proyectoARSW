
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
    
    function setsubastaID(){
        var coockie = document.cookie;
        var values = coockie.split(";");
        console.log(values);
        for (var i = 0; i<values.length;i++){
            var temp = values[i].replace(" ","").split("=");
            console.log(temp[1]);
            if (temp[0]==="subastaId"){
                subastaIdSelected = temp[1];
                break
            }
        }
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
                var theObject=JSON.parse(Subasta.body); 
                reload(theObject);
            });
        });
        
    };
    
    function reload (){  
        console.log("RELOAD----- "+subastaIdSelected);
        $.getScript(module, function(){
            api.getSubastaById(subastaIdSelected, refresh);
        });
    }
    
    function setSubasta(subast){
        subastaSelected = new subasta(subast); 
    }
    
    function refresh(subasta){
        if (!connected){
            connectAndSubscribe();
        }
        setSubasta(subasta);
        document.getElementById('relevantInfo').style.visibility = "hidden";
        $('#relevantInfo').empty();
        document.getElementById('relevantInfo').style.visibility = "visible";
        document.getElementById('descriptionproduct').innerHTML = subastaSelected.description;
        document.getElementById('titleproduct').innerHTML = subastaSelected.name;
        document.getElementById('newprice').innerHTML = subastaSelected.highestPush;
    }
    
    function postedPush(){
        console.log("POSTED");
        console.log('/app/subasta.'+subastaIdSelected);
        console.log(subastaSelected);
        if (connected){
            stompClient.send("/app/subasta."+subastaIdSelected, {}, JSON.stringify(subastaSelected));
        }
        
    }
    
    function htmlProduct(subastaSelected){
        console.log("Subasta ID : "+ subastaSelected.id);
        product ="<div class=\"grid images_3_of_2\">"
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
                +"<h1>"+"$"+subastaSelected.name+"</h1>"
                +"<div  class=\"price_single\">"  
                +"<span class=\"reducedfrom\">"+"$"+subastaSelected.highestPush+"</span>"
                +"<input type=\"text\" id=\"offerSumited\" placeholder=\"OfferSumited\"><a href=\"#\"> </a>"
                +"</div>"
                +"<h2 class=\"quick\">Descripción:</h2>"
                +"<p class=\"quick_desc\">"+subastaSelected.description+"</p>"

                +"<button class=\"btn btn-outline-primary\" onclick=\"pushS.pushSubasta("+subastaSelected.id+",20191919,"+"offerSumited.value)\">Ofertar</button>"

                +"</div>"
                +"<div class=\"clearfix\"> </div>";
    }

return {
    connect: function(){
            connectAndSubscribe();
            
    },
    
    pushSubasta: function(userId,push ){
        $.getScript(module, function(){
            api.postSubastaPush(subastaIdSelected,userId,push);
        });
        postedPush();
        subastaSelected.highestPush = push;
        
         $.getScript(module, function(){
            api.getSubastaById(subastaIdSelected, refresh);
        });

        
    },

    load: function(){
        setsubastaID();
        $.getScript(module, function(){
            api.getSubastaById(subastaIdSelected,refresh);
        });
        
    }
    
    
};
})();
