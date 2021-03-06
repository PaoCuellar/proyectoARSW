
var pushS = (function () {
    
    var stompClient = null;
    var module = "js/apiclient.js";
    var product = "";
    var subastaSelected;
    var connected = false;
    var subastaIdSelected;
    var end;
    
    class subasta{
        constructor(subast){
            this.userId = subast.user.id;
            this.id = subast.id;
            this.userWinning = subast.userWinning? subast.userWinning.id:null;
            this.highestPush = subast.highestPush;
            this.description = subast.item.description;
            this.name = subast.item.name;
            this.endDate = subast.fechaFin;
        }
    }

    var end = new Date('12/31/2020 9:30 AM');

    var _second = 1000;
    var _minute = _second * 60;
    var _hour = _minute * 60;
    var _day = _hour * 24;
    var timer;

    function showRemaining() {
        now = new Date();
        var distance = end - now;
        if (distance < 0) {

            clearInterval(timer);
            document.getElementById('countdown').innerHTML = 'EXPIRED!';

            return;
        }
        var days = Math.floor(distance / _day);
        var hours = Math.floor((distance % _day) / _hour);
        var minutes = Math.floor((distance % _hour) / _minute);
        var seconds = Math.floor((distance % _minute) / _second);

        document.getElementById('countdown').innerHTML = days + ' dias, ';
        document.getElementById('countdown').innerHTML += hours + ' horas, ';
        document.getElementById('countdown').innerHTML += minutes + ' minutos y ';
        document.getElementById('countdown').innerHTML += seconds + ' segundos';
    }

    timer = setInterval(showRemaining, 1000);


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
                subastaIdSelected = theObject;
                reload();
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
        console.log(subasta);
        setSubasta(subasta);
        if (!connected){
            now = new Date(subastaSelected.endDate+' 12:59 PM');
            connectAndSubscribe();
        }
        document.getElementById('relevantInfo').style.visibility = "hidden";
        $('#relevantInfo').empty();
        document.getElementById('relevantInfo').style.visibility = "visible";
        document.getElementById('descriptionproduct').innerHTML = subastaSelected.description;
        document.getElementById('titleproduct').innerHTML = subastaSelected.name;
        document.getElementById('newprice').innerHTML = subastaSelected.highestPush;
    }
    
    function postedPush(push){
        console.log("POSTED");
        console.log('/app/subasta.'+subastaIdSelected);
        console.log(subastaSelected);
        subastaSelected.highestPush = push;
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
        
        postedPush(push);
    },

    load: function(){
        setsubastaID();
        $.getScript(module, function(){
            api.getSubastaById(subastaIdSelected,refresh);
        });
    }
    
    
};
})();