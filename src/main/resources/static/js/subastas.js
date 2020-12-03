var subastas =  (function () {
    function setSubastaC(subastaId){
        document.cookie =  "subastaId = "+subastaId+";path=/;  ";
        location.replace("https://subastasdinipa.herokuapp.com/product.html");
        //location.replace("http://localhost:8080/product.html");
        
    }
    
    return {
        
        setSubastaId: function(subastaId){
            setSubastaC(subastaId);
        }
        
    };
    
})();